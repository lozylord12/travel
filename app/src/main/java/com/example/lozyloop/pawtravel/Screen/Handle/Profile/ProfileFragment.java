package com.example.lozyloop.pawtravel.Screen.Handle.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Handle.TravelActivity;
import com.example.lozyloop.pawtravel.Screen.Login.SigninActivity;
import com.example.lozyloop.pawtravel.data.Source.Local.AuthenticationLocalDataSource;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsImpl;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.RetrofitClient;
import com.example.lozyloop.pawtravel.data.Source.Remote.AuthenticationRemoteDataSource;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

public class ProfileFragment extends Fragment implements ProfileFragmentContract.View {

    ProfileFragmentPresenter mPresenter;

    AuthenticationRepository mAuthenticationRepository;

    AuthenticationLocalDataSource mAuthenticationLocalDataSource;
    AuthenticationRemoteDataSource mAuthenticationRemoteDataSource;

    SharedPrefsImpl mSharedPrefsImpl;

    RetrofitClient mRetrofitClient = new RetrofitClient();

    Button btn_signOut;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        init(v);
        onClickEvent();


        return v;
    }

    public void init(View view){
        btn_signOut = view.findViewById(R.id.btn_signOut);

        mAuthenticationLocalDataSource = new AuthenticationLocalDataSource(mSharedPrefsImpl);
        mAuthenticationRemoteDataSource = new AuthenticationRemoteDataSource(mRetrofitClient.provideNameApi(RetrofitClient.getGetInstance()));

        mAuthenticationRepository = new AuthenticationRepository (mAuthenticationLocalDataSource,mAuthenticationRemoteDataSource);
        mPresenter = new ProfileFragmentPresenter(mAuthenticationRepository);
        mPresenter.setView(ProfileFragment.this);
    }

    public void onClickEvent(){
        btn_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.logout();
            }
        });
    }

    @Override
    public void LogoutSuccess() {
        getActivity().finish();
    }
}
