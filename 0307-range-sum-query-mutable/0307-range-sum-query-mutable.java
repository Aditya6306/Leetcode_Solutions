class NumArray {
   int[] seg;
   int n;
    public NumArray(int[] nums) {
        seg=new int[4*nums.length];
        n=nums.length;
        
        build(0, nums.length-1, nums, 0, seg);
    }
    public void build(int low, int high, int[] nums, int i, int[] seg){
        if(low == high){
            seg[i] = nums[low];
            return;
        }
        int mid = (low + high)/2;
        build(low, mid, nums, 2*i+1, seg);
        build(mid+1, high, nums, 2*i+2, seg);
        seg[i]=seg[i*2+1]+seg[i*2+2];
    }
    public void change(int idx, int val, int[] seg, int l, int h, int i){
        if(l==h){
            seg[i]=val;
            return;
        }
        int mid = (l+h)/2;
        if(idx<=mid){
            change(idx, val, seg, l, mid, 2*i+1);
        }
        else{
            change(idx, val, seg, mid+1, h, 2*i+2);
        }
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public void update(int index, int val) {
        change(index, val, seg, 0, n-1, 0);
    }
    public int calculate(int left, int right, int l, int r, int[] seg, int i){
        if(l>right || r<left) return 0;

        if(l>=left && r<=right) return seg[i];

        int mid=(l+r)/2;
        int s1=calculate(left, right, l, mid, seg, 2*i+1);
        int s2=calculate(left, right, mid+1, r, seg, 2*i+2);
        return s1+s2;
    }
    public int sumRange(int left, int right) {
        int ans=calculate(left, right, 0, n-1, seg, 0);
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */