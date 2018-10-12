package com.example.lozyloop.pawtravel.data.Source.Remote.Api.Response;

import com.example.lozyloop.pawtravel.data.Model.ErrorMessage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;


public class ErrorResponse {
    @Expose
    private int mCode;
    @Expose
    private String mMessages;
    @Expose
    @SerializedName("data")
    private ErrorMessage mErrorMessage;

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        if (mErrorMessage != null
                && mErrorMessage.getMessages() != null
                && mErrorMessage.getMessages().size() != 0) {
            return mMessages.toUpperCase(Locale.getDefault())
                    + "\n"
                    + mErrorMessage.getMessageList();
        }
        return mMessages;
    }
}
