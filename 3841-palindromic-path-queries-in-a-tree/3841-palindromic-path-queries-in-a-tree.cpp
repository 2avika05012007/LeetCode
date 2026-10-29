
class Solution {
    int n, LOG;
    vector<vector<int>> adj, up;
    vector<int> tin, tout, depth, rootMask;
    vector<int> euler, bit;
    string s;
    int timer = 0;

    int charMask(char c) {
        return 1 << (c - 'a');
    }

    void dfs(int u, int p) {
        tin[u] = ++timer;
        euler[timer] = u;
        up[u][0] = p;

        for (int j = 1; j < LOG; j++) {
            up[u][j] = up[up[u][j - 1]][j - 1];
        }

        for (int v : adj[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            rootMask[v] = rootMask[u] ^ charMask(s[v]);
            dfs(v, u);
        }

        tout[u] = timer;
    }

    void add(int idx, int val) {
        while (idx <= n) {
            bit[idx] ^= val;
            idx += idx & -idx;
        }
    }

    int prefixXor(int idx) {
        int res = 0;

        while (idx > 0) {
            res ^= bit[idx];
            idx -= idx & -idx;
        }

        return res;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) swap(u, v);

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if (diff & (1 << j)) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

public:
    vector<bool> palindromePath(int n,
                                vector<vector<int>>& edges,
                                string s,
                                vector<string>& queries) {
        this->n = n;
        this->s = s;
        timer = 0;

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        adj.assign(n, {});

        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }

        tin.assign(n, 0);
        tout.assign(n, 0);
        depth.assign(n, 0);
        rootMask.assign(n, 0);
        euler.assign(n + 1, 0);
        up.assign(n, vector<int>(LOG, 0));
        bit.assign(n + 1, 0);

        rootMask[0] = charMask(s[0]);
        dfs(0, 0);

        for (int i = 1; i <= n; i++) {
            int u = euler[i];
            int delta = rootMask[u];

            for (int j = i - 1; j > 0; j -= j & -j) {
                delta ^= bit[j];
            }

            add(i, delta);
        }

        vector<bool> ans;

        for (string& q : queries) {
            stringstream ss(q);
            string type;
            int u, v;

            ss >> type >> u;

            if (type == "update") {
                char c;
                ss >> c;

                int delta = charMask(s[u]) ^ charMask(c);

                if (delta != 0) {
                    add(tin[u], delta);
                    add(tout[u] + 1, delta);
                }

                s[u] = c;
            } else {
                ss >> v;

                int a = lca(u, v);

                int pu = prefixXor(tin[u]);
                int pv = prefixXor(tin[v]);

                int mask = pu ^ pv ^ charMask(s[a]);

                ans.push_back((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }
};
