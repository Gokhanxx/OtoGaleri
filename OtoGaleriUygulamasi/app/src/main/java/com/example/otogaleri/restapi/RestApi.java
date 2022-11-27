package com.example.otogaleri.restapi;


import com.example.otogaleri.models.Result;
import com.example.otogaleri.models.Uyeler;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {


    //region LoginPage
    @FormUrlEncoded
    @POST("/OtoGaleri/LoginPage/login.php")
    Call<Uyeler> loginUser(@Field("kullaniciadi") String kadi, @Field("kullanicisifre") String ksifre);
    //endregion

    //region NewUserPage
    @FormUrlEncoded
    @POST("/OtoGaleri/NewUserPage/register.php")
    Call<Result> createuser(@Field("kadi") String kadi, @Field("kemail") String kemail,@Field("ksifre") String ksifre);
    //endregion



}
