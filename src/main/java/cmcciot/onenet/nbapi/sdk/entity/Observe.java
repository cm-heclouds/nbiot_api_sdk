package cmcciot.onenet.nbapi.sdk.entity;

import cmcciot.onenet.nbapi.sdk.config.Config;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public class Observe extends CommonEntity{
    private Boolean cancel;
    private Integer pmax;
    private Integer pmin;
    private Double gt;
    private Double lt;
    private Double st;

    /**
     * @param imei 设备IMEI，必填
     * @param objId 订阅对象ID，必填
     * @param cancel 订阅或者取消订阅，必填
     *               其他可选参数，可以通过相关set函数设置
     */
    public Observe(String imei, Integer objId, Boolean cancel) {
        this.imei = imei;
        this.objId = objId;
        this.cancel = cancel;
    }

    public void setObjInstId(Integer objInstId) {
        this.objInstId = objInstId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public void setPmax(Integer pmax) {
        this.pmax = pmax;
    }

    public void setPmin(Integer pmin) {
        this.pmin = pmin;
    }

    public void setGt(Double gt) {
        this.gt = gt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    public void setSt(Double st) {
        this.st = st;
    }
    @Override
    public String toUrl() {
        StringBuilder url = new StringBuilder(Config.getDomainName());
        url.append("/nbiot/observe?imei=").append(this.imei);
        url.append("&obj_id=").append(this.objId);
        url.append("&cancel=").append(this.cancel);
        if (this.objInstId != null){
            url.append("&obj_inst_id=").append(this.objInstId);
        }
        if (this.resId != null) {
            url.append("&res_id=").append(this.resId);
        }
        if (this.pmax != null) {
            url.append("&pmax=").append(this.pmax);
        }
        if (this.pmin != null) {
            url.append("&pmin=").append(this.pmin);
        }
        if (this.gt != null) {
            url.append("&gt=").append(this.gt);
        }
        if (this.lt != null) {
            url.append("&lt=").append(this.lt);
        }
        if (this.st != null) {
            url.append("&st=").append(this.st);
        }

        return url.toString();
    }
}
