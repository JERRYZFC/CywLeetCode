package com.cyw.test;

public class Solution {
    public static boolean isPowerOfThree(int n) {
    	
//    	�����,ȡ����е�������ȥ��С����Ȼ��˷����жϵ����Ƿ����
//    	logx(y) =loge(x) / loge(y)�����׹�ʽ
//    	log() ��ln()
    		return Math.pow(3,Math.round(Math.log(n)/Math.log(3)))==n && n>0;
    	
//    	boolean result = false;
//        if(n%3==0 && n!=1){
//        	result = isPowerOfThree(n/3);
//        }
//        else if(n==1){
//        	return true;
//        }else
//        	return false;
//        if(result)
//        	return true;
//        else 
//        	return false;
    }
    
    public static boolean isPowerOfTwo(int n) {
    	 //���һ��������2���ݣ���ô���Ķ�������ʽ���λΪ1�������λΪ0
        return (n > 0 && ((n&(n - 1))==0));
    }
    
    public static void main(String [] args){
    	
//    	System.out.println();
    	
    	if(isPowerOfThree(27))
    		System.out.println("True");
    	else
    		System.out.println("False");
    }
}