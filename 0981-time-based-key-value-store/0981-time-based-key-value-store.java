/*
Time complexity:

In the set() function, in each call, we push a (timestamp, value) pair in the key bucket, which takes O(L) time to hash the string. Thus, for M calls overall it will take, $O(M.L)$ time.

In the get() function, we use binary search on the key's bucket which can have at most M elements and to hash the string it takes O(L)O(L)O(L) time, thus overall it will take O(L⋅logM)O(L \cdot logM)O(L⋅logM) time for binary search.
And, for N calls overall it will take, $O(N \cdot L \cdot logM)$ time.

Space complexity:

In the set() function, in each call we store one value string of length L, which takes O(L) space.
Thus, for M calls we may store M unique values, so overall it may take O(M⋅L) space.

In the get() function, we are not using any additional space.
Thus, for all N calls it is a constant space operation.

*/


class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;
    
    public TimeMap() {
        keyTimeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        if (timestamp < keyTimeMap.get(key).get(0).getKey()) {
            return "";
        }
        
        // Using binary search on the list of pairs.
        int left = 0;
        int right = keyTimeMap.get(key).size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }
                
        return keyTimeMap.get(key).get(right - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */