package com.view;
import java.util.*;

import com.dao.addtocartDAO;
import com.model.*;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class addtocart
 */
@WebServlet("/cart.do")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger car = Logger.getLogger(addtocart.class.getName());

    @Override

    public void init() throws ServletException

{

          car.setLevel(Level.FINE);

          car.addHandler(new ConsoleHandler());

          try {

               File dir = new File("D:\\Logs");

               if(!dir.exists())

               {

                    dir.mkdir();

               }

              

               File file = new File(dir,"logger.car");

               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

               car.addHandler(fileHandler);

       } catch (SecurityException | IOException e1) {

           System.out.println("Exception on creating log file");

          e1.printStackTrace();
       }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
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
		User u=(User)hs.getAttribute("xyz");
		String books[]=request.getParameterValues("book_id");
		if(books==null)
		{
			car.warning("You did not select any book. Please select the book needed to add into cart");
			request.setAttribute("errmsg22","You did not select any book. Please select the book needed to add into cart");
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}
		else
		{
		addtocartDAO dao=new addtocartDAO();
		Addintocart addto=null;
		Long id=u.getUserid();
		int val=0;
		List<Addintocart> into=new ArrayList<>();
		for(int i=0;i<books.length;i++)
		{
			try {
				if(dao.checkincart(books[i],id))
				{
					
					request.setAttribute("already", books[i]);
					RequestDispatcher rd=request.getRequestDispatcher("info.jsp");
					rd.forward(request, response);
					break;
				}
				else
				{
				val=dao.addintocart(id,books[i]);
				into=dao.search();
				}
			
			} catch (Exception ex)
			{
				System.out.println(ex+" is here");
			}
			try
			{
				if(into!=null || !into.isEmpty())
				{
					request.setAttribute("intocart", into);
				RequestDispatcher rd=request.getRequestDispatcher("userincart.jsp");
				rd.forward(request, response);
				}
			}catch(Exception ex)
			{
				System.out.println(ex+" here");
			}
		}
		}
	}
}