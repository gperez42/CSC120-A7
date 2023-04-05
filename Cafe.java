/* This is a stub for the Cafe class */
public class Cafe extends Building{

    /** Attribute for number of coffee ounces remaining in cafe's inventory */
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    /** Attribute for number of sugar packets remaining in cafe's inventory */
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    /** Attribute for number of creams remaining in cafe's inventory */
    private int nCreams; // The number of "splashes" of cream remaining in inventory
     /** Attribute for number of coffee cups remaining in cafe's inventory */
    private int nCups; // The number of cups remaining in inventory
    
    // private boolean elevator;

    /**
     * Constructor - builds cafes
     * @param name - name of the cafe
     * @param address - address of the cafe
     * @param nFloors - number of floors the cafe has
     */
    public Cafe(String name, String address, int nFloors) {
        // System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 1000;
        this.nCreams = 300;
        this.nCups = 500;
        // this.elevator = elevator;
    }
    /** Overloaded Constructor with just name and address 
     * @param name - name of the cafe
     * @param address - address of the cafe
    */
    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 1000;
        this.nCreams = 300;
        this.nCups = 500;
    }

    /**
     * Sells a coffee to a customer and decreases the stock of the cafe depending on how much of each ingredient the customer requests, then restocks ingredients as needed
     * @param size - size of the coffee the customer wants
     * @param nSugarPackets - number of sugar packets going in the customer's coffee
     * @param nCreams - number of creams going in the customer's coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams) {
        //    this.restock(200, 1000, 300, 500);
        //    // RESTOCKING WITH ORDER OF ORIGINAL AMOUNT THAT CAFE STARTS WITH
        // }
        // else {
        //     this.nCoffeeOunces = this.nCoffeeOunces - size;
        //     this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        //     this.nCreams = this.nCreams - nCreams;
        //     this.nCups = this.nCups - 1;
        // }
        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams){
            this.restock(0, 0, 0, 50);

        }
        else if (size > this.nCoffeeOunces) {
            this.restock(200, 0, 0, 0);
        }
        else if (nSugarPackets > this.nSugarPackets) {
            this.restock(0, 1000, 0, 0);
        }
        else if (nCreams > this.nCreams) {
            this.restock(0, 0, 300, 0);

        } // RESTOCKING EACH INGREDIENT INDIVIDUALLY AS IT RUNS OUT TO SAVE MONEY FOR
        // THE CAFE, BUT ALWAYS RESTOCKING CUPS BY 1/10 OF ORIGINAL ORDER AMOUNT AS TO
        // NOT RUN OUT WHILE FULFILLING ALL COFFEE ORDERS
       
        else {
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
            }
      
    }
    /** Overloaded Method: sellCoffee
     * @param size - size of the coffee the customer wants
     */
    public void sellCoffee(int size) {
        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams){
            this.restock(50, 3, 5, 1);
        }
    } 

    /** Restocks the cafe's ingredients
     * @param nCoffeeOunces - number of coffee ounces being restocked
     * @param nSugarPackets - number of sugar packets being restocked
     * @param nCreams - number of creams being restocked
     * @param nCups - number of cups being restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces + this.nCoffeeOunces;
        this.nSugarPackets = nSugarPackets + this.nSugarPackets;
        this.nCreams = nCreams + this.nCreams;
        this.nCups = nCups + this.nCups;

    }

   /** Overriden goToFloor() method from Building class - does not let the customer move floors because it assumes that any floors beyond the 1st are inaccessible
    * @param floorNum: the floor number that the customer is trying to go to
    */
    public void goToFloor(int floorNum) {
        if (floorNum > 1) {
            throw new RuntimeException("Sorry, you are already on this floor and this is the only floor in the cafe that is accessible to customers.");
        }
    }

    /** Overriden showOptions() method from Building class - adds the options of selling coffee and restocking for the cafe */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    
    }

    /**
     * Tests for methods by building a cafe, selling coffee, printing stock of ingredients, and restocking manually
     * @param args - Command line arguments
     */
    public static void main(String[] args) {
        Cafe perezCafe = new Cafe("Perez Cafe", "123 Family St. Magical Place, Somewhere", 2);
        perezCafe.sellCoffee(12, 2, 3);
        // System.out.println(perezCafe.nCoffeeOunces);
        // System.out.println(perezCafe.nSugarPackets);
        // System.out.println(perezCafe.nCreams);
        // System.out.println(perezCafe.nCups);
        // // perezCafe.sellCoffee(200, 1000, 300);
        // // System.out.println(perezCafe.nCoffeeOunces);
        // // System.out.println(perezCafe.nSugarPackets);
        // // System.out.println(perezCafe.nCreams);
        // // System.out.println(perezCafe.nCups);
        // perezCafe.sellCoffee(200, 1000, 300);
        // perezCafe.restock(200, 1000, 300, 500);
        // System.out.println(perezCafe.nCoffeeOunces);
        // System.out.println(perezCafe.nSugarPackets);
        // System.out.println(perezCafe.nCreams);
        // System.out.println(perezCafe.nCups);

        perezCafe.showOptions();
        perezCafe.enter();
        perezCafe.goToFloor(1);
        // perezCafe.goToFloor(2);

        Cafe compassCafe = new Cafe("Compass Cafe", "Smith College", 5);
        compassCafe.sellCoffee(300);
        System.out.println(compassCafe.nCoffeeOunces);
        System.out.println(compassCafe.nSugarPackets);
        System.out.println(compassCafe.nCreams);
        System.out.println(compassCafe.nCups);

    }
    
}
