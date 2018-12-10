package com.view;
import com.dao.*;
import com.model.cancelmenu;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class cancel
 */
@WebServlet("/cancel.do")
public class cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger cancel = Logger.getLogger(cancel.class.getName());

     @Override

     public void init() throws ServletException

{

    	 cancel.setLevel(Level.FINE);

    	 cancel.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.cancel");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                cancel.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancel() {
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
		HttpSession hs=request.getSession();
		String id=(String)hs.getAttribute("cus_id");
		String or_id=(String)hs.getAttribute("ord_id");
		try
		{
		CancelDAO dao=new CancelDAO();

		int re=dao.search(or_id, id);
		if(re>0)
		{
		List<cancelmenu> can=dao.search(or_id);
		
		for(cancelmenu c:can)
		{
			int x11=dao.update(c.getQuantity(), c.getBook_id());
		}
		int r12=dao.checktime(or_id);
		if(r12==0)
		{
			cancel.warning("You cannot cancel the order after 2 days of booking");
			request.setAttribute("errmsg5", "<font color='white'>You cannot cancel the order after 2 days of booking<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("notcancel.jsp");
			rd.forward(request, response);
		}
		else
		{
		int s1=dao.deletefromcart(or_id);
		
		int rs=dao.cancellation(or_id);
		if(rs>0)
		{
				cancel.warning("You're successfully cancelled the booked order");
				cancel.warning("Your amount will will be return to your account within 4 working days.");
				request.setAttribute("errmsg4", "<font color='white'>You're successfully cancelled the booked order<br/>");
				request.setAttribute("errmsg5", "<font color='white'>Your amount will will be return to your account within 4 working days.<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("aftercancellation.jsp");
				rd.forward(request, response);
			
		}
		else
		{
			cancel.warning("You have entered the wrong credentials. Enter again");
			request.setAttribute("errmsg7", "<font color='white'>You have entered the wrong credentials. Enter again<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("cancel.jsp");
			rd.forward(request, response);
		}
		}
		}
	}catch(Exception ex)
	{
		System.out.println(ex);
	}
	}

}
