class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        findCombinations(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void findCombinations(int[] nums, int remain, int start, List tempList) {
        if(remain < 0) {
            return;
        }
        if(remain == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start; i<nums.length;i++) {
            tempList.add(nums[i]);
            findCombinations(nums, remain - nums[i], i, tempList);
            tempList.remove(tempList.size() - 1);
        }

    }
}