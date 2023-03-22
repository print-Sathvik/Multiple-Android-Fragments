package com.example.fragmentsold;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.HashMap;

public class ListFragment extends Fragment {
    String company;
    ListView list;
    TextView tv;
    HashMap<String, String[]> carModels = new HashMap<>();
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listfragment, viewGroup, false);

        carModels.put("Suzuki", new String[] {"Ciaz", "Dzire", "Baleno", "Alto"});
        carModels.put("BMW", new String[] {"Gran Coupe", "BMW X7", "BMW i7"});
        carModels.put("Honda", new String[] {"Jazz", "City", "Amaze"});
        carModels.put("Ferrari", new String[] {"Ferrari F8", "Roma", "Portofino"});
        carModels.put("Default", new String[] {"Modle1", "Model2"});

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstaceState) {
        Bundle data = getArguments();
        list = view.findViewById(R.id.listView);
        tv = view.findViewById(R.id.textView2);
        if(data != null){
            company = data.getString("company");
        }
        else {
            company = "Default";
        }
        super.onViewCreated(view, savedInstaceState);
        Log.d("Success",company + "************");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, carModels.get(company));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String[] models = carModels.get(company);
                Log.d("Success", company+"+++++++++"+models[position]);
                Bundle bundle = new Bundle();
                bundle.putString("name", models[position]);
                bundle.putString("company", company);
                Fragment detailsFrag = new DetailsFragment();
                detailsFrag.setArguments(bundle);
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.frame2, detailsFrag);
                ft.commit();

            }
        });
        list.setAdapter(ad);
        tv.setText(company);
        list.setSelector(android.R.color.holo_red_light);


        //Setting First Car Details for every company button click
        String[] models = carModels.get(company);
        Bundle bundle = new Bundle();
        bundle.putString("name",models[0]);
        bundle.putString("company", company);
        Fragment detailsFrag = new DetailsFragment();
        detailsFrag.setArguments(bundle);
        fm = getActivity().getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame2, detailsFrag);
        ft.commit();
    }
}
