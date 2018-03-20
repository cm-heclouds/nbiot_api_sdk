package cmcciot.onenet.nbapi.sdk.api.online;

import cmcciot.onenet.nbapi.sdk.entity.CommonEntity;
import okhttp3.Callback;
import org.json.JSONObject;

/**
 * Created by zhuocongbin
 * date 2018/3/16
 */
public abstract class BasicOpe {
    protected String apiKey;
    public BasicOpe(String apiKey) {
        this.apiKey = apiKey;
    }
    public abstract JSONObject operation(CommonEntity commonEntity, JSONObject body);
    public abstract void operation(CommonEntity commonEntity, JSONObject body, Callback callback);
}
