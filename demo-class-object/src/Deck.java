public class Deck {
  // static
  public static final Suit[] SUITS = new Suit[] {
    Suit.DIAMONDS,
    Suit.CLUBS,
    Suit.HEARTS,
    Suit.SPADES
  };

  public static final Rank[] RANKS = new Rank[] {
    Rank.ACE,
    Rank.TWO,
    Rank.THREE,
    Rank.FOUR,
    Rank.FIVE,
    Rank.SIX,
    Rank.SEVEN,
    Rank.EIGHT,
    Rank.NINE,
    Rank.TEN,
    Rank.JACK,
    Rank.QUEEN,
    Rank.KING
  };

  // attribute
  private Card[] cards;

  // constructor
  public Deck() {
    cards = new Card[52];
    int cardIndex = 0;
    for (Suit suit : SUITS) {
      for (Rank rank : RANKS) {
        cards[cardIndex] = new Card(suit, rank);
        cardIndex++;
      }
    }
  }

  // method

  // getter
  public Card[] getCards() {
    return cards;
  }

  // toString
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    int cardsPerRow = 13; // 13 ranks per suit
    
    for (int i = 0; i < cards.length; i++) {
      // Add the current card
      builder.append(cards[i].toString());
      
      // Add spacing between cards (except after the last card)
      if (i < cards.length - 1) {
        builder.append("  ");
      }
      
      // Add newline after every 13th card (except after the last card)
      if ((i + 1) % cardsPerRow == 0 && i < cards.length - 1) {
        builder.append("\n");
      }
    }
    
    return builder.toString();
  }






  // main method
  public static void main(String[] args) {
    // test
    Deck deck = new Deck();
    System.out.println(deck);









  }
}
