package com.rail.reserve.vo;

import lombok.Data;

@Data
public class TrainSeatVO {
	private String TRAIN_ID;
	private String TRAIN_NUM;
	private String SEAT_NUM;
	
	@Override
	public String toString() {
		return "TrainSeat [TRAIN_ID=" + TRAIN_ID + ", TRAIN_NUM=" + TRAIN_NUM + ", SEAT_NUM=" + SEAT_NUM + "]";
	}
	
	
}
