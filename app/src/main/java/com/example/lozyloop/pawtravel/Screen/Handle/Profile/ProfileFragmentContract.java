package com.example.lozyloop.pawtravel.Screen.Handle.Profile;

import com.example.lozyloop.pawtravel.Screen.BasePresenter;

public class ProfileFragmentContract {

    interface View{
        void LogoutSuccess();
    }

    interface Presenter extends BasePresenter<View>{
        void logout();
    }
}
