package com.bsoft.app.service;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.axis2.extensions.spring.receivers.ApplicationContextHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.context.ApplicationContext;

import com.bsoft.app.dao.IDAO;
import com.bsoft.app.model.Model;
import com.bsoft.app.model.ResultStatus;
import com.bsoft.app.model.ViewYyRecord;
import com.bsoft.app.model.ViewYyRecordNew;
import com.bsoft.app.model.YyDept;
import com.bsoft.app.model.YyDoctor;
import com.bsoft.app.model.YyHospital;
import com.bsoft.app.model.YyLinkUser;
import com.bsoft.app.model.YyOrder;
import com.bsoft.app.model.YyOrder2;
import com.bsoft.app.model.YyOrderList;
import com.bsoft.app.model.YyReturnData;
import com.bsoft.app.model.YyUserAccount;
import com.bsoft.app.model.YyUserLock;
import com.bsoft.app.model.YyWorkPb;
import com.bsoft.app.model.YyWorkPbNew;
import com.bsoft.app.model.YyWorkPbNew2;
import com.bsoft.util.DateConverter;
import com.bsoft.util.DateUtil;
import com.bsoft.util.Md5Util;
import com.bsoft.util.RandomUtil;
import com.thoughtworks.xstream.XStream;

public class AppServiceBusiness {
	
	
	
	private IDAO serviceDao;
	
	public AppServiceBusiness(){
		ApplicationContext aCtx  = ApplicationContextHolder.getContext();
		if(aCtx != null){
			serviceDao = (IDAO)aCtx.getBean("serviceDao");
		}
	}
	
	
	/**
	 * 获取医院介绍信息
	 * @param paramMap 入口参数包
	 * @return 医院集合
	 */
	public ResultStatus getHospitalInformation(String paramMap){

		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyHospital.class);
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyHospital yyHospital = (YyHospital)t.getParameter().get(0);
			List<YyHospital> list = null;
			if(StringUtils.isEmpty(yyHospital.getHospitalId())){
				list = serviceDao.queryList("YyHospital", "1=1", null);
			}else{
				list = serviceDao.queryList("YyHospital", "HospitalId = ?", new Object[]{yyHospital.getHospitalId()});
			}
			 
