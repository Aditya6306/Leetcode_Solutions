class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        int ans=1;
        int n=points.length;
        Arrays.sort(points, (a, b)->{
            return a[0]-b[0];
        });
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x = points[j][0]-points[i][0];
                int y = points[j][1]-points[i][1];
                int max=2;
                
                for(int k=0;k<n;k++){
                    if(k==j || k==i) continue;
                    else{
                        int dx = points[k][0]-points[i][0];
                        int dy = points[k][1]-points[i][1];
                        if(x*dy == y*dx) {
                            max++; 
                        }
                    }
                }
                ans=Math.max(max, ans);
                
            }
        }
        return ans;
    }
}