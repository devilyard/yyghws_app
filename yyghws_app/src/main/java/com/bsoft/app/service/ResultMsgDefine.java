package com.bsoft.app.service;

public class ResultMsgDefine {
	
	/** 未知的错误 */
	public static final int RS_CODE_UNKNOWN=-1;
	/** 未知的错误 */
	public static final String RS_MSG_UNKNOWN="未知的错误";
	/** 处理成功*/
	public static final int RS_CODE_SUCCESS=0;
	/** 处理成功标志的字符串格式*/
	public static final String RS_CODE_SUCCESS_STR="0";
	/** 处理成功*/
	public static final String RS_MSG_SUCCESS="处理成功";
	
	/** 参数格式不正确 */
	public static final int RS_CODE_FORMAT_ERROR=1000;
	/** 参数格式不正确 */
	public static final String RS_MSG_FORMAT_ERROR="参数格式不正确";
	
	/** 参数类型不正确 */
	public static final int RS_CODE_TYPE_ERROR=1001;
	/** 参数类型不正确 */
	public static final String RS_MSG_TYPE_ERROR="参数类型不正确";
	
	/** 参数值不合法 */
	public static final int RS_CODE_VALUE_ERROR=1009;
	/** 参数值不合法 */
	public static final String RS_MSG_VALUE_ERROR="参数值不合法";
	
	/** 配置错误 */
	public static final int RS_CODE_CONFIG_ERROR=1100;
	/** 配置错误  */
	public static final String RS_MSG_CONFIG_ERROR="配置错误";
	
	/** 校验错误 */
	public static final int RS_CODE_VALIDATE_ERROR=1101;
	/** 校验错误  */
	public static final String RS_MSG_VALIDATE_ERROR="校验错误";
	
	/** 黑名单 */
	public static final int RS_CODE_USER_ERROR=1102;
	/** 黑名单错误  */
	public static final String RS_MSG_USER_ERROR="黑名单错误";

	
	/** 系统异常 */
	public static final int RS_CODE_SYSTEM_ERROR=1111;
	/** 远程调用异常 */
	public static final String RS_MSG_SYSTEM_ERROR="系统异常";
	
	/** 远程调用异常 */
	public static final int RS_CODE_REMOTE_ERROR=1200;
	/** 远程调用异常 */
	public static final String RS_MSG_REMOTE_ERROR="远程调用异常";
		
	/** 无权访问 */
	public static final int RS_CODE_HAVNT_GRANT_ERROR=9999;
	/** 无权访问 */
	public static final String RS_MSG_HAVNT_GRANT_ERROR="无权访问";
	
	/** 禁止实例化 */
	private ResultMsgDefine(){}
	
	/**
	 * 根据处理结果编号取得处理结果描述
	 * @param rs_code
	 * @return
	 */
	public static String getMessage(int rs_code){
		switch(rs_code){
		case RS_CODE_UNKNOWN:return RS_MSG_UNKNOWN;
		case RS_CODE_SUCCESS:return RS_MSG_SUCCESS;
		case RS_CODE_FORMAT_ERROR:return RS_MSG_FORMAT_ERROR;
		case RS_CODE_TYPE_ERROR:return RS_MSG_TYPE_ERROR;
		case RS_CODE_CONFIG_ERROR:return RS_MSG_CONFIG_ERROR;
		case RS_CODE_VALIDATE_ERROR:return RS_MSG_VALIDATE_ERROR;
		case RS_CODE_REMOTE_ERROR:return RS_MSG_REMOTE_ERROR;
		case RS_CODE_SYSTEM_ERROR:return RS_MSG_SYSTEM_ERROR;
		case RS_CODE_VALUE_ERROR:return RS_MSG_VALUE_ERROR;
		default:
			return "交易处理结果编号["+rs_code+"]不存在！";
		}
	}
	
	
}
