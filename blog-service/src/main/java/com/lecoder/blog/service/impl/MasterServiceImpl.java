package com.lecoder.blog.service.impl;

import org.springframework.stereotype.Service;

import com.lecoder.blog.service.MasterService;
import com.lecoder.blog.vo.ServerEnvironment;
import com.lecoder.common.utils.IpAddressUtil;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Override
	public ServerEnvironment getEnvironmentInfo() {
		String vmName = System.getProperty("java.vm.name");
		String version = System.getProperty("java.version");
		String vendor = System.getProperty("java.vendor");
		String os = System.getProperty("os.name") + " / " + System.getProperty("os.arch");

		Runtime runtime = Runtime.getRuntime();
		double freeMemory = (double) runtime.freeMemory() / (1024 * 1024);
		double maxMemory = (double) runtime.maxMemory() / (1024 * 1024);
		double totalMemory = (double) runtime.totalMemory() / (1024 * 1024);
		double usedMemory = totalMemory - freeMemory;
		
		String address = IpAddressUtil.getAddress();
		
		ServerEnvironment environment = new ServerEnvironment();
		environment.setVmName(vmName);
		environment.setVersion(version);
		environment.setVendor(vendor);
		environment.setOs(os);
		environment.setUsedMemory(usedMemory);
		environment.setMaxMemory(maxMemory);
		environment.setLocation(address);
		
		return environment;
	}

}
