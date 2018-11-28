package com.example.lozyloop.pawtravel.Screen.Handle.Profile;

import com.example.lozyloop.pawtravel.Screen.BasePresenter;
import com.example.lozyloop.pawtravel.data.Model.Profile;

public class ProfileFragmentContract {

    interface View{
        void LogoutSuccess();
        void ShowProfile(Profile profile);
    }

    interface Presenter extends BasePresenter<View>{
        void logout();
        void showProfile(String id, String username, String api_key);
    }
}
