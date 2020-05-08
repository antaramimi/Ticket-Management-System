package com.antara.ticketsystem;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Ticket {
    private String description;

    Ticket(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket :" +
                "description='" + description + '\'' ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
