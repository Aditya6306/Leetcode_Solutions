class Solution {
    public boolean check(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : nums){
            list.add(ele);
        }
        list.add(nums[0]);
        int ct = 0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1))ct++;
        }
        return ct<=1;
    }
}