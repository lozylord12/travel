package com.example.lozyloop.pawtravel.Screen.Handle.Profile;

import android.util.Log;

import com.example.lozyloop.pawtravel.data.Model.Profile;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BaseException;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.RequestError;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LogoutResponse;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfileFragmentPresenter implements ProfileFragmentContract.Presenter {

    ProfileFragmentContract.View mView;
    AuthenticationRepository mAuthenticationRepository;
    CompositeDisposable mCompositeDisposable;

    public ProfileFragmentPresenter(AuthenticationRepository mAuthenticationRepository) {
        this.mAuthenticationRepository = mAuthenticationRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void logout() {
        onLogoutSuccess();
    }

    @Override
    public void showProfile(String id, String username, String api_key) {
//        Disposable disposable = mAuthenticationRepository.getProfile(id,username,api_key)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Profile>() {
//                    @Override
//                    public void accept(Profile profile) throws Exception {
//                        mView.ShowProfile(profile);
//                    }
//                });
//        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public void setView(ProfileFragmentContract.View view){
        mView = view;
    }

    private void onLogoutSuccess(){
        Disposable disposable = mAuthenticationRepository.Logout()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LogoutResponse>() {
                    @Override
                    public void accept(LogoutResponse logoutResponse) throws Exception {
                        mView.LogoutSuccess();
                        mAuthenticationRepository.deleteUser();

                    }
                }, new RequestError() {
                    @Override
                    public void onRequestError(BaseException error) {

                    }
                });

        mCompositeDisposable.add(disposable);
    }
}
