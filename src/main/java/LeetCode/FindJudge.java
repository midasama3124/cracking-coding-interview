package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class FindJudge {
  public static int findJudge(int N, int[][] trust) {
    // If empty and N=1
    if (trust.length == 0 && N == 1) return 1;
    // Sort trust array
    Arrays.sort(trust, (a, b) -> Integer.compare(a[0], b[0]));
    HashMap<Integer,Integer> possJudges = new HashMap<>();
    // Determine possible judges by people whom the first person trusts
    int i = 0;
    int firstTrusty = trust[0][0];
    while (i < trust.length) {
      if (trust[i][0] == firstTrusty) {
        possJudges.put(trust[i][1], 1);
        i++;
      } else break;
    }
    // Count frequency of possible judges iterating through the rest of people
    int trusty, trusted;
    for (int j = i; j < trust.length && !possJudges.isEmpty(); j++) {
      trusty = trust[j][0];
      if (possJudges.containsKey(trusty)) {
        possJudges.remove(trusty);
      }
      trusted = trust[j][1];
      if (possJudges.containsKey(trusted)) {
        possJudges.replace(trusted, possJudges.get(trusted)+1);
      }
    }
    // Return the possible with a count of N-1, otherwise -1
    for (int possJudge : possJudges.keySet()) {
      if (possJudges.get(possJudge) == N-1) return possJudge;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
    int N = 4;
    System.out.println(findJudge(N, trust));
  }
}
