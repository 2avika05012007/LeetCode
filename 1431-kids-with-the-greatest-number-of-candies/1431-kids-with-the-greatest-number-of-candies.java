import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       List<Boolean> list = new ArrayList<>();
       int max = Arrays.stream(candies).max().getAsInt();
       for (int c : candies) {
            list.add(c + extraCandies >= max);
        }
        return list;
    }
}