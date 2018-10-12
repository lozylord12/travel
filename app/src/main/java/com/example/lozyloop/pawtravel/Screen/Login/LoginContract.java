package com.example.lozyloop.pawtravel.Screen.Login;

import com.example.lozyloop.pawtravel.Screen.BasePresenter;

public class LoginContract {

    interface View {
        void showManUI();
        void showError();
    }


    interface Presenter extends BasePresenter<View> {

        void login(String username, String password);

    }
}
