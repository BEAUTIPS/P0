package com.laioffer.beautips.Fragments.ClosetPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.laioffer.beautips.MainActivity2;
import com.laioffer.beautips.Models.Closet;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentClosetBinding;

import java.util.ArrayList;
public class ClosetFragment extends Fragment {

    FragmentClosetBinding binding;
    ClosetImageAdapter ClosetImageAdapter;
    private static final String TAG = "ClosetFragment";
    private DatabaseReference myRef;
    Context context;
    RecyclerView recyclerView;
    private ArrayList<Closet> ClosetList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClosetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public ClosetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("size of list", String.valueOf(ClosetList.size()));
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();
        recyclerView = view.findViewById(R.id.Closet_results_recycler_view);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        ClosetImageAdapter = new ClosetImageAdapter(context, ClosetList);
        recyclerView.setAdapter(ClosetImageAdapter);
        recyclerView.setHasFixedSize(true);
        /*recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.d(TAG, "onItemClick: ");

                        openActivity2();

                    }



                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );*/
        LinearLayout occasionOnclick = view.findViewById(R.id.occasionOnclick);
        Button search = view.findViewById(R.id.search);
        TextView occasionPlus = view.findViewById(R.id.occasion);
        TextView bodyShapePlus = view.findViewById(R.id.bodyShapePlus);
        TextView clearAll = view.findViewById(R.id.cancel_button);
        TextView dressCodePlus = view.findViewById(R.id.dressCodePlus);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) search.getLayoutParams();
        ImageView loading = view.findViewById(R.id.loading);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(params.width == 206) {
                    new CountDownTimer(1500,1500) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            loading.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFinish() {
                            loading.setVisibility(View.GONE);
                        }
                    }.start();
                } else {
                    new CountDownTimer(500,500) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            loading.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFinish() {
                            loading.setVisibility(View.GONE);
                        }
                    }.start();
                }
            }
        });

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.hideOccasion).setVisibility(View.GONE);
                occasionPlus.setText("+");
                view.findViewById(R.id.hideBodyShape).setVisibility(View.GONE);
                bodyShapePlus.setText("+");
                view.findViewById(R.id.hideSize).setVisibility(View.GONE);
                view.findViewById(R.id.hideDressCode).setVisibility(View.GONE);
                dressCodePlus.setText("+");
                search.setBackgroundResource(R.drawable.search_btn);
                clearBackGroundAllForDressCode(view);
                clearBackGroundAllForOccasion(view);
                clearBackGroundAllForBodyShape(view);
                params.width = 206;

            }
        });


        occasionOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hideOccasion);

                if (hideList.getVisibility() == View.GONE) {
                    hideList.setVisibility(View.VISIBLE);
                    search.setBackgroundResource(R.drawable.save);
                    occasionPlus.setText("-");
                    params.width = 205; //change the size of search button as a flag
                } else {
                    hideList.setVisibility(View.GONE);
                    occasionPlus.setText("+");

                    if (view.findViewById(R.id.hideDressCode).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideSize).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideBodyShape).getVisibility() == View.GONE) {
                        search.setBackgroundResource(R.drawable.search_btn);
                        params.width = 206;
                    }
                }

            }
        });
        LinearLayout bodyShapeOnclick = view.findViewById(R.id.bodyShapeOnclick);

        bodyShapeOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hideBodyShape);

                if (hideList.getVisibility() == View.GONE) {
                    hideList.setVisibility(View.VISIBLE);
                    search.setBackgroundResource(R.drawable.save);
                    bodyShapePlus.setText("-");
                    params.width = 205;
                } else {
                    hideList.setVisibility(View.GONE);
                    bodyShapePlus.setText("+");

                    if (view.findViewById(R.id.hideDressCode).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideSize).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideOccasion).getVisibility() == View.GONE) {
                        search.setBackgroundResource(R.drawable.search_btn);
                        params.width = 206;
                    }

                }


            }
        });
        LinearLayout dressCodeOnclick = view.findViewById(R.id.dressCodeOnclick);

        dressCodeOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hideDressCode);

                if (hideList.getVisibility() == View.GONE) {
                    hideList.setVisibility(View.VISIBLE);
                    search.setBackgroundResource(R.drawable.save);
                    dressCodePlus.setText("-");
                    params.width = 205;
                } else {
                    hideList.setVisibility(View.GONE);
                    dressCodePlus.setText("+");

                    if (view.findViewById(R.id.hideOccasion).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideSize).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideBodyShape).getVisibility() == View.GONE) {
                        search.setBackgroundResource(R.drawable.search_btn);
                        params.width = 206;
                    }
                }


            }
        });
        LinearLayout sizeOnclick = view.findViewById(R.id.sizeOnclick);

        sizeOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hideSize);
                if (hideList.getVisibility() == View.GONE) {
                    hideList.setVisibility(View.VISIBLE);
                    search.setBackgroundResource(R.drawable.save);
                    params.width = 205;


                } else {
                    hideList.setVisibility(View.GONE);

                    if (view.findViewById(R.id.hideOccasion).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideDressCode).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideBodyShape).getVisibility() == View.GONE) {
                        search.setBackgroundResource(R.drawable.search_btn);
                        params.width = 206;
                    }
                }

            }
        });
        sizeOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout hideList = view.findViewById(R.id.hideSize);
                if (hideList.getVisibility() == View.GONE) {
                    hideList.setVisibility(View.VISIBLE);
                    search.setBackgroundResource(R.drawable.save);
                    params.width = 205;


                } else {
                    hideList.setVisibility(View.GONE);

                    if (view.findViewById(R.id.hideOccasion).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideDressCode).getVisibility() == View.GONE &&
                            view.findViewById(R.id.hideBodyShape).getVisibility() == View.GONE) {
                        search.setBackgroundResource(R.drawable.search_btn);
                        params.width = 206;
                    }
                }

            }
        });

        TextView pearIcon = view.findViewById(R.id.pearIcon); // first-hiding-list icon

        pearIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForBodyShape(view);
                pearIcon.setBackgroundResource(R.drawable.rainbowborder);
                pearIcon.setPadding(30,2,0,0); // still don't understand why pear will go to the left
            }
        });

        TextView roundIcon = view.findViewById(R.id.roundIcon);

        roundIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForBodyShape(view);
                roundIcon.setBackgroundResource(R.drawable.rainbowborder);
                roundIcon.setPadding(30,2,0,0);
            }
        });

        TextView triangleIcon = view.findViewById(R.id.triangleIcon);
        triangleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForBodyShape(view);
                triangleIcon.setBackgroundResource(R.drawable.rainbowborder);
                triangleIcon.setPadding(30,2,0,0);
            }
        });

        TextView rectangleIcon = view.findViewById(R.id.rectangleIcon);
        rectangleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForBodyShape(view);
                rectangleIcon.setBackgroundResource(R.drawable.rainbowborder);
                rectangleIcon.setPadding(30,2,0,0);
            }
        });

        TextView hourglassIcon = view.findViewById(R.id.hourglassIcon);
        hourglassIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForBodyShape(view);

                hourglassIcon.setBackgroundResource(R.drawable.rainbowborder);
                hourglassIcon.setPadding(30,2,0,0);
            }
        }); // end of first-hide-lists


        /*LinearLayout hideOccasion = view.findViewById(R.id.hideOccasion);
        int total = hideOccasion.getChildCount();
        for (int i = 0;i < total; i++) {
            onclickForOccasionButtons(hideOccasion.getChildAt(i)); // set the children programmatically, not finished
        }*/
        TextView weddingIcon = view.findViewById(R.id.weddingIcon);
        weddingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.weddingIcon));
            }
        });

        TextView partyIcon = view.findViewById(R.id.partyIcon);
        partyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.partyIcon));
            }
        });

        TextView beachIcon = view.findViewById(R.id.beachIcon);
        beachIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.beachIcon));
            }
        });

        TextView dinnerIcon = view.findViewById(R.id.dinnerIcon);
        dinnerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.dinnerIcon));
            }
        });

        TextView dailyLifeIcon = view.findViewById(R.id.dailyLifeIcon);
        dailyLifeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.dailyLifeIcon));
            }
        });

        TextView datingIcon = view.findViewById(R.id.datingIcon);
        datingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.datingIcon));
            }
        });

        TextView meetingIcon = view.findViewById(R.id.meetingIcon);
        meetingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickForOccasionButtons(view.findViewById(R.id.meetingIcon));
            }
        });

        TextView formalIcon = view.findViewById(R.id.formalIcon);
        formalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForDressCode(view);
                setRainbowBorder(view.findViewById(R.id.formalIcon));
            }
        });

        TextView semiIcon = view.findViewById(R.id.semiIcon);
        semiIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForDressCode(view);
                setRainbowBorder(view.findViewById(R.id.semiIcon));
            }
        });

        TextView informalIcon = view.findViewById(R.id.informalIcon);
        informalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForDressCode(view);
                setRainbowBorder(view.findViewById(R.id.informalIcon));
            }
        });

        TextView casualIcon = view.findViewById(R.id.casualIcon);
        casualIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackGroundAllForDressCode(view);
                setRainbowBorder(view.findViewById(R.id.casualIcon));
            }
        });



























        myRef = FirebaseDatabase.getInstance().getReference(); // java based backend
        ClosetList = new ArrayList<>();
        ClearAll();
        GetDataBaseFromFireBase();
        FloatingActionButton backToTop = view.findViewById(R.id.toTop); // back to top
        backToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView scrollView = view.findViewById(R.id.scroll);
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }



    /*private void onclickForOccasionButtons(View t) {
        Log.d(TAG, t.toString());
    }*/

    private void onclickForOccasionButtons(TextView t) {
        if(t.getPaintFlags() == 0) {
            t.setPaintFlags(1);
            t.setBackgroundResource(R.drawable.darkblackborder);
        } else {
            t.setPaintFlags(0);
            t.setBackgroundResource(R.drawable.blackborder);
        }
    }
    private void setRainbowBorder(TextView t) {
        t.setBackgroundResource(R.drawable.rainbowborder);
        t.setPadding(30,2,0,0);
    }

    private void clearBackGroundAllForBodyShape(View view) {
        view.findViewById(R.id.pearIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.roundIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.hourglassIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.rectangleIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.triangleIcon).setBackgroundResource(R.drawable.blackborder);
    }

    private void clearBackGroundAllForOccasion(View view) {
        view.findViewById(R.id.weddingIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.partyIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.beachIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.dinnerIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.dailyLifeIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.datingIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.meetingIcon).setBackgroundResource(R.drawable.blackborder);

    }

    private void clearBackGroundAllForDressCode(View view) {
        view.findViewById(R.id.formalIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.semiIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.informalIcon).setBackgroundResource(R.drawable.blackborder);
        view.findViewById(R.id.casualIcon).setBackgroundResource(R.drawable.blackborder);
    }

    /*private void openActivity2() {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }*/

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
                    closet.setBottomName(snapshot.child("bottomName").getValue().toString());

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