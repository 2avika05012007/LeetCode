class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        int[] oldLast = new int[n];

        Arrays.fill(last, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (node >= 0) {
                int c = s.charAt(node) - 'a';

                oldLast[node] = last[c];

                if (last[c] != -1) {
                    newParent[node] = last[c];
                }

                last[c] = node;

                stack.push(-node - 1);

                for (int i = children[node].size() - 1; i >= 0; i--) {
                    stack.push(children[node].get(i));
                }

            } else {
                node = -node - 1;
                int c = s.charAt(node) - 'a';

                last[c] = oldLast[node];
            }
        }

        List<Integer>[] finalTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        List<Integer> order = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();
            order.add(node);

            for (int child : finalTree[node]) {
                st.push(child);
            }
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);

            if (newParent[node] != -1) {
                answer[newParent[node]] += answer[node];
            }
        }

        return answer;
    }
}
