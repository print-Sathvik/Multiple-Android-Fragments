package com.example.fragmentsold;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("company", "Suzuki");
        Fragment listFrag = new ListFragment();
        listFrag.setArguments(bundle);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.frame1, listFrag);
        ft.commit();

        bundle.putString("name", "Ciaz");
        bundle.putString("company", "Suzuki");
        Fragment detailsFrag = new DetailsFragment();
        detailsFrag.setArguments(bundle);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.frame2, detailsFrag);
        ft.commit();
    }

    public void companyClick(View v) {
        Button b = (Button)v;
        String company = b.getText().toString();
        Toast.makeText(this, company, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("company", company);
        Fragment listFrag = new ListFragment();
        listFrag.setArguments(bundle);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame1, listFrag);
        ft.commit();

    }

}
