class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            map.put((long)num,map.getOrDefault((long)num,0)+1);
        }
        int ans=1;
        if(map.containsKey(1L))
        {
            int cnt=map.get(1L);
            ans=(cnt%2==0)?cnt-1:cnt;
        }
        for(long x:map.keySet())
        {
            if(x==1) continue;
            long cur=x;
            int len=1;
            while(map.getOrDefault(cur,0)>=2 && map.containsKey(cur*cur))
            {
                len+=2;
                cur*=cur;
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}