/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-15 10:03:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- Created By CodingNepal -->\r\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<!-- Somehow I got an error, so I comment the title, just uncomment to show -->\r\n");
      out.write("<!-- <title>Transparent Login Form UI</title> -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/loginForm.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<!-- javascript lib load -->\r\n");
      out.write("\t<script src=\"/resources/js/rsa/rsa.js\"></script>\r\n");
      out.write("\t<script src=\"/resources/js/rsa/jsbn.js\"></script>\r\n");
      out.write("\t<script src=\"/resources/js/rsa/prng4.js\"></script>\r\n");
      out.write("\t<script src=\"/resources/js/rsa/rng.js\"></script>\r\n");
      out.write("\t<script src=\"/resources/js/login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"bg-img\">\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<header>로그인</header>\r\n");
      out.write("\t\t\t<form id=\"loginForm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"RSAModulus\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${modulus}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><!-- 서버에서 전달한값을 셋팅한다. -->\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"RSAExponent\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${exponent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><!-- 서버에서 전달한값을 셋팅한다. -->\r\n");
      out.write("\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t<span class=\"fa fa-user\"></span> <input type=\"text\" id=\"e_mail\" name = \"e_mail\" required\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"이메일 입력\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"field space\">\r\n");
      out.write("\t\t\t\t\t<span class=\"fa fa-lock\"></span> <input type=\"password\" onkeyup=\"enterkey()\" id =\"password\"\r\n");
      out.write("\t\t\t\t\t\t name = \"password\" class=\"pass-key\" required placeholder=\"비밀번호 입력\"> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"show\">SHOW</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<p id=\"idPassChk\" style=\"color: #FF6600; margin: 0;\"></p>\r\n");
      out.write("\t\t\t\t<div class=\"pass\" style=\"float:left;\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"/idSearchForm\" >이메일 찾기 /&nbsp;</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"pass\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/passSearchForm\"> 비밀번호 찾기</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t\t\t<input class=\"login\" type=\"button\" value=\"로그인\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<div class=\"loginWith\">Or login with</div>\r\n");
      out.write("\t\t\t<div class=\"links\">\r\n");
      out.write("\t\t\t\t<div class=\"facebook\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fab fa-facebook-f\"><span>Facebook</span></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"instagram\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fab fa-instagram\"><span>Instagram</span></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"signup\">\r\n");
      out.write("\t\t\t\t아직 가입을 안하셨나요? <a href=\"/\">회원가입</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 실제 서버로 전송되는 form -->\r\n");
      out.write("\t<form id=\"hiddenForm\">\r\n");
      out.write("\t        <input type=\"hidden\" name=\"e_mail\" />\r\n");
      out.write("\t        <input type=\"hidden\" name=\"password\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("      const pass_field = document.querySelector('.pass-key');\r\n");
      out.write("      const showBtn = document.querySelector('.show');\r\n");
      out.write("      showBtn.addEventListener('click', function(){\r\n");
      out.write("       if(pass_field.type === \"password\"){\r\n");
      out.write("         pass_field.type = \"text\";\r\n");
      out.write("         showBtn.textContent = \"HIDE\";\r\n");
      out.write("         showBtn.style.color = \"#3498db\";\r\n");
      out.write("       }else{\r\n");
      out.write("         pass_field.type = \"password\";\r\n");
      out.write("         showBtn.textContent = \"SHOW\";\r\n");
      out.write("         showBtn.style.color = \"#222\";\r\n");
      out.write("       }\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
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
