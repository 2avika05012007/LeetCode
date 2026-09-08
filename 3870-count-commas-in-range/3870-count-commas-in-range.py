class Solution:
    def countCommas(self, n):
        ans = 0
        mini = 1000

        while mini <= n:
            ans += n - mini + 1
            mini *= 1000

        return ans