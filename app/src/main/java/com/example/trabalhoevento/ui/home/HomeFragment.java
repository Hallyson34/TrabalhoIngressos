package com.example.trabalhoevento.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.trabalhoevento.R;
import com.example.trabalhoevento.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private GridView gridView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        gridView = binding.gridApresentacoes;

        int[] list = new int[]{ R.drawable.postmalone, R.drawable.brunomars,
                R.drawable.imaginedragons, R.drawable.alok,
                R.drawable.blackbear, R.drawable.lilnasx,
        };
        gridView.setAdapter(new Adaptador(getContext(), list));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}