public enum Suit {
  DIAMONDS('D', '♦', "Diamonds"),
  CLUBS('C', '♣', "Clubs"),
  HEARTS('H', '♥', "Hearts"),
  SPADES('S', '♠', "Spades");

  private final char symbolChar;
  private final char displaySymbol;
  private final String fullName;

  Suit(char symbolChar, char displaySymbol, String fullName) {
    this.symbolChar = symbolChar;
    this.displaySymbol = displaySymbol;
    this.fullName = fullName;
  }

  public char getSymbolChar() {
    return symbolChar;
  }

  public char getDisplaySymbol() {
    return displaySymbol;
  }

  public String getFullName() {
    return fullName;
  }

  public static Suit fromChar(char c) {
    for (Suit suit : values()) {
      if (suit.symbolChar == Character.toUpperCase(c)) {
        return suit;
      }
    }
    throw new IllegalArgumentException("Invalid suit character: " + c);
  }
}
