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
 * Servlet implementation class order
 */
@WebServlet("/ord.do")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger ord = Logger.getLogger(order.class.getName());

    @Override

    public void init() throws ServletException

{

          ord.setLevel(Level.FINE);

          ord.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.ord");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               ord.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
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
		String customer_id=request.getParameter("cus_id");
		String order_id=request.getParameter("ord_id");
		HttpSession hs=request.getSession();
		System.out.println(order_id);
		if(customer_id.isEmpty())
		{
			ord.warning("Please fill the below details as they are mandatory");
			request.setAttribute("errm", "<font color='red'>Please fill the below details as they are mandatory<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("ordereddetails.jsp");
			rd.forward(request, response);
		}
		else
		{
		if(order_id.equalsIgnoreCase("none") || order_id.isEmpty())
		{
			ord.warning("Please fill the below details as they are mandatory");
			request.setAttribute("errm", "<font color='red'>Please fill the below details as they are mandatory<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("ordereddetails.jsp");
			rd.forward(request, response);
		}
		else
		{
		hs.setAttribute("y1",order_id);
		RequestDispatcher rd=request.getRequestDispatcher("booksordered.jsp");
		rd.forward(request, response);
		}
		}
	}

}
