package com.view;
import com.dao.*;

import java.io.*;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment.do")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger paym = Logger.getLogger(payment.class.getName());

     @Override

     public void init() throws ServletException

{

           paym.setLevel(Level.FINE);

           paym.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.paym");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                paym.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
	
		String id=(String) hs.getAttribute("id");
		System.out.println(id);
		double pr=(double)hs.getAttribute("toprice");
		System.out.println(pr);
		String accno=request.getParameter("acc_no");
		String bankname=request.getParameter("bank_name");
		String ifsccode=request.getParameter("ifsc_code");
		double totalamount=Double.parseDouble(request.getParameter("amount"));
		try{
 		PayDAO dao=new PayDAO();
		String or_id=dao.orderid();
		hs.setAttribute("or_id",or_id);
		int r=dao.checkincart(id,or_id,pr,accno,bankname,ifsccode,totalamount);
		if(r>0)
		{
			List<Integer> xs=dao.incart(id);
			if(xs!=null)
			{
				
			for(int y:xs)
			{
				
			int x1=dao.updateincart(or_id,y);
			}
			paym.warning("You're Payment done successfully.");
			paym.warning("You have ordered the books successfully.");
			request.setAttribute("errmsg2", "<font color='red'>You're Payment done successfully.<br/>");
			request.setAttribute("errmsg3", "<font color='red'>You have ordered the books successfully.<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("Afterpayment.jsp");
			rd.forward(request, response);
			}
		}
		else
		{
			paym.warning("Please fill it again");
			paym.warning("You have entered the wrong details.");
			request.setAttribute("errmsg2", "<font color='red'>Please fill it again><br/>");
			request.setAttribute("errmsg3", "<font color='red'>You have entered the wrong details.<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
			rd.forward(request, response);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}