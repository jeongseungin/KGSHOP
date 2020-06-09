package com.care.DTO;

import java.util.Date;

public class Board_qa_ReplyDTO {
	private int qa_seq;
	private int qa_reply_seq;
	private String qa_reply_content;
	private String qa_reply_user_id;
	private Date qa_reply_logtime;
	
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
	String getQa_reply_content() {
		return qa_reply_content;
	}
	void setQa_reply_content(String qa_reply_content) {
		this.qa_reply_content = qa_reply_content;
	}
	String getQa_reply_user_id() {
		return qa_reply_user_id;
	}
	void setQa_reply_user_id(String qa_reply_user_id) {
		this.qa_reply_user_id = qa_reply_user_id;
	}
	Date getQa_reply_logtime() {
		return qa_reply_logtime;
	}
	void setQa_reply_logtime(Date qa_reply_logtime) {
		this.qa_reply_logtime = qa_reply_logtime;
	}
	

}
