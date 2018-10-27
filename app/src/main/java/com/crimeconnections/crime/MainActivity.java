package com.crimeconnections.crime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.crimeconnections.crime.CrimePojos.Attributes;
import com.crimeconnections.crime.CrimePojos.CrimeData;
import com.crimeconnections.crime.CrimePojos.Feature;
import com.crimeconnections.crime.Remote.ApiService;
import com.crimeconnections.crime.Remote.ApiUtils;
import com.crimeconnections.crimeconnections.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity implements View.OnClickListener{
    RadioGroup rgDate,rgCrime;
    int time=1;
    String crimeType="accident";
    ApiService apiService;
    CrimeData crimeData;
    ArrayList<Feature> featureArrayList=new ArrayList<Feature>();
    Call<CrimeData> crimeDataCall;
    ArrayList<Attributes> attributesArrayList=new ArrayList<Attributes>();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgDate=findViewById(R.id.radioGroup6);
        rgCrime=findViewById(R.id.radioGroup7);
        apiService= ApiUtils.getApiService();
        button=findViewById(R.id.button);
        button.setOnClickListener(this);

        rgDate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radioButton8:
                        time=-3;
                        break;
                    case R.id.radioButton9:
                        time=-6;
                        break;
                    case R.id.radioButton7:
                        time=-9;
                        break;
                }
            }
        });

        rgCrime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radioButton13:
                        crimeType="accident";
                        break;
                    case R.id.radioButton15:
                        crimeType="assault";
                        break;
                    case R.id.radioButton14:
                        crimeType="burglary";
                        break;
                }
            }
        });

    }


    void getCrimeData()
    {
        attributesArrayList.clear();
        crimeDataCall=apiService.fetch();
        crimeDataCall.enqueue(new Callback<CrimeData>() {
            @Override
            public void onResponse(Call<CrimeData> call, Response<CrimeData> response) {
                crimeData=response.body();
                featureArrayList=(ArrayList<Feature>) crimeData.getFeatures();
                for(Feature feature:featureArrayList)
                {
                    attributesArrayList.add(feature.getAttributes());
                }
                parseData();


            }

            @Override
            public void onFailure(Call<CrimeData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void parseData()
    {
        ArrayList<Attributes> attributesArrayList1=new ArrayList<Attributes>();
        for(Attributes attributes:attributesArrayList)
        {

            if(attributes.getCFSType()!=null) {
                if (attributes.getCFSType().toLowerCase().contains(crimeType.toLowerCase())) {
                    Date date = new Date(attributes.getOccDt());
                    if (!isThisDateWithin3MonthsRange(date.toString(), "E MMM dd HH:mm:ss Z yyyy"))
                    {
                        attributesArrayList1.add(attributes);
                    }

                } else {
                    attributesArrayList1.add(attributes);
                }
            }
            else
            {
                attributesArrayList1.add(attributes);
            }
        }
        attributesArrayList.removeAll(attributesArrayList1);
        Intent intent=new Intent(this,CrimeActivity.class);
        intent.putExtra("attr",attributesArrayList);
        startActivity(intent);
    }

    public boolean isThisDateWithin3MonthsRange(String dateToValidate,
                                                String dateFormat) {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {

            Date date = sdf.parse(dateToValidate);


            Calendar currentDateBefore3Months = Calendar.getInstance();
            currentDateBefore3Months.set(Calendar.YEAR,2012);
            currentDateBefore3Months.add(Calendar.MONTH, time);

            System.out.println("\n\ncurrentDate : "
                    + Calendar.getInstance().getTime());
            System.out.println("currentDateBefore3Months : "
                    + currentDateBefore3Months.getTime());
            System.out.println("dateToValidate : " + dateToValidate);

            if ( date.after(currentDateBefore3Months.getTime())) {

                return true;

            } else {

                return false;

            }

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void onClick(View v) {
        getCrimeData();
    }
}

