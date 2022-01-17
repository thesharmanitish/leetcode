class Solution {
//     public String fractionToDecimal(int numerator, int denominator) {
//         double n = numerator;
//         double d = denominator;
//         double temp = n/d;
//         String temp1 = ""+temp;
//         int tempInt = (int)temp;
//         boolean flag = false;
//         int count = 0;
//         if(temp1.length()>10){
//             temp1 = temp1.substring(2);
//             Map<Character,Integer> charFrequency = new HashMap<>();
//             for (char ch : temp1.toCharArray())
//                 charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
//             int prev = -1;
//             for(int i:charFrequency.values()){
//                 if(prev == -1) {
//                     prev = i;
//                     count++;
//                     continue;
//                 }
//                 if(prev == i) {
//                     count++;
//                     continue;
//                 }
//                 flag = true;
//                 break;
//             }
//             if(!flag){
//                 double temp2 = temp*Math.pow(10,count);
//                 double diff = (int)temp2;
//                 StringBuilder st = new StringBuilder()   ;
//                 diff = diff/Math.pow(10,count);
//                 st.append(""+diff);
//                 st.insert(2,"(",0,1);
//                 st.insert(3+count,")",0,1);
//                 return st.toString();
//             }

//         }
//         else if((temp - (double) tempInt) ==0)
//             return ""+tempInt;

//         return ""+temp;
   
        
//     }
        public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}