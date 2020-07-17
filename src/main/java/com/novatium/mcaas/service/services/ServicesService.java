package com.novatium.mcaas.service.services;


import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novatium.mcaas.service.model.ServiceMaster;
import com.novatium.mcaas.service.model.ServiceMasterLang;
import com.novatium.mcaas.service.model.ServicePlatformConfig;
import com.novatium.mcaas.service.repository.ServiceRepository;

@Service
public class ServicesService<T> {

	/*@Autowired
	private ServiceRepository serviceRepository;


		public Map<String, Object> getPlatformDetails() {

			Map<String, Object> result = new HashMap<String, Object>();
			
			List<ServicePlatformConfig> PlateformMasters = serviceRepository.findAll();
			result.put("platformDetails", PlateformMasters);
			return result;
		}*/

		public Map<String, Object> saveServiceDetails(Map<String, Object> serviceData) {
			Map<String, Object> result = new HashMap<String, Object>();
			/*ServicePlatformConfig platformData=null;
			ServiceMaster platformDetails=null;
			ServiceMasterLang platformMasterLang=null;
			Date date = new Date();
			if(serviceData!=null){
				int serviceId=(Integer)serviceData.get("serviceId");
				String serviceVersion=(String)serviceData.get("serviceVersion");
				String serviceExeName=(String)serviceData.get("serviceExeName");
				ServicePlatformConfig configData=serviceRepository.getCheckPlatformDetails(serviceId,serviceVersion,serviceExeName);
				if(configData!=null){
					platformData=new ServicePlatformConfig();
					platformData.setPlatformName((String)serviceData.get("platformName"));
					platformData.setServiceDisplayName((String)serviceData.get("serviceDisplayName"));
					platformData.setServiceExeName((String)serviceData.get("serviceExeName"));
					platformData.setServiceId((Integer)serviceData.get("serviceId"));
					platformData.setServiceType((String)serviceData.get("serviceType"));
					platformData.setServiceVersion((String)serviceData.get("serviceVersion"));
					platformData.setCreatedTs(date);
					platformData.setModifiedTs(date);
					serviceRepository.save(platformData);
					if(platformData!=null){
						platformDetails=new ServiceMaster();
						platformDetails.setServiceId(serviceId);
						platformDetails.setServiceName((String)serviceData.get("serviceName"));
						platformDetails.setCreatedTs(date);
						platformDetails.setModifiedTs(date);
						serviceRepository.save(platformDetails);
					}if(platformDetails!=null && platformData!=null){
						platformMasterLang=new ServiceMasterLang();
						platformMasterLang.setServiceId(serviceId);
						platformMasterLang.setCustomerId((String)serviceData.get("customerId"));
						serviceRepository.save(platformMasterLang);
					}
					result.put("Message", "Success");
					result.put("Reason", "Service saved Successfully");
				}else{
					configData.setServiceDisplayName((String)serviceData.get("serviceDisplayName"));
					configData.setModifiedTs(date);
					serviceRepository.update( configData);*/
					result.put("Message", "Success");
					result.put("Reason", "Service updated Successfully");
				//}
			//}
			return result;
		}

	}
	
	

