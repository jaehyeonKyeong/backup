package myTest0405;

public class Dog extends Animal {
	
	
	public Dog() {
		this.kind="포유류";
		super.kind="조류";
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		
		System.out.println(dog.kind);

	}

}
