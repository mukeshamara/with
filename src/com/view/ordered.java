package com.view;
import java.sql.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.addtocartDAO;
import com.model.User;

/**
 * Servlet implementation class ordered
 */
@WebServlet("/ordered.do")
public class ordered extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger orde = Logger.getLogger(ordered.class.getName());

    @Override

    public void init() throws ServletException

{

          orde.setLevel(Level.FINE);

          orde.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.orde");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               orde.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ordered() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpSession ses = hrequest.getSession();
        User obj = (User) ses.getAttribute("xyz");
        addtocartDAO dao=new addtocartDAO();
        try
        {
        	int z=dao.ordereddetails(Long.toString(obj.getUserid()));
        	if(z>0)
        	{
        		RequestDispatcher rd=request.getRequestDispatcher("ordered.jsp");
        		rd.forward(request, response);
        	}
        	else
        	{
        		orde.warning("You did not booked any books.Please book any books for order");
        		request.setAttribute("errmsg10", "<font color='blue'>You did not booked any books.Please book any books for order<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("userincart.jsp");
				rd.forward(request, response);
        	}
        }catch(Exception ex)
        {
        	System.out.println(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
