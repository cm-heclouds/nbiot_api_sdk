package cmcciot.onenet.nbapi.sdk.entity;

import cmcciot.onenet.nbapi.sdk.config.Config;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public class Write extends CommonEntity{
    private Integer mode;

    /**
     * @param imei 设备IMEI
     * @param objId 写对象ID
     * @param objInstId 写实例ID
     * @param mode 写的模式（1：replace，2：partial update）
     */
    public Write(String imei, Integer objId, Integer objInstId, Integer mode) {
        this.imei = imei;
        this.objId = objId;
        this.objInstId = objInstId;
        this.mode = mode;
    }
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/nbiot?imei=").append(this.imei);
        url.append("&obj_id=").append(this.objId);
        url.append("&obj_inst_id=").append(this.objInstId);
        url.append("&mode=").append(this.mode);
        return url.toString();
    }
}
