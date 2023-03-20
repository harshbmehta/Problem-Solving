class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;

        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if(!Character.isLetter(lc) && !Character.isDigit(lc)) {
                left++;
                continue;
            }

            if(!Character.isLetter(rc) && !Character.isDigit(rc)) {
                right--;
                continue;
            }

            if(Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}