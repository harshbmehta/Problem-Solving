import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0, right = 0;
        Set<Character> charSet = new HashSet<>();
        while(right < s.length()) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            right++;
            res = Math.max(res, right-left);
        }

        return res;
      }
}