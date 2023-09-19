class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pque = new PriorityQueue<>((a,b)->(b-a));
        // PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder()); // slower


        for(int stone: stones) {
            pque.offer(stone);
        }

        while(pque.size() > 1) {
            int stone1 = pque.poll();
            int stone2 = pque.poll();

            int weightDiff = stone1 > stone2 ? stone1-stone2: stone2-stone1;
            if(weightDiff != 0) {
                pque.offer(weightDiff);
            }
        }

        return pque.size() == 0? 0: pque.poll();

    }
}