package fr.esiea.ex4A.agify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<Age> getAge(@Query("name") String name, @Query("country_id") String country);
}
