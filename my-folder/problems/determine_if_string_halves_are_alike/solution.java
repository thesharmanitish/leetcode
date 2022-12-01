class Solution {

    public boolean isVowel(char c) {
        switch(c){
            case 'a' : 
            case 'e':
            case 'i':
            case 'o':
            case 'u': 
            case 'A':
            case 'E':
            case 'O':
            case 'U':
            case 'I':
                     return true;
            default: return false;
        }
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowelCount = 0;
        for(int i=0;i<n/2;i++){
            if(isVowel(s.charAt(i)))
                vowelCount +=1;
        }
        for(int i=n/2;i<n;i++){
            if(isVowel(s.charAt(i)))
                vowelCount -=1;
        }
        return vowelCount==0;

    }
}