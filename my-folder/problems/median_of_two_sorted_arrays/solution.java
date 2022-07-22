class Solution {

    
    public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	if (aStart > A.length - 1) return B[bStart + k - 1];            
	if (bStart > B.length - 1) return A[aStart + k - 1];                
	if (k == 1) return Math.min(A[aStart], B[bStart]);
	
	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
	
	if (aMid < bMid) 
	    return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
	else 
	    return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
}
    
//public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
    
    
//         int index1 = 0;
//     int index2 = 0;
//     int med1 = 0;
//     int med2 = 0;
//     for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
//         med1 = med2;
//         if (index1 == nums1.length) {
//             med2 = nums2[index2];
//             index2++;
//         } else if (index2 == nums2.length) {
//             med2 = nums1[index1];
//             index1++;
//         } else if (nums1[index1] < nums2[index2] ) {
//             med2 = nums1[index1];
//             index1++;
//         }  else {
//             med2 = nums2[index2];
//             index2++;
//         }
//     }

//     // the median is the average of two numbers
//     if ((nums1.length+nums2.length)%2 == 0) {
//         return (float)(med1+med2)/2;
//     }

//     return med2;
// }
    // int m=nums1.length,n=nums2.length;
    // int[] arr=new int[m+n];
    // System.arraycopy(nums1, 0, arr, 0, m);
    // System.arraycopy(nums2, 0, arr, m, n);
    // Arrays.sort(arr);
    // int l=m+n;
    // float res=0;
    // if(l%2==0)
    // {
    // res=(float) ((float)(arr[l/2]+arr[(l/2)-1])/2.0);
    // }
    // else
    // {
    // res=(float)(arr[l/2]);
    // }
    // return res;
    // }

//     public double findMedianSortedArrays(int[] arr, int[] brr) {
// 	    int al=0, bl=0, ah = arr.length-1, bh =brr.length-1;
        
//             if(arr.length ==0 && brr.length==0)
//                 return -1;
//             else if(arr.length ==1 && brr.length==1){
//                 return (double) (arr[0]+brr[0])/2.0;
//             }
//             else if(brr.length ==0){
//                 if(arr.length%2==1)
//                     return arr[arr.length/2];
//                 else
//                     return ((double)(arr[(arr.length-1)/2]+ arr[(arr.length/2)])/2);
//             }else if(arr.length ==0){
//                 if(brr.length%2==1)
//                     return brr[brr.length/2];
//                 else
//                     return ((double)(brr[(brr.length-1)/2]+ brr[(brr.length/2)])/2);
//             }
                
//         // while(al< ah || bl<bh){
//             int mid1 = (al+ah)/2,  mid2 = (bl+bh)/2;
//             while((mid2+1) <=bh && arr[mid1]>brr[mid2+1]){
//                 mid2++;
//                 mid1--;
//             }
//             while((mid1+1) <= ah && brr[mid2]>arr[mid1+1]){
//                 mid1++;
//                 mid2--;
//             }
            


//         // }
//             if(mid1==-1){
//                 if((ah+bh)%2==1)
//                     return brr[mid2];
//                 else return (double)(brr[mid2]+arr[mid1+1])/2;
//             }
//             else if(mid2==-1){
//                 if((ah+bh)%2==1)
//                     return arr[mid1];
//                 else return  (double)(arr[mid1]+brr[mid2+1])/2;
//             }
//             if((ah+bh)%2==1)
//                 return Math.max(arr[mid1],brr[mid2]);
//             else{
//                 if((mid1+1) <= ah && (mid2+1) <=bh)
//                     return (double)(Math.max(arr[mid1],brr[mid2]) + Math.min(arr[mid1+1],brr[mid2+1])) /2;
//                 else if((mid2+1) <=bh)
//                     return (double)(Math.max(arr[mid1],brr[mid2]) + brr[mid2+1]) /2;
//                 else if((mid1+1) <=ah)
//                     return (double)(Math.max(arr[mid1],brr[mid2]) + arr[mid1+1]) /2;      
//                 else
//                     return (double)(Math.max(arr[mid1],brr[mid2]));
//             }        
// }
}