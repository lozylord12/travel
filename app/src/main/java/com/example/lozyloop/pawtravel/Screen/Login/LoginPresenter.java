package com.example.lozyloop.pawtravel.Screen.Login;






import android.util.Log;

import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BaseException;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.RequestError;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;
    AuthenticationRepository mAuthenticationRepository;
    CompositeDisposable mCompositeDisposable;


    public LoginPresenter(AuthenticationRepository mAuthenticationRepository) {
        this.mAuthenticationRepository = mAuthenticationRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }



    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public void setView(LoginContract.View view){
        mView = view;
    }

    @Override
    public void login(final String username,final String password) {
        onValidateEmailSuccess(username,password);
    }

    private void onValidateEmailSuccess(String username, String password) {
        Disposable disposable = mAuthenticationRepository.loginToServer(username, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showLoanding();
                    }
                })
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        mAuthenticationRepository.saveUserToLocal(loginResponse);
                        mView.showManUI();

                    }
                }, new RequestError() {
                    @Override
                    public void onRequestError(BaseException error) {

                        mView.showError();
                    }
                });


        mCompositeDisposable.add(disposable);

    }
}
