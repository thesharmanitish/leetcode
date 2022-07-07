 public class Solution {
    public Boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            if (i == s1.length() && j == s2.length())
                return true;
            return false;
        }  
        if (memo[i][j]!=null) {
            return memo[i][j];
        }        
        if (i == s1.length()) {
            return memo[i][j] = s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return memo[i][j] = s1.substring(i).equals(s3.substring(k));
        }
        boolean check1 = false;
        if (s1.charAt(i) == s3.charAt(k))
            check1 = is_Interleave(s1, i+1, s2, j, s3, k+1);
        if(check1)
            return memo[i][j] = true;
        if (s2.charAt(j) == s3.charAt(k))
            check1 = is_Interleave(s1, i, s2, j+1, s3, k+1);
        return memo[i][j]=check1;
    }
     Boolean memo[][] ;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new Boolean[s1.length()+1][s2.length()+1];
        return is_Interleave(s1, 0, s2, 0, s3, 0);
    }
}