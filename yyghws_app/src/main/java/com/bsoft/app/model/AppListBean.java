package com.bsoft.app.model;

public class AppListBean {
	
	private AppResult Result; 
	private int ResultCode;
	private String ErrorMsg;
	
	public AppResult getResult() {
		return Result;
	}
	public void setResult(AppResult result) {
		Result = result;
	}
	public int getResultCode() {
		return ResultCode;
	}
	public void setResultCode(int resultCode) {
		ResultCode = resultCode;
	}
	public String getErrorMsg() {
		return ErrorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
	
 
}