package com.view;
import com.model.*;
import com.dao.*;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search.do")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		String searchedp=request.getParameter("item");
		
		List<product> list=new ArrayList<>();
		try
		{
			searchDAO dao=new searchDAO();
			list=dao.search(searchedp);
			HttpSession hs=request.getSession();
			hs.setMaxInactiveInterval(1);
			if(list.isEmpty() || list==null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("lo.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("list", list);
				RequestDispatcher rs=request.getRequestDispatcher("search.jsp");
			rs.forward(request, response);
				
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}

}
