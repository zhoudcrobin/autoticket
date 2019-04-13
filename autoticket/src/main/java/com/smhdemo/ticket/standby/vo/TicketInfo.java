package com.smhdemo.ticket.standby.vo;

import java.io.Serializable;
/**
 * 票信息实体对象
 * 
 * <ul>
 * <li>出发码头:departurePier</li>	
 * <li>抵达码头:arrivalPier</li>
 * <li>航班号:flightNumber</li>
 * <li>开航时间:flightTime</li>
 * <li>登船口:boatPort</li>
 * <li>票价:price</li>
 * <li>余票:number</li>
 * </ul>
 */
public class TicketInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String departurePier;
	private String arrivalPier;
	private String flightNumber;
	private String flightTime;
	private String boatPort;
	private Double price;
	private Integer number;
	public String getDeparturePier() {
		return departurePier;
	}
	public void setDeparturePier(String departurePier) {
		this.departurePier = departurePier;
	}
	public String getArrivalPier() {
		return arrivalPier;
	}
	public void setArrivalPier(String arrivalPier) {
		this.arrivalPier = arrivalPier;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getBoatPort() {
		return boatPort;
	}
	public void setBoatPort(String boatPort) {
		this.boatPort = boatPort;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
