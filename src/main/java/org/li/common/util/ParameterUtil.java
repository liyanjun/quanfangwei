package org.li.common.util;

import com.google.gson.Gson;
import org.li.module.user.bean.SvDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class ParameterUtil {

    public static synchronized String geneDevceIds(List<SvDevice> devices) {
        List<Integer> list = new ArrayList<>();
        for (SvDevice svDevice : devices) {
            list.add(svDevice.getId());
        }
        return new Gson().toJson(list);
    }
}
