//实现循环队列的练习程序
class ArrayQueue{
	String[] arr;
	int head = 0;
	int tail = 0;
	int size = 0;
	
	public void Queuesize(int size) {
		this.size = size;
		arr = new String[size];
		//创建队长度
	}
	
	public void Push(String intext) {
		//入队
		if(isFull()) {
			//判断是否出队留下空位
			if(head == 0) {
				System.out.println("队满，入队失败");
			}else {
				tail = head-1;
			}
		}else{
			System.out.println("入队成功");
			arr[tail] = intext;
			tail++;
		}
	}
	
	public String SeeHead() {
		/*
		 * 查看队头元素，不出队；
		 * 检查是否空队；
		*/
		if(isEmpty()) {
			return "队空";
		}else {
			return arr[head];
		}
	}
	
	public boolean isEmpty() {
		//检查是否队空
		return head == tail;
	}
	
	public boolean isFull() {
		//检查是否队满
		return head == (tail+1)%arr.length;	
	}
	
	public String Pop() {
		/*出队
		 * 
		 */
		if(head > tail && head == size) {
			//将队头初始化，实现队列循环
			head = 0;
		}
		if(isEmpty()) {
			return "队空无法出队";
		}
		head++;
		return arr[head-1];
		
	}
	
}


public class Demo {
	public static void main(String[] args) {
		ArrayQueue testqueue = new ArrayQueue();
		testqueue.Queuesize(5);
		
		testqueue.Push("张三");
		testqueue.Push("李四");
		testqueue.Push("王二麻子");
		testqueue.Push("王二麻子");
		System.out.println(testqueue.Pop());
		testqueue.Push("王三");
		
		System.out.println(testqueue.Pop());
		System.out.println(testqueue.Pop());
		System.out.println(testqueue.Pop());
		System.out.println(testqueue.Pop());
		System.out.println(testqueue.Pop());
		
		System.out.println("队头为："+testqueue.SeeHead());
		//System.out.println(testqueue.);
	}
	
}
