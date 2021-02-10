package com.laioffer.beautips;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.laioffer.beautips.Fragments.startup.onb1Fragment;

public class setUpActivity extends AppCompatActivity {
    private onb1Fragment oneFragment = new onb1Fragment();
    FragmentManager fm = fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);


        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,new onb1Fragment()).setReorderingAllowed(true)
                .addToBackStack("")
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}