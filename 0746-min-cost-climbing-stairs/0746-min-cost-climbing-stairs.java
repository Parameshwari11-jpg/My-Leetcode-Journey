class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a=cost[0];
        int b=cost[1];
        for(int i=2;i<cost.length;i++)
        {
            int curr=cost[i]+Math.min(a,b);
            a=b;
            b=curr;
        }
        return Math.min(a,b);
    }
}