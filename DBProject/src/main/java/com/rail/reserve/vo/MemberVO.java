package com.rail.reserve.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String MEMBER_ID;
	private String PASSWORD;
	private String NAME;
	private String PHONE;
	private String GRADE;
	private String CARD;
	private String FLAG;
	private String STATE;
	@Override
	public String toString() {
		return "MemberVO [MEMBER_ID=" + MEMBER_ID + ", PASSWORD=" + PASSWORD + ", NAME=" + NAME + ", PHONE=" + PHONE
				+ ", GRADE=" + GRADE + ", CARD=" + CARD + ", FLAG=" + FLAG + ", STATE=" + STATE + "]";
	}
	
	
	
	
	
	
}
