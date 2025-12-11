import java.util.Random;

public class ShuffleHelper {
  // attribute
  private Card[] cards;

  // constructor
  public ShuffleHelper(Card[] cards) {
    this.cards = cards;
  }

  // method
  public void shuffle(int shuffleNumber) {
    Random random = new Random();
    int randomCardIndex;

    for (int i = 0; i < shuffleNumber; i++) {
      randomCardIndex = random.nextInt(52);
      Card pickedCard = cards[randomCardIndex];
      Card temp = cards[0];
      cards[0] = pickedCard;
      cards[randomCardIndex] = temp;
    }
  }

  // main method
  public static void main(String[] args) {
    // test
    Deck deck = new Deck();
    ShuffleHelper helper = new ShuffleHelper(deck.getCards());
    helper.shuffle(1000);
    System.out.println(deck);













  }
}
