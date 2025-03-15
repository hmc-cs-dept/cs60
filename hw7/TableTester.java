package com.gradescope.hw7;

import static org.junit.Assert.*;
import org.junit.Test;

public class TableTester {

    /********************
     * Tests constructors with acceptable and unacceptable input
     ********************/

    @Test
    public void testTable() {
        new Table();
        new Table(0);
        new Table(100);
    }

    @Test
    public void testSnackTable() {
        new SnackTable();
        new SnackTable(0);
        new SnackTable(100);
    }

    @Test
    public void testHochTable() {
        new HochTable();
        new HochTable(0);
        new HochTable(100);
    }

    @Test
    public void testSuperFriendlyHochTable() {
        new SuperFriendlyHochTable();
        new SuperFriendlyHochTable(0);
        new SuperFriendlyHochTable(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTable_ConstructorError() {
        new Table(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSnackTable_ConstructorError() {
        new SnackTable(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHochTable_ConstructorError() {
        new HochTable(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSuperFriendlyHochTable_ConstructorError() {
        new SuperFriendlyHochTable(-5);
    }

    /********************
     * Tests getters
     ********************/

    @Test
    public void testTableGetNumChairs() {
        Table t = new Table();
        assertEquals(Table.NUMBER_OF_CHAIRS, t.getNumChairs());

        Table t0 = new Table(0);
        assertEquals(0, t0.getNumChairs());

        Table t100 = new Table(100);
        assertEquals(100, t100.getNumChairs());
    }

    @Test
    public void testTableGetNumPeople() {
        Table t = new Table();
        assertEquals(0, t.getNumPeople());

        Table t0 = new Table(0);
        assertEquals(0, t0.getNumPeople());

        Table t100 = new Table(100);
        assertEquals(0, t100.getNumPeople());
    }

    @Test
    public void testTableGetPeople() {
        Table t = new Table();
        assertEquals("[]", t.getPeople());

        Table t0 = new Table(0);
        assertEquals("[]", t0.getPeople());

        Table t100 = new Table(100);
        assertEquals("[]", t100.getPeople());
    }

    @Test
    public void testSnackTableGetNumChairs() {
        SnackTable t = new SnackTable();
        assertEquals(SnackTable.NUMBER_OF_CHAIRS, t.getNumChairs());

        SnackTable t0 = new SnackTable(0);
        assertEquals(0, t0.getNumChairs());

        SnackTable t100 = new SnackTable(100);
        assertEquals(100, t100.getNumChairs());
    }

    @Test
    public void testSnackTableGetNumPeople() {
        SnackTable t = new SnackTable();
        assertEquals(0, t.getNumPeople());

        SnackTable t0 = new SnackTable(0);
        assertEquals(0, t0.getNumPeople());

        SnackTable t100 = new SnackTable(100);
        assertEquals(0, t100.getNumPeople());
    }

    @Test
    public void testSnackTableGetPeople() {
        SnackTable t = new SnackTable();
        assertEquals("[]", t.getPeople());

        SnackTable t0 = new SnackTable(0);
        assertEquals("[]", t0.getPeople());

        SnackTable t100 = new SnackTable(100);
        assertEquals("[]", t100.getPeople());
    }

    @Test
    public void testHochTableGetNumChairs() {
        HochTable t = new HochTable();
        assertEquals(HochTable.NUMBER_OF_CHAIRS, t.getNumChairs());

        HochTable t0 = new HochTable(0);
        assertEquals(0, t0.getNumChairs());

        HochTable t100 = new HochTable(100);
        assertEquals(100, t100.getNumChairs());
    }

    @Test
    public void testHochTableGetNumPeople() {
        HochTable t = new HochTable();
        assertEquals(0, t.getNumPeople());

        HochTable t0 = new HochTable(0);
        assertEquals(0, t0.getNumPeople());

        HochTable t100 = new HochTable(100);
        assertEquals(0, t100.getNumPeople());
    }

    @Test
    public void testHochTableGetPeople() {
        HochTable t = new HochTable();
        assertEquals("[]", t.getPeople());

        HochTable t0 = new HochTable(0);
        assertEquals("[]", t0.getPeople());

        HochTable t100 = new HochTable(100);
        assertEquals("[]", t100.getPeople());
    }

    @Test
    public void testSuperFriendlyHochTableGetNumChairs() {
        SuperFriendlyHochTable t = new SuperFriendlyHochTable();
        assertEquals(SuperFriendlyHochTable.NUMBER_OF_CHAIRS, t.getNumChairs());

        SuperFriendlyHochTable t0 = new SuperFriendlyHochTable(0);
        assertEquals(0, t0.getNumChairs());

        SuperFriendlyHochTable t100 = new SuperFriendlyHochTable(100);
        assertEquals(100, t100.getNumChairs());
    }

    @Test
    public void testSuperFriendlyHochTableGetNumPeople() {
        SuperFriendlyHochTable t = new SuperFriendlyHochTable();
        assertEquals(0, t.getNumPeople());

        SuperFriendlyHochTable t0 = new SuperFriendlyHochTable(0);
        assertEquals(0, t0.getNumPeople());

        SuperFriendlyHochTable t100 = new SuperFriendlyHochTable(100);
        assertEquals(0, t100.getNumPeople());
    }

    @Test
    public void testSuperFriendlyHochTableGetPeople() {
        SuperFriendlyHochTable t = new SuperFriendlyHochTable();
        assertEquals("[]", t.getPeople());

        SuperFriendlyHochTable t0 = new SuperFriendlyHochTable(0);
        assertEquals("[]", t0.getPeople());

        SuperFriendlyHochTable t100 = new SuperFriendlyHochTable(100);
        assertEquals("[]", t100.getPeople());
    }

    /********************
     * Tests emptySeat
     ********************/

    @Test
    public void testTableEmptySeat() {
        Table t0 = new Table(0);
        assertFalse(t0.emptySeat());

        Table t1 = new Table(1);
        assertTrue(t1.emptySeat());
    }

    @Test
    public void testSnackTableEmptySeat() {
        SnackTable t0 = new SnackTable(0);
        assertFalse(t0.emptySeat());

        SnackTable t1 = new SnackTable(1);
        assertTrue(t1.emptySeat());
    }

    @Test
    public void testHochTableEmptySeat() {
        HochTable t0 = new HochTable(0);
        assertTrue(t0.emptySeat());

        HochTable t1 = new HochTable(1);
        assertTrue(t1.emptySeat());
    }

    @Test
    public void testSuperFriendlyHochTableEmptySeat() {
        SuperFriendlyHochTable t0 = new SuperFriendlyHochTable(0);
        assertTrue(t0.emptySeat());

        SuperFriendlyHochTable t1 = new SuperFriendlyHochTable(1);
        assertTrue(t1.emptySeat());
    }

    /********************
     * Tests addPerson
     ********************/

    @Test
    public void testTableAddPerson() {
        String salutation;

        Table t0 = new Table(0);
        salutation = t0.addPerson("Katherine");
        assertEquals(0, t0.getNumChairs());
        assertEquals(0, t0.getNumPeople());
        assertEquals("(Silence - no one is here to say sorry.)", salutation);

        Table t2 = new Table(2);
        salutation = t2.addPerson("Beth");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        salutation = t2.addPerson("Jim");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Welcome Jim!", salutation);

        salutation = t2.addPerson("Wally");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Sorry - there is no space for you Wally.", salutation);

        assertEquals("[Beth, Jim]", t2.getPeople());
    }

    @Test
    public void testSnackTableAddPerson() {
        String salutation;

        SnackTable t0 = new SnackTable(0);
        salutation = t0.addPerson("Katherine");
        assertEquals(0, t0.getNumChairs());
        assertEquals(0, t0.getNumPeople());
        assertEquals("(Silence - no one is here to say sorry.)", salutation);

        SnackTable t2 = new SnackTable(2);
        salutation = t2.addPerson("Beth");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        salutation = t2.addPerson("Jim");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Welcome Jim!", salutation);

        salutation = t2.addPerson("Wally");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Sorry - there is no space for you Wally.", salutation);

        assertEquals("[Beth, Jim]", t2.getPeople());
    }

    @Test
    public void testHochTableAddPerson() {
        String salutation;

        HochTable t0 = new HochTable(0);
        salutation = t0.addPerson("Katherine");
        assertEquals(1, t0.getNumChairs());
        assertEquals(1, t0.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        HochTable t2 = new HochTable(2);
        salutation = t2.addPerson("Beth");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        salutation = t2.addPerson("Jim");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Welcome Jim!", salutation);

        salutation = t2.addPerson("Wally");
        assertEquals(3, t2.getNumChairs());
        assertEquals(3, t2.getNumPeople());
        assertEquals("Welcome Wally!", salutation);

        assertEquals("[Beth, Jim, Wally]", t2.getPeople());
    }

    @Test
    public void testSuperFriendlyHochTableAddPerson() {
        String salutation;

        SuperFriendlyHochTable t0 = new SuperFriendlyHochTable(0);
        salutation = t0.addPerson("Katherine");
        assertEquals(1, t0.getNumChairs());
        assertEquals(1, t0.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        SuperFriendlyHochTable t2 = new SuperFriendlyHochTable(2);
        salutation = t2.addPerson("Beth");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say hello.)", salutation);

        salutation = t2.addPerson("Jim");
        assertEquals(2, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Welcome Jim! Thanks Beth!!!!!", salutation);

        salutation = t2.addPerson("Wally");
        assertEquals(3, t2.getNumChairs());
        assertEquals(3, t2.getNumPeople());
        assertEquals("Welcome Wally! Thanks Beth, Jim!!!!!", salutation);

        assertEquals("[Beth, Jim, Wally]", t2.getPeople());
    }

    /********************
     * Tests removePerson
     ********************/

    @Test
    public void testTableRemovePerson() {
        String salutation;

        Table t3 = new Table(3);
        t3.addPerson("Beth");
        salutation = t3.removePerson("Alien");
        assertEquals(3, t3.getNumChairs());
        assertEquals(1, t3.getNumPeople());
        assertEquals("Weird! Alien was not here!", salutation);

        t3.addPerson("Jim");
        t3.addPerson("Wally");
        salutation = t3.removePerson("Jim");
        assertEquals(3, t3.getNumChairs());
        assertEquals(2, t3.getNumPeople());
        assertEquals("Bye Jim.", salutation);

        salutation = t3.removePerson("Jim");
        assertEquals(3, t3.getNumChairs());
        assertEquals(2, t3.getNumPeople());
        assertEquals("Weird! Jim was not here!", salutation);

        salutation = t3.removePerson("Beth");
        assertEquals(3, t3.getNumChairs());
        assertEquals(1, t3.getNumPeople());
        assertEquals("Bye Beth.", salutation);

        salutation = t3.removePerson("Wally");
        assertEquals(3, t3.getNumChairs());
        assertEquals(0, t3.getNumPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);
    }

    @Test
    public void testSnackTableRemovePerson() {
        String salutation;

        SnackTable t3 = new SnackTable(3);
        t3.addPerson("Beth");
        salutation = t3.removePerson("Alien");
        assertEquals(3, t3.getNumChairs());
        assertEquals(1, t3.getNumPeople());
        assertEquals("Weird! Alien was not here!", salutation);

        t3.addPerson("Jim");
        t3.addPerson("Wally");
        salutation = t3.removePerson("Jim");
        assertEquals(3, t3.getNumChairs());
        assertEquals(2, t3.getNumPeople());
        assertEquals("Bye Jim.", salutation);

        salutation = t3.removePerson("Jim");
        assertEquals(3, t3.getNumChairs());
        assertEquals(2, t3.getNumPeople());
        assertEquals("Weird! Jim was not here!", salutation);

        salutation = t3.removePerson("Beth");
        assertEquals(3, t3.getNumChairs());
        assertEquals(1, t3.getNumPeople());
        assertEquals("Bye Beth.", salutation);

        salutation = t3.removePerson("Wally");
        assertEquals(3, t3.getNumChairs());
        assertEquals(0, t3.getNumPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);
    }

    @Test
    public void testHochTableRemovePerson() {
        String salutation;

        HochTable t2 = new HochTable(2);
        t2.addPerson("Beth");
        salutation = t2.removePerson("Alien");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("Weird! Alien was not here!", salutation);

        t2.addPerson("Jim");
        t2.addPerson("Wally");
        salutation = t2.removePerson("Jim");
        assertEquals(3, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Bye Jim.", salutation);

        salutation = t2.removePerson("Jim");
        assertEquals(3, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Weird! Jim was not here!", salutation);

        salutation = t2.removePerson("Beth");
        assertEquals(3, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("Bye Beth.", salutation);

        salutation = t2.removePerson("Wally");
        assertEquals(3, t2.getNumChairs());
        assertEquals(0, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);
    }

    @Test
    public void testSuperFriendlyHochTableRemovePerson() {
        String salutation;

        SuperFriendlyHochTable t2 = new SuperFriendlyHochTable(2);
        t2.addPerson("Beth");
        salutation = t2.removePerson("Alien");
        assertEquals(2, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("Weird! Alien was not here!", salutation);

        t2.addPerson("Jim");
        t2.addPerson("Wally");
        salutation = t2.removePerson("Jim");
        assertEquals(3, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Bye Jim. Bye Beth, Wally.", salutation);

        salutation = t2.removePerson("Jim");
        assertEquals(3, t2.getNumChairs());
        assertEquals(2, t2.getNumPeople());
        assertEquals("Weird! Jim was not here!", salutation);

        salutation = t2.removePerson("Beth");
        assertEquals(3, t2.getNumChairs());
        assertEquals(1, t2.getNumPeople());
        assertEquals("Bye Beth. Bye Wally.", salutation);

        salutation = t2.removePerson("Wally");
        assertEquals(3, t2.getNumChairs());
        assertEquals(0, t2.getNumPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);
    }

    /********************
     * Tests class-specific methods
     ********************/

    @Test
    public void testSnackTable_SpecificThings() {
        int numSnacks;
        String salutation;

        /**
         * number of seats < number of snacks
         */
        int numChairsSmall = 1;
        SnackTable tSmall = new SnackTable(numChairsSmall);
        numSnacks = SnackTable.BAG_OF_SNACKS;
        assertEquals(0, tSmall.getNumSnacks());

        salutation = tSmall.addHungryPerson("Beth");
        assertEquals(numChairsSmall, tSmall.getNumChairs());
        assertEquals(0, tSmall.getNumPeople());
        assertEquals(0, tSmall.getNumSnacks());
        assertEquals("(Silence - no one is here to say sorry.)", salutation);

        tSmall.addSnacks();
        assertEquals(numChairsSmall, tSmall.getNumChairs());
        assertEquals(0, tSmall.getNumPeople());
        assertEquals(numSnacks, tSmall.getNumSnacks());

        salutation = tSmall.addHungryPerson("Jim");
        numSnacks--;
        assertEquals(numChairsSmall, tSmall.getNumChairs());
        assertEquals(1, tSmall.getNumPeople());
        assertEquals(numSnacks, tSmall.getNumSnacks());
        assertEquals("(Silence - no one is here to say hello.) Jim says yummy!", salutation);

        // chairs exhausted
        salutation = tSmall.addHungryPerson("Wally");
        assertEquals(numChairsSmall, tSmall.getNumChairs());
        assertEquals(1, tSmall.getNumPeople());
        assertEquals(numSnacks, tSmall.getNumSnacks());
        assertEquals("Sorry - there is no space for you Wally.", salutation);

        /**
         * number of seats > number of snacks
         */
        int numChairsLarge = SnackTable.BAG_OF_SNACKS + 2;
        SnackTable tLarge = new SnackTable(numChairsLarge);
        numSnacks = SnackTable.BAG_OF_SNACKS;
        assertEquals(0, tLarge.getNumSnacks());

        salutation = tLarge.addHungryPerson("Beth");
        assertEquals(numChairsLarge, tLarge.getNumChairs());
        assertEquals(0, tLarge.getNumPeople());
        assertEquals(0, tLarge.getNumSnacks());
        assertEquals("(Silence - no one is here to say sorry.)", salutation);

        tLarge.addSnacks();
        assertEquals(numChairsLarge, tLarge.getNumChairs());
        assertEquals(0, tLarge.getNumPeople());
        assertEquals(numSnacks, tLarge.getNumSnacks());

        salutation = tLarge.addHungryPerson("Jim");
        numSnacks--;
        assertEquals(numChairsLarge, tLarge.getNumChairs());
        assertEquals(1, tLarge.getNumPeople());
        assertEquals(numSnacks, tLarge.getNumSnacks());
        assertEquals("(Silence - no one is here to say hello.) Jim says yummy!", salutation);

        // exhaust snacks
        for (int i = numSnacks; i > 0; i--) {
            salutation = tLarge.addHungryPerson("Person " + i);
        }
        assertEquals(numChairsLarge, tLarge.getNumChairs());
        assertEquals(6, tLarge.getNumPeople());
        assertEquals(0, tLarge.getNumSnacks());

        // snacks exhausted
        salutation = tLarge.addHungryPerson("Wally");
        assertEquals(numChairsLarge, tLarge.getNumChairs());
        assertEquals(6, tLarge.getNumPeople());
        assertEquals(0, tLarge.getNumSnacks());
        assertEquals("Sorry - there is no snack for you Wally.", salutation);
    }

    @Test
    public void testHochTableClassStartingSoon() {
        String salutation;

        HochTable t1 = new HochTable(1);
        salutation = t1.classStartingSoon();
        assertEquals(0, t1.getNumPeople());
        assertEquals("[]", t1.getPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);

        HochTable t5 = new HochTable(5);
        t5.addPerson("Beth");
        t5.addPerson("Jim");
        t5.addPerson("Zach");
        t5.addPerson("Melissa");
        t5.addPerson("Julie");
        t5.addPerson("Ben");
        t5.addPerson("Arthi");

        salutation = t5.classStartingSoon();
        assertEquals(0, t5.getNumPeople());
        assertEquals("[]", t5.getPeople());
        assertEquals("(Silence - everyone runs to class.)", salutation);
    }

    @Test
    public void testSuperFriendlyHochTableClassStartingSoon() {
        String salutation;

        SuperFriendlyHochTable t1 = new SuperFriendlyHochTable(1);
        salutation = t1.classStartingSoon();
        assertEquals(0, t1.getNumPeople());
        assertEquals("[]", t1.getPeople());
        assertEquals("(Silence - no one is here to say goodbye.)", salutation);

        SuperFriendlyHochTable t5 = new SuperFriendlyHochTable(5);
        t5.addPerson("Beth");
        t5.addPerson("Jim");
        t5.addPerson("Zach");
        t5.addPerson("Melissa");
        t5.addPerson("Julie");
        t5.addPerson("Ben");
        t5.addPerson("Arthi");

        salutation = t5.classStartingSoon();
        assertEquals(0, t5.getNumPeople());
        assertEquals("[]", t5.getPeople());
        assertEquals("Bye everyone!", salutation);
    }
}
!
