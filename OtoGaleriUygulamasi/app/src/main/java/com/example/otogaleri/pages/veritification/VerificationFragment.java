package com.example.otogaleri.pages.veritification;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.otogaleri.databinding.FragmentVerificationBinding;

public class VerificationFragment extends Fragment {

    private FragmentVerificationBinding binding;
    private VerificationViewModel viewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentVerificationBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(VerificationViewModel.class);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getData();
    }

    private void getData() {

        if (getArguments() != null) {
            Toast.makeText(getContext(), "" + getArguments().getInt("kod") + " / " + getArguments().getString("email"), Toast.LENGTH_SHORT).show();
            binding.edittextEmail.setText(getArguments().getString("email"));
            binding.edittextPassword.setText(String.valueOf(getArguments().getInt("kod")));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}