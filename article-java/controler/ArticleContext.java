package article.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.model.ArticleBean;
import article.model.ArticleDaoImpl_Jdbc;
import article.model.ClobToString;



@WebServlet("/article/DisplayPageProducts")
public class ArticleContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String context = null;
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 如果讀不到，直接點選主功能表的『購物』就不會送 pageNo給後端伺服器
		
		ArticleDaoImpl_Jdbc service = new ArticleDaoImpl_Jdbc(); 
		//
		// 讀取一頁的書籍資料之前，告訴service，現在要讀哪一頁
		
		
		request.setAttribute("baBean", service);
		// service.getPageBooks()方法開始讀取一頁的書籍資料
		ArticleBean coll = service.queryArticle(id);
		try {
			 context = ClobToString.ClobToString(coll.getContent());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("articlecontext", coll);
		request.setAttribute("context", context);
		RequestDispatcher rd = request.getRequestDispatcher("articlecontext.jsp");
		rd.forward(request, response);
		return;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
