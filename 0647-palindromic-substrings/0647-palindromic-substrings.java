class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0) {
            return 0;
        }
        
        int count=0;
        for(int i=0; i<s.length();i++) {
            count += extractPalindrome(s, i, i);
            count += extractPalindrome(s, i, i+1);
        }
        
        return count;
    }
    
    private int extractPalindrome(String s, int i, int j) {
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        
        return count;
    }
}