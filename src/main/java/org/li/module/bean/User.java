package org.li.module.bean;

import org.li.common.base.bean.BaseEntity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14.
 */
public class User extends BaseEntity {

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;

    /**
     * 记录创建时间
     */
    private java.sql.Timestamp createTime;

    public User() {
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(Integer value) {
        this.age = value;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setCreateTime(java.sql.Timestamp value) {
        this.createTime = value;
    }

    public java.sql.Timestamp getCreateTime() {
        return this.createTime;
    }

}
