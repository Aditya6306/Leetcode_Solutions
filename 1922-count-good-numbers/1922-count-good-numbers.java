class Solution {
    long mod = (long)1e9+7;
    public long pow(int x, long n){
        if(n==1) return x;
        if(n==0) return 1;

        long ans = pow(x, n/2);
        long res = (ans*ans)%mod;
        if(n%2==1) res = (res*x)%mod;
        return res;

    }
    public int countGoodNumbers(long n) {
        if(n==1) return 5;


        long even = n-n/2;
        long odd = n/2;

        long ev = pow(5, even);
        long od = pow(4, odd);

        long ans = (ev*od)%mod;
        return (int)ans;
    }
}