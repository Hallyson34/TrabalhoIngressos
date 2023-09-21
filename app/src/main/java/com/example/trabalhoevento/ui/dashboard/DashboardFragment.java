package com.example.trabalhoevento.ui.dashboard;

import android.database.DataSetObserver;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private MediaPlayer mediaPlayer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ListView listView = contentView.findViewById(R.id.list_view);

        MyAdapter listAdapter = new MyAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                switch (position){
                    case 0:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.postmalone);
                        mediaPlayer.start();
                        break;
                    case 1:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.brunomars);
                        mediaPlayer.start();
                        break;
                    case 2:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.imaginedragons);
                        mediaPlayer.start();
                        break;
                    case 3:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.alok);
                        mediaPlayer.start();
                        break;
                    case 4:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.blackbear);
                        mediaPlayer.start();
                        break;
                    case 5:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.lilnasx);
                        mediaPlayer.start();
                        break;
                }
            }
        });

        return contentView;
    }

    private class MyAdapter extends BaseAdapter {

        // override other abstract methods here
        String[] shows = new String[]
                {
                        "Post Malone (20h) - Clique para conhecer",
                        "Bruno Mars (21h) - Clique para conhecer",
                        "Imagine Dragons (22h) - Clique para conhecer",
                        "Alok (23h) - Clique para conhecer",
                        "Blackbear (00h) - Clique para conhecer",
                        "Lil Nas X (01h) - Clique para conhecer",
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