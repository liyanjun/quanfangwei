package org.li.module.lingling.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;


/**
 * 
 * @author liyanjun
 * @date 2017-3-21 11:04:47
 */
public class SvLingLingDevice extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**主键ID，自增*/
	private Integer deviceId;

	/**设备名称*/
	private String name;

	/**家庭ID*/
	private String familyId;

	/**设备类型，1为BT，2为WIFI，3为WIFI+BT，4为开门按钮*/
	private Integer deviceType;

	/**设备编码*/
	private String deviceCode;

	/**设备物理地址*/
	private String mac;

	/**默认物理地址*/
	private String defaultMac;

	/***/
	private String wifiSsid;

	/***/
	private String wifiPassword;

	/***/
	private String bluetoochName;

	/***/
	private String bluetoochPassword;

	/**锁的类型*/
	private Integer lockType;

	/**开门后多少秒关闭，单位：秒*/
	private Integer lockInterval;

	/**最后一次同步的时间*/
	private Timestamp lastSynchroTime;

	/**是否有效，1为有效，0为无效*/
	private Integer status;

	/**关联区域的ID*/
	private Integer regionId;

	/**是否为单元门还是公共门，1为单元门，2为公共门*/
	private Integer customType;

	/**自定义设备类型:公共门，单元门*/
	private Integer residentialType;

	/**备注*/
	private String note;

	/**v3设备的Id*/
	private Integer v3DeviceId;

	/**设备是否在线：1在线，0不在线*/
	private Integer isOnline;

	/**x坐标*/
	private Double xcoordinate;

	/**y坐标*/
	private Double ycoordinate;

	/**坐标标注*/
	private String mark;

	/**锁的状态：0常闭，1常开*/
	private Integer lockStatus;

	/**设备添加时间*/
	private Timestamp makeTime;

	public SvLingLingDevice(){
	}

	public SvLingLingDevice(Integer deviceId){
		this.deviceId = deviceId;
	}

	public void setDeviceId(Integer value) {
		this.deviceId = value;
	}

	public Integer getDeviceId() {
		return this.deviceId;
	}
	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}
	public void setFamilyId(String value) {
		this.familyId = value;
	}

	public String getFamilyId() {
		return this.familyId;
	}
	public void setDeviceType(Integer value) {
		this.deviceType = value;
	}

	public Integer getDeviceType() {
		return this.deviceType;
	}
	public void setDeviceCode(String value) {
		this.deviceCode = value;
	}

	public String getDeviceCode() {
		return this.deviceCode;
	}
	public void setMac(String value) {
		this.mac = value;
	}

	public String getMac() {
		return this.mac;
	}
	public void setDefaultMac(String value) {
		this.defaultMac = value;
	}

	public String getDefaultMac() {
		return this.defaultMac;
	}
	public void setWifiSsid(String value) {
		this.wifiSsid = value;
	}

	public String getWifiSsid() {
		return this.wifiSsid;
	}
	public void setWifiPassword(String value) {
		this.wifiPassword = value;
	}

	public String getWifiPassword() {
		return this.wifiPassword;
	}
	public void setBluetoochName(String value) {
		this.bluetoochName = value;
	}

	public String getBluetoochName() {
		return this.bluetoochName;
	}
	public void setBluetoochPassword(String value) {
		this.bluetoochPassword = value;
	}

	public String getBluetoochPassword() {
		return this.bluetoochPassword;
	}
	public void setLockType(Integer value) {
		this.lockType = value;
	}

	public Integer getLockType() {
		return this.lockType;
	}
	public void setLockInterval(Integer value) {
		this.lockInterval = value;
	}

	public Integer getLockInterval() {
		return this.lockInterval;
	}

	public void setLastSynchroTime(Timestamp value) {
		this.lastSynchroTime = value;
	}

	public Timestamp getLastSynchroTime() {
		return this.lastSynchroTime;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setRegionId(Integer value) {
		this.regionId = value;
	}

	public Integer getRegionId() {
		return this.regionId;
	}
	public void setCustomType(Integer value) {
		this.customType = value;
	}

	public Integer getCustomType() {
		return this.customType;
	}
	public void setResidentialType(Integer value) {
		this.residentialType = value;
	}

	public Integer getResidentialType() {
		return this.residentialType;
	}
	public void setNote(String value) {
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}
	public void setV3DeviceId(Integer value) {
		this.v3DeviceId = value;
	}

	public Integer getV3DeviceId() {
		return this.v3DeviceId;
	}
	public void setIsOnline(Integer value) {
		this.isOnline = value;
	}

	public Integer getIsOnline() {
		return this.isOnline;
	}
	public void setXcoordinate(Double value) {
		this.xcoordinate = value;
	}

	public Double getXcoordinate() {
		return this.xcoordinate;
	}
	public void setYcoordinate(Double value) {
		this.ycoordinate = value;
	}

	public Double getYcoordinate() {
		return this.ycoordinate;
	}
	public void setMark(String value) {
		this.mark = value;
	}

	public String getMark() {
		return this.mark;
	}
	public void setLockStatus(Integer value) {
		this.lockStatus = value;
	}

	public Integer getLockStatus() {
		return this.lockStatus;
	}

	public void setMakeTime(Timestamp value) {
		this.makeTime = value;
	}

	public Timestamp getMakeTime() {
		return this.makeTime;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DeviceId",getDeviceId())
			.append("Name",getName())
			.append("FamilyId",getFamilyId())
			.append("DeviceType",getDeviceType())
			.append("DeviceCode",getDeviceCode())
			.append("Mac",getMac())
			.append("DefaultMac",getDefaultMac())
			.append("WifiSsid",getWifiSsid())
			.append("WifiPassword",getWifiPassword())
			.append("BluetoochName",getBluetoochName())
			.append("BluetoochPassword",getBluetoochPassword())
			.append("LockType",getLockType())
			.append("LockInterval",getLockInterval())
			.append("LastSynchroTime",getLastSynchroTime())
			.append("Status",getStatus())
			.append("RegionId",getRegionId())
			.append("CustomType",getCustomType())
			.append("ResidentialType",getResidentialType())
			.append("Note",getNote())
			.append("V3DeviceId",getV3DeviceId())
			.append("IsOnline",getIsOnline())
			.append("Xcoordinate",getXcoordinate())
			.append("Ycoordinate",getYcoordinate())
			.append("Mark",getMark())
			.append("LockStatus",getLockStatus())
			.append("MakeTime",getMakeTime())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeviceId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SvLingLingDevice == false) return false;
		if(this == obj) return true;
		SvLingLingDevice other = (SvLingLingDevice)obj;
		return new EqualsBuilder()
			.append(getDeviceId(),other.getDeviceId())
			.isEquals();
	}
}

