package com.softkoki.saltsideassignment.service;

import com.softkoki.saltsideassignment.model.MyImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by gulkush on 9/24/2016.
 */

public class DataService {

    private static String baseUrl = "https://gist.githubusercontent.com/maclir/f715d78b49c3b4b3b77f/raw/8854ab2fe4cbe2a5919cea97d71b714ae5a4838d/";
    private DataAPI dataAPI;

    public DataService() {
        this(baseUrl);
    }

    public DataService(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataAPI = retrofit.create(DataAPI.class);
    }

    public DataAPI getAPI() {
        return dataAPI;
    }

    public interface DataAPI {

        @GET("items.json")
        Call<List<MyImage>> getData();

    }
}
