package com.novatium.mcaas.service.controller;

import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novatium.mcaas.service.repository.ServiceRepository;
import com.novatium.mcaas.service.services.ServicesService;

@Controller
@RequestMapping(value="/servicesApi")
public class ServiceController {

	private static final Logger LOGGER = Logger.getLogger(ServiceController.class);
	@Autowired
	ServicesService servicesService;
	@Autowired
	private ServiceRepository serviceRepository;
	
	@RequestMapping(value = "/getPlatformDetails", method = RequestMethod.GET)
	public @ResponseBody Object getPlatformDetails() {

		try {
			return serviceRepository.findAll();
		} catch (Exception e) {
			String errMsg = "Unable to find any Platform Details data";
			LOGGER.error(errMsg, e);
			return errMsg;
		}
	}
	
	@RequestMapping(value = "/saveServiceDetails", method = RequestMethod.POST)
	public @ResponseBody Object saveServiceDetails(@RequestBody Map<String, Object> serviceData) {

		try {
			return servicesService.saveServiceDetails(serviceData);
		} catch (Exception e) {
			String errMsg = "Error while saving Service data";
			LOGGER.error(errMsg, e);
			return errMsg;
		}
	}
}
