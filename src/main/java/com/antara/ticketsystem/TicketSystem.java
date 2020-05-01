package com.antara.ticketsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketSystem {
    //Database:
    HashMap<String, ArrayList<Ticket>> map = new HashMap<>();


    public static void main(String[] args) {
        TicketSystem sm = new TicketSystem();
        sm.showMenu();
    }

    public void printDetailsforUser(String name) {
        for (Map.Entry<String, ArrayList<Ticket>> entry : map.entrySet()) {
            if (name.equals(entry.getKey())) {
                ArrayList<Ticket> value = entry.getValue();
                for (Ticket ticketDetails : value) {
                    System.out.println("key : " + name + " value : " + ticketDetails.getDescription());
                }
            }

        }
    }

    public void showMenu() {
        int option;
        System.out.println("Welcome to ticket management system ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: File a ticket");
            System.out.println("2: Get all tickets");
            System.out.println("3: Exit");

            option = Integer.valueOf(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter email: ");
                    String email = sc.nextLine();
                    User user = new User(name, email);
                    System.out.println("Enter ticket issue: ");
                    String description = sc.nextLine();
                    Ticket ticket = new Ticket(description);
                    ArrayList<Ticket> tickets = new ArrayList<>();
                    tickets.add(ticket);
                    map.put(name, tickets);
                    break;

                case 2:
                    System.out.println("Enter your name");
                    String name1 = sc.nextLine();
                    System.out.println("Fetching tickets...");
                    printDetailsforUser(name1);
                    // print all data from map
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
