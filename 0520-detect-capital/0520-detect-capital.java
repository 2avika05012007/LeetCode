class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(Character.isLowerCase(arr[0])){
            for(int i = 1; i < arr.length; i++){
                if(Character.isUpperCase(arr[i])){
                    return false;
                }
            }
        }
        else{
            if(arr.length > 1 && Character.isUpperCase(arr[1])){
                for(int i = 2; i < arr.length; i++){
                    if(Character.isLowerCase(arr[i])){
                        return false;
                    }
                }
            }
            else {
                for(int i = 1; i < arr.length; i++){
                    if(Character.isUpperCase(arr[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}