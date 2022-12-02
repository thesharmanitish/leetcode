class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twen =0;
        boolean flag = false;
        for(int bill:bills){
            switch(bill){
                case 5:  five+=1; 
                         break;
                case 10: if(five==0){
                            flag = true;
                        }else five-=1; ten +=1;
                        break;
                case 20: if(five==0 || (five <3 && ten ==0)){
                            flag = true;
                        }else if(ten>0){five-=1; ten -=1;twen+=1;}
                        else five-=3;
                        break;
            }
            if(flag)
                return false;
        }
        return true;
    }
}