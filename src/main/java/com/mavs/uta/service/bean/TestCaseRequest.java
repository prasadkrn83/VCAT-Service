package com.mavs.uta.service.bean;

import java.util.List;

public class TestCaseRequest {
	
	private String url;
	private List<WebElement> elements;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<WebElement> getElements() {
		return elements;
	}
	public void setElements(List<WebElement> elements) {
		this.elements = elements;
	}
	
	

}
