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
    Suit firstSuit = cards[0].getSuit();

    for (int i = 1; i < cards.length; i++) {
      if (cards[i].getSuit() != firstSuit) {
        return false; // Found a card with different suit
      }
    }

    return true;
  }

  // Helper method to convert rank char to array index
  private int rankToIndex(Rank rank) {
    return rank.getValue();
  }

  public boolean isFullHouse() {
    if (cards.length != 5) return false;
    
    // Count how many cards of each rank we have
    int[] rankCounts = new int[13]; // Index: 0=A, 1=2, 2=3, ..., 8=9, 9=T, 10=J, 11=Q, 12=K
    
    // Fill the rankCounts array
    for (Card card : cards) {
      Rank rank = card.getRank();  // ← Only checking RANK, not suit!
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
    Card[] flushHand = {
      new Card(Suit.HEARTS, Rank.TWO),
      new Card(Suit.HEARTS, Rank.FIVE),
      new Card(Suit.HEARTS, Rank.NINE),
      new Card(Suit.HEARTS, Rank.JACK),
      new Card(Suit.HEARTS, Rank.KING)
    };
    HandManager flushManager = new HandManager(flushHand);
    System.out.println("Is Flush: " + flushManager.isFlush()); // Expected: true

    Card[] nonFlushHand = {
      new Card(Suit.HEARTS, Rank.TWO),
      new Card(Suit.DIAMONDS, Rank.FIVE),
      new Card(Suit.HEARTS, Rank.NINE),
      new Card(Suit.HEARTS, Rank.JACK),
      new Card(Suit.HEARTS, Rank.KING)
    };
    HandManager nonFlushManager = new HandManager(nonFlushHand);
    System.out.println("Is Flush: " + nonFlushManager.isFlush()); // Expected: false

    Card[] fullHouseHand = {
      new Card(Suit.CLUBS, Rank.THREE),
      new Card(Suit.DIAMONDS, Rank.THREE),
      new Card(Suit.HEARTS, Rank.THREE),
      new Card(Suit.SPADES, Rank.SIX),
      new Card(Suit.HEARTS, Rank.SIX)
    };
    HandManager fullHouseManager = new HandManager(fullHouseHand);
    System.out.println("Is Full House: " + fullHouseManager.isFullHouse()); // Expected: true

    Card[] nonFullHouseHand = {
      new Card(Suit.CLUBS, Rank.THREE),
      new Card(Suit.DIAMONDS, Rank.THREE),
      new Card(Suit.HEARTS, Rank.FOUR),
      new Card(Suit.SPADES, Rank.SIX),
      new Card(Suit.HEARTS, Rank.SIX)
    };
    HandManager nonFullHouseManager = new HandManager(nonFullHouseHand);
    System.out.println("Is Full House: " + nonFullHouseManager.isFullHouse()); // Expected: false





  }
}
