package com.cyw.test;

public class Cyw_326 {
    public static boolean isPowerOfThree(int n) {
//    	�����,ȡ����е�������ȥ��С����Ȼ��˷����жϵ����Ƿ����
//    	logx(y) =loge(x) / loge(y)�����׹�ʽ
//    	log() ��ln()
    		return Math.pow(3,Math.round(Math.log(n)/Math.log(3)))==n && n>0;
    }
}
