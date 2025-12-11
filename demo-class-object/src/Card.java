public class Card {
  // attribute
  private char suit; // D C H S
  private char rank; // A 2 3 4 5 6 7 8 9 T J Q K

  // constructor
  public Card(char suit, char rank) {
    this.suit = suit;
    this.rank = rank;
  }

  // method

  // getter
  public char getRank() {
    return rank;
  }

  public char getSuit() {
    return suit;
  }

  // toString
  @Override
  public String toString() {
    // Convert rank character to readable string
    String rankString;
    switch (rank) {
      case 'A': rankString = "A"; break;
      case 'T': rankString = "10"; break;
      case 'J': rankString = "J"; break;
      case 'Q': rankString = "Q"; break;
      case 'K': rankString = "K"; break;
      default: rankString = String.valueOf(rank); // 2-9
    }
    
    // Convert suit character to full name
    String suitString = "";
    switch (suit) {
      case 'D': suitString += (char)4; break;
      case 'C': suitString += (char)5; break;
      case 'H': suitString += (char)3; break;
      case 'S': suitString += (char)6; break;
      default: suitString = "Unknown";
    }
    
    return  "(" + suitString + " " + rankString + ")";
  }







  // main method
  public static void main(String[] args) {
    // test
    System.out.println(new Card('D', 'Q'));
    





  }
}