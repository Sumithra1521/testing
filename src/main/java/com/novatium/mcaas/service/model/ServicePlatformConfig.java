package com.novatium.mcaas.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "service_platform_config")
public class ServicePlatformConfig implements java.io.Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int servicePlatformConfigId;
	private int serviceId;
	private String platformName;
	private String serviceType;
	private String serviceDisplayName;
	private String serviceVersion;
	private String serviceExeName;
	private Date createdTs;
	private Date modifiedTs;
	
	public ServicePlatformConfig(){
		
	}
	public ServicePlatformConfig(int servicePlatformConfigId, int serviceId, String platformName, String serviceType,
			String serviceDisplayName, String serviceVersion, String serviceExeName, Date createdTs, Date modifiedTs) {
		
		this.servicePlatformConfigId = servicePlatformConfigId;
		this.serviceId = serviceId;
		this.platformName = platformName;
		this.serviceType = serviceType;
		this.serviceDisplayName = serviceDisplayName;
		this.serviceVersion = serviceVersion;
		this.serviceExeName = serviceExeName;
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}
	@Column(name = "service_platform_config_id",unique=true, nullable = false)
	public int getServicePlatformConfigId() {
		return servicePlatformConfigId;
	}
	public void setServicePlatformConfigId(int servicePlatformConfigId) {
		this.servicePlatformConfigId = servicePlatformConfigId;
	}
	@Column(name = "service_id",unique=true, nullable = false)
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	@Column(name = "platform_name", nullable = false,length = 30)
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	@Column(name = "service_type", nullable = false,length = 30)
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Column(name = "service_display_name", nullable = false,length = 30)
	public String getServiceDisplayName() {
		return serviceDisplayName;
	}
	public void setServiceDisplayName(String serviceDisplayName) {
		this.serviceDisplayName = serviceDisplayName;
	}
	@Column(name = "service_version", unique=true,nullable = false,length = 30)
	public String getServiceVersion() {
		return serviceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}
	@Column(name = "service_exe_name", nullable = false,length = 30)
	public String getServiceExeName() {
		return serviceExeName;
	}
	public void setServiceExeName(String serviceExeName) {
		this.serviceExeName = serviceExeName;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_ts",length=8)
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_ts",length=8)
	public Date getModifiedTs() {
		return modifiedTs;
	}
	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}
	@Override
	public String toString() {
		return "ServicePlatformConfig [servicePlatformConfigId=" + servicePlatformConfigId + ", serviceId=" + serviceId
				+ ", platformName=" + platformName + ", serviceType=" + serviceType + ", serviceDisplayName="
				+ serviceDisplayName + ", serviceVersion=" + serviceVersion + ", serviceExeName=" + serviceExeName
				+ ", createdTs=" + createdTs + ", modifiedTs=" + modifiedTs + "]";
	}
	
	
}
