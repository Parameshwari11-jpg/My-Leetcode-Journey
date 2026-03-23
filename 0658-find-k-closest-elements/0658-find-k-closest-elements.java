class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int windowStart=0;
        int n=arr.length;
        for(int i=0;i<n-k;i++)
        {
            if(Math.abs(arr[i]-x)>Math.abs(arr[i+k]-x))
            {
                windowStart=i+1;
            }
        }
        List<Integer>closestElements=new ArrayList<>();
        for(int i=windowStart;i<windowStart+k;i++)
        {
            closestElements.add(arr[i]);
        }
        return closestElements;
    }
}