class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastlower=new int[26];
        int[] firstupper=new int[26];
        for(int i=0;i<26;i++)
        {
            lastlower[i]=-1;
            firstupper[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch))
            {
                lastlower[ch-'a']=i;
            }
            else
            {
                int idx=ch-'A';
                firstupper[idx]=Math.min(firstupper[idx],i);
            }
        }
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(lastlower[i]!=-1 && firstupper[i]!=Integer.MAX_VALUE && lastlower[i]<firstupper[i])
            {
                count++;
            }
        }
        return count;
    }
}