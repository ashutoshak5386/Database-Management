package com.newweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newweb.daoimpl.UserDaoImpl;
import com.newweb.vo.ResultVO;
import com.newweb.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDaoImpl daoimpl = new UserDaoImpl();
       ResultVO rvo = new ResultVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);
		try {
			
			String email = request.getParameter("email");
			String password = request.getParameter("pwd");
			
			UserVO uvo = new UserVO();
			uvo.setEmail(email);
			uvo.setPassword(password);
			
			rvo = daoimpl.dataInsertResultVO(uvo);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/");
			rd.include(request,response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
