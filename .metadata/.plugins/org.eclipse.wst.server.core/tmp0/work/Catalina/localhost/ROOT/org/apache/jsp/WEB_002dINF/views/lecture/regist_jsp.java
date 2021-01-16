/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-15 03:38:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.lecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.domain.lecture.Difficulty;
import com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory;
import java.util.List;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/lecture/./inc/sidebar_regist.jsp", Long.valueOf(1610640626667L));
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
    _jspx_imports_classes.add("com.jscompany.springproject.model.domain.lecture.Difficulty");
    _jspx_imports_classes.add("com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory");
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

	List<Lecture_TopCategory> topList = (List)request.getAttribute("topList");
	List<Difficulty> diffList = (List)request.getAttribute("diffList");
	Member member = (Member)session.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/lecture/regist.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//cdn.ckeditor.com/4.15.1/standard/ckeditor.js\"></script>\r\n");
      out.write("<script src=\"/resources/js/admin/main.js\"></script>\r\n");
      out.write("<script src=\"/resources/js/lecture/crud.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("  <a id =\"1\" href=\"/lecture/list\"><i class=\"fa fa-fw fa-clipboard\"></i> 내 강의</a>\r\n");
      out.write("  <a id =\"2\" href=\"/lecture/registForm\" class=\"active\"><i class=\"fa fa-fw fa-book\"></i> 강의등록</a>\r\n");
      out.write("  <a id =\"3\" href=\"#\"><i class=\"fa fa-fw fa-cube\"></i> 커리큘럼</a>\r\n");
      out.write("  <a id =\"4\" href=\"#\"><i class=\"fa fa-fw fa-image\"></i> 이미지등록</a>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<form id = \"LectureRegistForm\">\r\n");
      out.write("  \t\t<div class=\"container\">\r\n");
      out.write("\t  \t\t<h1>강의 등록</h1>\r\n");
      out.write("\t    \t<hr>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name = \"member_id\" value=\"");
      out.print(member.getMember_id());
      out.write("\"/>\r\n");
      out.write("\t\t\t<!-- 강의 제목 작성란 -->\r\n");
      out.write("\t\t    <label for=\"lecTitle\"><b>강의제목</b></label>\r\n");
      out.write("\t\t    <input type=\"text\" placeholder=\"ex ) 자바 프로그래밍 기초\" name=\"lecture_name\" id=\"lecture_name\" />\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 상위 카테고리 선택 라디오 박스 -->\r\n");
      out.write("\t\t\t<div id =\"category_top\">\r\n");
      out.write("\t\t\t\t<label for=\"topRadio\"><b>상위 카테고리</b></label><br><br>\r\n");
      out.write("\t\t\t\t");
for(int i = 0; i < topList.size(); i++) {
      out.write("\r\n");
      out.write("\t\t\t\t");
Lecture_TopCategory lecture_TopCategory = topList.get(i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t<label class=\"topCategory\">");
      out.print(lecture_TopCategory.getLecture_topcategory_name() );
      out.write("\r\n");
      out.write("\t\t\t\t  \t\t<input type=\"radio\" id = ");
      out.print(lecture_TopCategory.getLecture_topcategory_id() );
      out.write(" class = \"topRadio\" name = \"topRadio\" value=\"");
      out.print(lecture_TopCategory.getLecture_topcategory_name() );
      out.write("\">\r\n");
      out.write("\t\t\t\t  \t\t<span class=\"checkmark\"></span>\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 하위 카테고리 선택 라디오 박스 -->\r\n");
      out.write("\t\t\t<div id=\"category_sub\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"diff_radio\">\r\n");
      out.write("\t\t\t\t<label for=\"difficulty_id\"><b>난이도</b></label><br><br>\r\n");
      out.write("\t\t\t\t");
for(int i = 0; i < diffList.size(); i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
Difficulty difficulty = diffList.get(i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t<label class=\"topCategory\">");
      out.print(difficulty.getDifficulty_name());
      out.write("\r\n");
      out.write("\t\t\t\t  \t\t<input type=\"radio\" id = ");
      out.print(difficulty.getDifficulty_id() );
      out.write(" class = \"diffRadio\" name=\"difficulty_id\" value=\"");
      out.print(difficulty.getDifficulty_id());
      out.write("\">\r\n");
      out.write("\t\t\t\t  \t\t<span class=\"checkmark\"></span>\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 강의 요약 작성란 -->\r\n");
      out.write("\t\t\t<label for=\"lecture_summary_content\"><b>강의 요약</b></label>\r\n");
      out.write("\t\t   \t<textarea id=\"lecture_summary_content\" name=\"lecture_summary_content\" placeholder=\"간단하게 강의 요약을 입력 해주세요~\" style=\"height:60px\"></textarea>\r\n");
      out.write("\t\t\t<!-- 강의 상세 내용 작성란-->\r\n");
      out.write("\t\t    <label for=\"lecture_detail_content\"><b>강의 상세 내용</b></label>\r\n");
      out.write("\t\t    <textarea id=\"lecture_detail_content\" name=\"lecture_detail_content\" placeholder=\"강의 상세내용을 입력 해주세요~\" ></textarea>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <hr>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <label for=\"price\"><b>가격</b></label>\r\n");
      out.write("\t\t    <input type=\"text\" name=\"price\" id=\"price\" value=\"0\"/>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<label><b>강의 대표 이미지(강의를 대표하는 이미지를 넣어주세요! 주의> jpg 또는 png 파일만 넣어주세요)</b></label><br><br>\r\n");
      out.write("\t\t\t<img id=\"blah\" src=\"/resources/images/javascript.png\"alt=\"your image\" style=\"width:230px; height:150px;\"/>\r\n");
      out.write("\t\t\t<input type='file' id=\"imgInp\" name=\"imgFile\" /><br /> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t    <hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t    <button id=\"lectureRegistBtn\" type=\"button\" class=\"registerbtn\">등록</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
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
