class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right=m*n;
        
        while(left<right){
            int count = 0, mid = left +(right-left)/2;
            // for(int i=1;i<=m;i++){
            //     int v = mid/i;
            //     int temp =v>n?n:v;
            //     if(temp ==0) break;
            //     count+=temp;
            // }
            count = countOfNumbersTillMid(mid,m,n);
            if(count>=k){
                right = mid;
            }else{
                left = mid+1;
            }
        }
     return left;   
    }
    
    public static int countOfNumbersTillMid(int x, int m, int n) {
		int count = 0;
		int i = m;
		int j = 1;
		while (i >= 1 && j <= n)         // i goes from m to 1, j goes from 1 to n
		{
			if (i*j <= x)
			{
				count += i;
				j++;
			}
			else
				i--;
		}
		return count;
	}
}