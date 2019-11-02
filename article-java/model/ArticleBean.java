package article.model;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;

public class ArticleBean {
	private Integer 	articleId ;
	private String  	listtitle;
	private Blob    	listimage;
	private String  	listcontent;
	private String      title;
	private String      subtitle;
	private Blob    	image;
	private Date         date;
	private String      vendor;
	private Clob    	content;
	private String		fileName;
	public ArticleBean() {
	
	}
	public ArticleBean(Integer articleId, String listtitle, Blob listimage, String listcontent, String title,
			String subtitle, Blob image, Date date, String vendor, Clob content, String fileName) {
		super();
		this.articleId = articleId;
		this.listtitle = listtitle;
		this.listimage = listimage;
		this.listcontent = listcontent;
		this.title = title;
		this.subtitle = subtitle;
		this.image = image;
		this.date = date;
		this.vendor = vendor;
		this.content = content;
		this.fileName = fileName;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getListtitle() {
		return listtitle;
	}
	public void setListtitle(String listtitle) {
		this.listtitle = listtitle;
	}
	public Blob getListimage() {
		return listimage;
	}
	public void setListimage(Blob listimage) {
		this.listimage = listimage;
	}
	public String getListcontent() {
		return listcontent;
	}
	public void setListcontent(String listcontent) {
		this.listcontent = listcontent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Clob getContent() {
		return content;
	}
	public void setContent(Clob content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

	
	


	

}
