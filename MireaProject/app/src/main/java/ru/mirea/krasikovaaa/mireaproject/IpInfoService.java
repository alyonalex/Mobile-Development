package ru.mirea.krasikovaaa.mireaproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpInfoService {
    @GET("json")
    Call<IpInfoResponse> getIpInfo();
}

