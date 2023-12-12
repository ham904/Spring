package com.ysboards.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int rcdNO;
	private int rcdGrpNO;
	private String userName;
	private String userMail;
	private String rcdSubject;
	private String rcdContent;
	private String rcdPass;
	private Date rcdDate;
	private int rcdRefer;
	private int rcdIndent;
	private int rcdOrder;
	
	
	
}
