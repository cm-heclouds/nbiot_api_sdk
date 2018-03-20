package cmcciot.onenet.nbapi.sdk.entity;

import cmcciot.onenet.nbapi.sdk.config.Config;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public class Execute extends CommonEntity{
    /**
     *
     * @param imei 设备IMEI号，必填
     * @param objId，下发命令的对象ID,必填
     * @param objInstId，下发命令的实例ID,必填
     * @param resId，下发命令的资源ID,必填
     */
    public Execute(String imei, Integer objId, Integer objInstId, Integer resId) {
        this.imei = imei;
        this.objId = objId;
        this.objInstId = objInstId;
        this.resId = resId;
    }
    @Override
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/nbiot/execute?imei=").append(this.imei);
        url.append("&obj_id=").append(this.objId);
        url.append("&obj_inst_id=").append(this.objInstId);
        url.append("&res_id=").append(this.resId);
        return url.toString();
    }
}
