package com.bsoft.app.service;

public interface IFunctionCodeDefine {
	
	/** 协议的版本名称 */
	public static final String VERSION_TAG = "POOL_STD1.0";
	
	/* 运营商提供接口 */
	/** 接口编号 - [运营商3001]更新医院信息 */
	public static final String FCO_UPDATE_HOS_INFO="3001";
	/** 接口编号 - [运营商3002]更新科室信息 */
	public static final String FCO_UPDATE_DEPT_INFO="3002";
	/** 接口编号 - [运营商3003]更新医生信息 */
	public static final String FCO_UPDATE_DOCTOR_INFO="3003";
	/** 接口编号 - [运营商3004]更新排班信息 */
	public static final String FCO_UPDATE_WORK_INFO="3004";
	/** 接口编号 - [运营商3005]更新可预约数 */
	public static final String FCO_UPDATE_AVAILABLE_COUNT="3005";
	/** 接口编号 - [运营商3006]同步预约执行情况 */
	public static final String FCO_UPDATE_ORDER_LIST="3006";
	
	/* 号源池提供接口 */
	/** 接口编号 - [号源池4001]获取医院信息 */
	public static final String FCP_GET_HOSP_INFO="4001";
	/** 接口编号 - [号源池4002]获取科室信息 */
	public static final String FCP_GET_DEPT_INFO="4002";
	/** 接口编号 - [号源池4003]获取医生信息*/
	public static final String FCP_GET_DOCTOR_INFO="4003";
	/** 接口编号 - [号源池4004]获取排班信息 */
	public static final String FCP_GET_WORK_INFO="4004";
	/** 接口编号 - [号源池4005]同步预约执行情况 */
	public static final String FCP_SYNC_ORDER_STATE="4005";
	/** 接口编号 - [号源池4006]同步可预约数 */
	public static final String FCP_SYNC_AVAILABLE_COUNT="4006";
	/** 接口编号 - [号源池4007]获取停诊通知 */
	public static final String FCP_GET_CANCELED_WORKS="4007";
	/** 接口编号 - [号源池4008]查询可挂号数 */
	public static final String FCP_GET_AVAILABLE_COUNT="4008";
	/** 接口编号 - [号源池4009]诊疗卡验证 */
	public static final String FCP_VALIDATE_CARDID="4009";
	/** 接口编号 - [号源池4010]提交预约 */
	public static final String FCP_ORDER="4010";
	/** 接口编号 - [号源池4011]取消预约 */
	public static final String FCP_CANCEL_ORDER="4011";
	/** 接口编号 - [号源池4012]付费通知 */
	public static final String FCP_PAY="4012";
	/**接口编号 - [号源池4013]接收运营商的用户信息 */
	public static final String FCP_RECEIVE_USER="4013"; 
	/** 接口编号 - [号源池4014]获取排班信息 */
	public static final String FCP_GET_WORK_INFOBY="4014";
	/**接口编号 - [号源池4015]接收运营商的用户 新密码*/
	public static final String FCP_RECEIVE_USER_PWD="4015";
	/**接口编号 - [号源池4015]接收运营商的用户账户*/
	public static final String FCP_RECEIVE_USER_ACCOUNT="4016";
	/**接口编号 - [号源池4018]查询历史预约记录*/
	public static final String FCP_QUERY_APPOINT_RECORDS="4018";
	/**接口编号 - [号源池4019]接收运营商传过来的常用联系人*/
	public static final String FCP_RECEIVE_LINK_USER="4019";
	/**接口编号 - [号源池4020]完善个人信息*/
	public static final String FCP_IMPROVE_USER_INFO="4020";
	
}
