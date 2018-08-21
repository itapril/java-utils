package com.itapril.test.okhttp3;

import com.itapril.utils.okhttp3.OkHttp3Factory;
import com.itapril.utils.okhttp3.OkHttp3Wrapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itapril.
 * @create 2018/8/21 15:19.
 */
public class HttpTest {

    @Test
    public void HttpTest1() throws Exception{
        OkHttp3Wrapper http3Wrapper = OkHttp3Factory.getOkHttpLoader();
        String str = http3Wrapper.get("http://www.baidu.com");
        System.out.println(str);
        String str2 = http3Wrapper.get("http://www.baidu.com");
        System.out.println(str2);

    }

    @Test
    public void HttpTes3() throws Exception{
        OkHttp3Wrapper http3Wrapper = OkHttp3Factory.getOkHttpLoader();
        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("page", 10);
//        map.put("name", "itapril");
        String str = http3Wrapper.get("http://www.baidu.com",map,new HashMap<String, String>());
        System.out.println(str);
        String str2 = http3Wrapper.get("http://www.baidu.com");
        System.out.println(str2);
    }

}
