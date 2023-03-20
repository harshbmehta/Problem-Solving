class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0] == target ?  0 :  -1;
        }
        int left = 0;
        int right = nums.length-1;

        // if only one element in array [1], left = right so `<=`
        while(left <= right) {
            int mid = (left+right)/2;

            if (nums[mid] == target) {
                return mid;
            }

           if(nums[mid] >= nums[left]) {
               if(target < nums[left] || target > nums[mid]) {
                   left = mid + 1;
               } else {
                   right = mid-1;
               }
           } else {
               if(target > nums[right] || target< nums[mid]) {
                   right = mid - 1;
               } else {
                   left = mid+1;
               }
           }
    }
              return -1;
}
}