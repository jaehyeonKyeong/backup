package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.NamecardDAO;
import kr.co.sist.vo.NCListVO;
import kr.co.sist.vo.NCStartEndVO;

/**
 * 명함을 페이지별로 조회할 때 사용
 * 게시판의 리스트 형태로 보여주기 위해 연산하는 작업이 들어간다.
 * @author owner
 */
public class NamecardService {
	private int pageScale;
	
	public NamecardService() {
		pageScale=10;
	}//NamecardService
	
	
	public int getTotalCount() {
		NamecardDAO n_dao=NamecardDAO.getInstance();
		int cnt=0;
		
		try {
			cnt=n_dao.namecardTotalCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return cnt;
	}//getTotalCount

	public int getPageScale() {
		return pageScale;
	}//getPageScale



	public List<NCListVO> searchNc(int currentPage){
		
		NamecardDAO n_dao=NamecardDAO.getInstance();
				
		List<NCListVO> list=null;
		try {
			//1.전체 게시물의 갯수
			int totalCount=getTotalCount();
			//2.한 화면에 보여줄 명함의 수 
			
			//3.총 페이지 수 계산
			int totalPage=totalPage(totalCount,pageScale);
			
			//5.시작번호 구하기
			int startNum=startNum(currentPage, pageScale);
			
			//6.끝 번호 구하기
			int endNum=endNum(startNum, pageScale);
			
			NCStartEndVO ncseVO=new NCStartEndVO(startNum, endNum);
			//시작번호와 끝번호에 해당하는 명함을 조회
			list=n_dao.selectList(ncseVO);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchNc
	
	//끝번호
	private int endNum(int startNum, int pageScale) {
		return startNum+pageScale-1;
	}//endNum
	
	//시작번호
	private int startNum(int tempPage, int pageScale) {
		return tempPage*pageScale-pageScale+1;
	}//startNum
	
	public int totalPage(int totalCount, int pageScale){
		int totalPage=totalCount/pageScale;
		if(totalCount%pageScale!=0){
			totalPage++;
		}//end if
		return totalPage;
	}//totalPage
	
	
	public String indexList(int current_page, int total_page, String list_url) {
		  
	int pagenumber=3;  
	int startpage=0; 
	int endpage=0; 
	int curpage=0; 
	StringBuilder strList=new StringBuilder();

	startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

	endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

	if (total_page <= endpage){
		endpage = total_page;
	}//end if

	if ( current_page > pagenumber) {
		curpage = startpage - 1; 
		strList.append("[<a href='").append(list_url).append("&current_page=").append(curpage).append("'>&lt;&lt;</a>]");
	}else{
		strList.append("[&lt;&lt;]");
	}//end else 
	strList.append(" ... ");

	curpage = startpage;

	while (curpage <= endpage){

		if (curpage == current_page) {
			strList.append("[ <a href='").append(list_url).append("&current_page=").append(current_page).append("'>").append(current_page).append("</a> ]");
		} else {
			strList.append("[ <a href='").append(list_url).append("&current_page=").append(curpage).append("'>").append(curpage).append("</a> ]");
		}//end else
		curpage++;
	}//end while
	strList.append(" ... ");
	
	if ( total_page > endpage) {
		curpage = endpage + 1;
		strList.append("[ <a href='").append(list_url).append("&current_page=").append(curpage).append("'>&gt;&gt;</a>]");
	}else{
		strList.append("[&gt;&gt;]");
	}//end else 
	
		return strList.toString();
	}//indexList
	
	
	
}//class








