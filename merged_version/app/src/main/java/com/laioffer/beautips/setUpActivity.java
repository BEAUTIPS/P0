package com.laioffer.beautips;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.app.Fragment;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;

import com.laioffer.beautips.Fragments.startup.onb1Fragment;

public class setUpActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        Fragment fragment = new onb1Fragment();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fl_main, fragment)
                .setReorderingAllowed(true)
                .commit();

    }


}