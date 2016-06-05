package com.cyw.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ԫģʽ�ĺ��ģ���Ԫ������
 * ά��һ�������б�
 * @author cyw
 *
 */
public class ReportManagerFactory {
	Map<String, IReportManager> financialReportManager = 
			new HashMap<String, IReportManager>();
	Map<String, IReportManager> employeeReportManager = 
			new HashMap<String, IReportManager>();
	
	public IReportManager getFinancialManager(String tenantId){
		//ͨ��id��ȡ��Ԫ
		IReportManager ir = financialReportManager.get(tenantId);
		if(ir == null){
			//ά���Ѿ���������Ԫ����
			ir = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, ir);
		}
		return ir;
	}
	
	public IReportManager getEmployeeReportManager(String tenantId){
		IReportManager ir = employeeReportManager.get(tenantId);
		if(ir == null){
			ir = new EmployeeReportManager(tenantId);
			employeeReportManager.put(tenantId, ir);
		}
		return ir;
	}
	
}
