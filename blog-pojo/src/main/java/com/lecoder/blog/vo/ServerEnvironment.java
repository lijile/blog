package com.lecoder.blog.vo;

public class ServerEnvironment {
	
	//Java Version
	private String version;
	
	//供应商
	private String vendor;
	
	//虚拟机名称
	private String vmName;
	
	//定位
	private String location;
	
	//操作系统
	private String os;
	
	//已使用的内存空间
	private double usedMemory;
	
	//最大内存空间
	private double maxMemory;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public double getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(double usedMemory) {
		this.usedMemory = usedMemory;
	}

	public double getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(double maxMemory) {
		this.maxMemory = maxMemory;
	}
	

}
