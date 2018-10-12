package com.example.lozyloop.pawtravel.Screen.Login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lozyloop.pawtravel.R;

import com.example.lozyloop.pawtravel.Screen.Handle.TravelActivity;
import com.example.lozyloop.pawtravel.data.Source.Local.AuthenticationLocalDataSource;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsImpl;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.Api;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.RetrofitClient;
import com.example.lozyloop.pawtravel.data.Source.Remote.AuthenticationRemoteDataSource;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

import retrofit2.Retrofit;


public class SigninActivity extends AppCompatActivity implements LoginContract.View {

    LoginPresenter mPresenter;

    AuthenticationRepository mAuthenticationRepository;

    AuthenticationLocalDataSource mAuthenticationLocalDataSource;
    AuthenticationRemoteDataSource mAuthenticationRemoteDataSource;

    SharedPrefsImpl mSharedPrefsImpl;

    RetrofitClient mRetrofitClient = new RetrofitClient();


    private ImageButton btn_back;
    private EditText et_user,et_pass;
    private Button btn_Login;
    private TextView text_error;
    private ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mSharedPrefsImpl = new SharedPrefsImpl(this);
        init();

        onClickEvent();

    }

    public void init(){
        btn_back = findViewById(R.id.btn_back);
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        btn_Login = findViewById(R.id.btn_Login);
        text_error = findViewById(R.id.text_error);
        mProgressBar = findViewById(R.id.mProgressBar);

        mProgressBar.setVisibility(View.GONE);



        mAuthenticationLocalDataSource = new AuthenticationLocalDataSource(mSharedPrefsImpl);
        mAuthenticationRemoteDataSource = new AuthenticationRemoteDataSource(mRetrofitClient.provideNameApi(RetrofitClient.getGetInstance()));

        mAuthenticationRepository = new AuthenticationRepository (mAuthenticationLocalDataSource,mAuthenticationRemoteDataSource);
        mPresenter = new LoginPresenter(mAuthenticationRepository);
        mPresenter.setView(this);
    }


    @Override
    public void showManUI() {
        Intent intent = new Intent(this, TravelActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError() {
        text_error.setText(R.string.text_error_login);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    public void onClickEvent(){


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = et_user.getText().toString();
                String password = et_pass.getText().toString();

                mPresenter.login(username,password);
                mProgressBar.setVisibility(View.VISIBLE);

            }
        });
    }
}
