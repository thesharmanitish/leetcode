class Solution {
    public int minMaxDifference(int num) {
        char[] n = Integer.toString(num).toCharArray();
        char[] m = new char[n.length];
        System.arraycopy(n,0, m, 0 , n.length);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        int j=0;
        while(j<n.length && n[j]=='9')
            j++;
        char ref = j<n.length?n[j]:' ';
        for(int i=1;i<n.length;i++){
            if(j<n.length &&  n[i] == ref){
                n[i] = '9';
            }
            if(m[i] == m[0])
                m[i] = '0';
        }
        n[0] = '9';
        m[0] = '0';
        return Integer.parseInt(new String(n)) - Integer.parseInt(new String(m));
    }
}