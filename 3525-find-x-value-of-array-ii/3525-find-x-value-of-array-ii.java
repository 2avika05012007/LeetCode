import java.util.*;
class Solution {

    int k;
    Node[] tree;

    class Node {
        int product;
        int[] count;

        Node() {
        }

        Node(int k) {
            count = new int[k];
            product = 1;
        }
    }

    Node merge(Node left, Node right) {

        Node ans = new Node(k);

        ans.product = (int) ((long) left.product * right.product % k);

        for (int r = 0; r < k; r++) {
            ans.count[r] += left.count[r];
        }

        for (int r = 0; r < k; r++) {

            int newRemainder =
                (int) ((long) left.product * r % k);

            ans.count[newRemainder] += right.count[r];
        }

        return ans;
    }

    void build(int[] nums, int node, int l, int r) {

        if (l == r) {

            tree[node] = new Node(k);

            tree[node].product = nums[l] % k;

            tree[node].count[tree[node].product] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] =
            merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r,
                int index, int value) {

        if (l == r) {

            tree[node] = new Node(k);

            tree[node].product = value % k;

            tree[node].count[tree[node].product] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] =
            merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r,
               int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left =
            query(node * 2, l, mid, ql, qr);

        Node right =
            query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(
        int[] nums,
        int k,
        int[][] queries
    ) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            Node result =
                query(
                    1,
                    0,
                    n - 1,
                    start,
                    n - 1
                );

            answer[i] = result.count[x];
        }

        return answer;
    }
}