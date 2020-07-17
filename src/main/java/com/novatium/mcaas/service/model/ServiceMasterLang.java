package com.novatium.mcaas.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_master_lang")
public class ServiceMasterLang {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceLangId;
	private int serviceId;
	private String customerId;
	
	public ServiceMasterLang(){
		
	}
	public ServiceMasterLang(int serviceLangId, int serviceId, String customerId) {
		this.serviceLangId = serviceLangId;
		this.serviceId = serviceId;
		this.customerId = customerId;
	}
	@Column(name = "service_lang_id", nullable = false,unique=true)
	public int getServiceLangId() {
		return serviceLangId;
	}
	public void setServiceLangId(int serviceLangId) {
		this.serviceLangId = serviceLangId;
	}
	@Column(name = "service_id", nullable = false,unique=true)
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	@Column(name = "customer_id",length = 10)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "ServiceMasterLang [serviceLangId=" + serviceLangId + ", serviceId=" + serviceId + ", customerId="
				+ customerId + "]";
	}
	
	
	
	
}
