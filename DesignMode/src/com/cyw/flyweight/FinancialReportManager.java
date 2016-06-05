package com.cyw.flyweight;

/**
 * �������Ԫ��
 * @author cyw
 *
 */
public class FinancialReportManager implements IReportManager{

	protected String tenantId = null;
	public FinancialReportManager(String tenantId){
		this.tenantId = tenantId;
	}
	
	public String createReport() {
		return "This is a financial report!";
	}

}
