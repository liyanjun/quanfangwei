package org.li.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by liyanjun on 2017/2/28.
 */
public class HelloJob  {
    private final static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    public void test() {
        logger.debug("定时任务测试");
    }
}
