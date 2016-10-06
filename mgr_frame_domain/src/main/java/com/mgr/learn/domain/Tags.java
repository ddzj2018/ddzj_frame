package com.mgr.learn.domain;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户定义标签列表
 * @author 
 *
 */
public class Tags {
    private String  _id;
   
    private String  pin;
   
    private List<TagInfo> tags;
    
    private List<TagInfo> otherTags;//其他标签
    
    private List<TagInfo> totalList;//总开关
    
    private List<TagInfo> couponList;//优惠券
    
    private Date createDate=new Date();
    
    private Date updateDate=new Date();
    

	public Tags() {
		
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<TagInfo> getTags() {
		return tags;
	}

	public void setTags(List<TagInfo> tags) {
		this.tags = tags;
	}

	public List<TagInfo> getOtherTags() {
		return otherTags;
	}

	public void setOtherTags(List<TagInfo> otherTags) {
		this.otherTags = otherTags;
	}

	public List<TagInfo> getTotalList() {
		return totalList;
	}

	public void setTotalList(List<TagInfo> totalList) {
		this.totalList = totalList;
	}

	public List<TagInfo> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<TagInfo> couponList) {
		this.couponList = couponList;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	


	
	
   
   
}
