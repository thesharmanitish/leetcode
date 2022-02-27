/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
     int findInMountainArray(int target, MountainArray A) {
        int n = A.length(), l, r, m, peak = 0;
        // find index of peak
        l  = 0;
        r = n - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A.get(m) < A.get(m + 1))
                l = peak = m + 1;
            else
                r = m;
        }
        // find target in the left of peak
        l = 0;
        r = peak;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) < target)
                l = m + 1;
            else if (A.get(m) > target)
                r = m - 1;
            else
                return m;
        }
        // find target in the right of peak
        l = peak;
        r = n - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) > target)
                l = m + 1;
            else if (A.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }
//     public int findInMountainArray(int target, MountainArray mountainArr) {
//         int start = 0, end = mountainArr.length()-1;
//         int ind = findPeek(mountainArr, start,end);
//         System.out.print(ind);
//         int firstTry =  bsearch(mountainArr,target, start,ind);
//         if(firstTry==-1)
//             firstTry =  bsearch(mountainArr,target, ind+1, end);
        
//         return firstTry;
//     }
    
//     int findPeek(MountainArray mountainArr, int start, int end){
        
        
//         while(start<end){
//             int mid = start + (end-start) /2;
//             if(mid <end && mountainArr.get(mid) >mountainArr.get(mid+1)){
//                 end = mid;
//             }else start =mid+1;
            
            
            
//         }
//         return start;
            
//     }
    
//     int bsearch(MountainArray mountainArr,int target, int start, int end){
//         boolean isAsc = mountainArr.get(start) <=mountainArr.get(end) ? true: false;
        
        
//             while(start<=end){
//                 int mid = start + (end-start) /2;
//                 if(mountainArr.get(mid) == target)
//                     return mid;
//                 if(isAsc){
//                     if(target<mountainArr.get(mid)){
//                         end = mid-1;
//                     }else if(target> mountainArr.get(mid)){
//                         start = mid+1;
//                     }
//                 }
//                 else{
                
//                     if(target>mountainArr.get(mid)){
//                         end = mid-1;
//                     }else if(target< mountainArr.get(mid)){
//                         start = mid+1;
//                     }

//                 }
        
//         }
//         return -1;
//     }
}