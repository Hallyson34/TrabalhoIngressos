package com.example.trabalhoevento.ui.dashboard;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabalhoevento.R;
import com.example.trabalhoevento.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ListView listView = contentView.findViewById(R.id.list_view);

        MyAdapter listAdapter = new MyAdapter();
        listView.setAdapter(listAdapter);
        return contentView;
    }

    private class MyAdapter extends BaseAdapter {

        // override other abstract methods here
        String[] shows = new String[]
                {
                        "Post Malone (20h)",
                        "Bruno Mars (21h)",
                        "Demi Lovato (22h)",
                        "Alok (23h)",
                        "Blackbear (00h)",
                        "Lil Nas X (01h)",
                };

        @Override
        public int getCount() {
            return shows.length;
        }

        @Override
        public Object getItem(int i) {
            return shows[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.fragment_dashboard, container, false);
            }
            TextView textView = new TextView(getContext());
            textView.setText(shows[position]);
            return textView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}