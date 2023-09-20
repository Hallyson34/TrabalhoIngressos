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

        int[] list = new int[]{ R.drawable.postmalone, R.drawable.postmalone, R.drawable.postmalone,
                R.drawable.postmalone,
                R.drawable.postmalone,
                R.drawable.postmalone,
        };
        gridView.setAdapter(new Adaptador(getContext(), list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                switch (position){
                    case 0:
                        System.out.println('0');
                        break;
                    case 1:
                        System.out.println('1');
                        break;
                    case 2:
                        System.out.println('2');
                        break;
                    case 3:
                        System.out.println('3');
                        break;
                    case 4:
                        System.out.println('4');
                        break;
                    case 5:
                        System.out.println('5');
                        break;
                    case 6:
                        System.out.println('6');
                        break;
                    case 7:
                        System.out.println('7');
                        break;
                    case 8:
                        System.out.println('7');
                        break;
                }
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