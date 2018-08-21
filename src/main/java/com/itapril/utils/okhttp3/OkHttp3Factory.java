package com.itapril.utils.okhttp3;

/**
 * @author itapril.
 * @create 2018/8/21 15:00.
 */
public class OkHttp3Factory {

    private static OkHttp3Wrapper okHttp3Loader;

    public OkHttp3Factory() {
    }

    public static OkHttp3Wrapper getOkHttpLoader() {

        if (okHttp3Loader == null){
            synchronized (OkHttp3Factory.class) {
                okHttp3Loader = new OkHttp3Loader();
            }
        }
        return okHttp3Loader;
    }

}
