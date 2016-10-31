package com.ddhh.readonline.bean;

public class SearchResultBean {

	private String name;
	private String desc;
	private String author;
	private String type;
	private String section;
	private String time;
	private String crossUrl;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCrossUrl() {
		return crossUrl;
	}
	public void setCrossUrl(String crossUrl) {
		this.crossUrl = crossUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SearchResultBean [name=" + name + ", desc=" + desc
				+ ", author=" + author + ", type=" + type + ", section="
				+ section + ", time=" + time + ", crossUrl=" + crossUrl
				+ ", id=" + id + "]";
	}
	
	
	
	
}
