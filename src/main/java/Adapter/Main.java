package Adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalenderToNewAdapter();

        date.setDay(4);
        date.setMonth(12);
        date.setYear(2001);

        System.out.println("Original Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(7);

        System.out.println("Advanced Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
