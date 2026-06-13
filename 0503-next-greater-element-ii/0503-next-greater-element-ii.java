class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        int i=n-2;
        while(i>=0)st.push(nums[i--]);

        int ans[] = new int[n];
        for(int j=n-1;j>=0;j--){
            while(!st.isEmpty() && st.peek()<=nums[j]){
                st.pop();
            }
            if(st.isEmpty()) ans[j] = -1;
            else ans[j] = st.peek();
            st.push(nums[j]);
        }

        return ans;
    }
}