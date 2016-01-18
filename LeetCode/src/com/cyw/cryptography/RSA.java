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
		generateD(e, fn);
	}
	
	public RSA(long p, long q,long e){
		this.p = p;
		this.q = q;
		this.n = p*q;
		this.fn = (p-1)*(q-1);
		this.e = e;
		generateD(e, fn);
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
	
	private long generateD(long e, long fn){
//		e*d + fn*y == 1;
		long[] result = getEx(e, fn);
		this.d = result[0];
		return result[0];
	}
	
	public long getP() {
		return p;
	}
	public void setP(long p) {
		this.p = p;
	}
	public long getQ() {
		return q;
	}
	public void setQ(long q) {
		this.q = q;
	}
	public long getN() {
		return n;
	}
	public void setN(long n) {
		this.n = n;
	}
	public long getE() {
		return e;
	}
	public void setE(long e) {
		this.e = e;
	}
	public long getD() {
		return d;
	}
	public void setD(long d) {
		this.d = d;
	}
	public void setFn(long fn) {
		this.fn = fn;
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
	public long encryption(long m, long[] re){
//		m^e �� c (mod n)
		long n = re[0];
		long e = re[1];
		System.out.println("e:"+e);
		return (long) (Math.pow(m, e)%n);
	}
	/**
	 * ����
	 * @return 
	 */
	public long decryption(long c, long[] re){
//		c^d �� m (mod n)
		long n = re[0];
		long d = re[1];
		System.out.println("d:"+d);
		return (long) (Math.pow(c, d)%n);
	}
	
	
	public static void main(String [] args){
		RSA r = new RSA(3,7,17);
		long[] pk = r.generatePublicKey();
		long[] prk = r.generatePrivateKey();
		System.out.println(r.getN());
		System.out.println(r.getFn());
		System.out.println(r.getD());
		System.out.println(r.getE());
		System.out.println(r.encryption(3, pk));
		System.out.println(r.decryption(12,prk));
		
		System.out.println(Math.pow(3, 17)%21);
		System.out.println(Math.pow(12, 5)%21);
	}
}
