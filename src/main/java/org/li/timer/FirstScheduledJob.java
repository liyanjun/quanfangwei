package org.li.timer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class FirstScheduledJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(FirstScheduledJob.class);
    private HelloJob anotherBean;

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        logger.debug("I am FirstScheduledJob");
        this.anotherBean.test();

    }

    public void setAnotherBean(HelloJob anotherBean) {
        this.anotherBean = anotherBean;
    }
}