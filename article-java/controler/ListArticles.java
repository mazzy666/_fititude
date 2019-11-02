package article.controler;

import java.io.IOException;
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



@WebServlet("/article/DisplayListArticle")
public class ListArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int page= 1 ;
		
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr == null) {
			page = 1;
			
		} else {
			try {
				page = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				page = 1;
			}
		}
		// 如果讀不到，直接點選主功能表的『購物』就不會送 pageNo給後端伺服器
		
		ArticleDaoImpl_Jdbc article = new ArticleDaoImpl_Jdbc(); 
		//
		// 讀取一頁的書籍資料之前，告訴article，現在要讀哪一頁
		article.setPageNo(page);
		
		request.setAttribute("baBean", article);
		// article.getPageBooks()方法開始讀取一頁的書籍資料
		Collection<ArticleBean> coll = article.getPageArticle();
		request.setAttribute("pageNo", String.valueOf(page));
		request.setAttribute("totalPages", article.getTotalPages());
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		request.setAttribute("articleList", coll);

		System.out.println("看有沒有");
		RequestDispatcher rd = request.getRequestDispatcher("article.jsp");
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
