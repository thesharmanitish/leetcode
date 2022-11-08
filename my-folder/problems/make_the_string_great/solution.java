class Solution {
    boolean flag = false;
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length(), i=0;
        for(i=0;i<n-1;i+=1){
            if(s.charAt(i)- s.charAt(i+1) ==32 || s.charAt(i+1)- s.charAt(i) ==32 ){
                // result.append(s.charAt(i)+""+ s.charAt(i));
                i+=1;
                flag = true;
                continue;
            } 
            // else if(s.charAt(i+1)- s.charAt(i) ==32 ){
            //     result.append(s.charAt(i+1)+""+ s.charAt(i+1));
            // }
            else result.append(s.charAt(i));
        }
        if(i==n-1)
            result.append(s.charAt(s.length()-1));
        if(!flag)
            return result.toString();
        flag = false;
        return makeGood(result.toString());
    }
}