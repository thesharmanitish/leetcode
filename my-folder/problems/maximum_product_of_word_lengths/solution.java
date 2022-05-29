class Solution {
    public int maxProduct(String[] words) {
    int n = words.length;
    int maxProd = 0;
    int[] vector = new int[words.length]    ;
        int i=0;
    for(String w:words)    {
        for(char c:w.toCharArray()){
            vector[i] |= 1<<c-'a';
        }
        i++;
    }
    for (i = 0; i < n; ++i)
      for (int j = i + 1; j < n; ++j)
        if ((vector[i] & vector[j] ) ==0)
          maxProd =Math.max(maxProd,words[i].length() * words[j].length());

    return maxProd;
    }
    
}