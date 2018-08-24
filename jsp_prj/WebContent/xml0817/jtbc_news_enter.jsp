<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<!-- CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
   table{ border: 1px solid #333; margin-top: 10px; margin-left: 10px;}
</style>
</head>
<body>
<% 
	String[] rssList={"newsflash","politics","economy","society","international","culture","entertainment","sports","fullvideo","newsrank","newsroom","morningand","newssite","politicaldesk"};
	String[] rssTitle={"속보","정치","경제","사회","국제","문화","연예","스포츠","풀영상","뉴스랭킹","뉴스룸","아침&","뉴스현장","정치부회의"};
	for(int i=0;i<rssTitle.length;i++){
	
%>
	<a href="jtbc_news_enter.jsp?param=<%= rssList[i] %>"><%=rssTitle[i] %></a> | 
	
<%
	}
   //JTBC의 뉴스속보 얻기 : 뉴스
   //선언부 -> rss -> chanel -> 
   //title | link | description | language | copyright | category | pubDate | item | ,,,,,
   
   //1. parser 생성
   SAXBuilder builder=new SAXBuilder();
   
   String type=request.getParameter("param");
   if(type==null){
	   type="newsflash";
   }
   
   //2. XML문서를 객체로 저장
   Document doc=builder.build("http://fs.jtbc.joins.com/RSS/"+type+".xml");
   
   //3. 최상위 부모노드 얻기(근 노드, rootNode)얻기
   Element rssNode=doc.getRootElement();//<rss>
   
   //4. 자식 노드 얻기
   Element channelNode=rssNode.getChild("channel");//<chanel>
   
   //channel노드의 자식 노드들 얻기
   Iterator<Element> channelSubNodes=channelNode.getChildren().iterator();
   
   Element channelSubNode=null;
   Iterator<Element> itemNodes=null;
   Element itemSubNode=null;
   
   while(channelSubNodes.hasNext()){
      channelSubNode=channelSubNodes.next();
      //parsing한 노드를 찾기
      if("item".equals(channelSubNode.getName())){//아이템 노드
         itemNodes=channelSubNode.getChildren().iterator();//아이템 노드들
         %>
         <table>
         <%   
         String label="",value="";
         while(itemNodes.hasNext()){
            itemSubNode=itemNodes.next();
            if( "title".equals(itemSubNode.getName()) ){
               label="기사제목";
            }//end if
            if( "link".equals(itemSubNode.getName()) ){
               label="링크";
            }//end if
            if( "description".equals(itemSubNode.getName()) ){
               label="설명";
            }//end if
            if( "pubDate".equals(itemSubNode.getName()) ){
               label="작성일";
            }//end if
            value=itemSubNode.getValue();
            %>
            <tr>
               <td style="width: 100px; text-align: center;"><%= label %></td>
               <td style="width: 800px;">
               <% if("링크".equals(label)){ %>
               <a href="<%= value %>" target="_new">기사보기</a>
               <% }else{ %>
               <%= value %>
               <% }//end else%>
               </td>
            </tr>
            <%
         }//end while
         %>
         </table>   
         <%
      }//end if
   }//end while
   
      
   
%>
</body>
</html>