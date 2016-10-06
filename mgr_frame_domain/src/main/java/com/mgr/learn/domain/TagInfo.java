package com.mgr.learn.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 标签信息
 * @author
 *
 */
public class TagInfo {
	
    private  String  name;//标签名称
   
    private  int     type;//标签类型   促销提醒(最新活动) 0  白条提醒       1  理财提醒           2    众筹            3
   
    private  int     flag=1;//订阅开关 1开 0关闭 默认开
    
    private  int     alert=0;//需要弹框 0不需要 1需要
    
    private  String   cMsg="";//关闭开关提醒文案
    
    private  String   oMsg="";//打开开关提醒文案
    
    
    public TagInfo() {

	}


	public TagInfo(String name, int type, int flag,int alert) {
	
		this.name = name;
		this.type = type;
		this.flag = flag;
		this.alert = alert;
	}
	
	public TagInfo(String name, int type, int flag,int alert,String cMsg,String oMsg) {
		
		this.name = name;
		this.type = type;
		this.flag = flag;
		this.alert = alert;
		this.cMsg=cMsg;
		this.oMsg=oMsg;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}


	public int getAlert() {
		return alert;
	}


	public void setAlert(int alert) {
		this.alert = alert;
	}


	public String getcMsg() {
		return cMsg;
	}


	public void setcMsg(String cMsg) {
		this.cMsg = cMsg;
	}


	public String getoMsg() {
		return oMsg;
	}


	public void setoMsg(String oMsg) {
		this.oMsg = oMsg;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	
   
   
}
