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

import com.dao.UserDAO;
import com.model.User;
import com.dao.*;
/**
 * Servlet implementation class totalprice
 */
@WebServlet("/totalprice.do")
public class totalprice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger total = Logger.getLogger(totalprice.class.getName());

     @Override

     public void init() throws ServletException

{

           total.setLevel(Level.FINE);

           total.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.total");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                total.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public totalprice() {
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
		String userid=request.getParameter("user_id");
		String name=request.getParameter("user_name");
		HttpSession hs=request.getSession();
		hs.setAttribute("id", userid);
		
UserDAO dao=new UserDAO();
		
		try
		{
		User u=dao.search(userid);
		PaymentDAO dao1=new PaymentDAO();
		
		if(u!=null)
		{
			if(userid.equals(Long.toString(u.getUserid())) && u.getName().equalsIgnoreCase(name))
			{
			request.setAttribute("id", userid);
			double price=dao1.totalprice(userid);
			if(price>0)
			{
			hs.setAttribute("toprice",price);
		RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
		rd.forward(request, response);
			}
			else
			{
				total.warning("You did not booked any books.Please book any books for order");
				request.setAttribute("errmsg10", "<font color='white'>You did not booked any books.Please book any books for order<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("userincart.jsp");
				rd.forward(request, response);
			}
			}
			else
			{
				total.warning("Please enter the registered user name");
				request.setAttribute("errmsg10", "<font color='white'>Please enter the registered user name<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("order.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			total.warning("You entered wrong credentials.Please entered the registered User ID.User ID is displayed on the top.");
			request.setAttribute("errmsg10", "<font color='white'>You entered wrong credentials.Please entered the registered User ID.User ID is displayed on the top.<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("order.jsp");
			rd.forward(request, response);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
