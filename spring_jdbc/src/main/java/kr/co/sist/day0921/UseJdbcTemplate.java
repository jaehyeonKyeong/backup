package kr.co.sist.day0921;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.co.sist.vo.CpEmpVO;
import kr.co.sist.vo.CpEmpVO2;

public class UseJdbcTemplate {
	
	public JdbcTemplate getJdbcTemplate() {
		ApplicationContext ac=new ClassPathXmlApplicationContext
				("kr/co/sist/day0921/applicationContext.xml");
		
		JdbcTemplate jt=ac.getBean(JdbcTemplate.class);
		return jt;
	}//getJdbcTemplate
	
	public int insertCpEmp(CpEmpVO cev) {
		String insert_cpemp=
				"insert into cp_emp(empno, ename, sal, hiredate, comm)values(?,?,?,sysdate,?)";
		JdbcTemplate jt=getJdbcTemplate();
		
		//insert, update,delete는 JdbcTemplate의 update method로 쿼리를 수행한다.
		//update("SQL문", 값,,,);
		int cnt=jt.update(insert_cpemp,cev.getEmpno(),
					cev.getEname(),cev.getSal(),cev.getComm());
		return cnt;
		
	}//insertCpEmp
	
	
	public int updateCpEmp(CpEmpVO cev) {
		String update_cpemp=
				"update cp_emp set sal=?,comm=? where empno=? and ename=?";
		JdbcTemplate jt=getJdbcTemplate();
		
		//insert, update,delete는 JdbcTemplate의 update method로 쿼리를 수행한다. update("SQL문", 값,,,);
		//bind변수 순서에 맞게 입력
		int cnt=jt.update(update_cpemp,cev.getSal(),cev.getComm(),cev.getEmpno(),cev.getEname());
		return cnt;
		
	}//updateCpEmp
	
	
	public int deleteCpEmp(int empno) {
		String delete_cpemp=
				"delete from cp_emp where empno=?";
		JdbcTemplate jt=getJdbcTemplate();
		
		//insert, update,delete는 JdbcTemplate의 update method로 쿼리를 수행한다. update("SQL문", 값,,,);
		
		int cnt=jt.update(delete_cpemp, empno);
		return cnt;
		
	}//deleteCpEmp
	
	
	//Spring Jdbc로 조회
	public CpEmpVO2 selectCpEmp(int empno) throws DataAccessException {
		//1.RowMapper 생성:조회된 값을 VO(Domain)에 매핑
		RowMapper<CpEmpVO2> rm=new RowMapper<CpEmpVO2>() {

			@Override
			public CpEmpVO2 mapRow(ResultSet rs, int cnt) throws SQLException {
				CpEmpVO2 cev=new CpEmpVO2(rs.getString("ename"),
						rs.getInt("sal"),rs.getInt("comm"));
				return cev;
			}//mapRow

		};//anonymous innertype으로 객체화
		//2.쿼리문 생성 //1번과 2번은 순서가 바뀌어도 됨.
		String select_cpemp=
				"select ename, sal, comm from cp_emp where empno=?";
		//3.쿼리수행 후 결과 얻기
		JdbcTemplate jt=getJdbcTemplate();
		CpEmpVO2 cev2=jt.queryForObject(select_cpemp, new Object[]{empno} , rm);
		
		return cev2;
	}//selectCpEmp
	
	//입력받은 부서번호와 직무에 해당하는 사원정보를 emp테이블에서 조회
	//사원번호, 사원명, 연봉, 보너스 조회
	public List<CpEmpVO> selectEmp(int deptno, String job) throws DataAccessException{
		List<CpEmpVO> list=null;
		
		//1. 쿼리문 생성
		StringBuilder selectEmp=new StringBuilder();
		selectEmp.append("select empno,ename,sal,comm from emp ")
		.append("where deptno=? and job=?")
		.append("order by sal desc");
		
		//2.RowMappe설정
		RowMapper<CpEmpVO> rowMapper=new RowMapper<CpEmpVO>() {
			
			@Override
			public CpEmpVO mapRow(ResultSet rs, int cnt) throws SQLException {
				CpEmpVO cev=new CpEmpVO(rs.getInt("empn"), rs.getInt("sal"), rs.getInt("comm"), rs.getString("ename"));
				return cev;
			}
		};//anonymous inner class
		
		//3.쿼리수행후 결과 얻기 : query
		JdbcTemplate jt=getJdbcTemplate();
		list=jt.query(selectEmp.toString(), new Object[] {deptno,job},rowMapper);
		
		
		return list;
	}
	
	public static void main(String[] args) {
		//insert
	/*	UseJdbcTemplate ujt=new UseJdbcTemplate();
		CpEmpVO cev=new CpEmpVO(2222, 3000, 0, "강소예");
		if(ujt.insertCpEmp(cev)==1) {
		System.out.println(cev.getEname()+" 사원 정보 추가");
		}else {
		System.out.println(cev.getEname()+" 사원 정보 추가실패");
		}//end else*/
		
		//update
		/*UseJdbcTemplate ujt=new UseJdbcTemplate();
		CpEmpVO cev=new CpEmpVO(2222, 3800, 900, "강소예");
		if(ujt.updateCpEmp(cev)==1) {
			System.out.println(cev.getEname()+" 사원 정보 변경");
		}else {
			System.out.println(cev.getEname()+" 사원 정보 변경실패");
		}//end else*/
		
		/*//delete
		UseJdbcTemplate ujt=new UseJdbcTemplate();
		int empno=2222;
		if(ujt.deleteCpEmp(empno)==1) {
			System.out.println(empno+" 사원 정보 삭제");
		}else {
			System.out.println(empno+" 사원 정보 삭제실패");
		}//end else	*/		
		
		//select 한행 조회
		UseJdbcTemplate ujt=new UseJdbcTemplate();
		/*		try {
		int empno=1235;
		CpEmpVO2 cev2=ujt.selectCpEmp(empno);
		System.out.println(empno+"번 사원 정보조회\n사원명 : "+cev2.getEname()+"\n연봉 : "
					+cev2.getSal()+"\n보너스 : "+cev2.getComm());
		}catch(DataAccessException dae)
		{
			System.err.println("조회된 결과가 한행이 아닙니다.");
			dae.printStackTrace();
		}
*/		
		//select 여러행 조회
		int deptno=30;
		String job="SALESMAN";
		try {
		List<CpEmpVO> list=ujt.selectEmp(deptno, job);
		System.out.println("사원번호\t사원명\t연봉\t보너스");
		for(CpEmpVO cev:list) {
			System.out.printf("%d\t%s\t%d\t%d\n",cev.getEmpno(),cev.getEname(),cev.getSal(),cev.getComm());
		}
		}catch(DataAccessException dae) {
			System.err.println("DBMS에서 문제가 발생 하였습니다 : "+dae.getMessage());
			//발생한 예외 메시지를 파일로 출력.c:/dev/jdbc_exception.log
			File logFile=new File("c/dev/jdbc_exception.log");
			if(logFile.exists()) {
				FileWriter fw=null;
				try {
					logFile.createNewFile();
					String str=dae.getLocalizedMessage();
					try {
						fw=new FileWriter(logFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					fw.write(str);
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}//main
	
	
	

}//class
