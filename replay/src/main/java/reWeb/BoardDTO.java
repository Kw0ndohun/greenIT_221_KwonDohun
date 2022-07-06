package reWeb;

import java.sql.Date;

public class BoardDTO {
	int no;
	int code; 
	String title; 
	String contents; 
	int viewCnt; 
	int likeCnt;
	String createdAt;
	String modifiedAt;
	
	public BoardDTO(String title, String contents,String createdAt) {
		this.title=title;
		this.contents=contents;
		this.createdAt=createdAt;
	}
	
	public BoardDTO(int no, String title, String contents, int viewCnt, int likeCnt, String createdAt, String modifiedAt){
		this.no=no;
		this.title=title;
		this.contents=contents;
		this.viewCnt=viewCnt;
		this.likeCnt=likeCnt;
		this.createdAt=createdAt;
		this.modifiedAt=modifiedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
}
