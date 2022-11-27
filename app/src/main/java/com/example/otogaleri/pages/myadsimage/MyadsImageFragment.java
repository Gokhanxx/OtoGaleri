package com.example.otogaleri.pages.myadsimage;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.otogaleri.R;
import com.example.otogaleri.activities.MainActivity;
import com.example.otogaleri.databinding.FragmentMyadsBinding;
import com.example.otogaleri.databinding.FragmentMyadsimageBinding;
import com.example.otogaleri.others.ChangeFragment;
import com.example.otogaleri.others.StaticData;
import com.example.otogaleri.pages.myads.MyAdsFragment;
import com.example.otogaleri.pages.myads.MyAdsViewModel;
import com.example.otogaleri.pages.newuser.NewUserFragment;

public class MyadsImageFragment extends Fragment {

    private MyadsImageViewModel viewModel;
    private FragmentMyadsimageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MyadsImageViewModel.class);
        binding = FragmentMyadsimageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttongeri();
        buttonilanverkayit();

    }

    private void buttongeri() {

        binding.geriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                ChangeFragment changeFragment = new ChangeFragment(getContext(), new MyAdsFragment(), "replaceFragMyAds", R.id.content_FrameLayout);
                changeFragment.change();

                //fragmentten aktiviteye animasyon geçiş kodudur
                getActivity().overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
    }

    public void buttonilanverkayit() {
        binding.ilanyayinlaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.ilanver(StaticData.getKullaniciadi(), Integer.valueOf(StaticData.getSehirid()), StaticData.getIlce(), StaticData.getMahalle(), StaticData.getMarka(), StaticData.getSeri(), StaticData.getModel(), StaticData.getYil(), StaticData.getKm(), StaticData.getIlantipi(), StaticData.getKimden(), StaticData.getBaslik(), StaticData.getAciklama(), StaticData.getMotortipi(), StaticData.getMotorhacmi(), StaticData.getSurat(), StaticData.getYakittipi(), StaticData.getOrtalamayakit(), StaticData.getDepohacmi());

                viewModel.resultmessage.observe(getViewLifecycleOwner(), resultmesaj -> {
                    switch (resultmesaj) {
                        case "0":
                            Toast.makeText(getContext(), "Ekleme Başarısız", Toast.LENGTH_SHORT).show();
                            break;
                        case "1":
                            Toast.makeText(getContext(), "Ekleme Başarılı", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }


                });

            }
        });

    }

}