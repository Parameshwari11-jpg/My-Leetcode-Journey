class Solution {

    class Pair {
        long cnt, wav;
        Pair(long c, long w) {
            cnt = c;
            wav = w;
        }
    }

    String s;
    Pair[][][][] dp;
    boolean[][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    long calc(long x) {
        if (x <= 0) return 0;

        s = String.valueOf(x);
        int n = s.length();

        dp = new Pair[n][12][12][2];
        vis = new boolean[n][12][12][2];

        return dfs(0, 10, 10, 1).wav;
    }

    Pair dfs(int pos, int p1, int p2, int tight) {

        if (pos == s.length()) return new Pair(1, 0);

        if (vis[pos][p1][p2][tight])
            return dp[pos][p1][p2][tight];

        vis[pos][p1][p2][tight] = true;

        long cnt = 0, wav = 0;
        int lim = tight == 1 ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= lim; d++) {

            int nt = (tight == 1 && d == lim) ? 1 : 0;
            Pair nxt;

            if (p1 == 10 && d == 0)
                nxt = dfs(pos + 1, 10, 10, nt);

            else if (p1 == 10)
                nxt = dfs(pos + 1, d, 10, nt);

            else if (p2 == 10)
                nxt = dfs(pos + 1, d, p1, nt);

            else {
                long add = ((p1 > p2 && p1 > d) || (p1 < p2 && p1 < d)) ? 1 : 0;
                nxt = dfs(pos + 1, d, p1, nt);
                wav += add * nxt.cnt;
            }

            cnt += nxt.cnt;
            wav += nxt.wav;
        }

        return dp[pos][p1][p2][tight] = new Pair(cnt, wav);
    }
}