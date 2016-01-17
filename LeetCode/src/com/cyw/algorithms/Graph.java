package com.cyw.algorithms;

public class Graph {
	
	/*
	 * Marienbad��Ϸ
	 * ���㷨������
	 * ���ݱ�־
	 * 
	 * ȱ���ǣ�
	 * ��Ҫһ����һ�εļ�����ͬ��ֵ��������ظ���ֵ��
	 */
	public static boolean recwin(int i,int j){
		//�ٶ�0<=j<=i;���ҽ���<i,j>�ǿ�Ӯ�ڵ��Ƿ���true
		for(int k=1;k<j;k++){
			if(!recwin(i-k,Math.min(2*k,i-k))){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * ���Ч��
	 * ʹ�ö�̬�滮������һ��G�������飬���㵱�ҽ���<i,j>��һ����Ӯ�Ĳ���ʱ��G[i,j]=true
	 * ȱ���ǣ�
	 * �˷Ѵ�����ʱ�����G����Զ�ò�����һЩ��
	 */
//	public boolean[] dywin(int n){
//		boolean[] G
//		
//		return G;
//	}

	public static void main(String [] args){
		System.out.println(recwin(5,4));
	}
}
