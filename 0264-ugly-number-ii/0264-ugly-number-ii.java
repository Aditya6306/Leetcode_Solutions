class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];

        dp[1]=1;
        int i2=1;
        int i3=1;
        int i5=1;

        for(int i=2;i<=n;i++){
            int a = dp[i2]*2;
            int b = dp[i3]*3;
            int c = dp[i5]*5;

            int min = Math.min(a, Math.min(b, c));

            dp[i]=min;
            if(a == min) i2++;
            if(b == min) i3++;
            if(c == min) i5++;
        };

        // for(int i=0;i<=n;i++){
        //     System.out.println(dp[i]);
        // }
        return dp[n];
    }
}