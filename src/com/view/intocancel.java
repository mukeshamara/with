package com.view;
import com.model.*;

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

import com.dao.CancelDAO;

/**
 * Servlet implementation class intocancel
 */
@WebServlet("/intocancel.do")
public class intocancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger intocan = Logger.getLogger(intocancel.class.getName());

     @Override

     public void init() throws ServletException

{

    	 intocan.setLevel(Level.FINE);

    	 intocan.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.intocan");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                intocan.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public intocancel() {
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
		User u_id=(User)hs.getAttribute("xyz");
		String id=Long.toString(u_id.getUserid());
		String or_id=request.getParameter("order_id");
		
		/*if(id.isEmpty()||or_id.isEmpty()||or_id.equalsIgnoreCase("none")||id==null||or_id==null)
		{
			request.setAttribute("errmsg5", "<font color='red'>Please fill the below details of customer_id and order_id<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("cancel.jsp");
			rd.forward(request, response);
		}*/
		
		hs.setAttribute("cus_id",id);
		hs.setAttribute("ord_id",or_id);
		CancelDAO dao=new CancelDAO();
		try
		{
			int rs=dao.search(or_id, id);
			if(rs>0)
			{
				List<cancelmenu> x=dao.search(or_id);
				if(x==null || x.isEmpty()||or_id.equalsIgnoreCase("none"))
				{
					intocan.warning("Please select the Order ID to be cancelled");
					request.setAttribute("errmsg5", "<font color='red'>Please select the Order ID to be cancelled<br/>");
					RequestDispatcher rd=request.getRequestDispatcher("cancel.jsp");
					rd.forward(request, response);
					
				}
				else
				{
					request.setAttribute("search",x);
					RequestDispatcher rd=request.getRequestDispatcher("cancelinto.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				intocan.warning("No order has been placed.");
				request.setAttribute("errmsg5", "<font color='red'>No order has been placed.<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("cancel.jsp");
				rd.forward(request, response);
			}
		
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
}


