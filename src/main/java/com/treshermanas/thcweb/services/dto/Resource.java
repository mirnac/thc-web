package com.treshermanas.thcweb.services.dto;

import org.springframework.util.MimeType;

public class Resource {

	private byte[] data;
	private MimeType contentType;//content-type

	public Resource(MimeType tipo){
		this.contentType = tipo;
	}
	
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public MimeType getContentType() {
		return contentType;
	}
	public void setContentType(MimeType contentType) {
		this.contentType = contentType;
	}
	
	
}
