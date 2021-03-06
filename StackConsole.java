//对栈进行控制台操作

import java.util.Arrays;
import java.util.Scanner;

class Stack{
	String[] arr;
	int tail = 0;
	
	public void Size(int size) {
		arr = new String[size];
		
	}
	
	public void Push(String intext) {
		if(ifOver()) {
			//拷贝数组，添加长度
			arr = Arrays.copyOf(arr, arr.length*2);
			
			arr[tail] = intext;
			tail=tail+1;
		}else {
			arr[tail] = intext;
			tail=tail+1;
			
		}
		
	}
	public boolean ifOver() {
		//是否栈满
		return tail == arr.length;
		
	}
	public boolean ifZero() {
		//是否栈空
		return 0 == tail;
	}
	
	public String See() {
		if(ifZero()) {
			return "栈空，栈顶元素为空";
		}else {
			return arr[tail-1];
		}
	}
	
	public String Pop() {
		
		if(ifZero()) {
			return "栈空，无法出栈";
		}else {
			tail=tail-1;
			return arr[tail];
		}
		
	}
	
}
 class Menu{
	
	public void show() {
		System.out.println("----------------------");
		System.out.println("1.入栈");
		System.out.println("2.出栈");
		System.out.println("3.查看栈顶元素");
		System.out.println("4.查看栈长度");
		System.out.println("5.退出");
		System.out.println("----------------------");
		
	}
	
}
 

public class Demo {
	public static void main(String[] args) {
		int exit = 0;
		int num = 0;
		String text;
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		
		Stack stack = new Stack();
		stack.Size(1);
		
		do {
			menu.show();
			
			System.out.println("请输入需要进行的操作：");
			num = sc.nextInt();
			
			switch(num) {
			 case 1:{
				 System.out.println("请输入需要入栈的数据：");
				 text = sc.next();
				 stack.Push(text);
				 break;
			 }
			 case 2:{
				 System.out.println("出栈的元素为："+stack.Pop());
				 break;
			 }
			 case 3:{
				 System.out.println("栈顶的数据："+stack.See());
				 
				 break;
			 }
			 case 4:{
				 System.out.println("栈长度为："+stack.arr.length);
				 
				 break;
			 }
			 case 5:{
				 
				 exit = 1;
				 break;
			 }
			 }
		
		}while(exit != 1);
		
		
	}
}