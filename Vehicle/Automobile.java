package Vehicle;

public class Automobile { // create members of Automobile
  String Type;
  String Color;
  String Model;
  int Year;
  int NumberOfWheels;
  float EngineSize;
  boolean UsesGasoline;
  private String LicenseNum;

  public Automobile(String vehicle, int wheels, float engine, // setter for Vehicle members
      boolean gasoline, String vehicleColor, int vehicleYear,
      String vehicleModel, String plateNum) {

    Type = vehicle;
    NumberOfWheels = wheels;
    EngineSize = engine;
    UsesGasoline = gasoline;
    Color = vehicleColor;
    Year = vehicleYear;
    Model = vehicleModel;
    LicenseNum = plateNum;
  }

  public void print() { // prints all values for the members
    System.out.println("Vehicle: " + Type);
    System.out.println("Number of wheels: " + NumberOfWheels);
    System.out.println("Engine size: " + EngineSize);

    if (UsesGasoline == true) {
      System.out.print("Uses gasoline: " + "Yes" + "\n");
    } else {
      System.out.print("Uses gasoline: " + "No" + "\n");
    }
    System.out.println("Color: " + Color);
    System.out.println("Year & Model: " + Year + " " + Model);

    if (LicenseNum == "None") {
      System.out.println();
    } else {
      System.out.println("License Plate Number: " + LicenseNum + "\n");
    }
  }

  public static void main(String[] args) {
    Automobile[] myVehicles = new Automobile[4]; // initialize array to 4 objects
    myVehicles[0] = new Automobile("Bicycle", 2, 0, false, "Black", 2021, "Schwinn", "None");
    myVehicles[1] = new Automobile("Car", 4, 1390, true, "Grey", 2020, "Hyundai", "M19 - CSW");
    myVehicles[2] = new Automobile("Motorcycle", 2, 950, true, "Blue", 2022, "Yamaha", "507 - 14MC");
    myVehicles[3] = new Automobile("Semi-Truck", 18, 2880, true, "Red", 2019, "Mack Anthem USPS", "2LW 628");
    myVehicles[0].print(); // displays vehicle 1 information
    myVehicles[1].print(); // displays vehicle 2 information
    myVehicles[2].print(); // displays vehicle 3 information
    myVehicles[3].print(); // displays vehicle 4 information
  }
}
