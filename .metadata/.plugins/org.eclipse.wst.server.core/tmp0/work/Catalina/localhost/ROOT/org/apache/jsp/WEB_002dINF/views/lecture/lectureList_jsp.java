/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-15 01:16:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.lecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jscompany.springproject.model.domain.lecture.Lecture;
import com.jscompany.springproject.common.Pager;
import com.jscompany.springproject.model.domain.member.Member;
import java.util.List;

public final class lectureList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/lecture/./inc/sidebar_list.jsp", Long.valueOf(1610640626666L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.jscompany.springproject.common.Pager");
    _jspx_imports_classes.add("com.jscompany.springproject.model.domain.lecture.Lecture");
    _jspx_imports_classes.add("com.jscompany.springproject.model.domain.member.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Pager pager = (Pager)request.getAttribute("pager");
	List<Lecture> lectureList = pager.getList();
	Member memberSession = (Member)session.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/admin/style.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/js/lecture/main.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction back(){\r\n");
      out.write("\t\talert('접근할 수 없습니다');\r\n");
      out.write("\t\thistory.back();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
if(session.getAttribute("member")==null) {
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tback();\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");
} else if(memberSession.getTeacher_state_id() !=1){
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tback();\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("  <a id =\"1\" href=\"/lecture/list\" class=\"active\"><i class=\"fa fa-fw fa-clipboard\"></i> 내 강의</a>\r\n");
      out.write("  <a id =\"2\" href=\"/lecture/registForm\"><i class=\"fa fa-fw fa-book\"></i> 강의등록</a>\r\n");
      out.write("  <a id =\"3\" href=\"#\"><i class=\"fa fa-fw fa-cube\"></i> 커리큘럼</a>\r\n");
      out.write("  <a id =\"4\" href=\"#\"><i class=\"fa fa-fw fa-image\"></i> 이미지등록</a>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>강의명</th>\r\n");
      out.write("\t\t\t<th>가격</th>\r\n");
      out.write("\t\t\t<th>등록일자</th>\r\n");
      out.write("\t\t\t<th>승인여부</th>\r\n");
      out.write("\t\t\t<th></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

			int curPos = pager.getCurPos();
			int num = pager.getNum();
		
      out.write("\r\n");
      out.write("\t\t");
for(int i = 1; i<pager.getPageSize() + 1; i++){ 
      out.write("\r\n");
      out.write("\t\t");
if(num<1)break; 
      out.write("\r\n");
      out.write("\t\t");
Lecture lecture = lectureList.get(curPos++);
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t");
num--; 
      out.write("\r\n");
      out.write("\t\t\t<td>");
      out.print(lecture.getLecture_name() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
if(lecture.getPrice() == 0){ 
      out.write('무');
      out.write('료');
} else {
      out.print(lecture.getPrice());
} 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(lecture.getRegistDate() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
if(lecture.getLecture_use_state() == 1){
      out.write(" 승인완료 ");
} else if(lecture.getLecture_use_state() == 2) {
      out.write(" 승인반려 ");
} else {
      out.write(" 승인대기 ");
} 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input name=\"addSection\" class=\"");
      out.print(lecture.getLecture_id() );
      out.write("\" type=\"button\" value=\"섹션추가\" style=\"margin-left:2px;\"/>\r\n");
      out.write("\t\t\t\t<input name = \"updateLecture\" class=\"");
      out.print(lecture.getLecture_id() );
      out.write("\" type=\"button\" value=\"수정\" style=\"margin-left:8px;\"/>\r\n");
      out.write("\t\t\t\t<input name = \"delLacture\" class=\"");
      out.print(lecture.getLecture_id() );
      out.write("\" type=\"button\" value=\"삭제\" style=\"margin-left:8px;\"/>\r\n");
      out.write("\t\t\t\t<input id=\"currentPage\" type=\"hidden\" value=\"");
      out.print(pager.getCurrentPage());
      out.write("\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"5\" style=\"text-align: center\"><a id=\"blockPage\"\r\n");
      out.write("\t\t\t\thref=\"/lecture/list?currentPage=");
      out.print(1);
      out.write("\">◀◀</a> ");
if(pager.getCurrentPage() > 1){
      out.write("\r\n");
      out.write("\t\t\t\t<a id=\"blockPage\"\r\n");
      out.write("\t\t\t\thref=\"/lecture/list?currentPage=");
      out.print(pager.getFirstPage() - pager.getBlockSize());
      out.write("\">◀</a>\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write(" <a id=\"blockPage\">◀</a> ");
} 
      out.write(' ');
for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
if(pager.getTotalPage() < i)break; 
      out.write(" <a id=\"blockPage\"\r\n");
      out.write("\t\t\t\t");
if(pager.getCurrentPage() == i){ 
      out.write(" class=\"curPage\" ");
} 
      out.write("\r\n");
      out.write("\t\t\t\thref=\"/lecture/list?currentPage=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a> ");
} 
      out.write(' ');
if(pager.getCurrentPage() == pager.getTotalPage()) {
      out.write("\r\n");
      out.write("\t\t\t\t<a id=\"blockPage\">▶</a> ");
} else { 
      out.write(" <a id=\"blockPage\"\r\n");
      out.write("\t\t\t\thref=\"/lecture/list?currentPage=");
      out.print(pager.getLastPage() + 1);
      out.write("\">▶</a>\r\n");
      out.write("\t\t\t\t");
} 
      out.write(" <a id=\"blockPage\"\r\n");
      out.write("\t\t\t\thref=\"/lecture/list?currentPage=");
      out.print(pager.getTotalPage());
      out.write("\">▶▶</a></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
