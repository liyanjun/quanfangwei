package org.li.common.util;

import com.google.gson.Gson;
import org.li.module.lingling.bean.SvLingLingDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class ParameterUtil {

    public static synchronized List<Integer> getDeviceId(List<SvLingLingDevice> devices) {
        List<Integer> list = new ArrayList<>();
        for (SvLingLingDevice svDevice : devices) {
            if(svDevice!=null)
            list.add(svDevice.getDeviceId());
        }
        return list;
    }
}
