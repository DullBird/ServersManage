package com.server.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 服务器实体类
 * @author Dull Bird
 * @date 2015-7-8
 *
 */

public class ServerDetail {
	
	private Long id;					//主键
	@NotEmpty
	private String name;				//主机名
	@NotEmpty
	private String cpu;					//cpu核数
	@NotEmpty
	private String memory;				//内存大小
	@NotEmpty
	private String hardDisk;			//硬盘大小
	private String remark;				//备注说明
	private Integer status;				//状态，1：显示 0：删除
	private Date createDate;			//创建时间
	private Long createUid;				//创建人id
	private String createUser;			//创建人
	@NotEmpty
	private String ip;					//ip地址，多个以,分隔
	private String publicIp;			//公网ip，多个以,分隔
	@NotEmpty
	private String os;					//操作系统
	@NotNull
	private Integer isVirtual;			//是否虚拟机，0：不是 1：是，默认0
	private String model;				//服务器型号
	private String services;			//服务编码
	private String postDeviceCode;		//邮政设备号，通过邮政内部购买渠道才会有
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCreateUid() {
		return createUid;
	}
	public void setCreateUid(Long createUid) {
		this.createUid = createUid;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPublicIp() {
		return publicIp;
	}
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Integer getIsVirtual() {
		return isVirtual;
	}
	public void setIsVirtual(Integer isVirtual) {
		this.isVirtual = isVirtual;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getPostDeviceCode() {
		return postDeviceCode;
	}
	public void setPostDeviceCode(String postDeviceCode) {
		this.postDeviceCode = postDeviceCode;
	}
	
	
}
