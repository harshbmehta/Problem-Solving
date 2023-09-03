// O(N) solution using modified bucket sort

class Solution {
     /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
     public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> count = new HashMap<>();
         List<Integer> bucket[] = new ArrayList[nums.length+1];
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
         // Create buckets of freq -> list of elements with that frequency
      for (int key : count.keySet()){
            int freq = count.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (bucket[i] != null)
                for (int val : bucket[i]){
                    res[index++] = val;
                    if(index == k)
                        return res;
                }
        return res;
     }
}

// O(nLogK) solution

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> freq= new HashMap<>();
//         int[] res = new int[k];

//         for (int i: nums) {
//             freq.put(i, freq.getOrDefault(i, 0)+1);
//         }

//         List<Map.Entry<Integer,Integer>> entryLs = new ArrayList<>(freq.entrySet());

//         Collections.sort(entryLs, new Comparator<Map.Entry<Integer, Integer>> () {
//             public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                 if(o1.getValue() == o2.getValue()) return o1.getKey()-o2.getKey();
//                 else return o2.getValue()-o1.getValue();
//             }
//         });

//         for(int i=0;i<k; i++) {
//             res[i] = entryLs.get(i).getKey();
//         }

//         return res;
//     }
// }