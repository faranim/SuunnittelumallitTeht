package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingComputerBuilder);
        director.constructComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println("Gaming computer built: " + gamingComputer);

        ComputerBuilder officeComputerBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeComputerBuilder);
        director.constructComputer();
        Computer officeComputer = director.getComputer();
        System.out.println("Office computer built: " + officeComputer);
    }
}

