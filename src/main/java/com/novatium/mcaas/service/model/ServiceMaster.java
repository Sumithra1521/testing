package com.novatium.mcaas.service.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
@Table(name = "service_master")
public class ServiceMaster implements java.io.Serializable{

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceId;
	private String serviceName;
	private Date createdTs;
	private Date modifiedTs;
	private ServicePlatformConfig servicePlatformConfig;
	private ServiceMasterLang ServiceMasterLang;
	
	public ServiceMaster() {
		
	}
	public ServiceMaster(int serviceId, String serviceName, Date createdTs, Date modifiedTs) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.createdTs = createdTs;
		this.modifiedTs = modifiedTs;
	}
	@Column(name = "service_id", unique = true, nullable = false)
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	@Column(name = "service_name", nullable = false,length = 30)
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
	public ServicePlatformConfig getServicePlatformConfig() {
		return servicePlatformConfig;
	}
	public void setServicePlatformConfig(ServicePlatformConfig servicePlatformConfig) {
		this.servicePlatformConfig = servicePlatformConfig;
	}
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
	public ServiceMasterLang getServiceMasterLang() {
		return ServiceMasterLang;
	}
	public void setServiceMasterLang(ServiceMasterLang serviceMasterLang) {
		ServiceMasterLang = serviceMasterLang;
	}
	@Override
	public String toString() {
		return "ServiceMaster [serviceId=" + serviceId + ", serviceName=" + serviceName + ", createdTs=" + createdTs
				+ ", modifiedTs=" + modifiedTs + "]";
	}
	
}
