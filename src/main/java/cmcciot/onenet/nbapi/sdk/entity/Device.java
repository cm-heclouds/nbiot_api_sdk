package cmcciot.onenet.nbapi.sdk.entity;

import cmcciot.onenet.nbapi.sdk.config.Config;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by zhuocongbin
 * date 2018/3/16
 */
public class Device extends CommonEntity{
    // 设备名称，字符和数字组成的字符串，必填参数
    private String title;
    // 设备描述信息，可填参数
    private String desc;
    // 设备标签，可填参数
    private List<String> tags;
    // 设备接入协议，这里指定为: LWM2M，必填参数
    private String protocol;
    // 设备地理位置，格式为：{"lon": 106, "lat": 29, "ele": 370}，可填参数
    private JSONObject location;
    // 设备IMSI，必填参数
    private String imsi;
    // 设备接入平台是否启用自动订阅功能，可填参数
    private Boolean obsv;
    // 其他信息，可填参数
    private JSONObject other;

    /**
     * @param title，有字符或者数字组成，必填
     * @param imei，要求在OneNET平台唯一，必填
     * @param imsi，必填
     */
    public Device(String title, String imei, String imsi) {
        this.title = title;
        this.imei = imei;
        this.imsi = imsi;
        this.protocol = "LWM2M";
    }

    public void setObsv(Boolean obsv) {
        this.obsv = obsv;
    }

    public void setOther(JSONObject other) {
        this.other = other;
    }

    public void setLocation(JSONObject location) {
        this.location = location;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", this.title);
        if (StringUtils.isNotBlank(this.desc)) {
            jsonObject.put("desc", this.desc);
        }
        if (CollectionUtils.isNotEmpty(this.tags)) {
            jsonObject.put("tags", this.tags);
        }
        jsonObject.put("protocol", this.protocol);
        if (this.location != null) {
            jsonObject.put("location", this.location);
        }
        JSONObject authInfo = new JSONObject();
        authInfo.put(imei, imsi);
        jsonObject.put("auth_info", authInfo);
        if (this.obsv != null) {
            jsonObject.put("obsv", this.obsv);
        }
        if (this.other != null) {
            jsonObject.put("other", this.other);
        }

        return jsonObject;
    }
    @Override
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/devices");
        return url.toString();
    }
}
