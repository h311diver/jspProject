package kr.co.domain;

import java.io.Serializable;

public class InformationDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String writer;
	private String title;
	private String content;
	private String writeDay;
	private int readCnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	
	
	public InformationDTO(int num, String writer, String title, String content, 
		String writeDay, int readCnt, int repRoot, int repStep, int repIndent) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.writeDay = writeDay;
		this.readCnt = readCnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
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


	public int getRepRoot() {
		return repRoot;
	}


	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}


	public int getRepStep() {
		return repStep;
	}


	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}


	public int getRepIndent() {
		return repIndent;
	}


	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PostingDTO [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", writeDay=" + writeDay + ", readCnt=" + readCnt + ", repRoot=" + repRoot + ", repStep=" + repStep
				+ ", repIndent=" + repIndent + "]";
	}
	
	
	
	
	
}
