import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums1)
            list.add(i);

        for (int j : nums2)
            list.add(j);

        Collections.sort(list);

        int n = list.size();

        if (n % 2 == 0) {
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }

        return list.get(n / 2);
    }
}