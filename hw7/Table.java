package com.gradescope.hw7;

// ArrayLists are common and helpful!
// Read more about how to use ArrayLists:
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

/**
 * A table with chairs and people.
 */
public class Table {
    /**
     * The default number of chairs.
     */
    public static final int NUMBER_OF_CHAIRS = 5;

    private int numChairs;
    private int numPeople;
    private ArrayList<String> people;

    /**
     * Constructs a table with the default number of chairs.
     */
    public Table() {
        this(Table.NUMBER_OF_CHAIRS);
    }

    /**
     * Constructs a table with the specified number of chairs.
     * 
     * @param capacity - the number of seats
     * @throws IllegalArgumentException if the capacity is less than 0
     */
    public Table(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Tables must start with a capacity of 0 or more");
        }
        this.numChairs = capacity;
        this.numPeople = 0;
        this.people = new ArrayList<String>();
    }

    /**
     * Returns the number of chairs at this table.
     */
    public int getNumChairs() {
        return this.numChairs;
    }

    /**
     * Returns the number of people at this table.
     */
    public int getNumPeople() {
        return this.numPeople;
    }

    /**
     * Returns list of people at this table.
     */
    public String getPeople() {
        return this.people.toString();
    }

    /**
     * Returns true if there are fewer people than seats at this table.
     */
    public boolean emptySeat() {
        return this.numPeople < this.numChairs;
    }

    /**
     * Adds a person to this table if there is space.
     * 
     * @param name - the name of the person to add
     * @return a welcome message
     */
    public String addPerson(String name) {
        if (emptySeat()) {
            this.numPeople++;
            this.people.add(name);
            if (this.numPeople == 1) {
                return "(Silence - no one is here to say hello.)";
            }
            return "Welcome " + name + "!";
        } else {
            if (this.numPeople == 0) {
                return "(Silence - no one is here to say sorry.)";
            }
            return "Sorry - there is no space for you " + name + ".";
        }
    }

    /**
     * Removes a person from this table.
     * 
     * @param name - the name of the person to remove
     * @return a goodbye message
     */
    public String removePerson(String name) {
        boolean wasRemoved = this.people.remove(name);
        if (!wasRemoved) {
            return "Weird! " + name + " was not here!";
        }

        this.numPeople--;
        if (this.numPeople == 0) {
            return "(Silence - no one is here to say goodbye.)";
        }
        return "Bye " + name + ".";
    }
}
