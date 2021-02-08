package com.laioffer.beautips.Fragments.StylistPage.StylistList;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.beautips.Fragments.StylistPage.StylistProfileFragment;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.Models.Stylist;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.SingleStylistListBinding;

import java.util.ArrayList;
import java.util.List;

public class StylistListAdapter extends RecyclerView.Adapter<StylistListAdapter.StylistListViewHolder>{

    private Context context;
    // 1. supporting data
    private List<Stylist> stylistList = new ArrayList<>();
    private ItemCallback itemCallback;



    public StylistListAdapter(Context context, ArrayList<Stylist> stylistList) {
        this.context = context;
        this.stylistList = stylistList;

    }


    interface ItemCallback {
        void onOpenDetails(Stylist stylistList);
    }

    public void setItemCallback(ItemCallback itemCallback) {
        this.itemCallback = itemCallback;
    }


    // 2. adapter overrides
    @NonNull
    @Override
    public StylistListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // follow the pattern
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_stylist_list, parent, false);
        return new StylistListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StylistListViewHolder holder, int position) {
        Stylist list = stylistList.get(position);
        holder.stylistName.setText(list.getName());
//        holder.numsReview.setText(list.getNumOfReviews());
//        holder.stylistTitle.setText(list.getTitle());
        //holder.itemView.setOnClickListener(v -> ItemCallback.onOpenDetails(list));



    }

    @Override
    public int getItemCount() {
        return stylistList.size();
    }


    // 3. view holder
    public static class StylistListViewHolder extends RecyclerView.ViewHolder  {

        TextView stylistName;
        ImageView stylistImage;
        TextView stylistTitle;
        TextView numsReview;
        RatingBar ratingBar;
        CardView card;

        public StylistListViewHolder(@NonNull View itemView) {
            super(itemView);
            SingleStylistListBinding binding = SingleStylistListBinding.bind(itemView);
            stylistName = binding.name;
            stylistImage = binding.stylistImage;
            stylistTitle = binding.stylistTitle;
            numsReview = binding.reviews;
            ratingBar = binding.ratingBar;
            card = binding.cardList;

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), stylistName.getText(), Toast.LENGTH_LONG).show();
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    // Storing data into SharedPreferences




                    Fragment myFragment = new StylistProfileFragment(stylistName.getText().toString());
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.topview, myFragment).addToBackStack(null).commit();
                }
            });
        }
        }



}
