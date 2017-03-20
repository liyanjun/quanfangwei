package org.li.module.user.bean;

import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;


/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
public class SvDevice extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**设备ID*/
	private Integer deviceId;

	/**开门秘钥*/
	private String sdkKey;

	/**当前数据库用户ID*/
	private Integer userId;

	/**秘钥有效天数*/
	private Integer keyEffecDay;

	/**当前时间*/
	private Timestamp createTime;

	/***/
	private Timestamp updateTime;

	public SvDevice(){
	}

	public SvDevice(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setDeviceId(Integer value) {
		this.deviceId = value;
	}

	public Integer getDeviceId() {
		return this.deviceId;
	}
	public void setSdkKey(String value) {
		this.sdkKey = value;
	}

	public String getSdkKey() {
		return this.sdkKey;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setKeyEffecDay(Integer value) {
		this.keyEffecDay = value;
	}

	public Integer getKeyEffecDay() {
		return this.keyEffecDay;
	}

	public void setCreateTime(Timestamp value) {
		this.createTime = value;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Timestamp value) {
		this.updateTime = value;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

}

