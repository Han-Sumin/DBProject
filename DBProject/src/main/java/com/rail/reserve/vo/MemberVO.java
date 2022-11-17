package com.rail.reserve.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String member_id;
	private String password;
	private String member_name;
	private String phone;
	private String grade;
	private String card;
	private String flag;
	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", password=" + password + ", member_name=" + member_name
				+ ", phone=" + phone + ", grade=" + grade + ", card=" + card + ", flag=" + flag + "]";
	}
	
	
	
}
