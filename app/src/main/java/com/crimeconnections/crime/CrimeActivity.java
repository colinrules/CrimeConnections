package com.crimeconnections.crime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.crimeconnections.crime.Adapters.CrimeDetailAdapter;
import com.crimeconnections.crime.CrimePojos.Attributes;
import com.crimeconnections.crimeconnections.R;

import java.util.ArrayList;

public class CrimeActivity extends AppCompatActivity{
    ArrayList<Attributes> attributesArrayList=new ArrayList<Attributes>();
    RecyclerView recyclerView;
    CrimeDetailAdapter crimeDetailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attributesArrayList=(ArrayList<Attributes>)getIntent().getSerializableExtra("attr");
        setContentView(R.layout.activity_crime_detail);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        crimeDetailAdapter=new CrimeDetailAdapter(attributesArrayList,this);
        recyclerView.setAdapter(crimeDetailAdapter);
        if(attributesArrayList.size()==0)
        {
            recyclerView.setVisibility(View.GONE);
            findViewById(R.id.err).setVisibility(View.VISIBLE);
        }

    }
}
