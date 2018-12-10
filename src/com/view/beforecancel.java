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

import com.dao.CancelDAO;
import com.model.User;

/**
 * Servlet implementation class beforecancel
 */
@WebServlet("/beforecancel.do")
public class beforecancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger before = Logger.getLogger(beforecancel.class.getName());

     @Override

     public void init() throws ServletException

{

           before.setLevel(Level.FINE);

           before.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.before");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                before.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beforecancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		User x=(User)hs.getAttribute("xyz");
		CancelDAO dao=new CancelDAO();
		try
		{
		int y=dao.checktheorder(Long.toString(x.getUserid()));
		if(y>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("cancel.jsp");
			rd.forward(request, response);
		}
		else
		{
			before.warning("You did not order any book. Please order the book.");
			request.setAttribute("msg","<font color='white'>You did not order any book. Please order the book.<br/>");
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
