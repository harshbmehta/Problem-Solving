// class Solution {
//     public int trap(int[] height) {
//         int result = 0;
//         int start = 0;
//         int end = height.length - 1;
//         while (start < end) {
//             if (height[start] <= height[end]) {
//                 int current = height[start];
//                 while (height[++start] < current) {
//                     result += current - height[start];
//                 }
//             } else {
//                 int current = height[end];
//                 while(height[--end] < current) {
//                     result += current - height[end];
//                 }
//             }
//         }
//         return result;
//     }
// }
class Solution {

    public int trap(int[] heights) {
        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }

        return res;
    }
}

