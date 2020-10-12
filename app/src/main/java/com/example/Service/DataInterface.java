package com.example.Service;

import com.example.Service.Request.RequestEnvelope;
import com.example.Service.Response.ResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DataInterface {

    @Headers({"Content-Type: text/xml; charset=utf-8", "SOAPAction: http://thienhaso.com/GetLearningLevel"})
    @POST("AccountAPI.asmx")
    Call<ResponseEnvelope> GetLearningLevel(@Body RequestEnvelope requestEnvelope);

    @Headers({"Content-Type: text/xml; charset=utf-8", "SOAPAction: http://thienhaso.com/GetTrainingLevel"})
    @POST("AccountAPI.asmx")
    Call<ResponseEnvelope> GetTrainingLevel(@Body RequestEnvelope requestEnvelope);

    @Headers({"Content-Type: text/xml; charset=utf-8", "SOAPAction: http://thienhaso.com/GetSpecialBranch"})
    @POST("AccountAPI.asmx")
    Call<ResponseEnvelope> GetSpecialBranch(@Body RequestEnvelope requestEnvelope);
}
