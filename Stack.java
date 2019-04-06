import java.util.Arrays;

class Stack {
	int size = 0;
	String[] arr;
	
	Stack(int length) {
		//获得初始栈数组长度
		arr = new String[length];
	}
	
	public void push(String innumber) {
		//入栈
		
		if(check()) {
			System.out.println("栈满，添加栈空间");
			//arrays.copyof(原数组，新数组长度)；  增加数组长度！事实上是复制原来的数组到同名的新数组中。
			arr = Arrays.copyOf(arr, arr.length*2);
			arr[size] = innumber;
			size++;
		}else {
			arr[size] = innumber;
			size++;
		}
	}
	
	public boolean check() {
				//检查栈是否满	
			return size == arr.length;
		
	}
	
	public String pop() {
		//出栈
		if(size == 0) {
			return "栈空";
		}else {

			size--;
			return arr[size];
			
		}
	}
	public String see() {
		
		return arr[size-1];
		
	}
	
}


public class Demo {
	
	public static void main(String[] args) {
		Stack test = new Stack(1);
		test.push("张三");
		test.push("李四");
		test.push("李五");
		System.out.println("栈内元素为："+test.size);
		System.out.println("出栈："+test.pop());
		System.out.println("栈内元素为："+test.size);
		System.out.println("出栈："+test.pop());
		System.out.println("栈内元素为："+test.size);
		System.out.println("数组长度为："+test.arr.length);
		System.out.println("栈顶元素为："+test.see());
		System.out.println("栈内元素为："+test.size);
		
		
	}

}
