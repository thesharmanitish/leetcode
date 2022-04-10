class Solution {
    
    
 //   Tip1. left < right Vs left <= right

// Check all my solution, I keep using left < right.
// The easy but important approach:
// follow and upvote my codes,
// try to do the same.
// you'll find all binary search is similar,
// never bother thinking it anymore.

// Tip2. mid = (left + right + 1) / 2 Vs mid = (left + right) / 2

// mid = (left + right) / 2 to find first element valid
// mid = (left + right + 1) / 2to find last element valid

//     Maximum Candies Allocated to K Children
// Maximum Value at a Given Index in a Bounded Array
// Kth Missing Positive Number
// Minimum Number of Days to Make m Bouquets
// Find the Smallest Divisor Given a Threshold
// Divide Chocolate
// Capacity To Ship Packages In N Days
// Koko Eating Bananas
// Minimize Max Distance to Gas Station
// Split Array Largest Sum

    public int maximumCandies(int[] candies, long k) {
        // long sum = Arrays.stream(candies).sum();
        long start =0,end=0;
        for(int n:candies)
         end +=n;
        end/=k;
        while(start<end){
            long mid = (start+end+1)/2;
            long sum = 0;
            for(int num:candies)
                sum+=num/mid;
            if(sum<k)
                end = mid-1;
            else
                start =mid;
           
        }
        return (int)start;
    }
}