package com.example.otogaleri.pages.myadsimage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.otogaleri.models.IlanVer;
import com.example.otogaleri.models.Uyeler;
import com.example.otogaleri.restapi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyadsImageViewModel extends ViewModel {


    public MutableLiveData<String> resultmessage;
    public MutableLiveData<Uyeler> resultlist;
    public MutableLiveData<Boolean> resultiserror = new MutableLiveData<>();
    public MutableLiveData<Boolean> resultdialog = new MutableLiveData<>();

    public void ilanver(String uye_id, int sehirid, String ilce, String mahalle, String marka, String seri, String model, String yil, String km, String ilantipi, String kimden, String baslik, String aciklama, String motortipi, String motorhacmi, String surat, String yakittipi, String ortalamayakit, String depohacmi) {
        //public void ilanver() {

        try {
            resultmessage = new MutableLiveData<>();
            Call<IlanVer> ilanver = ManagerAll.getInstance().ilanverkayit(uye_id, sehirid, ilce, mahalle, marka, seri, model, yil, km, ilantipi, kimden, baslik, aciklama, motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi);
            //Call<IlanVer> ilanver = ManagerAll.getInstance().ilanverkayit();
            ilanver.enqueue(new Callback<IlanVer>() {
                @Override
                public void onResponse(Call<IlanVer> call, Response<IlanVer> response) {
                    if (response.isSuccessful()) {
                        resultmessage.setValue(response.body().getresultmessage());
                    }else{
                        resultmessage.setValue(null);
                    }
                }
                @Override
                public void onFailure(Call<IlanVer> call, Throwable t) {
                    resultmessage.setValue(null);
                }
            });
        }catch (Exception e){
            Log.i("denene11",e.toString());
        }
    }
}