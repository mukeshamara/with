package com.view;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout.do")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logou = Logger.getLogger(logout.class.getName());

    @Override

    public void init() throws ServletException

{

          logou.setLevel(Level.FINE);

          logou.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.logou");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               logou.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		logou.warning("Successfully logged out");
		request.setAttribute("errmsg", "<font color='red'>Successfully logged out<br/>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
