package com.laioffer.beautips.Fragments.StylistPage;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostViewModel;
import com.laioffer.beautips.R;
import com.laioffer.beautips.Repository.BeautipsViewModelFactory;
import com.laioffer.beautips.Repository.StylistPostRepository;
import com.laioffer.beautips.databinding.FragmentStylistProfileBinding;
import com.squareup.picasso.Picasso;


public class StylistProfileFragment extends Fragment {


    public static ViewPager viewPager;
    private FragmentStylistProfileBinding binding;
    public static TabLayout tabLayout;
    private PostReviewTabAdapter adapter;
    ImageButton btn;



    StylistPostViewModel stylistViewModel;
    Context context;
    String stylistName;



    public StylistProfileFragment(String name) {
        // Required empty public constructor
        this.stylistName = name;
    }

    /*
    When create, bind with xml file
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = binding.inflate(inflater, container, false);

        btn = (ImageButton) binding.scheduleButton;
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                ConstraintLayout mainView = binding.layoutProfile;


                PopUp popUpClass = new PopUp();
                popUpClass.showPopupWindow(arg0);
                ImageView shade = binding.shade;
                ImageButton button = binding.scheduleButton;
                shade.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                Toast.makeText(arg0.getContext(), "Schedule works", Toast.LENGTH_SHORT).show();


            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StylistPostRepository repository = new StylistPostRepository(getContext());
        stylistViewModel = new ViewModelProvider(this, new BeautipsViewModelFactory(repository))
                .get(StylistPostViewModel.class);

        Log.d("name is", stylistName);

//        stylistViewModel
//                .getStylistInfo(stylistName)
//                .observe(
//                        getViewLifecycleOwner(),
//                        response -> {
//                            if (response != null) {
//                                Log.d("TestResult", response.toString());
//                                //Binding set text
//                                binding.age.setText("#" + String.valueOf(response.getAge()) + " years");
//                                binding.numCustomers.setText(String.valueOf(response.getNumOfCustomers()));
//                                binding.bodyShape.setText("#" + response.getBodyShape() + " Shape");
//                                binding.size.setText("#" + response.getTopSize());
//                                binding.size.setText("#" + response.getBottomSize());
//                                binding.numLikes.setText(String.valueOf(response.getNumOfLikes()));
//                                binding.stylistName.setText(response.getName());
//                                binding.stylistTitle.setText(response.getTitle());
//                                binding.numsFollows.setText(String.valueOf(response.getNumOfFollowers()));
//                                binding.textView17numReview.setText(String.valueOf(response.getNumOfReviews()) + " reviews");
//
//                                Picasso.get()
//                                        .load(response.getProfileImageUrl())
//                                        .noFade().into(binding.stylistImage);
//
//                                Picasso.get()
//                                        .load(response.getProfileImageUrl())
//                                        .noFade().into((ImageView) getView().findViewById(R.id.stylist_profile_image));
//                            }
//                        });
//


        viewPager = binding.viewPager;
        viewPager.setOffscreenPageLimit(2);
        tabLayout = binding.tab;
        createTabFragment();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tabLayout.getSelectedTabPosition() == 0) {
                    Log.d("this is",String.valueOf(tabLayout.getSelectedTabPosition()));
                } else if (tabLayout.getSelectedTabPosition() == 1) {
                    Log.d("this is another",String.valueOf(tabLayout.getSelectedTabPosition()));
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    private void createTabFragment(){
        adapter = new PostReviewTabAdapter(getActivity().getSupportFragmentManager(), tabLayout, stylistName);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public class PopUp {

        public void showPopupWindow(final View view) {

            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.pop_up, null);


            boolean focusable = true;

            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;

            //Create a window with our parameters
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            ImageButton buttonEdit = popupView.findViewById(R.id.imageButton2);

            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Close the window when clicked
                    popupWindow.dismiss();
                    ConstraintLayout mainView = binding.layoutProfile;
                    ImageView shade = binding.shade;
                    shade.setVisibility(View.INVISIBLE);


                }
            });

        }

    }



    }
