package com.crimeconnections.crime.Remote;

public class ApiUtils {

    public static ApiService getApiService()
    {
       return RetrofitClient.getClient().create(ApiService.class);
    }
}
