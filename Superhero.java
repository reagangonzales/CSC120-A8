/**
 * A Superhero class representing Superman, implementing the Contract interface
 */
public class Superhero implements Contract {
    // Attributes to track health, current size, current location
    private int health;
    private int size;
    private int xPosition;
    private int yPosition;

    /**
     * Constructor initializes Superman's starting attributes
     */
    public Superhero() {
        this.health = 100; // full health
        this.size = 100; // normal size
        this.xPosition = 0; // starting location
        this.yPosition = 0;
    }

    /**
     * Grabs an item
     * @param item the item to grab
     */
    public void grab(String item) {
        System.out.println("Superman grabs the " + item + " with super strength.");
        this.health -= 2; // Reduce health slightly for the action
        System.out.println("Health after grabbing: " + this.health);
    }

    /**
     * Drops an item and returns a message about the drop
     * @param item the item to drop
     * @return a message about the item dropped
     */
    public String drop(String item) {
        return "Superman drops the " + item + " carefully.";
    }

    /**
     * Examines an item with super vision
     * @param item the item to examine
     */
    public void examine(String item) {
        System.out.println("Superman examines the " + item + " with his x-ray vision.");
    }

    /**
     * Uses an item
     * @param item the item to use
     */
    public void use(String item) {
        System.out.println("Superman uses the " + item + " heroically.");
        this.health -= 5; // Using an item requires more energy
        System.out.println("Health after using: " + this.health);
    }

    /**
     * Walks in a direction, changing position
     * @param direction the direction to walk in
     * @return true if the walk was successful, false if an invalid direction is given
     */
    public boolean walk(String direction) {
        System.out.println("Superman walks " + direction + " with purpose.");
        
        // Adjust position based on the direction
        if ("north".equalsIgnoreCase(direction)) {
            yPosition++;
        } else if ("south".equalsIgnoreCase(direction)) {
            yPosition--;
        } else if ("east".equalsIgnoreCase(direction)) {
            xPosition++;
        } else if ("west".equalsIgnoreCase(direction)) {
            xPosition--;
        } else {
            return false; // Invalid direction
        }
    
        System.out.println("Current Position: (" + xPosition + ", " + yPosition + ")");
        return true;
    }

    /**
     * Flies to a specific location with coordinates x,y
     * @param x the x-coordinate to fly to
     * @param y the y-coordinate to fly to
     * @return true if Superman reaches the destination
     */
    public boolean fly(int x, int y) {
        if (this.health < 20) {
            System.out.println("Superman is too weak to fly!");
            return false;
        }
        this.xPosition = x;
        this.yPosition = y;
        this.health -= 10; // Flying costs significant energy
        System.out.println("Superman flies to coordinates (" + x + ", " + y + ").");
        System.out.println("Health after flying: " + this.health);
        return true;
    }

    /**
     * Shrinks in size
     * @return the new size after shrinking
     */
    public Number shrink() {
        this.size -= 10;
        System.out.println("Superman shrinks down in size, now at " + this.size + "%.");
        return this.size;
    }

    /**
     * Grows in size
     * @return the new size after growing
     */
    public Number grow() {
        this.size += 10;
        System.out.println("Superman grows, now at " + this.size + "% size.");
        return this.size;
    }

    /**
     * Rests to regain health
     */
    public void rest() {
        this.health = 100;
        System.out.println("Superman rests and regains his strength. Health is now full.");
    }

    /**
     * Undo's all actions by resetting Superman's attributes
     */
    public void undo() {
        this.health = 100;
        this.size = 100;
        this.xPosition = 0;
        this.yPosition = 0;
        System.out.println("Superman's attributes have been reset to their original values.");
        System.out.println("Health: " + this.health + ", Size: " + this.size + "%, Position: (" + this.xPosition + ", " + this.yPosition + ")");
    }

    /**
     * Main method to demonstrate the use of all methods in the Superhero class
     */
    public static void main(String[] args) {
        // Create an instance of Superman!
        Superhero superman = new Superhero();
        // Demonstrate grabbing an item
        superman.grab("boulder");
        // Demonstrate dropping an item
        System.out.println(superman.drop("boulder"));
        // Examine an item
        superman.examine("villain");
        // Use an item
        superman.use("shield");
        // Rest to regain health
        superman.rest();
        // Walk in a direction
        superman.walk("north");
        // Fly to a new location
        superman.fly(100, 200);
        // Shrink in size
        superman.shrink();
        // Shrink in size again
        superman.shrink();
        // Grow in size
        superman.grow();
        // Undo to reset attributes to initial state
        superman.undo();
    }
}
