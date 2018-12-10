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

import com.dao.addtocartDAO;

/**
 * Servlet implementation class cartpage
 */
@WebServlet("/cartpage.do")
public class cartpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger cartpa = Logger.getLogger(cartpage.class.getName());

    @Override

    public void init() throws ServletException

{

    	cartpa.setLevel(Level.FINE);

    	cartpa.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.cartpa");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               cartpa.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartpage() {
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
		String id=request.getParameter("username");
		addtocartDAO dao=new addtocartDAO();
		HttpSession hs=request.getSession();
		int y=0;
		System.out.println("came");
		try
		{
		y=dao.checkuserincart(id);
			if(y>0)
			{
				System.out.println(y);
				hs.setAttribute("xy",id);
				RequestDispatcher rd=request.getRequestDispatcher("cartusingavax.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("going");
				cartpa.warning("You did not add any books in the cart.Please add any book");
				request.setAttribute("errmsg8","<font color='white'>You did not add any books in the cart.Please add any book<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("lo.jsp");
				rd.forward(request, response);
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
