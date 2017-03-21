package org.li.module.user.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;

/**
 * 创建开门二维码记录
 *
 * @author liyanjun
 * @date 2017-3-21 17:08:14
 */
public class SvCreateQrcodeRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /***/
    private Integer id;

    /**
     * 设备ID
     */
    private String deviceIds;

    /**
     * 哪个用户创建的
     */
    private Integer userId;

    /**
     * 创建出来的二维码
     */
    private String qrcode;

    /***/
    private Integer effectTime;

    /***/
    private Timestamp createTime;

    /***/
    private Integer isAvalible;

    public SvCreateQrcodeRecord() {
    }

    public SvCreateQrcodeRecord(Integer id) {
        this.id = id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setDeviceIds(String value) {
        this.deviceIds = value;
    }

    public String getDeviceIds() {
        return this.deviceIds;
    }

    public void setUserId(Integer value) {
        this.userId = value;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setQrcode(String value) {
        this.qrcode = value;
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public void setEffectTime(Integer value) {
        this.effectTime = value;
    }

    public Integer getEffectTime() {
        return this.effectTime;
    }

    public void setCreateTime(Timestamp value) {
        this.createTime = value;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setIsAvalible(Integer value) {
        this.isAvalible = value;
    }

    public Integer getIsAvalible() {
        return this.isAvalible;
    }


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Id", getId())
                .append("DeviceIds", getDeviceIds())
                .append("UserId", getUserId())
                .append("Qrcode", getQrcode())
                .append("EffectTime", getEffectTime())
                .append("CreateTime", getCreateTime())
                .append("IsAvalible", getIsAvalible())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof SvCreateQrcodeRecord == false) return false;
        if (this == obj) return true;
        SvCreateQrcodeRecord other = (SvCreateQrcodeRecord) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .isEquals();
    }
}

