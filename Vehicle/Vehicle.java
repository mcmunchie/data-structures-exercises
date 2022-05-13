package Vehicle;

public class Vehicle { // create members of Vehicle
  String Type;
  String Color;
  String Model;
  int Year;
  int NumberOfWheels;
  float EngineSize;
  boolean UsesGasoline;
  private String LicenseNum;

  // sets type of vehicle
  public void setType(String vehicle) {
    Type = vehicle;
  }

  // sets number of wheels
  public void setNumberOfWheels(int wheels) {
    NumberOfWheels = wheels;
  }

  // sets engine size
  public void setEngineSize(float engine) {
    EngineSize = engine;
  }

  // sets whether or not the vehicle uses gasoline
  public void setUsesGasoline(boolean gasoline) {
    UsesGasoline = gasoline;
  }

  // sets color
  public void setColor(String vehicleColor) {
    Color = vehicleColor;
  }

  // sets year
  public void setYear(int vehicleYear) {
    Year = vehicleYear;
  }

  // sets model of vehicle
  public void setModel(String vehicleModel) {
    Model = vehicleModel;
  }

  // sets license plate number
  public void setLicenseNumber(String plateNum) {
    LicenseNum = plateNum;
  }

  // gets type of vehicle
  public String getType(String vehicle) {
    return Type;
  }

  // gets the number of wheels for said vehicle
  public int getNumberOfWheels(int wheels) {
    return NumberOfWheels;
  }

  // gets engine size
  public float getEngineSize(float engine) {
    return EngineSize;
  }

  // gets gasoline usage information
  public boolean getUsesGasoline(boolean gasoline) {
    return UsesGasoline;
  }

  // gets color
  public String getColor(String color) {
    return Color;
  }

  // gets year
  public int getYear(int vehicleYear) {
    return Year;
  }

  // gets model
  public String getModel(String vehicleModel) {
    return Model;
  }

  // gets license plate number
  public String getLicenseNum(String plateNum) {
    return LicenseNum;
  }

  // prints information
  public void print() {
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
    Vehicle myBike = new Vehicle();
    myBike.setType("Bicycle");
    myBike.setNumberOfWheels(2);
    myBike.setEngineSize(0);
    myBike.setUsesGasoline(false);
    myBike.setColor("Black");
    myBike.setYear(2021);
    myBike.setModel("Schwinn");
    myBike.setLicenseNumber("None");

    Vehicle myCar = new Vehicle();
    myCar.setType("Car");
    myCar.setNumberOfWheels(4);
    myCar.setEngineSize(1390);
    myCar.setUsesGasoline(true);
    myCar.setColor("Grey");
    myCar.setYear(2020);
    myCar.setModel("Hyundai");
    myCar.setLicenseNumber("M19 - CSW");

    Vehicle myMotorcycle = new Vehicle();
    myMotorcycle.setType("Motorcycle");
    myMotorcycle.setNumberOfWheels(2);
    myMotorcycle.setEngineSize(950);
    myMotorcycle.setUsesGasoline(true);
    myMotorcycle.setColor("Blue");
    myMotorcycle.setYear(2022);
    myMotorcycle.setModel("Yamaha");
    myMotorcycle.setLicenseNumber("507 - 14MC");

    Vehicle myTruck = new Vehicle();
    myTruck.setType("Semi-Truck");
    myTruck.setNumberOfWheels(18);
    myTruck.setEngineSize(2880);
    myTruck.setUsesGasoline(true);
    myTruck.setColor("Red");
    myTruck.setYear(2019);
    myTruck.setModel("Mack Anthem USPS");
    myTruck.setLicenseNumber("2LW 628");

    Vehicle[] myVehicles = { myBike, myCar, myMotorcycle, myTruck };

    for (int i = 0; i < 4; i++) {
      myVehicles[i].print();
    }
  }
}
