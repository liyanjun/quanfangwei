package org.li.module.user.bean;

import org.li.common.base.bean.BaseEntity;

import java.sql.Timestamp;


/**
 * 
 * @author liyanjun
 * @date 2017-3-20 16:28:07
 */
public class SvQrcode extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**业主二维码：1，访客二维码：2*/
	private Integer type;

	/**二维码的code_id*/
	private Integer codeId;

	/**二维码字符串*/
	private String qrcodeKey;

	/**对应全方位服务器用户ID*/
	private Integer userId;

	/**访客手机号*/
	private String visitPhone;

	/**访客姓名*/
	private String name;

	/**来访时间，访客二维码特有,用于控制访客可以开始打开设备的时间*/
	private Timestamp startTime;

	/**二维码有效时间，单位分钟，最大4095分钟*/
	private Integer endTime;

	/**二维码创建时间*/
	private Timestamp createTime;

	public SvQrcode(){
	}

	public SvQrcode(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setType(Integer value) {
		this.type = value;
	}

	public Integer getType() {
		return this.type;
	}
	public void setCodeId(Integer value) {
		this.codeId = value;
	}

	public Integer getCodeId() {
		return this.codeId;
	}
	public void setQrcodeKey(String value) {
		this.qrcodeKey = value;
	}

	public String getQrcodeKey() {
		return this.qrcodeKey;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setVisitPhone(String value) {
		this.visitPhone = value;
	}

	public String getVisitPhone() {
		return this.visitPhone;
	}
	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setStartTime(Timestamp value) {
		this.startTime = value;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}
	public void setEndTime(Integer value) {
		this.endTime = value;
	}

	public Integer getEndTime() {
		return this.endTime;
	}

	public void setCreateTime(Timestamp value) {
		this.createTime = value;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

}

