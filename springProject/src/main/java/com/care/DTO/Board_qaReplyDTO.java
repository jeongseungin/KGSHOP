package com.care.DTO;

public class Board_qaReplyDTO {
	private int qa_seq;
	private int qa_reply_seq;
	private String userid;
	private String content;
	private String logtime;
	
	
	int getQa_seq() {
		return qa_seq;
	}
	void setQa_seq(int qa_seq) {
		this.qa_seq = qa_seq;
	}
	int getQa_reply_seq() {
		return qa_reply_seq;
	}
	void setQa_reply_seq(int qa_reply_seq) {
		this.qa_reply_seq = qa_reply_seq;
	}
	String getUserid() {
		return userid;
	}
	void setUserid(String userid) {
		this.userid = userid;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
	}
	String getLogtime() {
		return logtime;
	}
	void setLogtime(String logtime) {
		this.logtime = logtime;
	}

}
