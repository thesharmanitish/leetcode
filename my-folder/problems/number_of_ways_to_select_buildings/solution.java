class Solution {
    
    public static long numberOfWays(String s) {
		int zeroCount = 0, oneCount = 0;
		for(char c:s.toCharArray())
			if(c=='0')
				zeroCount++;
		oneCount = s.length()-zeroCount;
		
		int firstOne = s.charAt(0)=='1'? 1:0;
		int firstZero = s.charAt(0)=='0'? 1:0;
		long count = 0;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				count+=firstOne*(oneCount-firstOne);
                firstZero++;
			}else {
				count+=firstZero*(zeroCount-firstZero);
                firstOne++;
			}
		}
		return count;
		
	}
    
    public long numberOfWaysAlternate(String s) {
	
    long  _0 = 0, _1 = 0, _01 = 0, _10 = 0, _010 = 0, _101 = 0;
    for(char c : s.toCharArray()) 
        if(c == '0') {
            _010 += _01;     
            _10  += _1;        
            _0   += 1;
        }
        else {
            _101 += _10;
            _01  += _0;
            _1   += 1;
        }
                
    return _101 + _010;
	
    }
}