package com.example.fragmentsold;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;


public class DetailsFragment extends Fragment {
    TextView nameTv;
    ImageView imageView;
    static HashMap<String, Integer> modelImages = new HashMap<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detailsfragment, viewGroup, false);

        modelImages.put("Ciaz", R.drawable.ciaz);
        modelImages.put("Dzire", R.drawable.dzire);
        modelImages.put("Baleno", R.drawable.baleno);
        modelImages.put("Alto", R.drawable.alto);
        modelImages.put("Gran Coupe", R.drawable.gran);
        modelImages.put("BMW X7", R.drawable.x7);
        modelImages.put("BMW i7", R.drawable.i7);
        modelImages.put("Jazz", R.drawable.jazz);
        modelImages.put("City", R.drawable.city);
        modelImages.put("Amaze", R.drawable.amaze);
        modelImages.put("Ferrari F8", R.drawable.f8);
        modelImages.put("Roma", R.drawable.roma);
        modelImages.put("Portofino", R.drawable.portofino);

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTv = view.findViewById(R.id.name);
        imageView = view.findViewById(R.id.imageView);
        Log.d("Success",getArguments().getString("name")+"...........");
        String model = getArguments().getString("name");
        nameTv.setText(getArguments().getString("company") + " " + model);
        imageView.setImageResource(modelImages.get(model));

    }
}
