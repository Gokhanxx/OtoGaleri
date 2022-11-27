package com.example.otogaleri.restapi;


import com.example.otogaleri.models.Activate;
import com.example.otogaleri.models.IlanVer;
import com.example.otogaleri.models.Result;
import com.example.otogaleri.models.Uyeler;
import com.example.otogaleri.models.iller;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    Call<Result> createuser(@Field("kadi") String kadi, @Field("kemail") String kemail,@Field("ksifre") String ksifre,@Field("appuserid")String appuserid);
    //endregion

    //region Verification
    @FormUrlEncoded
    @POST("/OtoGaleri/VerificationPage/aktifet.php")
    Call<Activate> useractivate( @Field("kemail") String email, @Field("kod") String kod);
    //endregion

    //region citylist
    @POST("/OtoGaleri/MyAdsPage/cityList.php")
    Call<List<iller>> illist();
    //endregion

    //region ilanver
    @FormUrlEncoded//bu parametere gönderken ŞARRTTTT
    @POST("/OtoGaleri/MyAdsImagePage/ilanver.php")
    Call<IlanVer> ilanverkayit(@Field("kullaniciadi") String uyeid, @Field("sehirid") int sehirid, @Field("ilce") String ilce, @Field("mahalle") String mahalle, @Field("marka") String marka, @Field("seri") String seri, @Field("model") String model, @Field("yil") String yil, @Field("km") String km,@Field("ilantipi") String ilantipi, @Field("kimden") String kimden, @Field("baslik") String baslik, @Field("aciklama") String aciklama, @Field("motortipi") String motortipi, @Field("motorhacmi") String motorhacmi, @Field("surat") String surat, @Field("yakittipi") String yakittipi, @Field("ortalamayakit") String ortalamayakit, @Field("depohacmi") String depohacmi);
    //endregion










}
