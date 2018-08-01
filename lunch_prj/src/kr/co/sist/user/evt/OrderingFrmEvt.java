package kr.co.sist.user.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.OrderingDAO;
import kr.co.sist.user.util.copy.ImageResize;
import kr.co.sist.user.view.OrderingFrm;
import kr.co.sist.user.view.OrderingInfo;
import kr.co.sist.user.view.ProductDetail;
import kr.co.sist.user.vo.LunchDetailVO;
import kr.co.sist.user.vo.LunchVO;
import kr.co.sist.user.vo.MyOrderingVO;

public class OrderingFrmEvt extends MouseAdapter implements ActionListener {
	private OrderingFrm of;
	private OrderingInfo oi;

	public OrderingFrmEvt(OrderingFrm of,OrderingInfo oi) {
		this.of=of;
		this.oi=oi;
	}//OrderingFrmEvt


	/**
	 * JTable에 조회한 도시락 목록을 설정하는 메소드
	 */
	public void setTableLunch() {
		OrderingDAO od_dao=OrderingDAO.getInstance();
		try {

			List<LunchVO> list=od_dao.selectLunch();
			Object[] tempData=null;

			DefaultTableModel dtmLunch=of.getDtm();
			//모델에 있는 행을 초기화
			dtmLunch.setRowCount(0);
			//조회한 결과를 받아서 
			String tempImg="";
			File file=null;

			for(LunchVO lv : list) {
				file=new File("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+lv.getImg());
				if(!file.exists()) {
					FileClient fc=new FileClient();
					//TODO
					try {
						fc.uploadProcess(file);//서버에서 제공하는 파일 받기

					}catch(IOException e) {
						e.printStackTrace();
						//서버에서 파일을 읽어들이지 못하는 상황이면 기본 이미지를 보여준다.
						file=new File("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+lv.getImg());
					}//end catch

					//해당 파일이 없다면 서버에서 받아온다.
					//작은 이미지로부터 큰 이미지를 생성
					file=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/s_default.jpg");

				}//end if

				//List에 조회된 데이터를 배열을 생성하고 추가한다.
				tempData=new Object[4];
				tempData[0]=new ImageIcon(file.getAbsolutePath());
				tempData[1]=lv.getPrdName();
				tempData[2]=lv.getLunchInfo();
				tempData[3]=lv.getLunchCode();

				//생성된 배열을 JTable에 반영하기 위해 D.T.M에 추가한다.
				dtmLunch.addRow(tempData);

			}//end for

			//조회된 도시락이 없다면 
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(of, "죄송합니다. 준비된 도시락이 없습니다.");
			}//end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(of, 
					"도시락 조회 중 문제가 발생하였습니다. 잠시후 다시 이용해주세요.");
			e.printStackTrace();
		}//end catch

	}//setTableLunch


	@Override
	public void actionPerformed(ActionEvent ae) {
		String phone=oi.getTfPhone().getText().trim();
		if(!"".equals(phone)) {
			OrderingDAO o_dao=OrderingDAO.getInstance();

			try {
				//전화번호로 주문현황을 조회
				List<MyOrderingVO> listOrder=o_dao.selectOrderingList(phone);

				if(! listOrder.isEmpty()) {
					DefaultTableModel dtmOrder=oi.getDtm();
					//조회된 데이터가 존재하므로 D.T.M을  초기화한다.
					dtmOrder.setRowCount(0);
					Object[] rowData=null;

					DecimalFormat df=new DecimalFormat("#,###");

					for(MyOrderingVO mov:listOrder) {
						rowData=new Object[5];
						rowData[0]=new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/user/img/s_"+mov.getImg());
						rowData[1]=mov.getPrdName();
						rowData[2]=df.format(mov.getPrice());
						rowData[3]=df.format(mov.getQuantity());
						rowData[4]=df.format(mov.getPrice()*mov.getQuantity());
						//생성된 데이터를 테이블에 보여주기 위해 D.T.M에 추가
						dtmOrder.addRow(rowData);
					}//end for
				}else {
					JOptionPane.showMessageDialog(oi, 
							phone+"번으로는 주문내역이 없습니다.");
				}//end else

			} catch (SQLException se) {
				se.printStackTrace();
				JOptionPane.showMessageDialog(oi, 
						"사용중 불편을 드려 죄송합니다. 잠시 후 다시 시도해주세요.");
			}//end catch

		}else{
			JOptionPane.showMessageDialog(oi, "전화번호를 입력해주세요.");
		}//end else


	}//actionPerformed


	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getClickCount()==2) {
			//			int time=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			//			
			//			if(time <9 || time>13) {
			//				JOptionPane.showMessageDialog(of, 
			//						"주문 가능시간이 아닙니다.\n주문은 오전 9시부터 오후13시까지입니다.");
			//				return;
			//			}//end if

			JTable temp=(JTable)me.getSource();
			//선택된 행의 도시락명을 받아와서
			String prdName=(String)temp.getValueAt(temp.getSelectedRow(),1);

			//도시락의 큰 이미지가 없다면 큰 이미지를 생성
			ImageIcon img=(ImageIcon)temp.getValueAt(temp.getSelectedRow(),0);
			File tempFile=new File(img.toString());
			File tempFile1=new File(tempFile.getParent()+
					"/"+tempFile.getName().substring(2));
			//작은 파일을 큰 파일로 생성(파일명은 "s_"가 빠진 이름)
			if(!tempFile1.exists()) {
				try {
					ImageResize.imgResize(of, tempFile.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}//end catch

			}//end if
			//주문을 계속할 것인지 물어본다.
			switch(JOptionPane.showConfirmDialog(of, prdName+ "도시락을 주문 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:

				//선택한 행의 도시락 코드값(prd_code)를 얻어와서
				String prdCode=(String)temp.getValueAt(temp.getSelectedRow(),3);
				//해당 도시락의 상세정보를 조회한 후
				OrderingDAO od=OrderingDAO.getInstance();
				try {
					LunchDetailVO ldv=od.selectDetailLunch(prdCode);
					//주문창에 설정한다.
					new ProductDetail(ldv);
				}catch(SQLException se) {
					se.printStackTrace();
					JOptionPane.showMessageDialog(of,
							"상세정보 조회시 문제가 발생하였습니다. 잠시 후 다시 시도해주세요.");
				}//end catch
			}//end switch
		}//end if
	}//mouseClicked

}//class





