package com.itapril.utils.okhttp3;

import java.util.Map;

/**
 * @author itapril.
 * @create 2018/8/21 15:00.
 */
public interface OkHttp3Wrapper {

    /**
     * get 同步请求
     * @param url 请求的url
     * @return 返回的字符串
     * @throws Exception 异常
     */
    String get(String url) throws Exception;

    /**
     *
     * @param url 请求的url
     * @param params 请求的url的参数 ?name="test",如果没有参数，传null
     * @param headers 请求的请求头，如果不需要传 null
     * @return 返回的字符串
     * @throws Exception
     */
    String get(String url, Map<String, Object> params, Map<String, String> headers) throws Exception;

    /**
     * post 同步请求
     * @param url 请求的url
     * @param jsonStr 请求的body,json格式的字符串
     * @return 返回的字符串
     * @throws Exception 异常
     */
    String post(String url, String jsonStr) throws Exception;

    /**
     *
     * post 同步请求
     * @param url 请求的url
     * @param jsonStr 请求的body,json格式的字符串
     * @param headers 指定请求的请求头(headers)，如果不需要传 null
     * @return 返回的字符串
     * @throws Exception 异常
     */
    String post(String url, String jsonStr, Map<String, String> headers) throws Exception;

}
