package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ssx.Class.Product;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Product_DAO_Impl;

/**
 * Servlet implementation class Product_FindallServlet
 */
@WebServlet("/Product_FindallServlet")
public class Product_FindallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_FindallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//out.println("1111");
		Product_interface dao = new Product_DAO_Impl();
		HttpSession session = request.getSession();
		//out.println("1111");
		try {
			List <Product> list  = dao.Product_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Productlist", list);
			/*
			 * for(Product p:list) { System.out.println(p.getProduct_storedate()); }
			 */
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Jinhuoshangpinxinxi.jsp" );
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");
		//out.println("33333");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
