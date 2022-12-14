
package com.example.otogaleri.pages.newuser;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.otogaleri.R;
import com.example.otogaleri.databinding.FragmentNewuserBinding;
import com.example.otogaleri.others.ChangeFragment;
import com.example.otogaleri.others.Onesignal;
import com.example.otogaleri.pages.veritification.VerificationFragment;

public class NewUserFragment extends Fragment {


    private FragmentNewuserBinding binding;
    private NewUserViewModel viewModel;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewuserBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(NewUserViewModel.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttoncreateuser();
    }

    private void buttoncreateuser() {

        binding.buttonCreateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prossegdialogac();
                viewModel.createuser(binding.edittextUsername.getText().toString(), binding.edittextEmail.getText().toString(), binding.edittextPassword.getText().toString(), Onesignal.appuserid);
                viewModel.resultmessage.observe(getViewLifecycleOwner(), resultmesaj -> {

                    switch (resultmesaj) {
                        case "0":
                            Toast.makeText(getContext(), "Hata var yetkiliye bildiniriz", Toast.LENGTH_SHORT).show();
                            break;
                        case "1":
                            Toast.makeText(getContext(), "Kay??t Ba??ar??l??d??r Hesap Aktif olmas?? i??in L??tfen Do??rulay??n??z", Toast.LENGTH_SHORT).show();
                            createuserlistdinleceac();
                            break;
                        case "2":
                            Toast.makeText(getContext(), "B??le Bir Kullanici Ad?? Var", Toast.LENGTH_SHORT).show();
                            break;
                        case "3":
                            Toast.makeText(getContext(), "B??le Bir Email Var", Toast.LENGTH_SHORT).show();
                            break;
                        case "4":
                            Toast.makeText(getContext(), "4Kay??t Ba??ar??s??z L??tfen Yetkiliye bildiriniz", Toast.LENGTH_SHORT).show();
                            break;
                        case "5":
                            Toast.makeText(getContext(), "5Kay??t Ba??ar??s??z L??tfen Yetkiliye bildiriniz", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                });
                progressDialog.cancel();
            }
        });
    }

    public void createuserlistdinleceac() {
        viewModel.resultlist.observe(getViewLifecycleOwner(), resultlist -> {
            Bundle bundle = new Bundle();
            bundle.putString("email", binding.edittextEmail.getText().toString());
            bundle.putInt("kod", resultlist.getDogrulamakodu());
            ChangeFragment changeFragment = new ChangeFragment(getContext(), new VerificationFragment(), "replaceFragVerificition", R.id.nav_host_fragment_content_login, bundle);
            changeFragment.change();
        });

    }

    public void prossegdialogac() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Bilgiler Ekran??");
        progressDialog.setMessage("Devam eden i??leminiz bulunmaktad??r. L??tfen bekleyiniz..");
        progressDialog.setCancelable(false);//di??er yerlere t??klanmas??n diye
        progressDialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}