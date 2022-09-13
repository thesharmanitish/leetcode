class Solution {
//[197,130,1]
//     public boolean validUtf8(int[] data) {
//         int n = data.length;
//         int seqCount=0;
//         boolean flag = false;
//         for(int i=0;i<n;i++){
            
//             int x = 8, count = 0;
//             while((data[i] & (1<<--x)) !=0){
//                 count++;
//             }
//             if(flag){
//                 if(count !=1){
//                     return false;
//                 }
//                 else if(--seqCount ==0)
//                         flag = false;
//             }else{ //11000101 // 10000010 / 000000001
//                 switch(count){
//                     case 0: seqCount =0; flag = false; break;
//                     case 2: seqCount =1; flag = true; break;
//                     case 3: seqCount =2; flag = true; break;
//                     case 4: seqCount =3; flag = true; break;
//                     default: return false;
//                 }
                
//             }
//         }
//         return seqCount>0?false:true;
//     }
        public boolean validUtf8(int[] data) {
        int count = 0;
        for (int value : data) {
            if (count == 0) {
                if (value >> 3 == 0b11110) {
                    count = 3;
                } else if (value >> 4 == 0b1110) {
                    count = 2;
                } else if (value >> 5 == 0b110) {
                    count = 1;
                } else if (value >> 7 == 0b0) {
                    count = 0;
                } else {
                    return false;
                }
            } else {
                if (value >> 6 == 0b10) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }
}