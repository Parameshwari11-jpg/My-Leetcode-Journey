class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;
        int maxFreq=0;
        int maxLength=0;
        for(int right=0;right<s.length();right++)
        {
            char current=s.charAt(right);
            freq[current-'A']++;
            maxFreq=Math.max(maxFreq,freq[current-'A']);
            int window=right-left+1;
            while(window-maxFreq>k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
                window=right-left+1;
            }
            maxLength=Math.max(maxLength,window);
        }
        return maxLength;
    }
}