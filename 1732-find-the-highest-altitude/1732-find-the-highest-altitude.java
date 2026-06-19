class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[] alti=new int[n+1];
        int max=0;
        for(int i=1;i<=n;i++)
        {
            alti[i]=alti[i-1]+gain[i-1];
            max=Math.max(max,alti[i]);
        }
        return max;
    }
}