package cmcciot.onenet.nbapi.sdk.entity;

import cmcciot.onenet.nbapi.sdk.config.Config;

/**
 * Created by zhuocongbin
 * date 2018/3/16
 */
public class Resources extends CommonEntity{
    /**
     * @param imei 设备IMEI
     *             其他可选参数Object ID可以通过对应set函数设置
     */
    public Resources(String imei) {
        this.imei = imei;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }
    @Override
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/nbiot/resources");
        url.append("?imei=").append(this.imei);
        if (this.objId != null) {
            url.append("&obj_id=").append(this.objId);
        }
        return url.toString();
    }
}
