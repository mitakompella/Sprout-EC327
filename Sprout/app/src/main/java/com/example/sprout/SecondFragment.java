package com.example.sprout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    EditText et;
    Button bt;
    ListView listView;
    ArrayAdapter<String> listViewAdapter;
    String[] menuItems = {" Pothos", "  Snake Plant", " Succulent"};
    int[] plantImages = {R.drawable.pothos, R.drawable.snakeplant, R.drawable.succulent};
    int[] plantInfo = {R.drawable.pothosinfo, R.drawable.snakeplantinfo, R.drawable.succulentinfo};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), listviewdata.class);
                intent.putExtra("name", menuItems[i]);
                intent.putExtra("image", plantImages[i]);
                intent.putExtra("info", plantInfo[i]);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }


    public void onViewCreated(@NonNull ListView listView, Bundle savedInstanceState){
        super.onViewCreated(listView, savedInstanceState);

        listView.findViewById(R.id.listview);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.button_second_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }

        });

    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return plantImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.plants);
            ImageView image= view1.findViewById(R.id.images);
            name.setText(menuItems[i]);
            image.setImageResource(plantImages[i]);
            return view1;
        }
    }
}