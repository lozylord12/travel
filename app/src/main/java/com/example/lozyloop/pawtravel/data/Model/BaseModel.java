package com.example.lozyloop.pawtravel.data.Model;

import com.google.gson.Gson;


public class BaseModel implements Cloneable {

    @Override
    public Object clone() {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), this.getClass());
    }
}
