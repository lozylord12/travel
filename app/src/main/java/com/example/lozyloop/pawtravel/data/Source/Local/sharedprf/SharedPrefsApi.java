package com.example.lozyloop.pawtravel.data.Source.Local.sharedprf;

public interface SharedPrefsApi {
    <T> T get(String key, Class<T> clazz);

    <T> void put(String key, T data);

    void delete(String key);

    void clear();
}
