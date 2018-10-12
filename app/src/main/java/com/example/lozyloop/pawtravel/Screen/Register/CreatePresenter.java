package com.example.lozyloop.pawtravel.Screen.Register;


import android.util.Log;
import android.widget.Toast;

import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BaseException;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.RequestError;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.SignUpError;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response.LoginResponse;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;


import java.io.IOException;
import java.lang.annotation.Annotation;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;


import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CreatePresenter implements CreateContract.Presenter {

    CreateContract.View mView;
    AuthenticationRepository mAuthenticationRepository;
    CompositeDisposable mCompositeDisposable;

    public CreatePresenter(AuthenticationRepository mAuthenticationRepository) {
        this.mAuthenticationRepository = mAuthenticationRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void create(String username, String password, String first_name, String last_name, String email) {
        onValidateUserSuccess(username,password,first_name,last_name,email);
    }

    @Override
    public void getSignUpError(Throwable e, Retrofit retrofit) {
        if (e instanceof HttpException){
            ResponseBody body = ((HttpException) e).response().errorBody();

            Converter<ResponseBody, SignUpError> errorConverter =
                    retrofit.responseBodyConverter(SignUpError.class, new Annotation[0]);
            try {
                SignUpError error = errorConverter.convert(body);
                mView.showError(error.getmError());
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public void setmView(CreateContract.View mView) {
        this.mView = mView;
    }

    private void onValidateUserSuccess(String username, String password, String first_name, String last_name, String email){
        Disposable disposables = mAuthenticationRepository.CreateToServer(username, password, first_name, last_name, email)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginResponse>() {
                    @Override
                    public void onNext(LoginResponse loginResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.HandleError(e);
                        Log.d("ABC",e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        mView.showLabel();

                    }
                });
//                .subscribe(new Consumer<LoginResponse>() {
//                    @Override
//                    public void accept(LoginResponse loginResponse) throws Exception {
//                        mView.showLabel();
//                    }
//                }, new RequestError() {
//                    @Override
//                    public void onRequestError(BaseException error) {
//
//                    }
//                });

        mCompositeDisposable.add(disposables);

    }




}
