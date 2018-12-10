package com.view;
import com.password.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dao.*;
import com.model.*;

/**
 * Servlet implementation class newuser
 */
@WebServlet("/newus.do")
public class newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger newuser = Logger.getLogger(newuser.class.getName());
	 @Override

     public void init() throws ServletException

{

           newuser.setLevel(Level.FINE);

           newuser.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.newuser");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                newuser.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }
    public newuser() {
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
		newuserdetails ud=null;
		int x=0;
		String y="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try
		{
		
		String newusername=request.getParameter("name");
		String newuserdob=request.getParameter("dob");
		String newuserpass=request.getParameter("pass");
		String newuseremail=request.getParameter("email");
		String newusernumber=request.getParameter("number");
		Date date=sdf.parse(newuserdob);
		Encryption en=new Encryption();
		String enpass=en.encryp(newuserpass);
		//String fin=newusername+","+newuserdob+","+newuserpass+","+newuseremail+","+newusernumber;
		ud=new newuserdetails(newusername,enpass,date,newusernumber,newuseremail);
			HttpSession hs=request.getSession();
			newuserDAO dao=new newuserDAO();
			int z=dao.check(newusername,newuseremail);
			if(z==0)
			{
				newuser.warning("The registered details are alresdy exists. Please try with other details to register");
				request.setAttribute("errmsg", "<font color='white'>The registered details are alresdy exists. Please try with other details to register<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("new.jsp");
				rd.forward(request, response);
			}
			else
			{
			y=Integer.toString(dao.number());
			System.out.println(y);
			x=dao.insert(ud,y);
			
			if(x>0)
			{
				newuser.warning("Successfully registered.");
				hs.setAttribute("customerid", y);
				request.setAttribute("errmsg", "<font color='white'>Successfully registered.<br/>");
				RequestDispatcher rd=request.getRequestDispatcher("succesful.jsp");
				rd.forward(request, response);
			}
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}

}
