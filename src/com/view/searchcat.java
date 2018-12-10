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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class searchcat
 */
@WebServlet("/searchcat.do")
public class searchcat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger cat = Logger.getLogger(searchcat.class.getName());

    @Override

    public void init() throws ServletException

{

          cat.setLevel(Level.FINE);

          cat.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.cat");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               cat.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchcat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cat_item=request.getParameter("item");
		HttpSession hs=request.getSession();
		if(cat_item.equalsIgnoreCase("none"))
		{
			cat.warning("Please select the category and search");
			request.setAttribute("errms", "<font color='white'>Please select the category and search<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("lo.jsp");
			rd.forward(request, response);
		}
		else
		{
			hs.setAttribute("item",cat_item);
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}
	}
}
