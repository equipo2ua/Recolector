package com.example.recolector.io.Response;
import com.example.recolector.io.Model.IniciarSessionData;
import com.example.recolector.io.Model.RegistroRecolecciónData;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("registrarRecolector/")
    Call<List> postRegistrarRecolector(@Header("Authorization") String authorization,@Body RegistroRecolecciónData registroRecolecciónData);


    @POST("iniciarSesionRecolector/")
    Call<List> postSesionRecolector(@Header("Authorization") String authorization, @Body IniciarSessionData sessionData);

    @GET("listar-solicitudes/")
    Call<List> listSolicitudes(@Header("Authorization") String authorization);

    //@GET("verDetalleSolicitud")


}
