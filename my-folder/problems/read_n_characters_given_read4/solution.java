/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int ind = 0, x=0;
        while((x = read4(temp))>0){
            for(int i=0;i<x;i++){
                buf[ind++] = temp[i];
                if(ind == n)
                    return ind;
            }
            if(ind == n)
                break;            
        }
        return ind;
    }
}