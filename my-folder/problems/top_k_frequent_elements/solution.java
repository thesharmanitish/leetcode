class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[] unique;
    
    public void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int  partition(int start, int end, int pivot) {
        int frequency = map.get(unique[pivot]);
        swap(unique, pivot, end);
        int store_index = start;
        
        
        for(int i=start;i<end;i++){
            if(map.get(unique[i])<frequency)
                swap(unique, store_index++, i);
        }
        
        swap(unique, store_index, end);
        return store_index;
    }
    
    public void  quickSort(int left , int right, int kSmallest) {
        if (left == right) return;
        Random random_num = new Random();
        int pivot = left + random_num.nextInt(right - left); 
        
        pivot = partition(left, right, pivot);
        
        if(pivot == kSmallest)
            return;
        else if(pivot > kSmallest)
            quickSort(left, pivot-1, kSmallest);
        else
            quickSort(pivot+1, right, kSmallest);
    }
    
    
    
    public int[] topKFrequent(int[] nums, int k) {
        for(int num:nums)
            map.put(num, map.getOrDefault(num,0)+1);
        int n = map.size();
        unique = new int[n];
        
        int i=0;
        for(int key:map.keySet())
            unique[i++] = key;
        
        quickSort(0, n-1, n-k);
        
        return Arrays.copyOfRange(unique, n-k, n);
        
    }
}