package com.laioffer.beautips.Fragments.ClosetPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.laioffer.beautips.Fragments.HomePage.HomeImageAdapter;
import com.laioffer.beautips.Models.Closet;
import com.laioffer.beautips.R;
import com.laioffer.beautips.Utils.GlideApp;
import com.laioffer.beautips.databinding.SearchImageItemBinding;
import com.laioffer.beautips.Models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ClosetImageAdapter extends RecyclerView.Adapter<ClosetImageAdapter.ClosetImageViewHolder> {
    private Context context;
    private List<Closet> ClosetList;
    public ClosetImageAdapter(Context context, ArrayList<Closet> ClosetList) {

        this.context = context;
        this.ClosetList = ClosetList;
    }

    @NonNull
    @Override
    public ClosetImageAdapter.ClosetImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_image_item, parent, false);
        return new ClosetImageAdapter.ClosetImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClosetImageViewHolder holder, int position) {
        Closet ClosetImage = ClosetList.get(position);
        //Load Post Image
        GlideApp.with(holder.itemView)
                .load(getImage(ClosetImage.getImageName()))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(14)))
                .fitCenter()
                .into(holder.post);
        // modify all the text view
        holder.likeCount.setText(String.valueOf(ClosetImage.getScore()));
        holder.stylistName.setText(ClosetImage.getTopName());

        Picasso.get().load(ClosetImage.getImageUrl()).into(holder.stylistPic);
        Picasso.get().load(ClosetImage.getImageUrl()).into(holder.post);
        /*GlideApp.with(holder.itemView)
                .load(getImage(postImage.getProfileImageUrl()))
                .fitCenter()
                .into(holder.stylistPic);*/
    }

    private int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        return drawableResourceId;
    }
    @Override
    public int getItemCount() {
        return ClosetList.size();
    }

    public static class ClosetImageViewHolder extends RecyclerView.ViewHolder {

        ImageView post;
        TextView stylistName;
        TextView likeCount;
        ImageView thumbsUp;
        ImageView stylistPic;

        public ClosetImageViewHolder(@NonNull View itemView) {
            super(itemView);
            SearchImageItemBinding binding = SearchImageItemBinding.bind(itemView);
            post = binding.postPic;
            stylistName = binding.stylistNamePost;
            likeCount = binding.numThums;
            thumbsUp = binding.thumb;
            stylistPic = binding.stylistProfileImage;
        }

    }
}
