class Solution {
    long mod = 1000000007;
    public long pow(long x,long n){
        if(n == 0) return 1;
        x=x%mod;
        
        long half = pow(x, n/2);
        long result = (half * half) % mod;

        if(n%2 == 1){
            result = (result * x) % mod;

        }
        return result;
    }

    public int countGoodNumbers(long n) {
        if(n == 1) return 5;
        if(n  == 2) return 20;
        
        long even = pow(5,n-n/2);
        long odd = pow(4,n/2);

        long ans = (even * odd)%mod ;
        return (int)ans;
    }
}