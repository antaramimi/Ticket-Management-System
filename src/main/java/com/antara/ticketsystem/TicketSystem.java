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

    public void printTickets(String name) {
        List<Ticket> tickets = nameToTicketsMap.get(name);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(i + ": " + " " + tickets.get(i));
        }
    }


    public void showMenu() {
        int option;
        System.out.println("Welcome to ticket management system ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: File a ticket");
            System.out.println("2: Get all tickets");
            System.out.println("3: Edit the tickets description");
            System.out.println("4: Exit");

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
                    printTickets(name1);
                    break;
                case 3:
                    System.out.println("Enter your name");
                    String nameOftheUser = sc.nextLine();
                    printTickets(nameOftheUser);
                    System.out.println("Select a record ");
                    int record = sc.nextInt();
                    List<Ticket> ticketToupdates = nameToTicketsMap.get(nameOftheUser);
                    Ticket tickekToUpdate = ticketToupdates.get(record);
                    System.out.println("Update the description ");
                    String descriptionTOupdate = sc.nextLine();
                    tickekToUpdate.setDescription(descriptionTOupdate);
                    System.out.println("The record updated!");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
