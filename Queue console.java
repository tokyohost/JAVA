import java.util.Scanner;

class Queue{
	int head = 0;
	int tail = 0;

	String[] arr;
	void setsize(int size) {
		arr = new String[size];
	}
	
	void Push(String intext) {
		try {
			if(Full()) {
				
				
				System.out.println("array is Full ! Push Faild !");
			}else {
				
				arr[tail] = intext;
				tail+=1;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	boolean Zero() {
		
		return tail == head;
	}
	boolean Full() {
		
		return head == (tail +1)%arr.length;
	}
	
	
	public String See() {
		try {
		
			if(Zero()) {
				
				return "Queue is null,can not See!";
			}else {
				
				return arr[head];
			}
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	String Pop() {
		if(Zero()) {
			
			return "Queue not have Data ! can not Pop !";
		}else {
			head+=1;
			return arr[head-1];
		}
	}
}


class Menu{
	
	void PrintMenu() {
		System.out.println("-----------------------------");
		System.out.println("1。设置队长度");
		System.out.println("2。入队");
		System.out.println("3。出队");
		System.out.println("4。查看队头");
		System.out.println("5。退出");
		System.out.println("-----------------------------");
	}
}

public class Demo {
	public static void main(String[] args) {
		int num= 0;
		int exit= 0;
		Scanner sc = new Scanner(System.in);
		
		
		
		Menu menu = new Menu();
		
		Queue queue = new Queue();
		
		do {
			menu.PrintMenu();
			System.out.println("请输入您的操作：");
			num =sc.nextInt();
			if(num == 5) {
				exit =1;
			}
			
			switch(num) {
			case 1:{
				int size=0;
				System.out.println("Please Enter The queue size:");
				size = sc.nextInt();
				queue.setsize(size);
				break;
			}
			
			case 2:{
				String data;
				System.out.println("请输入需要入队的数据：");
				data = sc.next();
				queue.Push(data);
				break;
			}
			
			case 3:{
				
				System.out.println(queue.Pop());
				break;
			}
			case 4:{
				System.out.println(queue.See());
				break;
			}
			
			}
			
		}while(exit != 1);
		
		
	}

}
