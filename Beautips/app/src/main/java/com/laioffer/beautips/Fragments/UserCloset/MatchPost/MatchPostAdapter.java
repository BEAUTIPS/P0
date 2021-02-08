package com.laioffer.beautips.Fragments.UserCloset.MatchPost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostAdapter;
import com.laioffer.beautips.Models.Closet;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.StylistPostBinding;

import java.util.ArrayList;
import java.util.List;

public class MatchPostAdapter extends RecyclerView.Adapter<MatchPostAdapter.ClosetViewHolder> {
    private Context context;
    private List<Closet> closets;


    public MatchPostAdapter(Context context, ArrayList<Closet> closetList) {

        this.context = context;
        this.closets = closetList;
    }


    @NonNull
    @Override
    public MatchPostAdapter.ClosetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll_stylist_posts, parent, false);
        return new MatchPostAdapter.ClosetViewHolder(view);
    }


    /*
    This method change the content of each of our ViewHolder to different values
     */
    @Override
    public void onBindViewHolder(@NonNull MatchPostAdapter.ClosetViewHolder holder, int position) {

        Closet closetImage = closets.get(position);
        //Load Closet Image
//        Glide.with(holder.itemView)
//                .load(getImage(closetImage.getImageName()))
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(14)))
//                .fitCenter()
//                .into(holder.closet);
//        // modify all the text view
//        holder.likeCount.setText(closetImage.getNumOfLikes());
//        holder.stylistName.setText(closetImage.getOwnerId());
//
//        // get Profile Image url
//        Glide.with(holder.itemView)
//                .load(getImage(postImage.getPofileImageUrl()))
//                .fitCenter()
//                .into(holder.stylistPic);
    }

    private int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable-v24", context.getPackageName());
        return drawableResourceId;
    }


    @Override
    public int getItemCount() {
        return closets.size();
    }



    /*
    This is the holder class for an individual closet item;
     */
    public static class ClosetViewHolder extends RecyclerView.ViewHolder {


        ImageView closet;
        TextView stylistName;
        TextView likeCount;
        ImageView thumbsUp;
        ImageView stylistPic;

        public ClosetViewHolder(@NonNull View itemView) {
            super(itemView);
            StylistPostBinding binding = StylistPostBinding.bind(itemView);
            closet = binding.postPic;
            stylistName = binding.stylistNamePost;
            likeCount = binding.numThums;
            thumbsUp = binding.thumb;
            stylistPic = binding.stylistProfileImage;
        }
    }
}