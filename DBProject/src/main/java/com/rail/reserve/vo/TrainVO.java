package com.rail.reserve.vo;

import lombok.Data;

@Data
public class TrainVO {
	private String TRAIN_ID;
	private String TRAIN_NAME;
	@Override
	public String toString() {
		return "TrainVO [TRAIN_ID=" + TRAIN_ID + ", TRAIN_NAME=" + TRAIN_NAME + "]";
	}
	
	
	
}
