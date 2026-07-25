class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        int mid = palindrome.length()/2;
        if(palindrome.length() == 1){
            
                return "";
            
            
        }
        char[] arr = palindrome.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(i == mid && palindrome.length()%2!=0){
                ans.append(palindrome.charAt(i));
                continue;
            }
            if(palindrome.charAt(i)!='a'&& count!=0){
                ans.append('a');
                count--;
            }
            else if(palindrome.charAt(i)=='a'&& count!=0 && i == palindrome.length() -1){
                ans.append('b');
                count--;
            }
            else{
                ans.append(palindrome.charAt(i));
            }
        }
        return ans.toString();
    }
}