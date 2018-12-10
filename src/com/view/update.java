package com.view;
import com.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/updatedetails")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		int bono = Integer.parseInt(request.getParameter("fid"));

         int cnt = Integer.parseInt(request.getParameter("cnt"));
         double pr=Double.parseDouble(request.getParameter("pri"));
        
try
{
         response.setContentType("text/plain");

         response.setCharacterEncoding("utf-8");

         PrintWriter out = response.getWriter();

         int res = UpdateprDAO.update(pr,cnt,bono);
         int res1 = UpdateprDAO.reserve(bono,cnt);
         if(res1>0)

         {

                         out.println("Booked");

         }

         else

         {

                         out.println("Not Booked");

         }

}catch(Exception ex)
{
	System.out.println(ex);
}
	}
	}


