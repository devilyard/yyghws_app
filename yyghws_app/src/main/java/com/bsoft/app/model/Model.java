package com.bsoft.app.model;

import java.util.List;

/**
 * @author chbhuabin
 *
 */
public class Model {
	
	
	private String OperatorId;
	
	private String ApplicationId;
	
	private String TransactionId;
	
	private String ApplicationSecret;

	private List Parameter;
	
	public String getOperatorId() {
		return OperatorId;
	}

	public void setOperatorId(String operatorId) {
		OperatorId = operatorId;
	}

	public String getApplicationId() {
		return ApplicationId;
	}

	public void setApplicationId(String applicationId) {
		ApplicationId = applicationId;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public List getParameter() {
		return Parameter;
	}

	public void setParameter(List parameter) {
		Parameter = parameter;
	}

	public String getApplicationSecret() {
		return ApplicationSecret;
	}

	public void setApplicationSecret(String applicationSecret) {
		ApplicationSecret = applicationSecret;
	}
	
	
}
