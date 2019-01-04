package ds;

import java.util.Scanner;

/**
 * 使用jar
 * @author 钟登博
 *
 */
public class UseJar {
	
	/**
	 * 判断一个数是否为回文数
	 */
	public void Huiwenshu (){
		
		Scanner scan = new Scanner(System.in);
		boolean is = false;
		while (!is) {
			//一直要求输入,如果不是回文数就退出
			System.out.println("请输入一个整数:");
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
				System.out.println(a + "是一个回文数!");
			}else {
				System.out.println(a + "不是一个回文数!");
			}
		}
		
	}
	
	/**
	 * 加法
	 * @param a 加数
	 * @param b 被加数
	 * @return 返回和
	 */
	public int Add(int a, int b) {
		
		return a+b;
	}
	
	/**
	 * 阶乘
	 */
	public void Jiecheng() {
		// 递归求阶乘
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int a = scan.nextInt();
		rec fr = new rec();
		System.out.println(a +"!="+fr.rec(a));
	}

}

/**
 * 阶乘调用
 * @author 钟登博
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

