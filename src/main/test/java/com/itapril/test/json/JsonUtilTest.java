package com.itapril.test.json;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.itapril.utils.json.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        JSONObject jsonObject = JSONObject.parseObject(userJsonString);

        //将json解析成User对象
        //json 串中的对象 需要跟User中的对象字段一致，有的就解析 没有就不解析
        Gson gson = new Gson();
        String jsonUserString = "{\"id\":\"54321\",\"userName\":\"再见\",\"age\":16}";
        User temp = gson.fromJson(jsonUserString, User.class);
        System.out.println("the user is " + temp);


        Map<String,List<Map>> mapList = new HashMap<String, List<Map>>();
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        mapList.put("list_1",list);
        mapList.put("list_2",list);
        String listJson = JsonUtil.toJsonString(mapList);
        System.out.println("the list json is " + listJson);


    }

}
