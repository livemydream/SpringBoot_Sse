

package com.example.tset;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HttpUtil {
    private static final String url = "https://slytransf.market.alicloudapi.com/mobile_transfer";
    private static final String appCode = "115e0406951a40a6931dd44f006fb4f8";
    private static final String appSecret = "CQHJx15j2Lw3fnzlkVZUIl8IITsxzShu";
    private static final String appKey = "204162143";

    //测试
    public static void main(String[] args) throws IOException {
        String url = "https://slytransf.market.alicloudapi.com/mobile_transfer";
//        String appCode = "你的AppCode";
        Map<String, String> params = new HashMap<>();
        params.put("idcard", "622301199910242190");
        params.put("name", "张金善");

        params.put("mobile", "17724009963");
        String result = get(appCode, url, params);
        System.out.println(result);
    }

    /**
     * 用到的HTTP工具包：okhttp 3.13.1
     * <dependency>
     * <groupId>com.squareup.okhttp3</groupId>
     * <artifactId>okhttp</artifactId>
     * <version>3.13.1</version>
     * </dependency>
     */
    public static String get(String appCode, String url, Map<String, String> params) throws IOException {
        url = url + buildRequestUrl(params);
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).build();

        Response response = client.newCall(request).execute();

        System.out.println("返回状态码" + response.code() + ",message:" + response.message());
        System.out.println("hhha");
//        JsonParser parser = new ObjectMapper().createParser();
//        parser.
        return Objects.requireNonNull(response.body()).string();
    }

    public static String buildRequestUrl(Map<String, String> params) {
        StringBuilder url = new StringBuilder("?");
        for (String key : params.keySet()) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }
        return url.toString().substring(0, url.length() - 1);
    }
}
