package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error;

import android.support.annotation.NonNull;

import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BaseException;

import io.reactivex.functions.Consumer;



public abstract class RequestError implements Consumer<Throwable> {


    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        if (throwable == null) {
            onRequestError(BaseException.toUnexpectedError(new Throwable("Unknown exception")));
            return;
        }
        if (throwable instanceof BaseException) {
            onRequestError((BaseException) throwable);
        } else {
            onRequestError(BaseException.toUnexpectedError(throwable));
        }
    }

    public abstract void onRequestError(BaseException error);
}
