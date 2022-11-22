class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] result = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)
           result[i] = new StringBuilder();
        for(int i=0;i<s.length();){
            int x = 0;
            while(i<s.length() && x<numRows){
                result[x++].append(s.charAt(i++));
            }
            x-=2;
            while(i<s.length() && x>0){
                result[x--].append(s.charAt(i++));
            }
        }
        StringBuilder r = new StringBuilder();
        for(StringBuilder sb:result)
            r.append(sb);
        return r.toString();
    }
}