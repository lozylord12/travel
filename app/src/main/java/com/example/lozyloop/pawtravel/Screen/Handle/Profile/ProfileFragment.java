package com.example.lozyloop.pawtravel.Screen.Handle.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.Handle.TravelActivity;
import com.example.lozyloop.pawtravel.Screen.Login.SigninActivity;
import com.example.lozyloop.pawtravel.data.Model.Profile;
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
    TextView text_paw,text_locate,text_contact;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        init(v);
        onClickEvent();
//        mPresenter.showProfile("1", "admin","5a7c55673ed13f91ce27d1f72f2dde849eddde4f");


        return v;
    }

    public void init(View view){
        btn_signOut = view.findViewById(R.id.btn_signOut);
        text_paw = view.findViewById(R.id.text_paw);
        text_locate = view.findViewById(R.id.text_locate);
        text_contact = view.findViewById(R.id.text_contact);

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

    @Override
    public void ShowProfile(Profile profile) {
        text_paw.setText(profile.getUsername());
        text_contact.setText(profile.getEmail());
    }


}
