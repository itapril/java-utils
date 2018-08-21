package com.itapril.utils.okhttp3;


import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author itapril.
 * @create 2018/8/21 15:03.
 */
public class OkHttp3Loader implements OkHttp3Wrapper{

    private static final MediaType JSONTYPE = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            .readTimeout(3000, TimeUnit.MINUTES)
            .build();

    /**
     *
     * @param url 请求的url
     * @return 返回的字符串
     * @throws Exception
     */
    @Override
    public String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get().build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }


    /**
     *
     * @param url 请求的url
     * @param params 请求的url的参数 ?name="test",如果没有参数，传null
     * @param headers 请求的请求头，如果不需要传 null
     * @return 返回的字符串
     * @throws Exception
     */
    @Override
    public String get(String url, Map<String, Object> params, Map<String, String> headers) throws Exception {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        if(params != null){
            for (String key : params.keySet()) {
                urlBuilder.setQueryParameter(key, String.valueOf(params.get(key)));
            }
        }
        HttpUrl httpUrl = urlBuilder.build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .headers( headers == null ? new Headers.Builder().build() : Headers.of(headers))
                .get().build();

       /* Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                response.
                response.body().string();
            }
        });

        call.execute();*/
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    @Override
    public String post(String url, String jsonStr) throws Exception {
        RequestBody body = RequestBody.create(JSONTYPE, jsonStr);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    @Override
    public String post(String url, String jsonStr, Map<String, String> headers) throws Exception {
        RequestBody body = RequestBody.create(JSONTYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .headers( headers == null ? new Headers.Builder().build() : Headers.of(headers))
                .post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

}
