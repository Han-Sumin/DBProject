package com.rail.reserve.vo;

import lombok.Data;

@Data
public class TrainVO {
	private String train_id;
	private String train_name;
	@Override
	public String toString() {
		return "TrainVO [train_id=" + train_id + ", train_name=" + train_name + "]";
	}
	
	
}
