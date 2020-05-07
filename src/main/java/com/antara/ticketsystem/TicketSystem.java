package com.antara.ticketsystem;

import java.util.*;

public class TicketSystem {
    //Database:
    HashMap<String, List<Ticket>> nameToTicketsMap = new HashMap<>();

    //tickets.add(ticket);


    public static void main(String[] args) {
        TicketSystem sm = new TicketSystem();
        sm.showMenu();
    }


    public void printAllTickets(String name) {
        List<Ticket> tickets = nameToTicketsMap.get(name);
        System.out.println(name+" "+tickets);
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

                    List<Ticket> tickets = nameToTicketsMap.get(name);
                    if (tickets == null) {
                        tickets = new ArrayList<>();
                    }
                    tickets.add(new Ticket(description));
                    nameToTicketsMap.put(name, tickets);
                    break;

                case 2:
                    System.out.println("Enter your name");
                    String name1 = sc.nextLine();
                    System.out.println("Fetching tickets...");
                    printAllTickets(name1);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
