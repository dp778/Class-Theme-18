package TEMA_18;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    private static ArrayList<Ticket> MyTickets = new ArrayList<>();
    private static int NormalTicketNumber = 0;
    private static int DiscountTicketNumber = 0;
    private static int GroupTicketNumber = 0;

    private static double NormalTicketSum = 0.00;
    private static double DiscountTicketSum = 0.00;
    private static double GroupTicketSum = 0.00;

    private static double TotalSum;

    private static String PerfName = " ";
    private static double PerfPrice = 0.00;

    public static void main(String[] args) {
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.print("ENTER THE NAME OF THE PLAY : ");
        PerfName = new Scanner(System.in).next();

        System.out.print("ENTER THE PRICE OF THE TICKET : ");
        PerfPrice = new Scanner(System.in).nextDouble();
        System.out.println("-----------------------------<+>-----------------------------\n");

        InputTicket();
        MakeStatistic();
        PrintStatistic();
    }

    public static void InputTicket() {
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.println("Choose your ticket type! (normal, discount, group) : ");
        System.out.println("To end your session type 'end'!");
        System.out.println("-----------------------------<+>-----------------------------");
        System.out.print("COMMAND : ");
        String Answer = new Scanner(System.in).nextLine();
        System.out.println("-----------------------------<+>-----------------------------\n");

        while (!Answer.equals("end")) {
            switch (Answer) {
                case "normal":
                    NormalTicket normalTicket = new NormalTicket("", 0.00);
                    normalTicket.setPerformance(PerfName);
                    normalTicket.setPrice(PerfPrice);
                    MyTickets.add(normalTicket);
                    break;

                case "discount":
                    DiscountTicket discountTicket = new DiscountTicket("", 0.00);
                    discountTicket.setPerformance(PerfName);
                    discountTicket.setPrice(PerfPrice);
                    if (discountTicket.getPrice() == PerfPrice / 2) {
                        MyTickets.add(discountTicket);
                    }
                    break;
                case "group":
                    GroupTicket groupTicket = new GroupTicket("", 0.00);
                    groupTicket.setPerformance(PerfName);
                    groupTicket.setPrice(PerfPrice);
                    if(groupTicket.getPurchaseCount() >= 20) {
                        MyTickets.add(groupTicket);
                    }
                    break;
            }
            System.out.println("-----------------------------<+>-----------------------------");
            System.out.println("Choose your ticket type! (normal, discount, group) : ");
            System.out.println("To end your session type 'end'!");
            System.out.println("-----------------------------<+>-----------------------------");
            System.out.print("COMMAND : ");
            Answer = new Scanner(System.in).nextLine();
            System.out.println("-----------------------------<+>-----------------------------\n");
        }

    }

    private static void MakeStatistic(){

        for (Ticket tempTicket : MyTickets){

            if(tempTicket.getPrice() == PerfPrice){
                NormalTicketNumber++;
                NormalTicketSum = NormalTicketSum + tempTicket.getPrice();
            }

            if (tempTicket.getPrice() == PerfPrice * 0.5){
                DiscountTicketNumber++;
                DiscountTicketSum = DiscountTicketSum + tempTicket.getPrice();
            }

            if (tempTicket.getPrice() ==(PerfPrice - 2)){
                GroupTicketNumber = GroupTicketNumber + tempTicket.getPurchaseCount();
                GroupTicketSum = GroupTicketSum + (tempTicket.getPurchaseCount() * tempTicket.getPrice());
            }
        }
        TotalSum = NormalTicketSum + DiscountTicketSum + GroupTicketSum;
    }
    private static void PrintStatistic(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("[1] NORMAL TICKETS   : " + NormalTicketNumber + "| PRICE : " + NormalTicketSum);
        System.out.println("[2] DISCOUNT TICKETS : " + DiscountTicketNumber + "| PRICE : " + DiscountTicketSum);
        System.out.println("[3] GROUP TICKETS    : " + GroupTicketNumber + "| PRICE : " + GroupTicketSum);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" TOTAL : " + TotalSum);
        System.out.println("-------------------------------------------------------------------------------");
    }
}