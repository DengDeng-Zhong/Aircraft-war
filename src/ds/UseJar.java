package ds;

import java.util.Scanner;

/**
 * ʹ��jar
 * @author �ӵǲ�
 *
 */
public class UseJar {
	
	/**
	 * �ж�һ�����Ƿ�Ϊ������
	 */
	public void Huiwenshu (){
		
		Scanner scan = new Scanner(System.in);
		boolean is = false;
		while (!is) {
			//һֱҪ������,������ǻ��������˳�
			System.out.println("������һ������:");
			long a = scan.nextLong();
			String ss = Long.toString(a);
			char[] ch = ss.toCharArray();
			int j = ch.length;
			for (int i = 0; i < j/2; i++) {
				if (ch[i] != ch[j-i-1]) {
					is = true;
				}
			}
			if (is != true) {
				System.out.println(a + "��һ��������!");
			}else {
				System.out.println(a + "����һ��������!");
			}
		}
		
	}
	
	/**
	 * �ӷ�
	 * @param a ����
	 * @param b ������
	 * @return ���غ�
	 */
	public int Add(int a, int b) {
		
		return a+b;
	}
	
	/**
	 * �׳�
	 */
	public void Jiecheng() {
		// �ݹ���׳�
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ������:");
		int a = scan.nextInt();
		rec fr = new rec();
		System.out.println(a +"!="+fr.rec(a));
	}

}

/**
 * �׳˵���
 * @author �ӵǲ�
 *
 */
class rec{
	public long rec(int a) {
		long value = 0;
		if (a == 1) {
			value = 1;
		}else {
			value = a*rec(a-1);
		}
		return value;
	}
}

