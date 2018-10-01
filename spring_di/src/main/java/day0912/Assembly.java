package day0912;

/**
 * 객체간를 생성하고 객체간의 관계를 설정(의존성 주입 : DI :: Dependency Injection)하는 일
 * @author owner
 */
public class Assembly {
	public Service getBean() {
		//OracleDAO od=new OracleDAO();
		MySqlDAO msd=new MySqlDAO();
		Class4MemberService c4ms=new Class4MemberService(msd);
		return c4ms;
	}
}
