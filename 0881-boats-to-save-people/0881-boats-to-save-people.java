class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        int ans = 0;
        
        while(left<=right) {
            ans++;
            if(people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
        }
        return ans;
    }
}