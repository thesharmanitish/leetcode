class Solution {
    public void solve(char[] arr, int i, int j) {
            if(arr[i] == 'L' && arr[j] == 'L'){
                for(int k=i+1;k<j;k++)
                    arr[k] = 'L';
            }
            else if(arr[i] == 'R' && arr[j] == 'R'){
                for(int k=i+1;k<j;k++)
                    arr[k] = 'R';                
            }
            else if(arr[i] == 'L' && arr[j] == 'R'){
               return; 
            }
            else if(arr[i] == 'R' && arr[j] == 'L'){
                while(j-i>2){
                    arr[++i] = 'R';
                    arr[--j] = 'L';
                }
            }        
    }
    public String pushDominoes(String d) {
        int n = d.length();
        d = 'L'+d+'R';
        char[] arr = d.toCharArray();
        
        int i =0, j=1;
        while(j<arr.length){
            while(arr[j] == '.')
                j++;
            if(j-i>1)
                solve(arr, i, j);
            i = j;
            j+=1;
            
            
        }
                
        
        StringBuilder sb = new StringBuilder(new String(arr));
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}