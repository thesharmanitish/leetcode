class Solution {
    public int countVowelPermutation(int n) {

        long[] aVowelPermutationCount = new long[n];
        long[] eVowelPermutationCount = new long[n];
        long[] iVowelPermutationCount = new long[n];
        long[] oVowelPermutationCount = new long[n];
        long[] uVowelPermutationCount = new long[n];

        aVowelPermutationCount[0] = 1L;
        eVowelPermutationCount[0] = 1L;
        iVowelPermutationCount[0] = 1L;
        oVowelPermutationCount[0] = 1L;
        uVowelPermutationCount[0] = 1L;

        int MOD = 1000000007;
        
        int i=1;
        long result = 0L;
        for(i=1;i<n;i++){
            aVowelPermutationCount[i] =( eVowelPermutationCount[i-1] +uVowelPermutationCount[i-1]+ iVowelPermutationCount[i - 1])%MOD;
            eVowelPermutationCount[i] = (aVowelPermutationCount[i-1]+ iVowelPermutationCount[i - 1])%MOD;
            iVowelPermutationCount[i] = (eVowelPermutationCount[i-1] + oVowelPermutationCount[i-1])%MOD;
            oVowelPermutationCount[i] = (iVowelPermutationCount[i-1])%MOD;
            uVowelPermutationCount[i] = (oVowelPermutationCount[i-1] + iVowelPermutationCount[i - 1])%MOD;
            
        }
        i-=1;
        result = (aVowelPermutationCount[i] + eVowelPermutationCount[i] +iVowelPermutationCount[i] +
                oVowelPermutationCount[i] +uVowelPermutationCount[i])%MOD; 
        return (int) result;
    }
}