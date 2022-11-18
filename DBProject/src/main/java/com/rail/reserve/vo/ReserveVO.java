package com.rail.reserve.vo;

import lombok.Data;

@Data
public class ReserveVO {
	private int reserve_id;
	private String member_id;
	private String start_station;
	private String arrival_station;
	private String reserve_date;
	private String price;
	private String pay_method;
	private String station_id;
	private String train_id;
	private String direction;
	private String time;
	private String run_date;
	private String train_num;
	private String seat_num;
	
	@Override
	public String toString() {
		return "ReserveVO [reserve_id=" + reserve_id + ", member_id=" + member_id + ", start_station=" + start_station
				+ ", arrival_station=" + arrival_station + ", reserve_date=" + reserve_date + ", price=" + price
				+ ", pay_method=" + pay_method + ", station_id=" + station_id + ", train_id=" + train_id
				+ ", direction=" + direction + ", time=" + time + ", run_date=" + run_date + ", train_num=" + train_num
				+ ", seat_num=" + seat_num + "]";
	}
}
