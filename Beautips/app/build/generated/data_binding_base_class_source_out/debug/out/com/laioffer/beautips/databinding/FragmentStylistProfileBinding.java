// Generated by view binder compiler. Do not edit!
package com.laioffer.beautips.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.laioffer.beautips.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentStylistProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView age;

  @NonNull
  public final TextView bodyShape;

  @NonNull
  public final AppCompatButton buttonFollow;

  @NonNull
  public final View frame431;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final View line;

  @NonNull
  public final View line6;

  @NonNull
  public final TextView numCustomers;

  @NonNull
  public final TextView numLikes;

  @NonNull
  public final TextView numsFollows;

  @NonNull
  public final RatingBar ratingBar;

  @NonNull
  public final TextView size;

  @NonNull
  public final ImageView stylistImage;

  @NonNull
  public final TextView stylistName;

  @NonNull
  public final TextView stylistTitle;

  @NonNull
  public final TabLayout tab;

  @NonNull
  public final TextView textView17numReview;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final ViewPager viewPager;

  private FragmentStylistProfileBinding(@NonNull ConstraintLayout rootView, @NonNull TextView age,
      @NonNull TextView bodyShape, @NonNull AppCompatButton buttonFollow, @NonNull View frame431,
      @NonNull ImageView imageView, @NonNull View line, @NonNull View line6,
      @NonNull TextView numCustomers, @NonNull TextView numLikes, @NonNull TextView numsFollows,
      @NonNull RatingBar ratingBar, @NonNull TextView size, @NonNull ImageView stylistImage,
      @NonNull TextView stylistName, @NonNull TextView stylistTitle, @NonNull TabLayout tab,
      @NonNull TextView textView17numReview, @NonNull TextView textView3,
      @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ViewPager viewPager) {
    this.rootView = rootView;
    this.age = age;
    this.bodyShape = bodyShape;
    this.buttonFollow = buttonFollow;
    this.frame431 = frame431;
    this.imageView = imageView;
    this.line = line;
    this.line6 = line6;
    this.numCustomers = numCustomers;
    this.numLikes = numLikes;
    this.numsFollows = numsFollows;
    this.ratingBar = ratingBar;
    this.size = size;
    this.stylistImage = stylistImage;
    this.stylistName = stylistName;
    this.stylistTitle = stylistTitle;
    this.tab = tab;
    this.textView17numReview = textView17numReview;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentStylistProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentStylistProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_stylist_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentStylistProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.age;
      TextView age = rootView.findViewById(id);
      if (age == null) {
        break missingId;
      }

      id = R.id.body_shape;
      TextView bodyShape = rootView.findViewById(id);
      if (bodyShape == null) {
        break missingId;
      }

      id = R.id.button_follow;
      AppCompatButton buttonFollow = rootView.findViewById(id);
      if (buttonFollow == null) {
        break missingId;
      }

      id = R.id.frame_431;
      View frame431 = rootView.findViewById(id);
      if (frame431 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.line_;
      View line = rootView.findViewById(id);
      if (line == null) {
        break missingId;
      }

      id = R.id.line_6;
      View line6 = rootView.findViewById(id);
      if (line6 == null) {
        break missingId;
      }

      id = R.id.num_customers;
      TextView numCustomers = rootView.findViewById(id);
      if (numCustomers == null) {
        break missingId;
      }

      id = R.id.num_likes;
      TextView numLikes = rootView.findViewById(id);
      if (numLikes == null) {
        break missingId;
      }

      id = R.id.nums_follows;
      TextView numsFollows = rootView.findViewById(id);
      if (numsFollows == null) {
        break missingId;
      }

      id = R.id.ratingBar;
      RatingBar ratingBar = rootView.findViewById(id);
      if (ratingBar == null) {
        break missingId;
      }

      id = R.id.size;
      TextView size = rootView.findViewById(id);
      if (size == null) {
        break missingId;
      }

      id = R.id.stylist_image;
      ImageView stylistImage = rootView.findViewById(id);
      if (stylistImage == null) {
        break missingId;
      }

      id = R.id.stylist_name;
      TextView stylistName = rootView.findViewById(id);
      if (stylistName == null) {
        break missingId;
      }

      id = R.id.stylist_title;
      TextView stylistTitle = rootView.findViewById(id);
      if (stylistTitle == null) {
        break missingId;
      }

      id = R.id.tab;
      TabLayout tab = rootView.findViewById(id);
      if (tab == null) {
        break missingId;
      }

      id = R.id.textView17num_review;
      TextView textView17numReview = rootView.findViewById(id);
      if (textView17numReview == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = rootView.findViewById(id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager viewPager = rootView.findViewById(id);
      if (viewPager == null) {
        break missingId;
      }

      return new FragmentStylistProfileBinding((ConstraintLayout) rootView, age, bodyShape,
          buttonFollow, frame431, imageView, line, line6, numCustomers, numLikes, numsFollows,
          ratingBar, size, stylistImage, stylistName, stylistTitle, tab, textView17numReview,
          textView3, textView4, textView5, viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
