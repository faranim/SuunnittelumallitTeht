package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Apple M1 Chi");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(16);  // 16 GB RAM
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Apple GPU");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("macOS");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
