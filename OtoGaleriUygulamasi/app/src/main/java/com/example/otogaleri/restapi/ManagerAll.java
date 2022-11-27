package com.example.otogaleri.restapi;

import com.example.otogaleri.models.Result;
import com.example.otogaleri.models.Uyeler;


import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<Uyeler> loginUser(String kullaniciadi, String kullanicisifre) {
        Call<Uyeler> a = getRestApi().loginUser(kullaniciadi, kullanicisifre);
        return a;

    }

    public Call<Result> createuser(String kullaniciadi,String kullaniciemail, String kullanicisifre) {
        Call<Result> a = getRestApi().createuser(kullaniciadi,kullaniciemail,kullanicisifre);
        return a;
    }



}
