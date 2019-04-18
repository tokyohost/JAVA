//蓝桥杯算法训练，字符转换
/*
*从键盘输入一个大写字母，要求改用小写字母输出。
*
*算法训练 P0103  
*/

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		char[] Smallarr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] Bigarr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
		Scanner sc = new Scanner(System.in);
		char text;
		
		text = sc.next().charAt(0);
		
		
		for(int i=0;i<=Bigarr.length;i++) {
			if(text == Bigarr[i]) {
				
				System.out.println(Smallarr[i]);
			break;
		  }
	
	  }

	}
}
