package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Net FM</title>\n");
      out.write("<style>\n");
      out.write("body {\n");
      out.write("    background: url('kwallpaper.png') no-repeat fixed center center;\n");
      out.write("    background-size: cover;\n");
      out.write("    font-family: Montserrat;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block {\n");
      out.write("    width: 320px;\n");
      out.write("    padding: 20px;\n");
      out.write("    background: #fff;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    border-top: 5px solid #0066ff;\n");
      out.write("    margin: 0 auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block h1 {\n");
      out.write("    text-align: center;\n");
      out.write("    color: #000;\n");
      out.write("    font-size: 18px;\n");
      out.write("    text-transform: uppercase;\n");
      out.write("    margin-top: 0;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input {\n");
      out.write("    width: 100%;\n");
      out.write("    height: 42px;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    border: 1px solid #ccc;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    font-size: 14px;\n");
      out.write("    font-family: Montserrat;\n");
      out.write("    padding: 0 20px 0 50px;\n");
      out.write("    outline: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input#username {\n");
      out.write("    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;\n");
      out.write("    background-size: 16px 80px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input#username:focus {\n");
      out.write("    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;\n");
      out.write("    background-size: 16px 80px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input#password {\n");
      out.write("    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;\n");
      out.write("    background-size: 16px 80px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input#password:focus {\n");
      out.write("    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;\n");
      out.write("    background-size: 16px 80px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block input:active, .login-block input:focus {\n");
      out.write("    border: 1px solid #ff656c;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block button {\n");
      out.write("    width: 100%;\n");
      out.write("    height: 40px;\n");
      out.write("    background: #0066cc;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    border: 1px solid #0066ff;\n");
      out.write("    color: #fff;\n");
      out.write("    font-weight: bold;\n");
      out.write("    text-transform: uppercase;\n");
      out.write("    font-size: 14px;\n");
      out.write("    font-family: Montserrat;\n");
      out.write("    outline: none;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-block button:hover {\n");
      out.write("    background: #0066cc;\n");
      out.write("}\n");
      out.write(".head {\n");
      out.write("\n");
      out.write("font-family: Montserrat;\n");
      out.write("padding: 50px;\n");
      out.write("text-align: center;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"head\">\n");
      out.write("\t<h1> Net FM Project </h1>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("<div class=\"login-block\">\n");
      out.write("\t\n");
      out.write("    <h1>Login</h1>\n");
      out.write("\t<form action=\"/Project02/webresources/entity.user/switchTOHome\" method=\"post\">\n");
      out.write("\t\t<input type=\"text\" value=\"\" placeholder=\"Username\" id=\"username\" name=\"username\" />\n");
      out.write("\t\t<input type=\"password\" value=\"\" placeholder=\"Password\" id=\"password\" name=\"password\" />\n");
      out.write("\t\t<button>Login</button>\n");
      out.write("\t<form>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
