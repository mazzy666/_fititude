package article.model;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;







public class ArticleDaoImpl_Jdbc implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bookId = 0; 	// 查詢單筆商品會用到此代號
	private int pageNo = 0;		// 存放目前顯示之頁面的編號
	private int recordsPerPage = 8; // 預設值：每頁8筆
	private int totalPages = -1;
	DataSource ds = null;
	
	public ArticleDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDB");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	
	public List<ArticleBean> getPageArticle() {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		
		String sql0 =" SELECT  * FROM ( SELECT  *, "+ 
				"ROW_NUMBER() OVER " + 
				"(ORDER BY articleId DESC) AS RowNum   FROM article  ) AS NewTable "
				+ "WHERE RowNum >= ? AND RowNum <=  ?";
		
//		String sql1 = "SELECT b.BookId, b.author, b.bookNo, b.category, b.TITLE, "
//				+ "b.PRICE, b.discount, b.companyID, b.fileName, b.coverImage, "
//				+ "bc.name FROM Book b JOIN BookCompany bc ON  b.companyID = bc.id "
//						+ " LIMIT ?, ?";
		String sql = sql0;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(0 based)		
//		int startRecordNo = (pageNo - 1) * recordsPerPage;
//		int endRecordNo = recordsPerPage;
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, startRecordNo);
			ps.setInt(2, endRecordNo);
			try (
				ResultSet rs = ps.executeQuery();
			) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				// 迴圈內將逐筆取出ResultSet內的紀錄
				while (rs.next()) {
					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
					ArticleBean bean = new ArticleBean();    	
					bean.setArticleId(rs.getInt("articleId"));		
					bean.setListtitle(rs.getString("listtitle"));
					bean.setListimage(rs.getBlob("listimage"));
					bean.setListcontent(rs.getString("listcontent"));
					bean.setTitle(rs.getString("title"));
					bean.setSubtitle(rs.getString("subtitle"));
					bean.setImage(rs.getBlob("image"));
					bean.setDate(rs.getDate("date"));
					bean.setVendor(rs.getString("Vendor"));
					bean.setContent(rs.getClob("content"));
					
					// 最後將BookBean物件放入大的容器內
					list.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#getPageBooks()發生例外: " 
										+ ex.getMessage());
		}
		return list;
	}
	
//	public List<ArticleBean> getArticle(int articleId) {
//		List<ArticleBean> list = new ArrayList<ArticleBean>();
//		
//		String sql0 =" SELECT * FROM article WHERE articleid = ?  ";
//
//		String sql = sql0;
//
//		try (
//			Connection connection = ds.getConnection(); 
//			PreparedStatement ps = connection.prepareStatement(sql);
//		) {
//			ps.setInt(1, articleId );
//			try (
//				ResultSet rs = ps.executeQuery();
//			) {
//				// 只要還有紀錄未取出，rs.next()會傳回true
//				// 迴圈內將逐筆取出ResultSet內的紀錄
//				while (rs.next()) {
//					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
//					ArticleBean bean = new ArticleBean();    	
//					bean.setArticleId(rs.getInt("articleId"));		
//					bean.setListtitle(rs.getString("listtitle"));
//					bean.setListimage(rs.getBlob("listimage"));
//					bean.setListcontent(rs.getString("listcontent"));
//					bean.setTitle(rs.getString("title"));
//					bean.setSubtitle(rs.getString("subtitle"));
//					bean.setImage(rs.getBlob("image"));
//					bean.setDate(rs.getDate("date"));
//					bean.setVendor(rs.getString("Vendor"));
//					bean.setContent(rs.getClob("content"));
//					
//					// 最後將BookBean物件放入大的容器內
//					list.add(bean);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("BookDaoImpl_Jdbc()#getPageBooks()發生例外: " 
//										+ ex.getMessage());
//		}
//		return list;
//	}
	
	public ArticleBean queryArticle(int articleId)  {
		ArticleBean bean = null;
		String sql = "SELECT * FROM article WHERE articleid = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, articleId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new ArticleBean();
					bean.setArticleId(rs.getInt("articleId"));		
					bean.setListtitle(rs.getString("listtitle"));
					bean.setListimage(rs.getBlob("listimage"));
					bean.setListcontent(rs.getString("listcontent"));
					bean.setTitle(rs.getString("title"));
					bean.setSubtitle(rs.getString("subtitle"));
					bean.setImage(rs.getBlob("image"));
					bean.setDate(rs.getDate("date"));
					bean.setVendor(rs.getString("Vendor"));
					bean.setContent(rs.getClob("content"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#queryBook()發生例外: " 
										+ ex.getMessage());
		}
		return bean;
	}
	
	
	
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String sql = "SELECT count(*) FROM article";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#getRecordCounts()發生例外: " 
										+ ex.getMessage());
		}
		return count;
	}
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));

		return totalPages;
	}
	

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getRecordsPerPage() {
		return recordsPerPage;
	}


	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	
	
	
}
