package com.laioffer.beautips.Fragments.startup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.laioffer.beautips.MainActivity;
import com.laioffer.beautips.R;
public class logInFragment extends Fragment implements  View.OnClickListener{
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private ImageButton delete;
    private EditText email;
    private EditText passowrd;
    private TextView signup;
    private ImageButton login;
    private String emailText ;
    private String passwordText ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_log_in, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        initview(view);
        return view;
    }

    private void initview(View view) {
        delete = view.findViewById(R.id.delete2);
        email=view.findViewById(R.id.email);
        passowrd = view.findViewById(R.id.pwd);
        login=view.findViewById(R.id.login_3);
        signup = view.findViewById(R.id.signup_3);

        delete.setOnClickListener(this);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
        emailText = email.getText().toString();
        passwordText = passowrd.getText().toString();
    }

    @Override
    public void onClick(View arg0) {
        Intent intent=new Intent(getActivity(), MainActivity.class);
        switch (arg0.getId()) {
            case R.id.delete2:
                if(preferences.getString("location", "").toString() == "onb1"){
                    getFragmentManager().beginTransaction().replace(R.id.fl_main, new onb1Fragment()).commit();
                }
                else if(preferences.getString("location", "").toString() == "signUp"){
                    getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
             }
                break;

            case R.id.signup_3:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
                break;
            case R.id.login_3:
                // login
                //View Model --》 StylistPostFragemnt
                startActivity(intent);
                //getActivity().overridePendingTransition(R.anim.activity_right_to_left_enter, R.anim.activity_right_to_left_exit);
                break;
            default:
                break;

       }
    }

}