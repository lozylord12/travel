package com.example.lozyloop.pawtravel.Screen.Handle.Chatbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lozyloop.pawtravel.R;

public class ChatboxFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chatbox_fragment, container, false);
    }
}
