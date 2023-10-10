class Solution {
    public int minTimeToType(String word) {
        int minTime = word.length();
        char prevChar = 'a';
        for(int i=0; i<word.length();i++) {
            char currCh = word.charAt(i);
            int distance = Math.abs(currCh - prevChar);
            minTime += Math.min(distance, 26-distance);
            prevChar = currCh;
        }
        
        return minTime;
    }
}