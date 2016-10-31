package com.ddhh.readonline.bean;

public class IndexBean {

	private String section_url;
	private String section;
	public String getSection_url() {
		return section_url;
	}
	public void setSection_url(String section_url) {
		this.section_url = section_url;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "IndexBean [section_url=" + section_url + ", section=" + section
				+ "]";
	}
	
}
