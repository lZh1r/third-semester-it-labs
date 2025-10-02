package two;

public abstract class Bicycle {
    public final String name;
    public String color;
    private int price;
    public final double weight;
    public Bicycle(String name, String color, int price,  double weight) {
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.name = name;
    }
    public void info() {
        System.out.println(name + " info");
        System.out.println("color: " + color);
        System.out.println("price: " + price);
        System.out.println("weight: " + weight);
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void ride();
}

class MountainBike extends Bicycle {
    public double tireWidth;
    public boolean hasSuspension;
    public MountainBike(String name, String color, int price, double weight, double tireWidth, boolean hasSuspension) {
        super(name, color, price, weight);
        this.tireWidth = tireWidth;
        this.hasSuspension = hasSuspension;
    }

    @Override
    public void ride() {
        System.out.printf("Riding a Mountain Bike \"%s\"%n", this.name);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("tireWidth: " + tireWidth);
        System.out.println("hasSuspension: " + hasSuspension);
    }
}

class ChildBicycle extends Bicycle {
    public int wheelsCount;
    public ChildBicycle(String name, String color, int price, double weight, int wheelsCount) {
        super(name, color, price, weight);
        this.wheelsCount = wheelsCount;
    }

    @Override
    public void ride() {
        System.out.printf("Riding a Child Bike \"%s\"%n", this.name);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("wheelsCount: " + wheelsCount);
    }

}

class BMX extends Bicycle {
    private static int amountCreated;
    public boolean isFreestyle;
    public BMX(String name, String color, int price, double weight, boolean isFreestyle) {
        super(name, color, price, weight);
        this.isFreestyle = isFreestyle;
        BMX.amountCreated++;
    }

    public void performStunt(String stuntName) {
        System.out.println("Performing stunt " + stuntName);
    }

    @Override
    public void ride() {
        System.out.printf("Riding a BMX \"%s\"%n", this.name);
    }

    public static int getAmountCreated() {
        return BMX.amountCreated;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("isFreestyle: " + this.isFreestyle);
    }
}

class Run {
    public static void main(String[] args) {
        BMX bmxNoob = new BMX("Noob Bike 5", "Green", 500, 13, false);
        System.out.println(BMX.getAmountCreated());
        BMX bmxPro = new BMX("Pro Bike 2000", "Red", 1000, 10.5, true);
        bmxPro.ride();
        bmxPro.info();
        bmxNoob.performStunt("Backward 360 flip");
        System.out.println(BMX.getAmountCreated());
        //Black Friday happens
        bmxPro.setPrice(750);
        bmxNoob.setPrice(250);
        System.out.println(bmxPro.getPrice() + "$ is the Black Friday special price for " + bmxPro.name + "!");

        MountainBike mountainBike = new MountainBike("HillCrusher", "Black", 800, 15, 5.5, true);
        mountainBike.ride();
        ChildBicycle babyBike = new ChildBicycle("The King's Chariot", "Yellow", 250,  6, 3);
        babyBike.ride();
    }
}