package com.gradescope.hw7;

import java.util.ArrayList;

/**
 * A table at the Hoch with chairs and people. Hoch tables are never full!
 * (There's always room for N+1.)
 */
public class HochTable {
    /**
     * The default number of chairs.
     */
    public static final int NUMBER_OF_CHAIRS = 6;

    private int numChairs;
    private int numPeople;
    private ArrayList<String> people;

    /**
     * Constructs a table with the default number of chairs.
     */
    public HochTable() {
        this(HochTable.NUMBER_OF_CHAIRS);
    }

    /**
     * Constructs a table with the specified number of chairs.
     * 
     * @param capacity - the number of seats
     * @throws IllegalArgumentException if the capacity is less than 0
     */
    public HochTable(int capacity) {
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
     * Returns true because Hoch tables are never full.
     */
    public boolean emptySeat() {
        return true;
    }

    /**
     * Adds a person to this table if there is space.
     * 
     * @param name the name of the person to add
     * @return a welcome message
     */
    public String addPerson(String name) {
        // add a chair if needed
        if (this.numChairs == this.numPeople) {
            this.numChairs++;
        }

        // greet the person
        if (this.emptySeat()) {
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

    /**
     * Clears the table as everyone goes to class.
     * 
     * @return a goodbye message
     */
    public String classStartingSoon() {
        String message;
        if (this.numPeople > 1) {
            message = "(Silence - everyone runs to class.)";
        } else {
            message = "(Silence - no one is here to say goodbye.)";
        }
        this.numPeople = 0;
        this.people.clear();
        return message;
    }
}
