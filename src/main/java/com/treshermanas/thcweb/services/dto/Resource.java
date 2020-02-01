package com.treshermanas.thcweb.services.dto;

public class Resource {

	private String data;
	private String contentType;//content-type

	public Resource(){

	}

	public Resource(String tipo){
		this.contentType = tipo;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
}
