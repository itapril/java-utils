package com.itapril.test.okhttp3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itapril.utils.httpclient.HttpClientConfig;
import com.itapril.utils.httpclient.HttpClientUtil;
import com.itapril.utils.httpclient.HttpClientUtils;
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

    @Test
    public void httpTest() {

        String url = "https://aliyun.wocloud.cn/cmp/api/aliyun/resources/request/ResourceModule@queryPrice";
        String json = "{\n" +
                "    \"content\":{\n" +
                "        \"queryCommodityPriceForms\":[\n" +
                "            {\n" +
                "                \"billingMode\":\"PrePaid\",\n" +
                "                \"productPackageId\":\"5c88d4024f806f2020ad811a\",\n" +
                "                \"commodityName\":\"bastionhost\",\n" +
                "                \"count\":1,\n" +
                "                \"periodInMonths\":1,\n" +
                "                \"commodityAttrs\":{\n" +
                "                    \"PlanCode\":\"enterprise-ah-v2\",\n" +
                "                    \"SubscriptionType\":\"Subscription\",\n" +
                "                    \"Period\":\"BASTIONHOST_PERIODINMONTHS\",\n" +
                "                    \"LicenseCode\":\"BASTIONHOST_LICENSECODE\",\n" +
                "                    \"RegionId\":\"cn-huhehaote\",\n" +
                "                    \"RenewalStatus\":\"ManualRenewal\",\n" +
                "                    \"NetworkType\":\"vpc\"\n" +
                "                },\n" +
                "                \"type\":\"NewOrder\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"resourcePoolId\":\"580ed20d823aaf57283f1ecd\",\n" +
                "        \"tenantId\":\"5bfffeb7e82b6d000b3929fb\"\n" +
                "    },\n" +
                "    \"lang\":\"zh_CN\"\n" +
                "}";
        HttpClientConfig config = new HttpClientConfig();


        String periodInMonths = "1,3,6,9,12,24,36";
        String licenseCodes = "bastionhost_ah_enterprise_license_50_asset," +
                "bastionhost_ah_enterprise_license_100_asset," +
                "bastionhost_ah_enterprise_license_200_asset, " +
                "bastionhost_ah_ultimate_license_500_asset," +
                "bastionhost_ah_ultimate_license_1000_asset" +
                ",bastionhost_ah_ultimate_license_2000_asset," +
                "bastionhost_ah_ultimate_license_5000_asset";


        String[] periodInMonthList = periodInMonths.split(",");
        String[] licenseCodesList = licenseCodes.split(",");
        for (String periodInMonth : periodInMonthList) {
            for (String licenseCode : licenseCodesList) {
                // System.out.println("periodInMonth: " + periodInMonth + " , licenseCode: " + licenseCode);

                // json = json.replace("BASTIONHOST_LICENSECODE", licenseCode);
                // json = json.replace("BASTIONHOST_PERIODINMONTHS", periodInMonth);

                JSONObject object1 = JSON.parseObject(json);
                JSONObject jsonObject = object1.getJSONObject("content").getJSONArray("queryCommodityPriceForms").getJSONObject(0).getJSONObject("commodityAttrs");

                String licenseCodeNum = licenseCode.trim().split("_")[4];
                // System.out.println(licenseCodeNum);
                if (Integer.parseInt(licenseCodeNum) < 500) {
                    jsonObject.put("PlanCode", "enterprise-ah-v2");
                } else if (Integer.parseInt(licenseCodeNum) >= 500 && Integer.parseInt(licenseCodeNum) < 5000) {
                    jsonObject.put("PlanCode", "ultimate-ah-v2");
                } else if (Integer.parseInt(licenseCodeNum) >= 5000) {
                    jsonObject.put("PlanCode", "ultimateplus-ah-v2");
                }
                jsonObject.put("Period", periodInMonth.trim());
                jsonObject.put("LicenseCode", licenseCode.trim());


                json = JSON.toJSON(object1).toString();
                System.out.println("请求参数：");
                System.out.println(json);

                try {

                    config.addHeader("Cookie", "api-token=e39dd7ba-9c72-4255-ae82-42b710fd7404; _qddaz=QD.d9dapj.uu2pe5.k74g3vqx; Hm_lvt_9c85b70b74c8297db397a0c32910d2e7=1585030138; aliyun_lang=zh; aliyun_country=CN; JSESSIONID=6A83AA7FCB503F4D36DD9D9C0387892B; accessToken=bb1ff023-7573-4dce-b149-b0962226cd7f");
                    String post = HttpClientUtil.post(url, json, config);

                    JSONObject object = JSON.parseObject(post);
                    JSONObject content = object.getJSONObject("content");
                    Object totalPrice = content.get("totalPrice");
                    Object originalPrice = content.get("originalPrice");
                    Object discountPrice = content.get("discountPrice");
                    System.out.println("PlanCode: " + jsonObject.getString("PlanCode") + " , 套餐licenseCodeNum: " + licenseCodeNum + " ,购买时长periodInMonth " + periodInMonth + " , licenseCode: " + licenseCode);
                    System.out.println("totalPrice: " + totalPrice + ", originalPrice " + originalPrice + ", discountPrice " + discountPrice);

                    System.out.println();

                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


        // System.out.println();

       /* config.addHeader("Cookie", "api-token=ffba35a2-96f4-4c17-b09e-b747d6baab99; _qddaz=QD.d9dapj.uu2pe5.k74g3vqx; Hm_lvt_9c85b70b74c8297db397a0c32910d2e7=1585030138; aliyun_lang=zh; aliyun_country=CN; JSESSIONID=00889476B192FA12EA1DEEA45F4644EC; accessToken=5f7b4f53-dd84-4db1-8f5a-e6401e24bd06");
        String post = HttpClientUtil.post(url, json, config);
        System.out.println(post);

        JSONObject object = JSON.parseObject(post);
        JSONObject content = object.getJSONObject("content");
        Object totalPrice = content.get("totalPrice");
        Object originalPrice = content.get("originalPrice");
        Object discountPrice = content.get("discountPrice");

        System.out.println("totalPrice: " + totalPrice + ", originalPrice " + originalPrice + ", discountPrice " + discountPrice);*/


    }

}
