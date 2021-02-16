package com.laioffer.beautips.Fragments.startup;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.laioffer.beautips.MainActivity;
import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.Network.RetrofitClient;
import com.laioffer.beautips.Network.UserLoginApi;
import com.laioffer.beautips.R;
import com.laioffer.beautips.Repository.BeautipsViewModelFactory_User;
import com.laioffer.beautips.Repository.UserRepository;
import com.laioffer.beautips.databinding.FragmentLogInBinding;
import com.laioffer.beautips.databinding.FragmentOnb2Binding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class logInFragment extends Fragment implements  View.OnClickListener{
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private ImageButton delete;
    private EditText email;
    private EditText password;
    private TextView signup;
    private ImageButton login;
    private String emailText ;
    private String passwordText;
    private User UserInfo;
    FragmentLogInBinding binding;
    setUpViewModel viewModel;
    StringBuilder result;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        binding = binding.inflate(inflater, container, false);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();

        UserRepository repository = new UserRepository(getContext());
        viewModel = new ViewModelProvider(this, new BeautipsViewModelFactory_User(repository))
                .get(setUpViewModel.class);
        delete = (ImageButton)binding.delete2;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserRepository repository = new UserRepository(getContext());
        viewModel = new ViewModelProvider(this, new BeautipsViewModelFactory_User(repository))
                .get(setUpViewModel.class);
        delete = (ImageButton)binding.delete2;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
            }
        });

        email = (EditText) view.findViewById(R.id.email);
        email.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable arg0) {
                emailText= email.getText().toString();
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
            @Override
            public void onTextChanged(CharSequence s, int a, int b, int c) {
            }
        });

        password = (EditText) view.findViewById(R.id.pwd);
        password.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable arg0) {
                passwordText= password.getText().toString();
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
            @Override
            public void onTextChanged(CharSequence s, int a, int b, int c) {
            }
        });

        signup = view.findViewById(R.id.signup_3);
        signup.setOnClickListener(this);


        login = (ImageButton)binding.login3;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if uuid
                String uuid = preferences.getString("uuid", "");
                if (!uuid.equals("")){
                    //viewModel get UserInfo
                    viewModel
                            .getUserProfile(uuid)
                            .observe(
                                    getViewLifecycleOwner(),
                                    response -> {
                                        if (response != null) {
                                            myEdit.putString("shape", response.getBodyShape()).apply();
                                            myEdit.putString("topSize", response.getTopSize()).apply();
                                            myEdit.putString("bottomSize", response.getBottomSize()).apply();
                                            myEdit.putString("age", response.getAge()).apply();
                                            myEdit.putString("size", response.getSize()).apply();
                                            //tiao zhuan
                                            Intent intent  = new Intent(getActivity(), MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                }else{

                    myEdit.putString("email", emailText).apply();
                    Toast.makeText(v.getContext(), emailText, Toast.LENGTH_SHORT).show();
                    myEdit.putString("name", emailText).apply();
                    myEdit.putString("password", passwordText).apply();
                    user = new User();
                    user.setEmail(preferences.getString("email", ""));
                    user.setName(preferences.getString("name",""));
                    user.setPassword(preferences.getString("password",""));
                    Intent intent  = new Intent(getActivity(), MainActivity.class);

                    viewModel
                            .getUserInfo(user)
                            .observe(
                                    getViewLifecycleOwner(),
                                    response -> {
                                        if (response != null) {
                                            if (response.toString() == "true"){

                                                Log.d("tagging", response.toString());
                                                startActivity(intent);
                                            }
                                        }
                                    });

                }



            }
        });
    }


    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.signup_3:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new signUpFragment()).commit();
                break;
            default:
                break;

       }
    }

}