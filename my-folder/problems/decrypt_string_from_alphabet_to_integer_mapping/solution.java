class Solution {
    public String freqAlphabets(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1;i>=0;){
            int sum =0;
            if(arr[i]=='#'){
                sum = (arr[i-2]-'0')*10+ (arr[i-1]-'0');
                i-=3;
            }else{
                sum = arr[i]-'0';
                i-=1;
            }
            sum +='a'-1;
            char c = (char) sum ;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}