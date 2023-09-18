class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer i: nums) {
            if(!numSet.add(i)){
                return i;
            }
        }
        return 0;
}}