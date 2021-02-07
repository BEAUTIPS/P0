package com.laioffer.beautips.Fragments.StylistPage.StylistPost;

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
import com.laioffer.beautips.Models.Post;

import java.util.ArrayList;
import java.util.List;

import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.StylistPostBinding;

/*

 */
public class StylistPostAdapter extends RecyclerView.Adapter<StylistPostAdapter.StylistPostViewHolder> {

    private Context context;
    private List<Post> posts;


    public StylistPostAdapter(Context context, ArrayList<Post> postList) {

        this.context = context;
        this.posts = postList;
    }


    @NonNull
    @Override
    public StylistPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll_stylist_posts, parent, false);
        return new StylistPostViewHolder(view);
    }


    /*
    This method change the content of each of our ViewHolder to different values
     */
    @Override
    public void onBindViewHolder(@NonNull StylistPostViewHolder holder, int position) {

        Post postImage = posts.get(position);
        //Load Post Image
        Glide.with(holder.itemView)
                .load(getImage(postImage.getImageName()))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(14)))
                .fitCenter()
                .into(holder.post);
        // modify all the text view
        holder.likeCount.setText(postImage.getNumOfLikes());
        holder.stylistName.setText(postImage.getOwnerId());

        // get Profile Image url
        Glide.with(holder.itemView)
                .load(getImage(postImage.getPofileImageUrl()))
                .fitCenter()
                .into(holder.stylistPic);
    }

    private int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable-v24", context.getPackageName());
        return drawableResourceId;
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }



    /*
    This is the holder class for an individual post item;
     */
    public static class StylistPostViewHolder extends RecyclerView.ViewHolder {


        ImageView post;
        TextView stylistName;
        TextView likeCount;
        ImageView thumbsUp;
        ImageView stylistPic;

        public StylistPostViewHolder(@NonNull View itemView) {
            super(itemView);
            StylistPostBinding binding = StylistPostBinding.bind(itemView);
            post = binding.postPic;
            stylistName = binding.stylistNamePost;
            likeCount = binding.numThums;
            thumbsUp = binding.thumb;
            stylistPic = binding.stylistProfileImage;
        }
    }

}
