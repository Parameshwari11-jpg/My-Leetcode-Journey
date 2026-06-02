class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans=Integer.MAX_VALUE;
        int n=landStartTime.length;
        int m=waterStartTime.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //Land -> Water
                int landFinish=landStartTime[i]+landDuration[i];
                int waterBegin=Math.max(landFinish,waterStartTime[j]);
                int finish1=waterBegin+waterDuration[j];

                // water->land
                int waterFinish=waterStartTime[j]+waterDuration[j];
                int landBegin=Math.max(waterFinish,landStartTime[i]);
                int finish2=landBegin+landDuration[i];
                
                ans=Math.min(ans,Math.min(finish1,finish2));
            }
        }
        return ans;
    }
}