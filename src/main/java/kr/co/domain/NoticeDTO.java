package kr.co.domain;

import java.io.Serializable;

public class NoticeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String writer;
	private String title;
	private String content;
	private String writeDay;
	private int readCnt;
	
	
	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public NoticeDTO(int num, String writer, String title, String content, String writeDay, int readCnt) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.writeDay = writeDay;
		this.readCnt = readCnt;
	}






	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}




	public String getWriter() {
		return writer;
	}




	public void setWriter(String writer) {
		this.writer = writer;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getWriteDay() {
		return writeDay;
	}




	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}




	public int getReadCnt() {
		return readCnt;
	}




	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		
		return (writer + title + content);
	}
	
	
	
}
