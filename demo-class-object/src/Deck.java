public class Deck {
  // static
  public static final char[] SUITS = new char[] 
  {'D', 'C', 'H', 'S'};
  public static final char[] RANKS = new char[] 
  {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

  // attribute
  private Card[] cards;

  // constructor
  public Deck() {
    cards = new Card[52];
    int cardIndex = 0;
    for (char suit : SUITS) {
      for (char rank : RANKS) {
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
