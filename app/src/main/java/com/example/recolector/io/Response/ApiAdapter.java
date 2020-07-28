package com.example.recolector.io.Response;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

        private static ApiService API_SERVICE;
        private  static  ApiService GET;

        public static ApiService getApiService() {

            // Creamos un interceptor y le indicamos el log level a usar
            //esto se mostrará por la consola del androidStudio y se visualizará el estado de la peticion
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Asociamos el interceptor a las peticiones
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            String baseUrl = "http://192.168.0.10:8000/recolector/";

            if (API_SERVICE == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                API_SERVICE = retrofit.create(ApiService.class);
            }

            return API_SERVICE;
        }

        public static ApiService getSolicitudes(){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            String baseUrl = "http://192.168.0.10:8000/solicitud/";

            if (GET == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                GET = retrofit.create(ApiService.class);
            }

            return GET;

        }


}
