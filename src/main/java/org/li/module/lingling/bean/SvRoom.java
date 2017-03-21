package org.li.module.lingling.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.li.common.base.bean.BaseEntity;


/**
 * 
 * @author liyanjun
 * @date 2017-3-21 11:04:52
 */
public class SvRoom extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**房间Id*/
	private Integer roomId;

	/**关联的房屋*/
	private Integer residentialId;

	/**房间号*/
	private String roomNumber;

	/**房间状态：0代表未出租，1代表已出租*/
	private Integer status;

	/**备注*/
	private String note;

	public SvRoom(){
	}

	public SvRoom(Integer roomId){
		this.roomId = roomId;
	}

	public void setRoomId(Integer value) {
		this.roomId = value;
	}

	public Integer getRoomId() {
		return this.roomId;
	}
	public void setResidentialId(Integer value) {
		this.residentialId = value;
	}

	public Integer getResidentialId() {
		return this.residentialId;
	}
	public void setRoomNumber(String value) {
		this.roomNumber = value;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setNote(String value) {
		this.note = value;
	}

	public String getNote() {
		return this.note;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RoomId",getRoomId())
			.append("ResidentialId",getResidentialId())
			.append("RoomNumber",getRoomNumber())
			.append("Status",getStatus())
			.append("Note",getNote())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoomId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SvRoom == false) return false;
		if(this == obj) return true;
		SvRoom other = (SvRoom)obj;
		return new EqualsBuilder()
			.append(getRoomId(),other.getRoomId())
			.isEquals();
	}
}

