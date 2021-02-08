package com.laioffer.beautips.Fragments.ClosetPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.laioffer.beautips.Fragments.HomePage.HomeImageAdapter;
import com.laioffer.beautips.MainActivity;
import com.laioffer.beautips.MainActivity2;
import com.laioffer.beautips.Models.Closet;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentClosetBinding;

import java.util.ArrayList;
public class ClosetFragment extends Fragment {

    FragmentClosetBinding binding;

    ClosetImageAdapter ClosetImageAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    private static final String TAG = "homeFragment";
    private DatabaseReference myRef;
    Context context;
    RecyclerView recyclerView;


    private ArrayList<Closet> ClosetList = new ArrayList<>();

    public ClosetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("size of list",String.valueOf(ClosetList.size()));
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();
        recyclerView = view.findViewById(R.id.news_results_recycler_view);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        ClosetImageAdapter = new ClosetImageAdapter(context, ClosetList);
        recyclerView.setAdapter(ClosetImageAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.d(TAG, "onItemClick: ");

                        openActivity2();

                    }



                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        TextView hide = view.findViewById(R.id.occasion);

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hidelist);
                hideList.setVisibility(View.VISIBLE);
            }
        });
        myRef = FirebaseDatabase.getInstance().getReference();
        ClosetList = new ArrayList<>();
        ClearAll();
        GetDataBaseFromFireBase();
    }

    private void openActivity2() {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void GetDataBaseFromFireBase() {
        Query query = myRef.child("Closet");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    /*Post post = new Post();

                    post.setImageName(snapshot.child("imageName").getValue().toString());
                    post.setImageUrl(snapshot.child("imageUrl").getValue().toString());
                    post.setNumOfLikes(Integer.parseInt(snapshot.child("numOfLikes").getValue().toString()));
                    post.setOwnerId(snapshot.child("ownerId").getValue().toString());
                    post.setProfileImageUrl(snapshot.child("profileImageUrl").getValue().toString());
                    post.setPostId(snapshot.child("postId").getValue().toString());
                    post.setTimeStamp(snapshot.child("timeStamp").getValue().toString());

                    postList.add(post);*/

                    Closet closet = new Closet();
                    closet.setBodyShape(snapshot.child("bodyShape").getValue().toString());
                    closet.setImageName(snapshot.child("imageName").getValue().toString());
                    closet.setImageUrl(snapshot.child("imageUrl").getValue().toString());
                    closet.setScore(Integer.parseInt(snapshot.child("score").getValue().toString()));
                    closet.setBottomSize(snapshot.child("bottomSize").getValue().toString());
                    closet.setDressCode(snapshot.child("dressCode").getValue().toString());
                    closet.setOccasion(snapshot.child("occasion").getValue().toString());
                    closet.setTopSize(snapshot.child("topSize").getValue().toString());
                    closet.setBottomPrice(Integer.parseInt(snapshot.child("bottomPrice").getValue().toString()));
                    closet.setTopPrice(Integer.parseInt(snapshot.child("topPrice").getValue().toString()));
                    closet.setTopUrl(snapshot.child("topUrl").getValue().toString());
                    closet.setTopName(snapshot.child("topName").getValue().toString());
                    closet.setBottomUrl(snapshot.child("bottomUrl").getValue().toString());
                    closet.setBottomName(snapshot.child("bottomUrl").getValue().toString());

                    ClosetList.add(closet);
                }

                ClosetImageAdapter = new ClosetImageAdapter(context, ClosetList);
                recyclerView.setAdapter(ClosetImageAdapter);
                ClosetImageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void ClearAll () {
        if (ClosetList!= null) {
            ClosetList.clear();

            if(ClosetImageAdapter != null) {
                ClosetImageAdapter.notifyDataSetChanged();
            }
        }
        ClosetList = new ArrayList<>();
    }

    private static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);

            public void onLongItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }

        @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

        @Override
        public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
    }
}