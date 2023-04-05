import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{

   /** Attribute that sets up a hashtable for a String and Boolean in library's collection */
  private Hashtable<String, Boolean> collection;
  /** Attribute for elevator in library */
  private boolean elevator;

    /**
     * Constructor for Library - builds libraries
     * @param name - name of the library
     * @param address - adress of the library
     * @param nFloors - number of floors that the library has
     * @param elevator - whether or not the house has an elevator, if yes - true, if no - false
     */
    public Library(String name, String address, int nFloors, boolean elevator) {
      // System.out.println("You have built a library: 📖"); // can't put this at the beginning of a constructor
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.elevator = elevator;
      System.out.println("You have built a library: 📖");
    }
    /**
     * Overloaded Constructor for Library without either an elevator or more than 1 floor
     * @param name - name of the library
     * @param address - adress of the library
     */
    public Library(String name, String address) {
      super(name, address);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * Adds a title to the library's collection
     * @param title - title of the book we are adding to the collection
     */
    public void addTitle(String title) {
      if (this.collection.contains(title)) {
        throw new RuntimeException("This collection already contains this title.");
      }
      else {
        this.collection.put(title, true);
      }
    }
    /**
     * Removes a title that exists in the collection from the collection, and if not able to, it throws an exception
     * @param title - title of book we want to remove
     * @return String - title of the book we tried to remove
     */
    public String removeTitle(String title){
      // return the title that we removed
      if (this.collection.get(title)) {
        this.collection.remove(title);
      }
      else {
        throw new RuntimeException("This title cannot be removed because it is not in the collection.");
      }
      return title;
    } 
    /**
     * Checks out a title from the collection if it exists, and if not able to it throws an exception
     * @param title - title of the book we want to check out
     */
    public void checkOut(String title) {
      if (this.collection.get(title)) {
        this.collection.replace(title, false);
      }
      else {
        throw new RuntimeException("The title named " + title + " is not in the collection, so it cannot be checked out.");
      }
    
    }
     /**
     * Overloaded Method: checkOut() - checks out a title from the collection if it exists, and if not able to it throws an exception
     * @param title - title of the first book we want to check out
     * @param title2 - title of the second book being checked out
     */
    public void checkOut(String title, String title2) {
      if ((this.collection.get(title)) && (this.collection.get(title2))) {
        this.collection.replace(title, false);
        this.collection.replace(title2, false);
      }
      else if (this.collection.get(title)) {
        this.collection.replace(title, false);
      }
      else if (this.collection.get(title2)) {
        this.collection.replace(title2, false);
      }
      else {
        throw new RuntimeException("This titles named " + title + " and " + title2 + " are not in the collection, so it cannot be checked out.");
      }
    
    }

    /**
     * Returns book if it is checked out/unavailable at the moment, and if it has already been returned, it throws an exception
     * @param title - title of the book we want to return to the collection
     */
    public void returnBook(String title) {
      if (this.collection.get(title)) {
        throw new RuntimeException("This book cannot be returned right now because it has already been returned.");
     }
      else {
        this.collection.replace(title, true);
      }
    }
    /**
     * Checks if the library contains a specific title at all, available or unavailable
     * @param title - title of the book we are checking for in the collection
     * @return boolean - true (if available or unavailable) or false (if it doesn't exist at all)
     */
    public boolean containsTitle(String title) {
    // returns true if the title appears as a key in the Library's collection, false otherwise
      if (this.collection.contains(title)) {
        return true;
      }
      else {
        return false;
      }
    }
    /** 
     * Checks if a title is available in the library
     * @param title - title of the book we are checking the availability of
     * @return boolean - true (if available) or false (if unavailable)
     */
    public boolean isAvailable(String title){
      // returns true if the title is currently available, false otherwise
    //   if (this.collection.get(title) == true) {
    //     return true;
    //   }
    //   else {
    //     return false;
    //   }
    // }
      return this.collection.get(title);
    }
  
    /**
     * Prints out the entire collection of the library, which includes each title's name along with it's availability
     */
    public void printCollection(){
      // prints out the entire collection in an easy-to-read way (including checkout status)
      // System.out.println(this.collection); // unformatted way of printing all titles

      for (String title : this.collection.keySet()) {
        String availability = " ";
    
        if (this.isAvailable(title)) {
          availability = " (Available)";
         
        }

        else {
          availability = " (Unavailable)";
        }
        System.out.println(title + availability);
        }

        // for (String title2 : this.collection.keySet()) {
        //   String availability = " ";
      
        //   if (this.isAvailable(title2)) {
        //     availability = " (Available)";
           
        //   }
  
        //   else {
        //     availability = " (Unavailable)";
        //   }
        //   System.out.println(title2 + availability);
        //   }
      }

      /** Overriden goToFloor() method from Building class - allows people to move to non-adjacent floors with an elevator if Library has more than 1 floor */
      public void goToFloor(int floorNum) {
        if (this.elevator) {
          super.goToFloor(floorNum);
        }
        else {
          throw new RuntimeException("Sorry, this library doesn't have an elevator.");
        }
      }

      /** Overriden showOptions() method from Building class - adds the options of adding titles, removing titles, checking out books, and returning books for the library */
      public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook()\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
    
  /**
   * Tests methods by building a sample library called neilson library, adding titles, removing and checking some out, checking availability, and finally printing the whole collection
   * @param args - Command line arguments
   */
    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5, true);
      neilson.addTitle("A Bad Case of Stripes by David Shannon");
      neilson.addTitle("Chicka Chicka Boom Boom by Bill Martin Jr and John Archambault");
      neilson.addTitle("If You Give a Mouse a Cookie by Laura Numeroff");
      neilson.addTitle("Pinkalicious by Victoria Kann & Elizabeth Kann");
      neilson.removeTitle("Pinkalicious by Victoria Kann & Elizabeth Kann");
      neilson.checkOut("If You Give a Mouse a Cookie by Laura Numeroff");
      System.out.println(neilson.isAvailable("If You Give a Mouse a Cookie by Laura Numeroff"));
      neilson.printCollection();

      neilson.showOptions();
      neilson.enter();
      neilson.goToFloor(2);
      neilson.goToFloor(1);
      neilson.exit();


      neilson.checkOut("Chicka Chicka Boom Boom by Bill Martin Jr and John Archambault", "A Bad Case of Stripes by David Shannon");
      neilson.returnBook("Chicka Chicka Boom Boom by Bill Martin Jr and John Archambault");
      System.out.println(neilson.isAvailable("A Bad Case of Stripes by David Shannon"));
      neilson.printCollection();
    }
  
  }
