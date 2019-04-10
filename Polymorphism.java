//JAVA的多态性学习

package test;
class Animal{
	
	void eat() {
		
		System.out.println("他们都会吃食物");
	}
}

class Cat extends Animal{
	
	
	void eat() {
		System.out.println("小猫吃小鹰！");
	}
	//增加new 方法
	void neweat() {
		System.out.println("小猫也会吃老鼠！");
	}
}
class Dog extends Animal{
	
	void eat() {
		System.out.println("小狗吃小猫！");
	}
	//增加new 方法
		void neweat() {
			System.out.println("小狗也会吃屎！");
		}
}
class Eagle extends Animal{
	
	void eat() {
		System.out.println("老鹰吃小狗！");
	}
	//增加new 方法
		void neweat() {
			System.out.println("老鹰也会吃小鸡！");
		}
}


public class Demo1 {
	public static void main(String[] args) {
		
		Animal a = new Animal();
		a.eat();
		
		Animal a1 = new Cat();
		a1.eat();
		Animal a2 = new Dog();
		a2.eat();
		Animal a3 = new Eagle();
		a3.eat();
		
		//4.调用Cat new方法
		Cat cat = (Cat) a1;
		cat.eat();
		cat.neweat();
		Dog dog = (Dog) a2;
		dog.eat();
		dog.neweat();
		Eagle eagle= (Eagle) a3;
		eagle.eat();
		eagle.neweat();
		
		
		
	}
}
