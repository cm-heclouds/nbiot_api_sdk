package cmcciot.onenet.nbapi.sdk.samples;

import cmcciot.onenet.nbapi.sdk.api.online.*;
import cmcciot.onenet.nbapi.sdk.entity.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhuocongbin
 * date 2018/3/15
 */
public class ApiSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiSample.class);
    public static void main(String[] args) {
        String apiKey = "***********************";
        String imei = "*******";
        Integer objId = 3200;
        Integer objInstId = 0;
        Integer readResId = 5500;
        Integer executeResId = 5501;
        Integer writeResId = 5750;
        Integer writeMode = 2;
        // Create device
        CreateDeviceOpe deviceOpe = new CreateDeviceOpe(apiKey);
        Device device = new Device("samples", "imeitest", "320023320");
        LOGGER.info(deviceOpe.operation(device, device.toJsonObject()).toString());
        //Read
        ReadOpe readOperation = new ReadOpe(apiKey);
        Read read = new Read(imei, objId);
        read.setObjInstId(objInstId);
        read.setResId(readResId);
        LOGGER.info(readOperation.operation(read, null).toString());
        // Write
        WriteOpe writeOpe = new WriteOpe(apiKey);
        Write write = new Write(imei, objId, objInstId, writeMode);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res_id", writeResId);
        jsonObject.put("val", "data1");
        jsonArray.put(jsonObject);
        JSONObject data = new JSONObject();
        data.put("data", jsonArray);
        LOGGER.info(writeOpe.operation(write, data).toString());
        // Execute
        ExecuteOpe executeOpe = new ExecuteOpe(apiKey);
        Execute execute = new Execute(imei, objId, objInstId, executeResId);
        //下发命令内容，JSON格式
        JSONObject body = new JSONObject();
        body.put("args", "ping");
        LOGGER.info(executeOpe.operation(execute, body).toString());
        // Resource
        ResourcesOpe resourcesOpe = new ResourcesOpe(apiKey);
        Resources resources = new Resources(imei);
        LOGGER.info(resourcesOpe.operation(resources, null).toString());
        // Observe
        ObserveOpe observeOpe = new ObserveOpe(apiKey);
        Observe observe = new Observe(imei, objId, false);
        LOGGER.info(observeOpe.operation(observe, null).toString());

    }
}
