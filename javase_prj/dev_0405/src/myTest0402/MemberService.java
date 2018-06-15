package myTest0402;

public class MemberService {

	public boolean login(String id, String password) {
		return (id == "hong" && password == "12345");

	}

	public void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}

}
