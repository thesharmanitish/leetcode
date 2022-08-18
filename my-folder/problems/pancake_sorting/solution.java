class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            int ind = findIndex(arr, i+1);
            reverse(arr, ind);
            reverse(arr, i);
            
            result.add(ind+1);
            result.add(i+1);
        }
        
        return result;
                
    }
    public int findIndex(int[] arr, int ind) {
        for(int i=0;i<arr.length;i++)
            if(arr[i] == ind)
                return i;
        return -1;
    }
    public void reverse(int[] arr, int ind) {
        int i = 0, j = ind;
        while(i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}