package com.example.lozyloop.pawtravel.Screen.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Login.LoginPresenter;
import com.example.lozyloop.pawtravel.data.Source.Local.AuthenticationLocalDataSource;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsImpl;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.SignUpError;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Request.SignUpRequest;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.RetrofitClient;
import com.example.lozyloop.pawtravel.data.Source.Remote.AuthenticationRemoteDataSource;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateActivity extends AppCompatActivity implements CreateContract.View {

    Button btn_SignUp;
    ImageButton btn_back_main;
    EditText et_username,et_email,et_pass,et_first_name,et_last_name;
    TextView text_error_signup;
    ProgressBar mProgressBarCreate;

    CreatePresenter mPresenter;

    AuthenticationRepository mAuthenticationRepository;

    AuthenticationLocalDataSource mAuthenticationLocalDataSource;
    AuthenticationRemoteDataSource mAuthenticationRemoteDataSource;

    SharedPrefsImpl mSharedPrefsImpl;

    RetrofitClient mRetrofitClient = new RetrofitClient();

    Retrofit mSignUpRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        init();

        mSharedPrefsImpl = new SharedPrefsImpl(this);


        EventOnclick();
    }

    public void init(){
        btn_back_main = findViewById(R.id.btn_back_main);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        et_first_name = findViewById(R.id.et_first_name);
        et_last_name = findViewById(R.id.et_last_name);
        text_error_signup = findViewById(R.id.text_error_signup);
        mProgressBarCreate = findViewById(R.id.mProgressBarCreate);

        mProgressBarCreate.setVisibility(View.GONE);

        mSignUpRetrofit = RetrofitClient.provideRetrofit(RetrofitClient.provideGson(),RetrofitClient.provideOkHttp());

        mAuthenticationLocalDataSource = new AuthenticationLocalDataSource(mSharedPrefsImpl);
        mAuthenticationRemoteDataSource = new AuthenticationRemoteDataSource(mRetrofitClient.provideNameApi(RetrofitClient.getGetInstance()));

        mAuthenticationRepository = new AuthenticationRepository (mAuthenticationLocalDataSource,mAuthenticationRemoteDataSource);
        mPresenter = new CreatePresenter(mAuthenticationRepository);
        mPresenter.setmView(this);
    }

    public void EventOnclick(){

        btn_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_pass.getText().toString();
                String first_name = et_first_name.getText().toString();
                String last_name = et_last_name.getText().toString();
                String email = et_email.getText().toString();

                mPresenter.create(username,password,first_name,last_name,email);
                mProgressBarCreate.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void showLabel() {
        Toast.makeText(this, "Create Success", Toast.LENGTH_SHORT).show();
        mProgressBarCreate.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        text_error_signup.setText(error);
        mProgressBarCreate.setVisibility(View.INVISIBLE);
    }

    @Override
    public void HandleError(Throwable e) {
        mPresenter.getSignUpError(e, mSignUpRetrofit);
    }


}
