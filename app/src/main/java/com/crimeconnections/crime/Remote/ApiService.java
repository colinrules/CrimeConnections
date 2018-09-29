package com.crimeconnections.crime.Remote;

import com.crimeconnections.crime.CrimePojos.CrimeData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("query?where=1%3D1&outFields=*&outSR=4326&f=json")
    Call<CrimeData> fetch();
}
