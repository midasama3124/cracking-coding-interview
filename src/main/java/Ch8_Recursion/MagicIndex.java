package Ch8_Recursion;

public class MagicIndex {
  static int findMagicIndex(int[] array) {
    int l = 0;
    int r = array.length - 1;
    int magicIndex = findMagicIndex(array, l, r);
    return magicIndex;
  }

  // Find magic index recursively by implementing binary search
  private static int findMagicIndex(int[] array, int l, int r) {
    if (r >= l) {
      int midIndex = (l+r)/2;
      int midValue = array[midIndex];

      // If magic index is in the middle
      if (midValue == midIndex) return midIndex;

      // If element is smaller than mid, recurse left subarray
      int leftIndex = Math.min(midIndex-1, midValue);
      int left = findMagicIndex(array, l, leftIndex);
      if (left >= 0) {
        return left;
      }

      // Else, recurse right subarray
      int rightIndex = Math.max(midIndex+1, midValue);
      int right = findMagicIndex(array, rightIndex, r);
      return right;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {-2, 3, 4, 5, 6, 6, 6, 6, 9, 12, 13, 14, 15, 17, 19, 25};
    System.out.println(findMagicIndex(arr));
  }
}
