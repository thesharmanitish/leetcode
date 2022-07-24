class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        
        for(int num: nums) arr.add(num);
        
        Collections.sort(arr);
          
        for(int i = 0; i<len; i++){
            int index = binarySearch(arr,nums[i]);
            ans.add(index);
            arr.remove(index);
        }
        
        return ans;
    }
    
    public int binarySearch(ArrayList<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;
        int mid=0;
        
        while(start<=end){
            mid = start + ((end - start)/2);
            int val = arr.get(mid);
            if(val<target) start = mid + 1;
            else end = mid - 1;
        }
        if(arr.get(start) == target) return start;
        return mid;
    }
}

// class Solution {
//     public List<Integer> countSmaller(int[] nums) {
//         List<Integer> sortedList = new ArrayList<>();
//         List<Integer>  ans = new ArrayList<>();

//         if (nums == null || nums.length == 0)
//             return ans;
        
//         ans.add(0);
//         sortedList.add(nums[nums.length-1]);
        
//         for(int i=nums.length-2;i>=0;i--){
            
//             int index = Collections.binarySearch(sortedList, nums[i]);
            
            
//             if (index >= 0) {           
//                 while (index > 0 && sortedList.get(index-1) == nums[i]) {
//                     index--;
//                 }
//             }
//             else {
//                 index = -1 - index;
//             }
            
//             sortedList.add(index, nums[i]);
//             ans.add(0,index);
//             // Collections.sort(set);
            
//         }
//         return ans;
//     }
// }

// public class Solution {
//     class SegTreeNode {
//         int min, max; // range [min, max]
//         int count;
//         SegTreeNode left, right;
        
//         public int mid() {
//             return ((max + 1 - min) / 2 + min);
//         }
        
//         public SegTreeNode(int min, int max) {
//             this.min = min;
//             this.max = max;
//             count = 0;
//         }
//     }
    
//     public List<Integer> countSmaller(int[] nums) {
//         List<Integer> list = new LinkedList<Integer>();
        
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//         for (int i : nums) {
//             min = min > i ? i : min;
//             max = max < i ? i : max;
//         }
        
//         SegTreeNode root = new SegTreeNode(min, max);
        
//         for (int i = nums.length - 1; i >= 0; i--) {
//             list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
//             add(nums[i], root);
//         }
        
//         return list;
//     }
    
//     private int find(int x, SegTreeNode root) {
//         if (root == null) return 0;
        
//         if (x >= root.max) {
//             return root.count;
//         } else {
//             int mid = root.mid(); 
//             if (x < mid) {
//                 return find(x, root.left);
//             } else {
//                 return find(x, root.left) + find(x, root.right);
//             }
//         }
//     }
    
//     private void add(int x, SegTreeNode root) {
//         if (x < root.min || x > root.max) return;
       
//         root.count++;
//         if (root.max == root.min) return;
        
//         int mid = root.mid();
//         if (x < mid) {
//             if (root.left == null) {
//                 root.left = new SegTreeNode(root.min, mid - 1);
//             }
//             add(x, root.left);
//         } else {
//             if (root.right == null) {
//                 root.right = new SegTreeNode(mid, root.max);
//             }
//             add(x, root.right);
//         }
//     }
// }