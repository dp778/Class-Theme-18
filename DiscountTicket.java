package TEMA_18;

import java.util.Scanner;

public class DiscountTicket extends Ticket {

    public DiscountTicket(String performance, double price) {
        super(performance, price);
    }

    @Override
    public void setPrice(double price) {
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.println("Are you a student or retired? ( yes/no )");
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.print("COMMAND : ");
        String Check = new Scanner(System.in).next().toLowerCase();
        System.out.println("-----------------------------<+>-----------------------------\n");

        if (Check.equals("yes")) {
            super.setPrice(price * 0.5);
        }
        else {
            super.setPrice(price);
        }

    }
}