package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevealCardsIncreasingOrder {
  public static int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    List<Integer> newDeck = new ArrayList<>();
    for (int i = deck.length-1; i >= 0; i--) {
      newDeck.add(0, deck[i]);
      newDeck.add(1, newDeck.get(newDeck.size() - 1));
      newDeck.remove(newDeck.size() - 1);
    }
    return newDeck.stream().mapToInt(i->i).toArray();
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] result = deckRevealedIncreasing(array);
    System.out.println(Arrays.toString(result));
  }
}
