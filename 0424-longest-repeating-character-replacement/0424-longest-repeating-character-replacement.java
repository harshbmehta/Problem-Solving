//https://leetcode.com/problems/longest-repeating-character-replacement/solutions/2805777/longest-repeating-character-replacement/

/* Time: O(n): In this approach, we access each index of the string at most two times. When it is added to the sliding window, and when it is removed from the sliding window. The sliding window always moves forward. In each step, we update the frequency map, maxFrequency, and check for validity, they are all constant-time operations. To sum up, the time complexity is proportional to the number of characters in the string - O(n).

Space: O(1): Similar to the previous approaches, this approach requires an auxiliary frequency map. The maximum number of keys in the map equals the number of unique characters in the string. If there are mmm unique characters, then the memory required is proportional to m. So the space complexity is O(m). Considering uppercase English letters only, m=26.
*/

class Solution {    
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int res = 0;

        for(int right = 0; right<s.length(); right++) {
            int currCh = s.charAt(right) - 'A';
            freq[currCh]++;

            if(freq[currCh] > maxFreq) {
                maxFreq = freq[currCh];
            }

            boolean isValid = (right - left + 1 - maxFreq) <= k? true: false;
            if(!isValid) {
                int outgoingChar = s.charAt(left) - 'A';
                freq[outgoingChar] --;
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}