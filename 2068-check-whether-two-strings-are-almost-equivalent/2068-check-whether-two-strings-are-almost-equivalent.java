class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freqWord1 = new int[26];
        
        for(char ch: word1.toCharArray()) {
            freqWord1[ch - 'a']++;
        }
        
        for(char ch: word2.toCharArray()) {
            freqWord1[ch - 'a']--;
        }
        
        for(int i=0; i<26; i++) {
            if(freqWord1[i] < -3 || freqWord1[i] > 3) {
                return false;
            }
        }
        return true;
    }
}