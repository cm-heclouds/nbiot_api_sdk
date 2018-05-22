package cmcciot.onenet.nbapi.sdk.utils;

import cmcciot.onenet.nbapi.sdk.exception.NBStatus;
import cmcciot.onenet.nbapi.sdk.exception.OnenetNBException;
import okhttp3.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public final class HttpSendCenter {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpSendCenter.class);
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
                                                    .connectTimeout(40, TimeUnit.SECONDS)
                                                    .readTimeout(40, TimeUnit.SECONDS)
                                                    .build();
    //
    public static JSONObject get(String apiKey, String url) {
        Request request = new Request.Builder()
                        .header("api-key", apiKey)
                        .url(url)
                        .build();
        return handleRequest(request);
    }

    public static void getAsync(String apiKey, String url, Callback callback) {
        Request request = new Request.Builder()
                .header("api-key", apiKey)
                .url(url)
                .build();
       handleAsyncRequest(request, callback);
    }

    public static JSONObject post(String apiKey, String url, JSONObject body) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                            .url(url)
                            .header("api-key", apiKey)
                            .post(requestBody)
                            .build();
        return handleRequest(request);
    }
    public static JSONObject postNotBody(String apiKey, String url) {
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, new JSONObject().toString()))
                .header("api-key", apiKey)
                .build();
        return handleRequest(request);
    }

    public static void postAsync(String apiKey, String url, JSONObject body, Callback callback) {
        RequestBody requestBody = RequestBody.create(JSON, body.toString());
        Request request = new Request.Builder()
                .url(url)
                .header("api-key", apiKey)
                .post(requestBody)
                .build();
        handleAsyncRequest(request, callback);
    }
    public static void postNotBodyAsync(String apiKey, String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, new JSONObject().toString()))
                .header("api-key", apiKey)
                .build();
        handleAsyncRequest(request, callback);
    }

    public static JSONObject put(String apiKey, String url) {

        return null;
    }

    public static void putAsync(String apiKey, String url, JSONObject body, Callback callback) {


    }

    public static JSONObject delete(String apiKey, String url) {

        return null;
    }

    public static void deleteAsync(String apiKey, String url, Callback callback) {

    }

    private static void handleAsyncRequest(Request request, Callback callback) {
        httpClient.newCall(request).enqueue(callback);
    }

    private static JSONObject handleRequest(Request request) {
        try {
            Response response = httpClient.newCall(request).execute();
            if (response != null) {
                String st = new String(response.body().bytes(), "utf-8");
                return new JSONObject(st);
            }else {
                throw new OnenetNBException(NBStatus.HTTP_REQUEST_ERROR);
            }
        } catch (IOException e) {
            LOGGER.info("http request error::{}", e.getMessage());
            throw new OnenetNBException(NBStatus.HTTP_REQUEST_ERROR);
        }
    }
}
