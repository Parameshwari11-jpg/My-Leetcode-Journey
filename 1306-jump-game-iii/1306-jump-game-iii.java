class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer>q=new LinkedList<>();
        q.offer(start);
        int n=arr.length;
        boolean[] visited=new boolean[n];
        while(!q.isEmpty())
        {
            int index=q.poll();
            if(arr[index]==0)
            {
                return true;
            }
            if(visited[index])
            {
                continue;
            }
            visited[index]=true;
            int forward=index+arr[index];
            int backward=index-arr[index];
            if(forward<arr.length)
            {
                q.offer(forward);
            }
            if(backward>=0)
            {
                q.offer(backward);
            }
        }
        return false;
    }
}