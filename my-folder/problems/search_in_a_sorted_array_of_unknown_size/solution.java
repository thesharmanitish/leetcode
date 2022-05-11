/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(target == reader.get(0))
            return 0;
        else if(target == reader.get(1))
            return 1;
        int mid;
        int start = 1, end = 2;
        while(reader.get(end) <target){
            end<<=1;
            start<<=1;
        }
        while(start<=end){
            mid = start+(end-start)/2;            
            if(target > reader.get(mid) ){
                start = mid+1;
            }else if(target < reader.get(mid)){
                end = mid -1;
            }else
                return mid;
        }
        return -1;        
    }
}