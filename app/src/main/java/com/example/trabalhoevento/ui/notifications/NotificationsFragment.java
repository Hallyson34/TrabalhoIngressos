package com.example.trabalhoevento.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.trabalhoevento.R;
import com.example.trabalhoevento.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Log.d("FragmentContext", "Context: " + requireContext());
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.quantity,
                android.R.layout.simple_spinner_item
        );
        binding.spinner1.setAdapter(adapter);
        binding.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.txtValue.setText(("Valor: R$ " + Double.toString((i + 1) * 60)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtFeedback.setText("Ingressos comprado com sucesso!");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}