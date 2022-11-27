package com.example.otogaleri.restapi;

import android.util.Log;

import com.example.otogaleri.models.Activate;
import com.example.otogaleri.models.IlanVer;
import com.example.otogaleri.models.Result;
import com.example.otogaleri.models.Uyeler;
import com.example.otogaleri.models.iller;


import java.util.List;

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

    public Call<Result> createuser(String kullaniciadi,String kullaniciemail, String kullanicisifre,String appuserid) {
        Call<Result> a = getRestApi().createuser(kullaniciadi,kullaniciemail,kullanicisifre,appuserid);
        return a;
    }

    public Call<Activate> useractivate(String kullaniciemail, String kod) {
        Call<Activate> a = getRestApi().useractivate(kullaniciemail,kod);
        return a;
    }

    public Call<List<iller>> illist() {
        Call<List<iller>> a = getRestApi().illist();
        return a;
    }

    public Call<IlanVer> ilanverkayit(String uye_id,int sehirid,String ilce,String mahalle,String marka,String seri,String model,String yil,String km,String ilantipi,String kimden,String baslik,String aciklama,String motortipi,String motorhacmi,String surat,String yakittipi,String ortalamayakit,String depohacmi) {
        //Log.i("log46","/"+uye_id+"/"+sehirid+"/"+ilce+"/"+mahalle+"/"+marka+"/"+seri+"/"+model+"/"+ yil+"/"+ km+"/"+ ilantipi+"/"+ kimden+"/"+ baslik+"/"+ aciklama+"/"+ motortipi+"/"+ motorhacmi+"/"+ surat+"/"+ yakittipi+"/"+ ortalamayakit+"/"+ depohacmi);
        Call<IlanVer> a = getRestApi().ilanverkayit(uye_id, sehirid,ilce,mahalle,marka,seri,model, yil, km, ilantipi, kimden, baslik, aciklama, motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi);

        return a;
    }






}
