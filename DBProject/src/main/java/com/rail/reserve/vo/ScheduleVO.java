package com.rail.reserve.vo;

import lombok.Data;

@Data
public class ScheduleVO {
    private String station_id;
    private String train_id;
    private String direction;
	@Override
	public String toString() {
		return "ScheduleVO [station_id=" + station_id + ", train_id=" + train_id + ", direction=" + direction + "]";
	}
    
}
