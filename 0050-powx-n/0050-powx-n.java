class Solution {
    public double myPo(double x, int n) {
        
        if(n==1) return x;
        if(n==0) return 1;

        double ans=1;
        if(n%2==0){
            double a=myPo(x, n/2);
            ans = a*a;
        }
        else{
            double a=myPo(x, n/2);
            ans = a*a*x;
        }
        
        return ans;
    }
    public double myPow(double x, int n) {
        int t=n;
        if(n<0) {
            t=-1*n;
        }
        

        double ans = myPo(x, t);
        if(n<0) return 1/ans;
        return ans;
    }
}