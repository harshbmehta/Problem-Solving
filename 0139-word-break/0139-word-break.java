// Time Complexity: O(m.n^2) where m is the length of wordDict and n is length of s
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // adding true at the last index

        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }

        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (
                    ((i + word.length()) <= s.length()) &&
                    (s.substring(i, i + word.length()).startsWith(word))
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}