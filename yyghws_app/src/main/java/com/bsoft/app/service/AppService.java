package com.bsoft.app.service;

import static com.bsoft.app.service.IFunctionCodeDefine.FCP_CANCEL_ORDER;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_GET_CANCELED_WORKS;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_GET_DEPT_INFO;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_GET_DOCTOR_INFO;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_GET_HOSP_INFO;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_GET_WORK_INFOBY;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_IMPROVE_USER_INFO;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_ORDER;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_QUERY_APPOINT_RECORDS;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_RECEIVE_LINK_USER;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_RECEIVE_USER;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_SYNC_AVAILABLE_COUNT;
import static com.bsoft.app.service.IFunctionCodeDefine.FCP_SYNC_ORDER_STATE;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;
import com.bsoft.app.model.AppListBean;
import com.bsoft.app.model.AppResult;
import com.bsoft.app.model.ResultStatus;
import com.bsoft.app.model.ViewYyRecordNew;
import com.bsoft.app.model.YyDept;
import com.bsoft.app.model.YyDoctor;
import com.bsoft.app.model.YyHospital;
import com.bsoft.app.model.YyOrder2;
import com.bsoft.app.model.YyOrderList;
import com.bsoft.app.model.YyReturnData;
import com.bsoft.app.model.YyWorkPb;
import com.bsoft.app.model.YyWorkPbNew;
import com.bsoft.app.model.YyWorkPbNew2;
import com.bsoft.util.ApplicationConfigUtil;
import com.bsoft.util.MoreDataResultNullConverter;
import com.thoughtworks.xstream.XStream;


