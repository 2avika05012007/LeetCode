class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();

        for (int x : nums1) s1.add(x);
        for (int x : nums2) s2.add(x);
        for (int x : nums3) s3.add(x);

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            int count = 0;

            if (s1.contains(i)) count++;
            if (s2.contains(i)) count++;
            if (s3.contains(i)) count++;

            if (count >= 2) {
                ans.add(i);
            }
        }

        return ans;
    }
}