package myTest0405;

public class Dog extends Animal {
	
	
	public Dog() {
		this.kind="������";
		super.kind="����";
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		
		System.out.println(dog.kind);

	}

}
