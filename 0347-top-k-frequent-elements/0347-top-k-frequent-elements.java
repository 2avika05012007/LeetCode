import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int freq : map.values()) {
            arr.add(freq);
        }
        Collections.sort(arr);
        int[] ans = new int[k];
        int index = 0;
        for (int i = arr.size() - 1; i >= 0 && index < k; i--) {
            int freq = arr.get(i);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == freq) {
                    ans[index++] = entry.getKey();
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        return ans;
    }
}