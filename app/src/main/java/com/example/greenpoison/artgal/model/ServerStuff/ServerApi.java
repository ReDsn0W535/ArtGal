package com.example.greenpoison.artgal.model.ServerStuff;

import android.graphics.Paint;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerApi {
    @GET("showBD.php")
    Call<List<Painting>> getAll();


}
