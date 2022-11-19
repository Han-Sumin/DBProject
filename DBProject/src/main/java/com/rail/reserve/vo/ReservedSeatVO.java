package com.rail.reserve.vo;

import lombok.Data;

@Data
public class ReservedSeatVO {
	private String STATION_ID;
	private String TRAIN_ID;
	private String DIRECTION;
	private String TRAIN_NUM;
	private String SEAT_NUM;
	private int RESERVE_ID;
	
	@Override
	public String toString() {
		return "ReservedSeatVO [STATION_ID=" + STATION_ID + ", TRAIN_ID=" + TRAIN_ID + ", DIRECTION=" + DIRECTION
				+ ", TRAIN_NUM=" + TRAIN_NUM + ", SEAT_NUM=" + SEAT_NUM + ", RESERVE_ID=" + RESERVE_ID + "]";
	}
	
}
