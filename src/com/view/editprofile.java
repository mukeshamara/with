package com.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.dao.*;
import com.model.User;
import com.model.newuserdetails;

/**
 * Servlet implementation class editprofile
 */
@WebServlet("/editprofile.do")
public class editprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger edit = Logger.getLogger(editprofile.class.getName());

     @Override

     public void init() throws ServletException

{

           edit.setLevel(Level.FINE);

           edit.addHandler(new ConsoleHandler());

           try {

                File dir = new File("D:\\Logs");

                if(!dir.exists())

                {

                     dir.mkdir();

                }

               

                File file = new File(dir,"logger.edit");

                Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);

                edit.addHandler(fileHandler);

        } catch (SecurityException | IOException e1) {

            System.out.println("Exception on creating log file");

           e1.printStackTrace();
        }
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editprofile() {
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		newuserdetails ud=null;
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		User xy=(User)hs.getAttribute("xyz");
		String edited_id=Long.toString(xy.getUserid());
		String newusername=request.getParameter("name");
		String newuserdob=request.getParameter("dob");
		String newuseremail=request.getParameter("email");
		String newusernumber=request.getParameter("number");
		try
		{
		Date date=sdf.parse(newuserdob);
		
		
		EditprofileDAO dao=new EditprofileDAO();
		int x=dao.editprofile(edited_id,newusername,newuserdob,newuseremail,newusernumber);
		if(x>0)
		{
			edit.warning("Succesfully you have edited your profile.");
			request.setAttribute("errmsg6", "<font color='white'>Succesfully you have edited your profile.<br/>");
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
	}catch(Exception ex)
	{
		System.out.println(ex);
	}
	}
}