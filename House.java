import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  /** Attribute for ArrayList of a String that holds the residents */
  private ArrayList<String> residents;
  /** Attribute for dining room in house */
  private boolean hasDiningRoom;
  /** Attribute for elevator in house */
  private boolean elevator;

  /**
   * Constructor for House - builds houses
   * @param name - name of the house
   * @param address - address of the house
   * @param nFloors - number of floors the house has
   * @param hasDiningRoom - whether or not the house has a dining room
   * @param elevator - whether or not the house has an elevator, if yes - true, if no - false
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean elevator) {
    // System.out.println("You have built a house: 🏠"); // can't put this at the beginning of a constructor
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }
  /**
   * Overloaded Constructor without elevator
   * @param name - name of house
   * @param address - address of house
   * @param nFloors - number of floors of the house
   * @param hasDiningRoom - whether or not house has a dining room, if yes - true, if no - false
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }
  /**
   * Overloaded Constructor without either an elevator or dining room possibility
   * @param name - name of house
   * @param address - address of house
   * @param nFloors - number of floors of the house
   */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

     /**
   * Overloaded Constructor without the possibility of either an elevator, dining room, or more than 1 floor
   * @param name - name of house
   * @param address - address of house
   */
  public House(String name, String address) {
    super(name, address);
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

  // JUST OVERLOADING by REMOVING nFloors

  // /**
  //  * Overloaded Constructor without number of floors
  //  * @param name - name of house
  //  * @param address - address of house
  //  * @param hasDiningRoom - whether or not house has a dining room, if yes - true, if no - false
  //  * @param elevator - whether or not the house has an elevator, if yes - true, if no - false
  //  */
  // public House(String name, String address, boolean hasDiningRoom, boolean elevator) {
  //   super(name, address);
  //   this.residents = new ArrayList<String>();
  //   this.hasDiningRoom = hasDiningRoom;
  //   this.elevator = elevator;
  //   System.out.println("You have built a house: 🏠");
  // }

/* Accessor/getter for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
/* Accessor/getter for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  /** Adds a new resident to the list of residents in the house
   * @param name - name of new resident who is moving in
  */
  public void moveIn(String name) {
    this.residents.add(name);
    System.out.println("A new resident named " + name + " has moved in.");
  }
  
  /** Removes a resident from the list of residents in the house
   * @param name: name of the resident who is moving out
   * @return String: returns the name of resident that moved out
   */
  public String moveOut(String name) {
    // return the name of the person who moved out

    if (this.residents.contains(name)) {
      this.residents.remove(name);
      System.out.println("The resident named " + name + " has moved out.");
      return name;
    }
    else {
      System.out.println("Sorry, the resident named " + name + " does not live here. ");
      return null; 
    }
  }
  /** Checks if an inputted person is a resident of the house
   * @param person - inputted person's name
   * @return boolean - true if the person is a resident or false if they are not
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      System.out.println("Yes, this person is a resident of the house.");
      return true;
    }
    else {
      System.out.println("A person named '" + person + "' doesn't seem to live here.");
      return false;
    }
  }

  /** Overloaded Method: isResident- checks if an inputted person is a resident of a specific house
  * @param person - first person's name
  * @param person2 - second person's name 
  * @return boolean - true if the person is a resident or false if they are not
  */
  public boolean isResident(String person, String person2) {
    if ((this.residents.contains(person)) && (this.residents.contains(person2))) {
      System.out.println("Yes, " + person + " and " + person2 + " are residents of the house.");
      return true;
    }
    else if (this.residents.contains(person)) {
        System.out.println("Yes, the person named " + person + " is a resident of the house.");
        return true;
    }
    else if (this.residents.contains(person2)) {
      System.out.println("Yes, the person named " + person2 + " is a resident of the house.");
      return true;
  }
    else {
      System.out.println("People named '" + person + " and " + person2 + "' don't seem to live here.");
      return false;
    }
  }

  /** Describes how many residents are currently living in a house and whether or not a house has a dining room
   * @return String - description of the number of residents and possbility of dining hall in house
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.residents.size() + " residents in this house.";
    description += " This house";
    if (this.hasDiningRoom){
      description += " has";

    } else {
      description += " does not have";
    }
    description += " an active dining room.";
    return description;
  }
  /** Overriden goToFloor() method from Building class - allows residents to move to non-adjacent floors with an elevator if House has more than 1 floor */
  public void goToFloor(int floorNum) {
   if (this.elevator) {
      super.goToFloor(floorNum);
    // if (this.activeFloor == -1) {
    //   throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    // }
    // if (floorNum < 1 || floorNum > this.nFloors) {
    //     throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    // }
    // System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    // this.activeFloor = floorNum;
   }
   else {
      // System.out.println("Sorry, your house doesn't have an elevator.");
      throw new RuntimeException("Sorry, your house doesn't have an elevator.");
   }

  // else {
  //   if (this.activeFloor == -1) {
  //     throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  //   }
  //   if (floorNum < 1 || floorNum > this.nFloors) {
  //     throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
  // }
  //   int startingFloor = this.activeFloor;
  //   for (int changeFloors = startingFloor; changeFloors <= floorNum; changeFloors++){
  //     this.activeFloor = floorNum + 1;
  //     System.out.println("You are now on floor" + activeFloor);
  //   }
    

  // }
}

  /** Overriden showOptions() method from Building class - adds the options of moving in and out of a House */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + moveIn() \n + moveOut() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
}

/** Tests methods created for House class that creates new houses and moves people in and out
 * @param args - The command line arguments
 */
  public static void main(String[] args) {
    House wilson = new House("Wilson House", "16 Kensington Ave Northampton, MA", 4, false, false);
    System.out.println(wilson);

    House lawrence = new House("Lawrence House", "<> Green Street Northampton, MA", 4, false, false);
    System.out.println(lawrence);

    House morris = new House("Morris House", "Green Street", 4, false, false);
    System.out.println(morris);

    House northrop = new House("Northrop House", "Elm Street", 5, true, true);
    System.out.println(northrop);

    House gillett = new House("Gillett House", "Elm Street", 5, true, true);
    System.out.println(gillett);

    // TESTING
    morris.moveIn("Lisa");
    System.out.println(morris.nResidents());
    System.out.println("There is/are " + morris.nResidents() + " resident(s) in Morris House.");
    
    morris.moveOut("Lisa");
    System.out.println(morris.nResidents());
    System.out.println("There is/are " + morris.nResidents() + " resident(s) in Morris House.");

    morris.isResident("Amber");
    morris.moveOut("Amber");

    // morris.showOptions();
    // morris.enter();
    // morris.goToFloor(3);
    // morris.exit();

    northrop.enter();
    northrop.goToFloor(3);

    morris.moveIn("Lucky Perez");
    morris.moveIn("Glenvelis Perez");
    morris.isResident("Lucky Perez", "Glenvelis Perez");
    morris.isResident("Barack Obama");
    morris.isResident("Barack Obama", "Michelle Obama");
  }

}