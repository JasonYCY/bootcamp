public enum Direction {
  NORTH('N'),
  EAST('E'),
  SOUTH('S'),
  WEST('W');

  private char value;

  private Direction(char value) {
    this.value = value;
  }

  public char getValue() {
    return value;
  }

  public boolean isOpposite(Direction other) {
    return (this == NORTH && other == SOUTH) ||
           (this == SOUTH && other == NORTH) ||
           (this == EAST && other == WEST) ||
           (this == WEST && other == EAST);
  }
  

  // main method for demonstration purposes
  public static void main(String[] args) {
    Direction dir1 = Direction.NORTH;
    Direction dir2 = Direction.SOUTH;
    System.out.println("Direction 1: " + dir1 + " (" + dir1.getValue() + ")");
    System.out.println("Direction 2: " + dir2 + " (" + dir2.getValue() + ")");
    System.out.println("Are Direcction 1 and Direction 2 opposite? " + dir1.isOpposite(dir2));

    Direction dir3 = Direction.EAST;
    System.out.println("Direction 3: " + dir3 + " (" + dir3.getValue() + ")");
    System.out.println("Are Direction 1 and Direction 3 opposite? " + dir1.isOpposite(dir3));
  }
}
