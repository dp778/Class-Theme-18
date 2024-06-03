package TEMA_18;

public class Ticket {
    private String Performance;
    private double Price;
    private int purchaseCount = 0;

    public Ticket(String performance, double price) {
        Performance = performance;
        Price = price;
    }

    public String getPerformance() {
        return Performance;
    }

    public void setPerformance(String performance) {
        Performance = performance;
    }

    public double getPrice() {return Price;}

    public void setPrice(double price) {Price = price;}

    public int getPurchaseCount() {return purchaseCount;}

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;}

    @Override
    public String toString(){
        StringBuilder toPrint = new StringBuilder();

        toPrint.append("PERFORMANCE : " + this.getPerformance() + "\n");
        toPrint.append("PRICE : " + this.getPrice() + "\n");
        toPrint.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n");

        return toPrint.toString();
    }
}