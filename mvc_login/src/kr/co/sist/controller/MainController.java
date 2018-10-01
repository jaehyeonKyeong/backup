package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.NamecardAction;
import kr.co.sist.action.NamecardAddFormAction;
import kr.co.sist.action.NamecardAddProcessAction;
import kr.co.sist.action.NamecardListAction;
import kr.co.sist.action.NamecardModfiyAction;
import kr.co.sist.action.NamecardRemoveAction;
import kr.co.sist.action.NamecardSearchAction;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, NamecardAction> ncMap;
	
	static{
		ncMap=new HashMap<String,NamecardAction>();
		//����,���Ը���Ʈ��ȸ
		ncMap.put("NC_M001",new NamecardListAction());
		//���� �Է� ��
		ncMap.put("NC_I001",new NamecardAddFormAction());
		//�Է¸��� �߰� ����
		ncMap.put("NC_I002",new NamecardAddProcessAction());
		//�Է»���ȸ
		ncMap.put("NC_S001",new NamecardSearchAction());
		//���� ����
		ncMap.put("NC_U001",new NamecardModfiyAction());
		//���� ����
		ncMap.put("NC_D001",new NamecardRemoveAction());
		
		
	}//static ���� : Ŭ������ ����Ǹ� ȣ������ �ʾƵ� �ѹ��� �ڵ� ����Ǵ¿�
	
//	{
//		
//	}//instance���� : Ŭ������ ��ü�� �����ɶ����� ȣ������ �ʾƵ�
	// �ڵ� ����Ǵ� ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get������� ��û�Ǹ� doPost method���� ó��(��û����� ������� �ʴ´�.)
		doPost(request,response); 
	}//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//Ű�� ���� �������ϸ� Ű�� �ܺο��� �Էµȴ�. :
		//command pattern�̶�� �Ѵ�. 
		String cmd=request.getParameter("cmd");
		
		
		//���ʿ�û�� �Ǵ� cmd�� ������ �� 
		if(cmd ==null) {
			cmd="NC_M001"; //����ȭ���� �����ֵ��� Ű�� �����Ѵ�.
		}//end if
		
		
		
		//�Էµ� command�� ���� XxxxAction�޴´�.
		//��ü ������: (na)���� �̸��� ��ü������ ���������� ��ü�� ����
		//�ٸ��� ���ȴ�.
		NamecardAction na =ncMap.get(cmd);
		if(na ==null) {//cmd�� �ܺο��� �����ϸ� na���� null�� ���´�.
			na=ncMap.get("NC_M001");
		}
		//method ������: (execute, moveURL, isForward) �����̸���
		//method  ������ �ٸ� ������ �����Ѵ�.
		na.execute(request, response);//method polymorphism
		String url=na.moveURL();
		boolean isForward=na.isForward();
		pageMove(request, response, url, isForward);
	}//doPost
	
	private void pageMove(HttpServletRequest request	,HttpServletResponse response, String url, boolean flag)throws IOException,ServletException{
		
		if(flag) {//forward�� �̵��Ҷ�(���� ������ Servlet, JSP)
			RequestDispatcher rd=request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else {// redirect�̵�(���� ����, �ܺ� ������ Servlet, JSP, HTML)
			response.sendRedirect(url);
		}//end else 
		
	}//pageMove
	
}//class
