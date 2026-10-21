class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            heap.offer(stones[i]);
        }

        while(heap.size() > 1){
            int f = heap.poll();
            int s = heap.poll();

            if(f != s){
                heap.offer(f-s);
            }

            
        }

        if(heap.isEmpty()){
            return 0;
        }else{
            return heap.poll();
        }
    }
}