package TEMA_18;

import java.util.Scanner;

public class GroupTicket extends Ticket {

    public GroupTicket(String performance, double price) {
        super(performance, price);
    }

    @Override
    public void setPrice(double price) {
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.println("HOW MANY PEOPLE ARE IN YOUR GROUP? (Must be at least 20 for the discount)");
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.print("COMMAND : ");
        int Number = new Scanner(System.in).nextInt();
        System.out.println("-----------------------------<+>-----------------------------\n");

        if (Number >= 20) {
            super.setPrice(price - 2);
            super.setPurchaseCount(Number);
        }
        else {
            super.setPrice(price);
            super.setPurchaseCount(0);

        }
    }
}
