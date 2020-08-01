package LeetCode;

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int compl = 0;
        while (i >= 0 || j >= 0) {
            int sum_a = i < 0 ? 0 : a.charAt(i--) - '0';
            int sum_b = j < 0 ? 0 : b.charAt(j--) - '0';
            int _sum = sum_a + sum_b + compl;
            compl = _sum > 1 ? 1 : 0;
            res.append(_sum % 2);
        }
        if (compl != 0) res.append(compl);
        return res.reverse().toString();
    }
}
