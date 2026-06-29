class Solution {
    int MOD=1000000007;
    public int numPrimeArrangements(int n) {
        int prime=0;
        for(int i=2;i<=n;i++)
        {
            if(isPrime(i))   prime++;
        }
        int nonPrime=n-prime;
        return (int) ((factorial(prime)*factorial(nonPrime))%MOD);
    }
    public boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i == 0)  return false;
        }
        return n>1;
    }
    public long factorial(int n)
    {
        long fact=1;
        for(int i=2;i<=n;i++)
        {
            fact=(fact*i)%MOD;
        }
        return fact;
    }
}