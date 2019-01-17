package com.gustavoforero.wesendtest.data.remote;

import com.gustavoforero.wesendtest.data.remote.model.BTCResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface BTCApi {

    String URL_BASE = "https://localbitcoins.com/";

    @GET("buy-bitcoins-online/ves/.json")
    Call<BTCResponse> getOffers();


}
