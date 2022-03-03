class Solution {
    public String convert(String st, int numRows) {
                char[] s = st.toCharArray();
        StringBuilder[] listSt = new StringBuilder[numRows];
        for(int i=0;i<listSt.length;i++)
        	listSt[i] = new StringBuilder();
        int k=0;
        if(s.length==0)
            return "";
        for(int i=0;i<s.length;i++){
        	listSt[k++].append(s[i]);
            if(k%(numRows)==0) {
            	for(int j=numRows-2;j>0;j--){
                    if(i+1<s.length)
                    listSt[j].append(s[++i]);
                }
                k=0;
            }
            
        }
        
        StringBuilder b = new StringBuilder();
        Arrays.stream(listSt).forEach(b::append);
        return b.toString();
    }
}