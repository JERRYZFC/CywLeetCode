package com.cyw.cryptography;

/**
 * �ǶԳ��Լ����㷨(��Կ���ܡ�˽Կ����)
 * ��Դ��http://www.ruanyifeng.com/blog/2013/06/rsa_algorithm_part_one.html
 * ŷ��������f(n)=n(1-1/p1)(1-1/p2)......(1-1/pr)
 * 
 * ��RSA�ĺ��ģ�ŷ������a�Ħ�(n)�η���n��������Ϊ1����a��n���ʣ�
 * ��Կ��n,e��;˽Կ��n,d��
 * Ҫ֪��d�ͱ���ֽ�n���Լ��������������ֽ���ѶȾ�����RSA�㷨�Ŀɿ��ԡ������ƽ�
 * 
 * ���ܣ���m^e �� c (mod n)   ;(mתΪ������m<n,����c)
 * ���ܣ�c^d �� m (mod n) ��(�Ӵ���Ϣm)
 * @author cyw
 */
public class RSA {
	
	/**
	 * 1��p��q���ʡ�������
	 * 2��n = q*p
	 * --3������n��ŷ��������(n)�����������ֽ⣩
	 * 4�����ѡ��һ������e��������1< e < ��(n)����e���(n) ���ʡ�(��ȡe=��(n)-1)
	 * 5������e���ڦ�(n)��ģ��Ԫ��d��
	 * 6����n��e��װ�ɹ�Կ��n��d��װ��˽Կ��
	 * 
	 * 1������������p,q��
	 * 2��ģ��n=p*q��
	 * 3��ŷ������fn=(p-1)(q-1)��
	 * 4�������e��1 
	 * 5��ģ��d������С����d��e*d=1 mod f��
	 */
	
	private long p;
	private long q;
	private long n;
	private long fn;
	private long e;
	private long d;
	
	public RSA(){}
	public RSA(long p, long q){
		this.p = p;
		this.q = q;
		this.n = p*q;
		this.fn = (p-1)*(q-1);
		this.e = fn-1;
	}
	
	public long getFn(){
		return fn;
	}
	
	/**
	 * ��չŷ������㷨
	 * շת�����
	 */
	public long[] getEx(long a, long b){
		long[] result = new long[3];
		if(b==0){
			result[0] = 1;
			result[1] = 0;
			result[2] = a;
			return result;
		}else{
			result = getEx(b, a%b);
			long t = result[0];
			result[0] = result[1];
			result[1] = t-(a/b)*result[1];
			return result;
		}
	}
	
	private long generateD(){
//		e*d + fn*y == 1;
		long[] result = getEx(e, fn);
		this.d = result[0];
		return result[0];
	}
	
	/**
	 * ���̣�
	 * ��1���ҷ�����������Կ����Կ��˽Կ������Կ�ǹ����ģ��κ��˶����Ի�ã�˽Կ���Ǳ��ܵġ�
	 * ��2���׷���ȡ�ҷ��Ĺ�Կ��Ȼ����������Ϣ���ܡ�
	 * ��3���ҷ��õ����ܺ����Ϣ����˽Կ���ܡ�
	 */
	public long[] generatePublicKey(){
		long[] re = {n, e};
		return re; 
	}
	private long[] generatePrivateKey(){
		long[] re = {n, d};
		return re;
	}
	
	/**
	 * ����
	 */
	public long encryption(long m){
//		m^e �� c (mod n)
		return (long) (Math.pow(m, e)%n);
	}
	/**
	 * ����
	 * @return 
	 */
	public long decryption(long c){
//		c^d �� m (mod n)
		return (long) (Math.pow(c, d)%n);
	}
}
