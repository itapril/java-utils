package com.itapril.test.json;

import com.itapril.utils.json.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by itapril on 2018/5/31 10:16.
 */
public class JsonUtilTest {

    @Test
    public void testJsonRun() throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","abc");
        map.put("b","abd");
        String jsonString = JsonUtil.toJsonString(map);
        System.out.println("============ the json string is \n" + jsonString);

        User user = new User();
        user.setId("123456");
        user.setUserName("hello");
        String userJsonString = JsonUtil.toJsonString(user);
        System.out.println("============ the user json string is \n" + userJsonString);


    }

}
