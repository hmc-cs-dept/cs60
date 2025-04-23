package com.gradescope.spampede;

/**
 * The type of a board cell (wall, open, spam, head, body).
 * 
 * <p>
 * CellType is an enumeration (aka enum) rather than an class. Enumerations are
 * used when we want behavior like a class (i.e. methods), but we want to define
 * a fixed set of values that an enum can take on.
 * </p>
 * 
 * <p>
 * In the declaration of an enum, Java requires that the constants be defined
 * first, prior to any fields or methods. Each constant calls the constructor,
 * possibly with some arguments. When there are fields and methods, the list of
 * enum constants must end with a semicolon.
 * </p>
 * 
 * <p>
 * Because an enum can only take on particular values, we want to prevent people
 * from making additional objects of the type. Notice that the constructor is
 * private. We get an error if we try to make the constructor public!
 * </p>
 * 
 * <p>
 * Instead of creating this enum, we could have had BoardCell store a String
 * (e.g. "*", "X", "H", "B", or " ") to keep track of the type. However, with
 * this approach, if we accidentally set the type to be "M" or some other
 * invalid String, we would not get a compile error! But, i we use this enum
 * (i.e. CellType), Java prevents us from setting the type of a BoardCell to
 * something invalid.
 * </p>
 * 
 * <p>
 * STYLE NOTE: No other class except BoardCell needs to know that CellType
 * exists. So it would be better to define this enum and set it as private
 * inside of BoardCell. But since we are introducing enums for the first time,
 * we thought that approach would be more confusing! Instead, as a compromise,
 * we decided to limit the enum so that nobody outside the package can access
 * it.
 * </p>
 * 
 * @author CS60 instructors
 */
enum CellType {
	WALL("*"), OPEN(" "), SPAM("X"), HEAD("H"), BODY("B");

	private final String displayChar;

	private CellType(String inputChar) {
		displayChar = inputChar;
	}

	/** Returns a String representing the CellType */
	public String getDisplayChar() {
		return displayChar;
	}

}
