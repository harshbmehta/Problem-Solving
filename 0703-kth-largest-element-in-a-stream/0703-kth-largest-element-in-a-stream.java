class KthLargest {
    PriorityQueue<Integer> pque;
    int kth = 0;

    public KthLargest(int k, int[] nums) {
        pque = new PriorityQueue<>();
        kth = k;
        for (int n: nums) {
            pque.offer(n);
        }

        while(pque.size()>k) {
            pque.poll();
        }
    }
    
    public int add(int val) {
        pque.offer(val);

        if(pque.size()>kth) {
            pque.poll();
        }
        return pque.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */