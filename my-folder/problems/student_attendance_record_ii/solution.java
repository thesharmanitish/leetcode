class Solution {
    int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        if(n==1)
            return 3;
        int[][] prevDp = new int[2][3];
        
        for(int i=0;i<2;i++)
            Arrays.fill(prevDp[i], 1);

        for(int i=1;i<=n;i++){
            int[][] newDp = new int[2][3];

            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    // present
                    newDp[j][k] = (newDp[j][k] + prevDp[j][2])%MOD;

                    if(j>0)  // absent
                        newDp[j][k] = (newDp[j][k] + prevDp[j-1][2])%MOD;
                    
                    if(k>0)
                        newDp[j][k] = (newDp[j][k] + prevDp[j][k-1])%MOD;
                }
            }
            prevDp = newDp;
                
        }
        return prevDp[1][2];
    }
}



/**
class Solution {
    public int checkRecord(int n) {
        if(n ==1)
            return 3;

        dp = new int[n+1][2][3];
        return numOfWays(n, 1, 2);
    }

    int MOD = 1_000_000_007;
    int[][][] dp;




    public int numOfWays(int n, int absentAllowed, int lateAllowed) {
        if(n==0)
            return 1;
        if(dp[n][absentAllowed][lateAllowed]!=0)
            return dp[n][absentAllowed][lateAllowed];
        long temp = 0l;
        temp = (temp + numOfWays(n-1, absentAllowed, 2)) %MOD;

        if(absentAllowed>0)
            temp = (temp + numOfWays(n-1, absentAllowed-1, 2))  %MOD;

        if(lateAllowed>0)
            temp = (temp +  numOfWays(n-1, absentAllowed, lateAllowed-1))  %MOD;
        
        return dp[n][absentAllowed][lateAllowed] =(int)temp %MOD;
    }    
}

 */
 

/**
3^n

class Solution {
    int count = 0, max = 1000000007;
    public int checkRecord(int n) {
        dfs("", n);
        return count;
    }


    public void dfs(String record, int n) {
        if(n == 0 && checkRecord(record))
            count = (count+1) % max;
        else if (n > 0) {
            if(record.indexOf('A')==-1)
                dfs(record + "A", n - 1);
            dfs(record + "P", n - 1);
            if(record.length()<=2 || (record.length()>2 && !record.substring(record.length()-3).equals("LL")))
                dfs(record + "L", n - 1);
        }
    }

     public boolean checkRecord(String s) {
        int count = 0;
        if(s.indexOf("AA")>=0 ||  s.indexOf("LLL") >= 0)
            return false;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 ;

     }
}

*/