			if(list != null && !list.isEmpty()){
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("指定医院不存在！");
			}
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 获取科室介绍信息
	 * @param paramMap 入口参数包
	 */
	public ResultStatus getDeptInformation(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyDept.class);
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyDept yyDept = (YyDept)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyDept.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			List<YyDept> list = null;
			if(StringUtils.isEmpty(yyDept.getDeptId())){
				//deptid 为空
				list = serviceDao.queryList("YyDept", "HospitalId = ?", new Object[]{yyDept.getHospitalId()});
			}else{
				list = serviceDao.queryList("YyDept", "HospitalId = ? and DeptId = ?", new Object[]{yyDept.getHospitalId(),yyDept.getDeptId()});
			}
			if(list != null && !list.isEmpty()){
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无科室数据！");
			}
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	
	/**
	 * 获取医生介绍信息
	 * @param paramMap 入口参数包
	 * @return XML，返回结果
	 */
	public ResultStatus getDoctorInformation(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyDoctor.class);
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyDoctor yyDoctor = (YyDoctor)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyDoctor.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			List<YyDoctor> list = null;
			if(StringUtils.isEmpty(yyDoctor.getDeptId())){
				//deptid 为空
				list = serviceDao.queryList("YyDoctor", "HospitalId = ?", new Object[]{yyDoctor.getHospitalId()});
			}else{
				list = serviceDao.queryList("YyDoctor", "HospitalId = ? and DeptId = ?", new Object[]{yyDoctor.getHospitalId(),yyDoctor.getDeptId()});
			}
			if(list != null && !list.isEmpty()){
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无医生数据！");
			}
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	/**
	 * 获取排班信息(2015-06-25新增可根据医生ID查询)
	 * @param paramMap 入口参数包
	 * @return XML，返回结果
	 */
//	public ResultStatus getWorkInfoBy(String paramMap){
//		
//		XStream xstream = new XStream(); 
//		xstream.alias("Request",Model.class); 
//		xstream.addImplicitCollection(Model.class, "Parameter");  
//		xstream.alias("Parameter",YyWorkPb.class);
//		xstream.registerConverter(new DateConverter());  
//		ResultStatus status=new ResultStatus();
//		try {
//			Model t = (Model)xstream.fromXML(paramMap); 
//			YyWorkPb yyWorkPb = (YyWorkPb)t.getParameter().get(0);
//			StringBuilder sql = new StringBuilder();
//			List<String> paramsArray = new ArrayList<String>();
//			if(isNotEmpty(yyWorkPb.getHospitalId())){
//				sql.append(" HospitalId=?");
//				paramsArray.add(yyWorkPb.getHospitalId());
//			}else{
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			if(isNotEmpty(yyWorkPb.getDeptId())){
//				sql.append(" and DeptId=?");
//				paramsArray.add(yyWorkPb.getDeptId());
//			}
//			if(isNotEmpty(yyWorkPb.getDoctorId())){
//				sql.append(" and DoctorId=?");
//				paramsArray.add(yyWorkPb.getDoctorId());
//			}
//			Object[] params = new Object[paramsArray.size()];
//			params = paramsArray.toArray(params);
//			
//			List<YyWorkPb> list = serviceDao.queryList("YyWorkPb", sql.toString(), params);
//			if(list != null && !list.isEmpty()){
//				Iterator<YyWorkPb> iterator = list.iterator();
//		        while(iterator.hasNext()){
//		        	YyWorkPb data = iterator.next();
//		        	String curWorkDate = data.getWorkDate() == null ? null :SimpleDateUtil.format(data.getWorkDate(), SimpleDateUtil.DATE_FORMAT);
//					if (yyWorkPb.getWorkDate() != null) {
//						// 条件中排班日期不为空，则忽略排班日期不一样的
//						if (!SimpleDateUtil.format(yyWorkPb.getWorkDate(), SimpleDateUtil.DATE_FORMAT).equals(curWorkDate)) {
//							iterator.remove(); 
//							continue;
//						}
//					} else if (curWorkDate != null) {
//						if(data.getWorkDate().getTime()<new Date().getTime()){
//							// 条件中排班日期为空，则忽略今天以前的排班
//							iterator.remove(); 
//							continue;
//						}
//					}
//		        }
//				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
//				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
//				status.setData(list);
//			}else{
//				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
//				status.setMessage("无排班信息！");
//			}
//		} catch (Exception e) {
//			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
//			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
//			e.printStackTrace();
//			return status;
//		}
//		return status;
//	}
	
	/**
	 * 中山医疗云平台用
	 * 获取排班信息
	 * @return XML，返回结果
	 */
	public ResultStatus getWorkInfoBy(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyWorkPb.class);
		xstream.registerConverter(new DateConverter());  
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyWorkPb yyWorkPb = (YyWorkPb)t.getParameter().get(0);
			StringBuilder sql = new StringBuilder("select * from yy_work_pb where 1=1 ");
			//List paramsArray = new ArrayList();
			if(isNotEmpty(yyWorkPb.getHospitalId())){
				sql.append(" and HospitalId='"+yyWorkPb.getHospitalId()+"'");
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			if(isNotEmpty(yyWorkPb.getDoctorId())){
				sql.append(" and DoctorId='"+yyWorkPb.getDoctorId()+"'");
			}
			if(yyWorkPb.getPeriodCode()!=null){
				sql.append(" and PeriodCode="+yyWorkPb.getPeriodCode()+"");
			}
			
			if(yyWorkPb.getWorkDate()!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String datestr = sdf.format(yyWorkPb.getWorkDate());
				sql.append(" and to_char(WorkDate,'yyyy-MM-dd')='"+datestr+"'");
			}
			
			sql.append(" and rownum < 2 ");
			
			List<Map<String, Object>> list = serviceDao.queryForListSQL(sql.toString(), new Object[]{});
			
			if(list != null && !list.isEmpty()){
				List<YyWorkPb> pblist = new ArrayList<YyWorkPb>();
				Map<String, Object> mp = list.get(0);
				YyWorkPb pb =new YyWorkPb();
				pb.setHospitalId((String)mp.get("HOSPITALID"));
				pb.setWorkId((String)mp.get("WORKID"));
				pb.setWorkDate((Date)mp.get("WORKDATE"));
				pb.setPeriodCode(new Integer(String.valueOf(mp.get("PERIODCODE"))));
				pb.setStartTime((String)mp.get("STARTTIME"));
				pb.setEndTime((String)mp.get("ENDTIME"));
				pb.setDoctorId((String)mp.get("DOCTORID"));
				pb.setDoctorName((String)mp.get("DOCTORNAME"));
				pb.setDoctorGender((String)mp.get("DOCTORGENDER"));
				pb.setDoctorRank((String)mp.get("DOCTORRANK"));
				pb.setWorkRankID(new Integer(String.valueOf(mp.get("WORKRANKID"))));
				pb.setWorkRank((String)mp.get("WORKRANK"));
				pb.setDeptId((String)mp.get("DEPTID"));
				pb.setDeptName((String)mp.get("DEPTNAME"));
				pb.setPrice(Double.parseDouble(String.valueOf(mp.get("PRICE"))));
				pb.setOrderFee(new Integer(String.valueOf(mp.get("ORDERFEE"))));
				pb.setAdmitAddress((String)mp.get("ADMITADDRESS"));
				pb.setOrderCount(new Integer(String.valueOf(mp.get("ORDERCOUNT"))));
				pb.setAvailableCount(mp.get("REMAIN")!=null?new Integer(String.valueOf(mp.get("REMAIN"))):null);
				pb.setFlag(new Integer(String.valueOf(mp.get("FLAG"))));
				pblist.add(pb);
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(pblist);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无排班信息！");
			}
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}

//	/**
//	 * 预约挂号
//	 * @param paramMap 入口参数包
//	 * @return XML，返回结果
//	 */
//	public ResultStatus order(String paramMap) {
//		
//		XStream xstream = new XStream(); 
//		xstream.alias("Request",Model.class); 
//		xstream.addImplicitCollection(Model.class, "Parameter");  
//		xstream.alias("Parameter",YyOrder.class);
//		xstream.registerConverter(new DateConverter()); 
//		ResultStatus status=new ResultStatus();
//		try {
//			Model t = (Model)xstream.fromXML(paramMap); 
//			YyOrder yyOrder = (YyOrder)t.getParameter().get(0);
//			if(StringUtils.isEmpty(yyOrder.getHospitalId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			if(StringUtils.isEmpty(yyOrder.getWorkId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("workid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			if(StringUtils.isEmpty(yyOrder.getCardId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("cardid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			if(yyOrder.getOrderTime() == null){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("ordertime:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			if(!lockInfo(yyOrder.getCardId(),yyOrder.getCardType())){
//				status.setCode(ResultMsgDefine.RS_CODE_USER_ERROR);
//				status.setMessage("用户在黑名单中");
//				return status;
//			}
//			//1、是否排班为空
//			YyWorkPb pb = new YyWorkPb();
//			
//			pb.setHospitalId(yyOrder.getHospitalId());
//			pb.setWorkId(yyOrder.getWorkId());
//			
//			pb = serviceDao.get(YyWorkPb.class, pb);
//			
//			if(pb==null||pb.getAvailableCount()<1){
//				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
//				status.setMessage("号源为空！请预约其他排班");
//				return status;
//			}
//			
//			YyUserAccount userAccount = serviceDao.queryT("YyUserAccount", "IdCard= ? and  CardType=?", new Object[]{yyOrder.getLoginUserIdCard(),yyOrder.getLoginUserCardType()});
//			if(userAccount != null){
//				yyOrder.setUserId(userAccount.getUserid());
//			}
//			
//			//2、是否已预约
//			int count = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and WorkId=? and ((state <>4 and state <>5) or state is null)", 
//					new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getWorkId()});
//			
//			if(count >0){
//				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
//				status.setMessage("您已经预约过该排班！请查看预约记录或预约其他排班");
//				return status;
//			}
//			
//			//3、判断是否已经约满六条
//			
//			int count6 = serviceDao.queryForCount("YyOrder", "CardId= ? and state is null", new Object[]{yyOrder.getCardId()});
//			
//			if(count6 >=6){
//				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
//				status.setMessage("您待就诊的已满六条！不可再约!");
//				return status;
//			}
//			//4、当天在同一医疗机构的预约不能超过3个
//			
//			int count3 = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and OrderTime=? ", new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getOrderTime()});
//			
//			if(count3>=3){
//				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
//				status.setMessage("您当天在同一医疗机构的预约不能超过3个");
//				return status;
//			}
//			
//			//5、当天预约同一家医疗机构同一个科室不能超过2次
//			
//			int count2 = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and OrderTime=?  and deptid=? ", new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getOrderTime(),pb.getDeptId()});
//			
//			if(count2>=2){
//				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
//				status.setMessage("当天预约同一家医疗机构同一个科室不能超过2次");
//				return status;
//			}
//			
//			
//			//6、您当天预约的医疗机构不能超过2个
//			 //TODO
//				
//			//
//			
//			//预约数据入库操作
//			
//			pb.setAvailableCount((pb.getAvailableCount()== null || pb.getAvailableCount() ==0) ? 0 :pb.getAvailableCount()-1);
//			if(isNotEmpty(pb.getOrderNumbers())){
//				String []numbers=pb.getOrderNumbers().split(",");
//				String numberReturn="";
//				for(int i=0;i<numbers.length;i++){
//					if(StringUtils.isEmpty(yyOrder.getSeqCode())){
//						yyOrder.setSeqCode(numbers[0]);
//						continue;
//					}else if(yyOrder.getSeqCode().equals(numbers[i])){
//						continue;
//					}
//					numberReturn=numberReturn+numbers[i]+",";
//				}
//				String remainNumbers= "".equals(numberReturn) ? "" : numberReturn.substring(0, numberReturn.length()-1);
//				pb.setOrderNumbers(remainNumbers);
//			}
//			
//			yyOrder.setCreat_time(new Date());
//			serviceDao.addOrder(pb, yyOrder);
//			
//			List<YyOrder> list=new ArrayList<YyOrder>();
//			list.add(yyOrder);
//			status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
//			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
//			status.setData(list);
//			
//		} catch (Exception e) {
//			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
//			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
//			e.printStackTrace();
//			return status;
//		}
//    	return status;	
//	}
	
	/**
	 * 中山医疗云平台用
	 * 提交一条预约挂号患者信息给第三方
	 * @return XML，返回结果
	 */
	public ResultStatus order(String paramMap) {
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyOrder.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyOrder yyOrder = (YyOrder)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyOrder.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyOrder.getSource())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("source:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyOrder.getWorkId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("workid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyOrder.getCardId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyOrder.getCardType())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardtype:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(!lockInfo(yyOrder.getCardId(),yyOrder.getCardType())){
				status.setCode(ResultMsgDefine.RS_CODE_USER_ERROR);
				status.setMessage("用户在黑名单中");
				return status;
			}
			//1、是否排班为空
			YyWorkPb pb = new YyWorkPb();
			
			StringBuilder sql = new StringBuilder();
			List<Object> paramsArray = new ArrayList<Object>();
			sql.append(" hospitalid=? and workid=? ");
			paramsArray.add(yyOrder.getHospitalId());
			paramsArray.add(yyOrder.getWorkId());
			if(yyOrder.getDeptid()!=null){
				sql.append(" and deptid=? ");
				paramsArray.add(yyOrder.getDeptid());
			}
			if(yyOrder.getDeptname()!=null){
				sql.append(" and deptname=? ");
				paramsArray.add(yyOrder.getDeptname());
			}
			if(yyOrder.getDoctors()!=null){
				sql.append(" and doctorid=? ");
				paramsArray.add(yyOrder.getDoctors());
			}
			if(yyOrder.getDoctorName()!=null){
				sql.append(" and doctorname=? ");
				paramsArray.add(yyOrder.getDoctorName());
			}
			if(yyOrder.getOrderdate()!=null){
				sql.append(" and to_char(workdate,'yyyy-MM-dd')=? ");
				paramsArray.add(yyOrder.getOrderdate().toString());
			}
			if(yyOrder.getOrderdate()!=null){
				sql.append(" and starttime=? and endtime=? ");
				paramsArray.add(yyOrder.getTime().substring(0, 5));
				paramsArray.add(yyOrder.getTime().substring(6, 11));
			}
			
			Object[] params = new Object[paramsArray.size()];
			params = paramsArray.toArray(params);
			pb = serviceDao.queryT("YyWorkPb", sql.toString(), params);
			
			if(pb==null||pb.getAvailableCount()<1){
				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
				status.setMessage("号源为空！请预约其他排班");
				return status;
			}
			
			List<YyUserAccount> userAccountlist = serviceDao.queryList("YyUserAccount", "IdCard= ? and  CardType=?", new Object[]{yyOrder.getLoginUserIdCard(),yyOrder.getLoginUserCardType()});
			if(userAccountlist != null && userAccountlist.size()>0){
				yyOrder.setUserId(userAccountlist.get(0).getUserid());
			}
			
			//2、是否已预约
			int count = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and WorkId=? and ((state <>4 and state <>5) or state is null)", 
					new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getWorkId()});
			
			if(count >0){
				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
				status.setMessage("您已经预约过该排班！请查看预约记录或预约其他排班");
				return status;
			}
			
			//3、判断是否已经约满六条
			
			int count6 = serviceDao.queryForCount("YyOrder", "CardId= ? and state is null", new Object[]{yyOrder.getCardId()});
			
			if(count6 >=6){
				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
				status.setMessage("您待就诊的已满六条！不可再约!");
				return status;
			}
			//4、当天在同一医疗机构的预约不能超过3个
			
			int count3 = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and to_char(OrderTime,'yyyy-MM-dd')= ? ", new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getOrderdate()});
			
			if(count3>=3){
				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
				status.setMessage("您当天在同一医疗机构的预约不能超过3个");
				return status;
			}
			
			//5、当天预约同一家医疗机构同一个科室不能超过2次
			
			int count2 = serviceDao.queryForCount("YyOrder", "CardId= ? and HospitalId= ? and to_char(OrderTime,'yyyy-MM-dd')= ? and deptid=? ", new Object[]{yyOrder.getCardId(),yyOrder.getHospitalId(),yyOrder.getOrderdate(),pb.getDeptId()});
			
			if(count2>=2){
				status.setCode(ResultMsgDefine.RS_CODE_HAVNT_GRANT_ERROR);
				status.setMessage("当天预约同一家医疗机构同一个科室不能超过2次");
				return status;
			}
			
			
			//6、您当天预约的医疗机构不能超过2个
			 //TODO
				
			//
			
			//预约数据入库操作
			
			pb.setAvailableCount((pb.getAvailableCount()== null || pb.getAvailableCount() ==0) ? 0 :pb.getAvailableCount()-1);
			if(isNotEmpty(pb.getOrderNumbers())){
				String []numbers=pb.getOrderNumbers().split(",");
				String numberReturn="";
				for(int i=0;i<numbers.length;i++){
					if(StringUtils.isEmpty(yyOrder.getSeqCode())){
						yyOrder.setSeqCode(numbers[0]);
						continue;
					}else if(yyOrder.getSeqCode().equals(numbers[i])){
						continue;
					}
					numberReturn=numberReturn+numbers[i]+",";
				}
				String remainNumbers= "".equals(numberReturn) ? "" : numberReturn.substring(0, numberReturn.length()-1);
				pb.setOrderNumbers(remainNumbers);
			}
			
			yyOrder.setCreat_time(new Date());
			if(pb.getVersion()==null){
				pb.setVersion(1);
			}
			serviceDao.addOrder(pb, yyOrder);
			
			int tag = serviceDao.queryForCount("YyWorkPb", "doctorid=? and remain>0 and workdate >= sysdate", new Object[]{pb.getDoctorId()});
			if(tag>0){
				serviceDao.update("YyDoctor", " set tag1=? ", " doctorid=? ", new Object[]{"1",pb.getDoctorId()});
			}else{
				serviceDao.update("YyDoctor", " set tag1=? ", " doctorid=? ", new Object[]{"0",pb.getDoctorId()});
			}
			
			YyReturnData yyreturn = getYyReturn(pb, yyOrder);
			List<YyReturnData> list=new ArrayList<YyReturnData>();
			list.add(yyreturn);
			status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
			status.setData(list);
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
    	return status;	
	}
	
	//判断是否为黑名单
	public boolean lockInfo(String idcard, String cardtype){
		YyUserLock lock = serviceDao.queryT("YyUserLock", "idcard= ?  and cardtype = ?", 
				new Object[]{idcard,cardtype});
		System.out.println(lock);
		if(lock == null){
			List<YyUserAccount> accountlist = serviceDao.queryList("YyUserAccount", "IdCard=? and CardType=? ", new Object[]{idcard,cardtype});
			if(accountlist != null && accountlist.size()>0){
				int count = serviceDao.queryForCount("YyOrder", "UserId= ? and (state = 2 or state=3)", new Object[]{accountlist.get(0).getUserid()});
				if(count >=3 ){
					lock=new YyUserLock();
					lock.setBuuid(RandomUtil.getUUID());
					lock.setIdcard(idcard);
					lock.setLocktime(new Date());
					serviceDao.save("YyUserLock",lock);
					return false;
				}
				return true;
			}else{
				int lickCount = serviceDao.queryForCount("YyOrder", "CardId= ? and CardType=? and (state = 2 or state=3)", new Object[]{idcard,cardtype});
				if(lickCount >= 3){
					lock=new YyUserLock();
					lock.setBuuid(RandomUtil.getUUID());
					lock.setIdcard(idcard);
					lock.setLocktime(new Date());
					serviceDao.save("YyUserLock",lock);
					return false;
				}
				return true;
			}
		}else{
			Calendar cal1=Calendar.getInstance();
			cal1.setTime(lock.getLocktime());
			Calendar cal2=Calendar.getInstance();
			cal2.setTime(new Date());
			int month=DateUtil.getBetweenTime(cal1, cal2, Calendar.MONTH);
			//三个月以上解禁
			if(month>=3){
				serviceDao.delete("YyOrder", "CardId= ? and (state = 2 or state=3)", new Object[]{idcard});
				List<YyLinkUser> linkUsers = serviceDao.queryList("YyLinkUser", "useridcard= ? and status=1", 
						new Object[]{idcard});
				if(!linkUsers.isEmpty()){
					for(YyLinkUser user:linkUsers){
						serviceDao.delete("YyOrder", "CardId= ? and (state = 2 or state=3)", new Object[]{user.getIdcard()});
					}
				}
				serviceDao.delete("YyUserLock", "idcard= ?", new Object[]{idcard});
				return true;
			}else {
				return false;
			}
		}
//		
//		YyUserLockExample example=new YyUserLockExample();
//		example.createCriteria().andIdcardEqualTo(idcard);
//		List<YyUserLock> locks=lockDao.selectByExample(example);
//		//判断是否在黑名单中
//		if(locks.isEmpty()){
//			//判断是否三次
//			YyOrderExample orderExample=new YyOrderExample();
//			orderExample.createCriteria().andCardidEqualTo(idcard);
//			orderExample.setInfo("state=2 or state=3");
//			int i=orderDao.countByExample2(orderExample);
//			if(i>=3){
//				YyUserLock lock=new YyUserLock();
//				lock.setBuuid(RandomUtil.getUUID());
//				lock.setIdcard(idcard);
//				lock.setLocktime(new Date());
//				lockDao.insert(lock);
//				return false;
//			}else{
//				//判断常用就诊人是否未就诊
//				YyLinkUserExample yyLinkUserExample=new YyLinkUserExample();
//				YyLinkUserExample.Criteria criteria=yyLinkUserExample.createCriteria();
//				criteria.andUseridcardEqualTo(idcard);
//				List<YyLinkUser> linkUsers=yyLinkUserDao.selectByExample(yyLinkUserExample);
//				if(!linkUsers.isEmpty()){
//					for(YyLinkUser user:linkUsers){
//						YyOrderExample orderExample0=new YyOrderExample();
//						orderExample0.createCriteria().andCardidEqualTo(user.getIdcard());
//						orderExample0.setInfo("state=2 or state=3");
//						int j=orderDao.countByExample(orderExample0);
//						if(j>=3){
//							YyUserLock lock=new YyUserLock();
//							lock.setBuuid(RandomUtil.getUUID());
//							lock.setIdcard(idcard);
//							lock.setLocktime(new Date());
//							lockDao.insert(lock);
//							return false;
//						}
//					}
//				}
//				
//				return true;
//			}
//		}else{
//			YyUserLock lock=locks.get(0);
//			Calendar cal1=Calendar.getInstance();
//			cal1.setTime(lock.getLocktime());
//			Calendar cal2=Calendar.getInstance();
//			cal2.setTime(new Date());
//			int month=DateUtil.getBetweenTime(cal1, cal2, Calendar.MONTH);
//			//三个月以上解禁
//			if(month>=3){
//				removeBg(lock.getBuuid());
//				lockDao.deleteByPrimaryKey(lock.getBuuid());
//				return true;
//			}else {
//				return false;
//			}
//		}
	}
	
	
