package com.laioffer.beautips.Fragments.startup;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.laioffer.beautips.MainActivity;
import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentLogInBinding;
import com.laioffer.beautips.databinding.FragmentOnb2Binding;

public class logInFragment extends Fragment implements  View.OnClickListener{
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private ImageButton delete;
    private EditText email;
    private EditText passowrd;
    private TextView signup;
    private ImageButton login;
    private String emailText ;
    private String passwordText;
    FragmentLogInBinding binding;
    setUpViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        binding = binding.inflate(inflater, container, false);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        delete = (ImageButton)binding.delete2;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        email=view.findViewById(R.id.email);
        passowrd = view.findViewById(R.id.pwd);
        signup = view.findViewById(R.id.signup_3);
        signup.setOnClickListener(this);
        emailText = email.getText().toString();
        passwordText = passowrd.getText().toString();


        login = (ImageButton)binding.login3;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.putString("email", emailText);
                myEdit.putString("name", emailText);
                myEdit.putString("password", passwordText);

                User user = new User();
                user.setEmail(preferences.getString("email", ""));
                user.setName(preferences.getString("name",""));
                user.setPassword(preferences.getString("password",""));

                MutableLiveData<String> result = viewModel.getUserInfo(user);
                Intent intent  = new Intent(getActivity(), MainActivity.class);
                if(result != null){
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onClick(View arg0) {
        Intent intent=new Intent(getActivity(), MainActivity.class);
        switch (arg0.getId()) {
            case R.id.delete2:
                break;

            case R.id.signup_3:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
                break;
            default:
                break;

       }
    }

}