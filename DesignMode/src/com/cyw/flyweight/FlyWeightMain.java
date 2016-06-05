package com.cyw.flyweight;

/**
 * ��Ԫ�����ǲ��ɴ���ģ��������Լ��ĺ������;��
 * ��������еĶ���ʱ�ȼ۵ģ������໥���
 * @author cyw
 *
 */
public class FlyWeightMain {
	public static void main(String [] args){
		ReportManagerFactory rmf = new ReportManagerFactory();
		IReportManager ir = rmf.getFinancialManager("A");
		System.out.println(ir.createReport());
	}

}
