class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, max = 0;
        for(int a:arr)
            map.put(a,i++);
        for(i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int count = 0;
                int left = i, right =j;
                int x  = arr[left]+arr[right];
                while(map.containsKey(x)){
                        count++;
                        int y = map.get(x);
                        left = right;
                        right = y;
                        x  = arr[left]+arr[right];
                }
                if(count>0)
                    max = Math.max(count+2, max);
            }
        }
        return max;
    }
}