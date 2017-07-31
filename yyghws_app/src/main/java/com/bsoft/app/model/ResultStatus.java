package com.bsoft.app.model;

import java.util.List;

@SuppressWarnings("rawtypes")
public class ResultStatus {
	private int code = 0;
	private String message = "";

	private List data;

	public int getCode() {
		return code;
	}

	public List getData() {
		return data;
	}

	public void setData(List list) {
		this.data = list;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
