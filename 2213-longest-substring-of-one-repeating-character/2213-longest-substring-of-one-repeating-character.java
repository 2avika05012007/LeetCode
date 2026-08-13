class Solution {
    class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int best;
        int length;
        Node() {}
        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            length = 1;
        }
    }
    Node[] tree;
    char[] arr;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }
        build(1, 0, n - 1);
        int[] ans = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            arr[index] = ch;
            update(1, 0, n - 1, index);
            ans[i] = tree[1].best;
        }
        return ans;
    }
    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start]);
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        merge(node);
    }
    void merge(int node) {
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];
        cur.length = left.length + right.length;
        cur.leftChar = left.leftChar;
        cur.rightChar = right.rightChar;
        cur.prefix = left.prefix;

        if (left.prefix == left.length &&
            left.rightChar == right.leftChar) {

            cur.prefix += right.prefix;
        }


        cur.suffix = right.suffix;

        if (right.suffix == right.length &&
            left.rightChar == right.leftChar) {

            cur.suffix += left.suffix;
        }

        cur.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {

            cur.best = Math.max(
                cur.best,
                left.suffix + right.prefix
            );
        }
    }

    // Update one index
    void update(int node, int start, int end, int index) {

        if (start == end) {
            tree[node] = new Node(arr[index]);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        merge(node);
    }
}