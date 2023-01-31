class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        // if(scores.length ==1){
        //     return scores[0];
        // }
        int[][] arr = new int[ages.length][2];
        for(int i=0;i<ages.length;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a,b)-> a[0] == b[0]? a[1] - b[1]:a[0]-b[0]);
        int[] dp = new int[ages.length+1];
        dp[0] = arr[0][1];
        int max = dp[0];
        for(int i=1;i<ages.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i][1]>=arr[j][1]){
                    dp[i] = Math.max(dp[i], arr[i][1]+dp[j]);
                    max = Math.max(max, dp[i]);   
                }else{
                    dp[i] = Math.max(dp[i], arr[i][1]);
                }
            }

        }
        return max;
    }
}