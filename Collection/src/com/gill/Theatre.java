package com.gill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
	private final String threatreName;
	
	public List<Seat> seats = new ArrayList<>();
	
	public  Theatre(String threatreName, int numRows, int seatsPerRow) {
		this.threatreName = threatreName;
		
		int lastRow = 'A' + (numRows - 1);
		for(char row='A'; row<=lastRow;row++) {
			for(int seatNum = 1; seatNum<=seatsPerRow; seatNum++) {
				Seat seat = new Seat(row+String.format("%02d", seatNum));
				this.seats.add(seat);
			}
		}
		
	}	
	
	public String getTheatreName() {
		return threatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if(foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		}
		else {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
//				for(Seat seat : seats) {
//			if(seat.getSeatNumber().equals(seatNumber)) {
//				requestedSeat = seat;
//				break;
//			}
//			System.out.print(".");
//		}
//		
//		if(requestedSeat == null) {
//			System.out.println("There is no seat " + seatNumber);
//		}
//		
//		return requestedSeat.reserve();
	}
	
	public void getSeats() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	public  class Seat implements Comparable<Seat>{
		private final String seatNumber;
		private boolean reserved  = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public boolean reserve() {
			if(!this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			} else {
				return false;
			}
		}
		
		public boolean cancel() {
			if(this.reserved) {
				this.reserved = false;
				System.out.println("Reservation for Seat " + seatNumber + " cancelled");
				return true;
			} else {
				return false;
			}
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}

		@Override
		public int compareTo(Seat seat) {
			// TODO Auto-generated method stub
			System.out.print(".");
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
	}

}
