package com.laioffer.beautips.Fragments.startup;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostAdapter;
import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostViewModel;
import com.laioffer.beautips.MainActivity;
import com.laioffer.beautips.R;
import com.laioffer.beautips.Repository.BeautipsViewModelFactory;
import com.laioffer.beautips.Repository.StylistPostRepository;
import com.laioffer.beautips.Repository.UserRepository;
import com.laioffer.beautips.setUpActivity;

public class signUpFragment extends Fragment implements View.OnClickListener{

    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private EditText email;
    private EditText passowrd;
    private TextView login;
    private ImageButton sign_up;
    private String emailText ;
    private String passwordText ;
    Context context;
    private setUpViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sign_up, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        initview(view);
        return view;
    }




    private void initview(View view) {
        email=view.findViewById(R.id.email);
        passowrd = view.findViewById(R.id.pwd);
        sign_up=view.findViewById(R.id.sign_up1);
        login = view.findViewById(R.id.log_in1);
        sign_up.setOnClickListener(this);
        login.setOnClickListener(this);
        emailText = email.getText().toString();
        passwordText = passowrd.getText().toString();

    }

    @Override
    public void onClick(View arg0) {

        Intent intent=new Intent(getActivity(), MainActivity.class); // 跳转到group2的ACTIVITY
        switch (arg0.getId()) {
            case R.id.log_in1:
                myEdit.putString("email", emailText);
                myEdit.putString("name", emailText);
                myEdit.putString("password", passwordText);
                startActivity(intent);
                break;
            case R.id.sign_up1:
                myEdit.putString("email", emailText);
                myEdit.putString("name", emailText);
                myEdit.putString("password", passwordText);
                startActivity(intent);
                break;
            default:
                break;
        }


    }



}