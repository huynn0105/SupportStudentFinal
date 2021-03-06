package com.example.Service;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitGenerator {
    public final static String BASE_URL = "http://phanmemdaotao.com/testapi/";
    public static StudentAPI studentAPI;

    private static final Strategy strategy = new AnnotationStrategy();
    private static final Serializer serializer = new Persister(strategy);

    private static final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    private static final Retrofit.Builder retrofitBuilder =  new Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
            .baseUrl(BASE_URL);

    public static <S> S createService(Class<S> serviceClass) {
        okHttpClient.interceptors().add(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Content-Type", "text/xml;charset=UTF-8")
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        OkHttpClient client = okHttpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
        Retrofit retrofit = retrofitBuilder.client(client).build();
        return retrofit.create(serviceClass);
    }



    public static StudentAPI getRetrofit() {
        if(studentAPI == null) {
            studentAPI = createService(StudentAPI.class);
        }
        return studentAPI;

    }
}
