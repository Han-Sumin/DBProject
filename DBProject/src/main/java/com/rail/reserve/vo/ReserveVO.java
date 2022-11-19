package com.rail.reserve.vo;

import lombok.Data;

@Data
public class ReserveVO {
	private int RESERVE_ID;
	private String MEMBER_ID;
	private String START_STATION;
	private String ARRIVAL_STATION;
	private String RESERVE_DATE;
	private String PRICE;
	private String PAY_METHOD;
	@Override
	public String toString() {
		return "ReserveVO [RESERVE_ID=" + RESERVE_ID + ", MEMBER_ID=" + MEMBER_ID + ", START_STATION=" + START_STATION
				+ ", ARRIVAL_STATION=" + ARRIVAL_STATION + ", RESERVE_DATE=" + RESERVE_DATE + ", PRICE=" + PRICE
				+ ", PAY_METHOD=" + PAY_METHOD + "]";
	}
	
	
}
