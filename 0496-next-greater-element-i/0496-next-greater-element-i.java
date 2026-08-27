class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set= new HashMap<>();
        int p=0;
        for(int ele : nums1) set.put(ele, p++);

        int[] arr = new int[nums2.length];
        arr[nums2.length-1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(nums2[nums2.length-1]);
        for(int i=nums2.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]) st.pop();
            if(st.isEmpty()) arr[i]=-1;
            else arr[i]=st.peek();
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<arr.length;i++){
            if(set.containsKey(nums2[i])){
                int idx = set.get(nums2[i]);
                ans[idx] = arr[i];
            }
        }
        return ans;
    }
}