//	/**
//	 * 取消预约
//	 * @param paramMap 入口参数包
//	 * @return XML，返回结果
//	 */
//	public ResultStatus cancelOrder(String paramMap){
//		
//		XStream xstream = new XStream(); 
//		xstream.alias("Request",Model.class); 
//		xstream.addImplicitCollection(Model.class, "Parameter");  
//		xstream.alias("Parameter",YyOrder.class);
//		xstream.registerConverter(new DateConverter()); 
//		ResultStatus status=new ResultStatus();
//		try {
//			Model t = (Model)xstream.fromXML(paramMap); 
//			YyOrder yyOrder = (YyOrder)t.getParameter().get(0);
//			if(StringUtils.isEmpty(yyOrder.getHospitalId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			if(StringUtils.isEmpty(yyOrder.getWorkId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("workid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			if(StringUtils.isEmpty(yyOrder.getSeqCode())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("seqCode:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			if(StringUtils.isEmpty(yyOrder.getCardId())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("cardId:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			
//			
//			if(StringUtils.isEmpty(yyOrder.getCardType())){
//				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
//				status.setMessage("cardType:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
//				return status;
//			}
//			//左去0 插入数据时有问题后续再改
//			if(yyOrder.getCardType().length()>1){
//				yyOrder.setCardType(yyOrder.getCardType().substring(1));
//			}
//			YyOrder order = serviceDao.queryT("YyOrder", "HospitalId= ? and WorkId= ? and CardId= ?  and CardType= ? and SeqCode= ? and to_char(ordertime,'yyyy/MM/dd') = ?", 
//					new Object[]{yyOrder.getHospitalId(),yyOrder.getWorkId(),yyOrder.getCardId(),yyOrder.getCardType(),yyOrder.getSeqCode(),yyOrder.getWorkdate()});
//			if(order != null){
//				
//				order.setState("5");
//				YyWorkPb pb = serviceDao.queryT("YyWorkPb", "HospitalId= ? and WorkId= ? ", new Object[]{yyOrder.getHospitalId(),yyOrder.getWorkId()});
//				if(pb != null){
//					
//					pb.setAvailableCount(pb.getAvailableCount() == null ? 1 : pb.getAvailableCount()+1);
//					
//					if(isNotEmpty(pb.getOrderNumbers())){
//						if(!pb.getOrderNumbers().contains(yyOrder.getSeqCode())){
//							pb.setOrderNumbers(pb.getOrderNumbers()+ "," +yyOrder.getSeqCode());
//						}
//					}
//					
//					serviceDao.cancelOrder(pb, order);
//					
//					List<YyOrder> list=new ArrayList<YyOrder>();
//	    			list.add(order);
//					status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
//	    			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
//	    			status.setData(list);
//				}else{
//					serviceDao.update(order);
//					status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
//					status.setMessage("无排班信息,已取消预约");
//				}
//			}else{
//				status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
//				status.setMessage("无预约信息");
//			}
//		} catch (Exception e) {
//			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
//			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
//			e.printStackTrace();
//			return status;
//		}
//		return status;
//	}
	
	/**
	 * 中山医疗云平台用
	 * 取消一条预约挂号信息给第三方
	 * @return XML，返回结果
	 */
	public ResultStatus cancelOrder(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyOrder.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyOrder yyOrder = (YyOrder)t.getParameter().get(0);
			StringBuilder sql = new StringBuilder();
			List<Object> paramsArray = new ArrayList<Object>();
			
			if(StringUtils.isEmpty(yyOrder.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
				sql.append(" HospitalId= ? ");
				paramsArray.add(yyOrder.getHospitalId());
			}
			
			if(StringUtils.isEmpty(yyOrder.getWorkId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("workid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
				sql.append(" and WorkId= ? ");
				paramsArray.add(yyOrder.getWorkId());
			}
			
			if(StringUtils.isEmpty(yyOrder.getSeqCode())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("seqCode:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
				sql.append(" and SeqCode= ? ");
				paramsArray.add(yyOrder.getSeqCode());
			}
			
			if(StringUtils.isEmpty(yyOrder.getCardId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardId:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
				sql.append(" and CardId= ? ");
				paramsArray.add(yyOrder.getCardId());
			}
			
			if(StringUtils.isEmpty(yyOrder.getCardType())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardType:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
//				//左去0 插入数据时有问题后续再改
//				if(yyOrder.getCardType().length()>1){
//					yyOrder.setCardType(yyOrder.getCardType().substring(1));
//				}
				sql.append(" and CardType= ? ");
				paramsArray.add(yyOrder.getCardType());
			}
			
			if(StringUtils.isEmpty(yyOrder.getSource())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("source:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}else{
				sql.append(" and Source= ? ");
				paramsArray.add(yyOrder.getSource());
			}
			
			if(!StringUtils.isEmpty(yyOrder.getPatientName())){
				sql.append(" and PatientName= ? ");
				paramsArray.add(yyOrder.getPatientName());
			}
			
			if(!StringUtils.isEmpty(yyOrder.getTelePhoneNo())){
				sql.append(" and TelePhoneNo= ? ");
				paramsArray.add(yyOrder.getTelePhoneNo());
			}
			
			if(yyOrder.getYyid()!=null){
				sql.append(" and yyid= ? ");
				paramsArray.add(yyOrder.getYyid());
			}
			
			Object[] params = new Object[paramsArray.size()];
			params = paramsArray.toArray(params);
			YyOrder order = serviceDao.queryT("YyOrder", sql.toString(), params);
			if(order != null){
				
				order.setState("5");
				YyWorkPb pb = serviceDao.queryT("YyWorkPb", "HospitalId= ? and WorkId= ? ", new Object[]{yyOrder.getHospitalId(),yyOrder.getWorkId()});
				if(pb != null){
					
					pb.setAvailableCount(pb.getAvailableCount() == null ? 1 : pb.getAvailableCount()+1);
					
					if(isNotEmpty(pb.getOrderNumbers())){
						if(!pb.getOrderNumbers().contains(yyOrder.getSeqCode())){
							pb.setOrderNumbers(pb.getOrderNumbers()+ "," +yyOrder.getSeqCode());
						}
					}
					
					serviceDao.cancelOrder(pb, order);
					int tag = serviceDao.queryForCount("YyWorkPb", "doctorid=? and remain>0 and workdate >= sysdate", new Object[]{pb.getDoctorId()});
					if(tag>0){
						serviceDao.update("YyDoctor", " set tag1=? ", " doctorid=? ", new Object[]{"1",pb.getDoctorId()});
					}else{
						serviceDao.update("YyDoctor", " set tag1=? ", " doctorid=? ", new Object[]{"0",pb.getDoctorId()});
					}
					
					List<YyOrder2> list=new ArrayList<YyOrder2>();
					YyOrder2 yyo = new YyOrder2();
					yyo.setHospitalId(order.getHospitalId());
					yyo.setSource(order.getSource());
					yyo.setWorkId(order.getWorkId());
					yyo.setCardId(order.getCardId());
					yyo.setCardType(order.getCardType());
					yyo.setYyid(order.getYyid().toString());
					yyo.setSeqCode(order.getSeqCode());
					if(order.getPatientName() == null){
						yyo.setPatientName("");
					}else{
						yyo.setPatientName(order.getPatientName());
					}
					if(order.getTelePhoneNo() == null){
						yyo.setTelePhoneNo("");
					}else{
						yyo.setTelePhoneNo(order.getTelePhoneNo());
					}
					if(order.getState() == null){
						yyo.setState("");
					}else{
						yyo.setState(order.getState());
					}
					if(order.getDeptid() == null){
						yyo.setDeptid("");
					}else{
						yyo.setDeptid(order.getDeptid());
					}
					if(order.getCreat_time() == null){
						yyo.setCreat_time("");
					}else{
						yyo.setCreat_time(order.getCreat_time().toString().substring(0, 19));
					}
	    			list.add(yyo);
					status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
	    			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
	    			status.setData(list);
				}else{
					serviceDao.update(order);
					status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
					status.setMessage("无排班信息,已取消预约");
				}
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
				status.setMessage("无预约信息");
			}
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 接收运营商传过来的常用联系人
	 * @param paramMap 入口参数包
	 * @return XML，返回结果
	 */
	public ResultStatus ReceiveLinkUser(String paramMap){
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyLinkUser.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try{
			Model t = (Model)xstream.fromXML(paramMap); 
			YyLinkUser linkUser = (YyLinkUser)t.getParameter().get(0);
			if(linkUser.getYyuserid() == null){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("yyuserid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			if(StringUtils.isEmpty(linkUser.getIdcard())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("idcard:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(linkUser.getCardtype())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardtype:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(linkUser.getPhoneno())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("phoneno:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(linkUser.getUsername())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("username:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(linkUser.getStatus())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("status:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}		
			
			YyLinkUser user = serviceDao.queryT("YyLinkUser", "yyuserid= ?  and cardtype = ? and idcard = ? and status=1", 
					new Object[]{linkUser.getYyuserid(),linkUser.getCardtype(),linkUser.getIdcard()});
			
			if(user != null){
				//国籍 证件号码 证件类型不能修改
				user.setStatus(linkUser.getStatus());
				user.setUsername(linkUser.getUsername());
				user.setPhoneno(linkUser.getPhoneno());
				user.setBirthday(linkUser.getBirthday());
				user.setSex(linkUser.getSex());
				serviceDao.update(user);
			}else{
				linkUser.setCreatTime(new Date());
				serviceDao.save(linkUser);
			}
			status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 完善个人信息
	 * @param paramMap 入口参数包
	 * @return XML，返回结果
	 */
	public ResultStatus ImproveUserInfo(String paramMap){
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyUserAccount.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try{
			Model t = (Model)xstream.fromXML(paramMap); 
			YyUserAccount userAccount = (YyUserAccount)t.getParameter().get(0);
			if(StringUtils.isEmpty(userAccount.getTelePhoneNo())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("telePhoneNo:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			if(StringUtils.isEmpty(userAccount.getIdCard())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("idcard:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(userAccount.getCardType())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("cardtype:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			YyUserAccount account = serviceDao.queryT("YyUserAccount", "TelePhoneNo= ? ", 
					new Object[]{userAccount.getTelePhoneNo()});
			if(account != null){
				//国籍 证件号码 证件类型不能修改
				account.setUserName(userAccount.getUserName());
				account.setGender(userAccount.getGender());
				account.setBirthDay(userAccount.getBirthDay());
				serviceDao.update(account);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
				status.setMessage("telePhoneNo:"+userAccount.getTelePhoneNo()+";无对应信息");
			}
			status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		
		
		return status;
	}
	
	
	/**
	 * 接收运营商传过来的用户
	 * @param paramMap 入口参数包
	 * @return XML，返回结果
	 */
	public ResultStatus ReceiveUser(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyUserAccount.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyUserAccount userAccount = (YyUserAccount)t.getParameter().get(0);
			if(StringUtils.isEmpty(userAccount.getTelePhoneNo())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("telePhoneNo:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			if(StringUtils.isEmpty(userAccount.getPassWords())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("passWords:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			YyUserAccount account = serviceDao.queryT("YyUserAccount", "TelePhoneNo= ? ", 
					new Object[]{userAccount.getTelePhoneNo()});
			
			if(account != null){
				account.setPassWords(Md5Util.encode(new String(Base64.decode(userAccount.getPassWords()))));
				account.setSource("2"); //来源APP
				serviceDao.update(account);
			}else{
				userAccount.setPassWords(Md5Util.encode(new String(Base64.decode(userAccount.getPassWords()))));
				userAccount.setRegdate(new Date());
				userAccount.setSource("2"); //来源APP
				serviceDao.save(userAccount);
			}
			status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
		
	}
	
	/**
	 * 查询历史预约记录
	 * @param paramMap
	 * @return
	 */
	public ResultStatus QueryAppointRecordsByUser(String paramMap){
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyUserAccount.class);
		ResultStatus status=new ResultStatus();
		try{
			Model t = (Model)xstream.fromXML(paramMap); 
			YyUserAccount user = (YyUserAccount)t.getParameter().get(0);
			if(StringUtils.isEmpty(user.getIdCard())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("useridcard:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			YyUserAccount userAccount = serviceDao.queryT("YyUserAccount", "IdCard= ? and  CardType=?", new Object[]{user.getIdCard(),user.getCardType()});
			List<YyOrder> orderList = null;
			if(userAccount == null){
				orderList = serviceDao.queryList("YyOrder", "CardId = ? and  CardType = ?", new Object[]{user.getIdCard(),user.getCardType()});
			}else{
				orderList = serviceDao.queryList("YyOrder", "UserId = ?", new Object[]{userAccount.getUserid()});
			}
			 
			List<YyOrderList>  list = new ArrayList<YyOrderList>();
			if(orderList != null && !orderList.isEmpty()){
				for(YyOrder order : orderList){
					YyWorkPb workpb = new YyWorkPb();
					workpb.setHospitalId(order.getHospitalId());
					workpb.setWorkId(order.getWorkId());
					YyWorkPb pb = serviceDao.get(YyWorkPb.class, workpb);
					if(pb != null){
						YyOrderList yol = new YyOrderList();
						yol.setYyid(order.getYyid());
						yol.setHospitalId(pb.getHospitalId());
						yol.setDoctorId(pb.getDoctorId());
						yol.setDoctorName(pb.getDoctorName());
						yol.setDeptId(pb.getDeptId());
						yol.setDeptName(pb.getDeptName());
						yol.setWorkId(pb.getWorkId());
						yol.setSeqCode(order.getSeqCode());
						yol.setWorkDate(pb.getWorkDate());
						yol.setStartTime(pb.getStartTime());
						yol.setEndTime(pb.getEndTime());
						yol.setAppointType(pb.getWorkRankID());
						yol.setAppointSource(order.getSource());
						yol.setAppointTime(order.getCreat_time());
						yol.setAppointStatus(order.getState());
						yol.setAppointPay(pb.getOrderFee());
						yol.setIdCard(order.getCardId());
						yol.setCardType(order.getCardType());
						list.add(yol);
					}
				}
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无历史预约数据！");
			}
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 同步预约执行情况
	 * @param paramMap
	 * @return
	 */
	public ResultStatus SyncOrderState(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",ViewYyRecord.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			ViewYyRecord yyRecord = (ViewYyRecord)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyRecord.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyRecord.getWorkDate().toString())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("workdate:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String ymd=sdf.format(yyRecord.getWorkDate());
			List<ViewYyRecord> recordList = serviceDao.queryList("ViewYyRecord", "hospitalid = ? and to_char(workdate,'yyyy-MM-dd') = ? ", new Object[]{yyRecord.getHospitalId(),ymd});
			
			List<ViewYyRecordNew>  list = new ArrayList<ViewYyRecordNew>();
			if(recordList != null && !recordList.isEmpty()){
				for(ViewYyRecord record : recordList){
					ViewYyRecordNew newrecord = new ViewYyRecordNew();
					newrecord.setHospitalId(record.getHospitalId());
					newrecord.setWorkId(record.getWorkId());
					newrecord.setSeqCode(record.getSeqCode());
					if(record.getOrderDate()!=null){
						SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
						String od=sdf2.format(record.getOrderDate());
						newrecord.setOrderDate(od);
					}
					newrecord.setOrderTimeRange(record.getKssj()+"-"+record.getJssj());
					newrecord.setCureFlag(record.getState());
					list.add(newrecord);
				}
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无同步预约执行数据！");
			}
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 同步可预约数
	 * @param paramMap
	 * @return
	 */
	public ResultStatus SyncAvailableCount(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyWorkPb.class);
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyWorkPb yyWork = (YyWorkPb)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyWork.getHospitalId())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("hospitalid:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			List<YyWorkPb> workList = null;
			if(StringUtils.isEmpty(yyWork.getWorkId())){
				workList = serviceDao.queryList("YyWorkPb", " hospitalid = ? ", new Object[]{yyWork.getHospitalId()} );
			}else{
				workList = serviceDao.queryList("YyWorkPb", " hospitalid = ? and workid = ? ", new Object[]{yyWork.getHospitalId(),yyWork.getWorkId()});
			}
			
			List<YyWorkPbNew>  list = new ArrayList<YyWorkPbNew>();
			if(workList != null && !workList.isEmpty()){
				for(YyWorkPb work : workList){
					YyWorkPbNew newwork = new YyWorkPbNew();
					newwork.setHospitalId(work.getHospitalId());
					newwork.setWorkId(work.getWorkId());
					newwork.setOrderCount(work.getOrderCount());
					newwork.setAvailableCount(work.getAvailableCount());
					newwork.setOrderNumbers(work.getOrderNumbers());
					list.add(newwork);
				}
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无同步可预约数据！");
			}
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	/**
	 * 获取停诊通知
	 * @param paramMap
	 * @return
	 */
	public ResultStatus GetCanceledWorks(String paramMap){
		
		XStream xstream = new XStream(); 
		xstream.alias("Request",Model.class); 
		xstream.addImplicitCollection(Model.class, "Parameter");  
		xstream.alias("Parameter",YyWorkPb.class);
		xstream.registerConverter(new DateConverter()); 
		ResultStatus status=new ResultStatus();
		try {
			Model t = (Model)xstream.fromXML(paramMap); 
			YyWorkPb yyWork = (YyWorkPb)t.getParameter().get(0);
			if(StringUtils.isEmpty(yyWork.getStartTime())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("starttime:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			if(StringUtils.isEmpty(yyWork.getEndTime())){
				status.setCode(ResultMsgDefine.RS_CODE_FORMAT_ERROR);
				status.setMessage("endtime:"+ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_FORMAT_ERROR));
				return status;
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			String s= yyWork.getStartTime()+" 00:00:00"; 
			String e= yyWork.getEndTime()+" 23:59:59";
			Date sdate =  formatter.parse(s);
			Date edate =  formatter.parse(e);
			List<YyWorkPb> workList = serviceDao.queryList("YyWorkPb", "flag = 3 and workdate <= ? and workdate >= ? ", new Object[]{edate,sdate});
			
			List<YyWorkPbNew2>  list = new ArrayList<YyWorkPbNew2>();
			if(workList != null && !workList.isEmpty()){
				for(YyWorkPb work : workList){
					YyWorkPbNew2 newwork = new YyWorkPbNew2();
					newwork.setHospitalId(work.getHospitalId());
					newwork.setWorkId(work.getWorkId());
					newwork.setReason(work.getReason());
					newwork.setSuggestWorkId(work.getSuggestworkid());
					list.add(newwork);
				}
				status.setCode(ResultMsgDefine.RS_CODE_SUCCESS);
				status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SUCCESS));
				status.setData(list);
			}else{
				status.setCode(ResultMsgDefine.RS_CODE_VALUE_ERROR);
				status.setMessage("无停诊数据！");
			}
			
		} catch (Exception e) {
			status.setCode(ResultMsgDefine.RS_CODE_SYSTEM_ERROR);
			status.setMessage(ResultMsgDefine.getMessage(ResultMsgDefine.RS_CODE_SYSTEM_ERROR));
			e.printStackTrace();
			return status;
		}
		return status;
	}
	
	//获取返回的预约数据
	public YyReturnData getYyReturn(YyWorkPb pb, YyOrder yyorder){
		YyReturnData yyreturn = new YyReturnData(yyorder.getHospitalId(),yyorder.getSource(),yyorder.getWorkId(),yyorder.getCardId(),yyorder.getCardType());
		YyOrder order = serviceDao.queryT("YyOrder", " hospitalid=? and workid=? and source=? and cardid=? and cardtype=? ", new Object[]{yyreturn.getHospitalId(),yyreturn.getWorkId(),yyreturn.getSource(),yyreturn.getCardId(),yyreturn.getCardType()});
		yyreturn.setYyid(order.getYyid().toString());
		if(order.getPatientName() == null){
			yyreturn.setPatientName("");
		}else{
			yyreturn.setPatientName(order.getPatientName());
		}
		if(order.getPatientGender() == null){
			yyreturn.setPatientGender("");
		}else{
			yyreturn.setPatientGender(order.getPatientGender());
		}
		if(order.getTelePhoneNo() == null){
			yyreturn.setTelePhoneNo("");
		}else{
			yyreturn.setTelePhoneNo(order.getTelePhoneNo());
		}
		if(order.getAddress() == null){
			yyreturn.setAddress("");
		}else{
			yyreturn.setAddress(order.getAddress());
		}
		if(order.getSeqCode() == null){
			yyreturn.setSeqCode("");
		}else{
			yyreturn.setSeqCode(order.getSeqCode());
		}
		if(pb.getDeptId() == null){
			yyreturn.setDeptid("");
		}else{
			yyreturn.setDeptid(pb.getDeptId());
		}
		if(order.getCreat_time() == null){
			yyreturn.setCreat_time("");
		}else{
			yyreturn.setCreat_time(order.getCreat_time().toString());
		}
		if(pb.getDoctorId() == null){
			yyreturn.setDoctors("");
		}else{
			yyreturn.setDoctors(pb.getDoctorId());
		}
		if(pb.getDoctorName() == null){
			yyreturn.setDoctorName("");
		}else{
			yyreturn.setDoctorName(pb.getDoctorName());
		}
		if(pb.getPeriodCode() == null){
			yyreturn.setPeriodCode("");
		}else{
			yyreturn.setPeriodCode(pb.getPeriodCode().toString());
		}
		if(pb.getDeptName() == null){
			yyreturn.setDeptname("");
		}else{
			yyreturn.setDeptname(pb.getDeptName());
		}
		if(pb.getWorkDate() == null){
			yyreturn.setOrderdate("");
		}else{
			yyreturn.setOrderdate(pb.getWorkDate().toString().substring(0, 10));
		}
		if(pb.getStartTime() == null || pb.getEndTime() == null){
			yyreturn.setTime("");
		}else{
			yyreturn.setTime(pb.getStartTime().toString()+"-"+pb.getEndTime().toString());
		}
		if(order.getLoginUserCardType() == null){
			yyreturn.setLoginUserCardType("");
		}else{
			yyreturn.setLoginUserCardType(order.getLoginUserCardType());
		}
		if(order.getLoginUserIdCard() == null){
			yyreturn.setLoginUserIdCard("");
		}else{
			yyreturn.setLoginUserIdCard(order.getLoginUserIdCard());
		}
		return yyreturn;
	}
}
