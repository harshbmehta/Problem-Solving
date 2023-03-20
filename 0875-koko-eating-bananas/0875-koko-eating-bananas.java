class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largestPile = 0;
        for(int pile: piles) {
            largestPile = Math.max(largestPile, pile);
        }
        int left = 0; 
        int right = largestPile;

        while(left < right) {
            int mid = (left+right)/2;
            int hrTot = 0;
            for (int pile : piles) {
                hrTot += Math.ceil((double) pile / mid);
            }

            if(hrTot <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;

    }
}