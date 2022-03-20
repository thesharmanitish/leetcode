class Solution {

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
int m=nums1.length,n=nums2.length;
int[] arr=new int[m+n];
System.arraycopy(nums1, 0, arr, 0, m);
System.arraycopy(nums2, 0, arr, m, n);
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
int l=m+n;
float res=0;
if(l%2==0)
{
res=(float) ((float)(arr[l/2]+arr[(l/2)-1])/2.0);
}
else
{
res=(float)(arr[l/2]);
}
return res;
}

//     public double findMedianSortedArrays(int[] arr, int[] brr) {
// 	    int al=0, bl=0, ah = arr.length-1, bh =brr.length-1;
        
//             if(arr.length ==0 && brr.length==0)
//                 return -1;
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
//     }
}