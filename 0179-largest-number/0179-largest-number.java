class Solution {
    public String largestNumber(int[] nums) {
        HashMap<Integer, String> map = new HashMap<>();
        int n=nums.length;

        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b)->{
            return (b+a).compareTo(a+b);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}