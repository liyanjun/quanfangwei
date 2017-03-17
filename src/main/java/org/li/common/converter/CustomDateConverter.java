package org.li.common.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 自定义日期转换器
 *
 */
public class CustomDateConverter implements Converter<String, Date> {

    private String[] patterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM", "HH:mm:ss", "yyyy年MM月dd日 HH:mm:ss", "yyyy年MM月dd日", "yyyy年MM月"};

    public CustomDateConverter() {

    }

    @Override
    public Date convert(String source) {
        DateTime dateTime = null;

        for (String p : patterns) {
            try {
                dateTime = DateTime.parse(source, DateTimeFormat.forPattern(p));
                break ;
            } catch (Exception e) {}
        }

        return dateTime == null ? null : dateTime.toDate();
    }

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }
}