public class AppService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);
	/**
	 * 获取医院介绍信息
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String GetHospitalInformation(String request){
		return receiveRequest(request, FCP_GET_HOSP_INFO);
	}
		
	/**
	 * 获取科室介绍信息
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String GetDeptInformation(String request){
		return receiveRequest(request, FCP_GET_DEPT_INFO);
	}
	
	/**
	 * 获取医生介绍信息
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String GetDoctorInformation(String request){
		return receiveRequest(request, FCP_GET_DOCTOR_INFO);
	}
	
	
	/**
	 * 获取排班信息
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String GetWorkInfoBy(String request){
		return receiveRequest(request, FCP_GET_WORK_INFOBY);
	}
	
//	/**
//	 * 中山云平台用
//	 * 获取排班信息
//	 * @param request 入口参数
//	 * @return XML，返回结果
//	 */
//	public String GetWorkInfoBy(String hospitalId,String doctorId,String periodCode,String workDate){
//		
//		XStream xstream = new XStream();
//		ResultStatus status=new ResultStatus(); 
//		AppServiceBusiness service = new AppServiceBusiness();
//		status = service.getWorkInfoBy(hospitalId,doctorId,periodCode,workDate);
//		xstream.alias("Record", YyWorkPb.class);
//		xstream.aliasSystemAttribute(null, "class"); 
//		AppListBean listBean= new AppListBean();
//		AppResult result = new AppResult();
//		result.setList(status.getData());
//		listBean.setResult(result);
//		listBean.setErrorMsg(status.getMessage());
//		listBean.setResultCode(status.getCode());
//		
//		xstream.alias("Response", AppListBean.class);
//		xstream.alias("Result", AppResult.class);
//	    xstream.addImplicitCollection(AppResult.class, "list");
//	    xstream.registerConverter(new MoreDataResultNullConverter());
//		return xstream.toXML(listBean).toString();
//		
//	}
	
	
	/**
	 * 预约挂号
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String Order(String request){
		return receiveRequest(request, FCP_ORDER);
	}

	/**
	 * 取消预约挂号
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String CancelOrder(String request){
		return receiveRequest(request, FCP_CANCEL_ORDER);
	}

	/**
	 * 完善个人信息
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	public String ImproveUserInfo(String request){
		return receiveRequest(request, FCP_IMPROVE_USER_INFO);
	}
	
	/**
	 * 接收运营商传过来的用户
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String ReceiveUser(String request){
		return receiveRequest(request, FCP_RECEIVE_USER);
	}
	
	/**
	 * 接收运营商传过来的常用联系人
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String ReceiveLinkUser(String request){
		return receiveRequest(request, FCP_RECEIVE_LINK_USER);
	}
	
	
	/**
	 * 查询历史预约记录
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String QueryAppointRecordsByUser(String request){
		return receiveRequest(request, FCP_QUERY_APPOINT_RECORDS);
	} 
	
	/**
	 * 同步预约执行情况
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String SyncOrderState(String request){
		return receiveRequest(request, FCP_SYNC_ORDER_STATE);
	}
	
	/**
	 * 同步可预约数
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String SyncAvailableCount(String request){
		return receiveRequest(request, FCP_SYNC_AVAILABLE_COUNT);
	}
	
	/**
	 * 获取停诊通知
	 * @param request 入口参数
	 * @return XML，返回结果
	 */
	
	public String GetCanceledWorks(String request){
		return receiveRequest(request, FCP_GET_CANCELED_WORKS);
	}
	
	/**
	 * 校验ApplicationId和ApplicationSecret
	 * @param request
	 * @return
	 */
	public boolean checkAppSecret(String request){
		Document doc;
		try {
			doc = DocumentHelper.parseText(request);
			Element e = doc.getRootElement();
			System.out.println(e.elementText("ApplicationId"));
			String appId = e.elementText("ApplicationId");
			String appSecret = e.elementText("ApplicationSecret");
			if(StringUtils.isEmpty(appId) || StringUtils.isEmpty(appSecret)){
				return false;
			}
			String secret = ApplicationConfigUtil.instance().getSecret(appId);
			if(StringUtils.isEmpty(secret) || !secret.equals(appSecret)){
				return false;
			}
		} catch (Exception e1) {
			LOGGER.error("校验AppSecret失败",e1);
			return false;
		}
		return true;
	}

	
	/**
	 * 接收请求
	 * @param request 请求参数(XML)
	 * @param functionCode 接口编号
	 * @return 处理结果(XML)
	 */
	private String receiveRequest(String request, String functionCode) {
		XStream xstream = new XStream();;
		ResultStatus status=new ResultStatus(); 

		if(!checkAppSecret(request)){
			AppListBean listBean= new AppListBean();
			listBean.setErrorMsg("应用Id或密匙错误");
			listBean.setResultCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
			return xstream.toXML(listBean).toString();
		}

		AppServiceBusiness service = new AppServiceBusiness();
		if (FCP_GET_HOSP_INFO.equals(functionCode)) {
			status = service.getHospitalInformation(request);
			xstream.alias("Record", YyHospital.class);
		} else if (FCP_GET_DEPT_INFO.equals(functionCode)) {
			status = service.getDeptInformation(request);
			xstream.alias("Record", YyDept.class);
		} else if (FCP_GET_DOCTOR_INFO.equals(functionCode)) {
			status = service.getDoctorInformation(request);
			xstream.alias("Record", YyDoctor.class);
		}  
		else if (FCP_ORDER.equals(functionCode)) {
			status = service.order(request);
//			//预约挂号用
//			xstream.alias("Record", YyOrder.class);
			//台州项目用
			xstream.alias("Record", YyReturnData.class);
		} else if (FCP_CANCEL_ORDER.equals(functionCode)) {
			status = service.cancelOrder(request);
//			//预约挂号用
//			xstream.alias("Record", YyOrder.class);
			//台州项目用
			xstream.alias("Record", YyOrder2.class);
			xstream.aliasSystemAttribute(null, "class"); 
		} 
		else if (FCP_RECEIVE_LINK_USER.equals(functionCode)) {
			status = service.ReceiveLinkUser(request);
		} 
		else if(FCP_RECEIVE_USER.equals(functionCode)){
			status = service.ReceiveUser(request);
		} 
		else if(FCP_GET_WORK_INFOBY.equals(functionCode)){
			status = service.getWorkInfoBy(request);
			xstream.alias("Record", YyWorkPb.class);
			xstream.aliasSystemAttribute(null, "class"); 
		}
		else if(FCP_QUERY_APPOINT_RECORDS.equals(functionCode)){
			status = service.QueryAppointRecordsByUser(request);
			xstream.alias("Record", YyOrderList.class);
			xstream.aliasSystemAttribute(null, "class"); 
		}
		else if(FCP_IMPROVE_USER_INFO.equals(functionCode)){
			status = service.ImproveUserInfo(request);
		}
		else if(FCP_SYNC_ORDER_STATE.equals(functionCode)){
			status = service.SyncOrderState(request);
			xstream.alias("Record", ViewYyRecordNew.class);
		}
		else if(FCP_SYNC_AVAILABLE_COUNT.equals(functionCode)){
			status = service.SyncAvailableCount(request);
			xstream.alias("Record", YyWorkPbNew.class);
		}
		else if(FCP_GET_CANCELED_WORKS.equals(functionCode)){
			status = service.GetCanceledWorks(request);
			xstream.alias("Record", YyWorkPbNew2.class);
		}
//		else {
//				return new Response(ResultMsgDefine.RS_CODE_SYSTEM_ERROR,"开发异常：暂不支持该方法！").toXML();
//			}
		
		AppListBean listBean= new AppListBean();
		AppResult result = new AppResult();
		result.setList(status.getData());
		listBean.setResult(result);
		listBean.setErrorMsg(status.getMessage());
		listBean.setResultCode(status.getCode());
		
		xstream.alias("Response", AppListBean.class);
		xstream.alias("Result", AppResult.class);
	    xstream.addImplicitCollection(AppResult.class, "list");
	    xstream.registerConverter(new MoreDataResultNullConverter());
		return xstream.toXML(listBean).toString();
	}
	
}
