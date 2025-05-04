public class Vehicle {
    public String vin;
    public String reg_plate;
    public String make;
    public String model;
    public int year;
    public String fuel_type;
    public String transmission;
    public String color;
    public String body;
    public String drivetrain;

    public Vehicle() {

    }

    public Vehicle(String vin, String reg_plate, String make, String model, int year, String fuel_type, String transmission, String color, String body, String drivetrain) {
        this.vin = vin;
        this.reg_plate = reg_plate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuel_type = fuel_type;
        this.transmission = transmission;
        this.color = color;
        this.body = body;
        this.drivetrain = drivetrain;
    }

    @Override
    public String toString() {
        return "Vehicle: " + make + " " + model + " " + reg_plate;
    }
}
