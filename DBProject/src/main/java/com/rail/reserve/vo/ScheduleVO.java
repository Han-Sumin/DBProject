package com.rail.reserve.vo;

import lombok.Data;

@Data
public class ScheduleVO {
	private String STATION_ID;
	private String TRAIN_ID;
	private String DIRECTION;
	@Override
	public String toString() {
		return "ScheduleVO [STATION_ID=" + STATION_ID + ", TRAIN_ID=" + TRAIN_ID + ", DIRECTION=" + DIRECTION + "]";
	}
	
	
    
}
