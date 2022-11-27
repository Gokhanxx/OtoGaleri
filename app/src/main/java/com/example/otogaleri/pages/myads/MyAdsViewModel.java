package com.example.otogaleri.pages.myads;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.otogaleri.models.Uyeler;
import com.example.otogaleri.models.iller;
import com.example.otogaleri.restapi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyAdsViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public MutableLiveData<String> resultmessage;
    public MutableLiveData<List<iller>> resultlist;
    public MutableLiveData<Boolean> resultiserror = new MutableLiveData<>();
    public MutableLiveData<Boolean> resultdialog = new MutableLiveData<>();

    public void illeridoldur() {
        resultmessage = new MutableLiveData<>();
        resultlist = new MutableLiveData<>();
        Call<List<iller>> il = ManagerAll.getInstance().illist();
        il.enqueue(new Callback<List<iller>>() {
            @Override
            public void onResponse(Call<List<iller>> call, Response<List<iller>> response) {
                if (response.isSuccessful()) {
                    resultlist.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<iller>> call, Throwable t) {
                resultlist.setValue(null);
            }
        });

    }

}