//��ջ���п���̨����

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
			//�������飬��ӳ���
			arr = Arrays.copyOf(arr, arr.length*2);
			
			arr[tail] = intext;
			tail=tail+1;
		}else {
			arr[tail] = intext;
			tail=tail+1;
			
		}
		
	}
	public boolean ifOver() {
		//�Ƿ�ջ��
		return tail == arr.length;
		
	}
	public boolean ifZero() {
		//�Ƿ�ջ��
		return 0 == tail;
	}
	
	public String See() {
		if(ifZero()) {
			return "ջ�գ�ջ��Ԫ��Ϊ��";
		}else {
			return arr[tail-1];
		}
	}
	
	public String Pop() {
		
		if(ifZero()) {
			return "ջ�գ��޷���ջ";
		}else {
			tail=tail-1;
			return arr[tail];
		}
		
	}
	
}
 class Menu{
	
	public void show() {
		System.out.println("----------------------");
		System.out.println("1.��ջ");
		System.out.println("2.��ջ");
		System.out.println("3.�鿴ջ��Ԫ��");
		System.out.println("4.�鿴ջ����");
		System.out.println("5.�˳�");
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
			
			System.out.println("��������Ҫ���еĲ�����");
			num = sc.nextInt();
			
			switch(num) {
			 case 1:{
				 System.out.println("��������Ҫ��ջ�����ݣ�");
				 text = sc.next();
				 stack.Push(text);
				 break;
			 }
			 case 2:{
				 System.out.println("��ջ��Ԫ��Ϊ��"+stack.Pop());
				 break;
			 }
			 case 3:{
				 System.out.println("ջ�������ݣ�"+stack.See());
				 
				 break;
			 }
			 case 4:{
				 System.out.println("ջ����Ϊ��"+stack.arr.length);
				 
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