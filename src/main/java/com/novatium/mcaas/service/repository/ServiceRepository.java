package com.novatium.mcaas.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.novatium.mcaas.service.model.ServiceMaster;
import com.novatium.mcaas.service.model.ServicePlatformConfig;

@SuppressWarnings("rawtypes")
@Component
@Repository("serviceRepository")
public interface ServiceRepository extends CrudRepository{

	 List<ServicePlatformConfig> findAll();

	ServicePlatformConfig getCheckPlatformDetails(int serviceId, String serviceVersion, String serviceExeName);

	void update(ServicePlatformConfig configData);
}
