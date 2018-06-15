package myTest0402;

public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " ABCDEFGH ";
		System.out.println(("ABC").contentEquals(str));
		System.out.println(("ABC").contentEquals(str));
		System.out.println( str);
		System.out.println( str.replace(" ",""));
		System.out.println("----------------------------------------------------------");
		String[] st = str.split("^^^");
		for (int i=0;i<st.length;i++) {
			System.out.println(st[i]);
		}

	}

}
/*
String name;
String id;
String password;
int age;

public Member(String name, String id){
this.name = name;
this.id = id;

}
public boolean login(String id, String password){
return (id=="hong" && password=="12345");

}
public void logout(String id){
System.out.println("로그아웃 되었습니다");
}


















*/