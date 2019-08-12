package com.gill;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved D12");
        }
        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved D12");
        }
        if(theatre.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved B13");
        }

        List<Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        //Collections.reverse(reverseSeats);
        printList(reverseSeats);
        //printList( theatre.getSeats());

    List<Seat> priceSeats = new ArrayList<>(theatre.getSeats());
    priceSeats.add(new Seat("B00", 13.00));
    priceSeats.add(new Seat("A00", 13.00));
    Collections.sort(priceSeats, Theatre.PRICE_ORDER);
    printList(priceSeats);

    }

        public static void printList(List<Seat> seatParam) {
            for (Seat seat : seatParam) {
                System.out.print(" " + seat.getSeatNumber()+","+seat.getPrice());
            }
            System.out.println();
            System.out.println("==================================================");
        }


}
