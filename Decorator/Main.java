package Decorator;


public class Main {
    public static void main(String[] args) {
        // Perustulostin
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");
        printer.print("Hellurei!");

        // Tulostin, joka tulostaa tiedostoon ja salaa viestin
        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("Hello World!");
    }
}
