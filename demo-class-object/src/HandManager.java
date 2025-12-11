public class HandManager {
  // attribute
  private Card[] cards;

  // constructor
  public HandManager(Card[] cards) {
    this.cards = cards;
  }

  // method
  public boolean isFlush() {
    if (cards.length != 5) return false;
    char firstSuit = cards[0].getSuit();

    for (int i = 1; i < cards.length; i++) {
      if (cards[i].getSuit() != firstSuit) {
        return false; // Found a card with different suit
      }
    }

    return true;
  }

  // Helper method to convert rank char to array index
  private int rankToIndex(char rank) {
    switch (rank) {
      case 'A': return 0;
      case '2': return 1;
      case '3': return 2;
      case '4': return 3;
      case '5': return 4;
      case '6': return 5;
      case '7': return 6;
      case '8': return 7;
      case '9': return 8;
      case 'T': return 9;
      case 'J': return 10;
      case 'Q': return 11;
      case 'K': return 12;
      default: return -1; // Should not happen
    }
  }

  public boolean isFullHouse() {
    if (cards.length != 5) return false;
    
    // Count how many cards of each rank we have
    int[] rankCounts = new int[13]; // Index: 0=A, 1=2, 2=3, ..., 8=9, 9=T, 10=J, 11=Q, 12=K
    
    // Fill the rankCounts array
    for (Card card : cards) {
      char rank = card.getRank();  // ← Only checking RANK, not suit!
      int index = rankToIndex(rank);
      rankCounts[index]++;
    }
    
    // Check for Full House pattern
    boolean hasThree = false;
    boolean hasTwo = false;
    
    for (int count : rankCounts) {
      if (count == 3) hasThree = true;
      else if (count == 2) hasTwo = true;
    }
    
    return hasThree && hasTwo;
  }

  // main method
  public static void main(String[] args) {
    // test





  }
}
