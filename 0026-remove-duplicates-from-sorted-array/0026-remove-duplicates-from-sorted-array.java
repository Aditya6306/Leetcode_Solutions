class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele : nums) set.add(ele);
        int i=0;
        for(int ele : set){
            nums[i]=ele;
            i++;
        }
        return set.size();
    }
}