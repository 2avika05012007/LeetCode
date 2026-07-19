import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int number : nums){
            if(set.contains(number))
                set.remove(number);
            else
                set.add(number);
        }
        int[] ans = new int[2];
        int i = 0;
        for(int number : set){
            ans[i++] = number;
        }
        return ans;
    }
}