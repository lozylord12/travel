package com.example.lozyloop.pawtravel.Screen.Register;

import com.example.lozyloop.pawtravel.Screen.BasePresenter;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.SignUpError;

import retrofit2.Retrofit;

public class CreateContract {

    interface View{
        void showLabel();
        void showError(String error);
        void HandleError(Throwable e);
    }

    interface Presenter extends BasePresenter<View>{

        void create (String username, String password, String first_name, String last_name, String email);
        void getSignUpError(Throwable e, Retrofit retrofit);
    }
}
