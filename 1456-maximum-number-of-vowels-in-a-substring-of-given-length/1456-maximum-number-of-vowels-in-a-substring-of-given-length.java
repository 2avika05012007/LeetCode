class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int count = 0;
        for(i = 0; i<k; i++){
            char a = s.charAt(i);
            if((a=='a')||(a=='e')||(a=='i')||(a=='o')||(a=='u')){
                count++;
            }
        }
        int countmax = count;
        for(int j = k; j<s.length(); j++){
            char a = s.charAt(j-k);
            if((a=='a')||(a=='e')||(a=='i')||(a=='o')||(a=='u')){
                count--;
            }
            char b = s.charAt(j);
            if((b=='a')||(b=='e')||(b=='i')||(b=='o')||(b=='u')){
                count++;
            }
            countmax = Math.max(count, countmax);
        }
        return countmax;
    }
}