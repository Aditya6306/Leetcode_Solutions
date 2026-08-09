class Solution {
    public void merge(int[] arr, int a[], int b[]){
        int i=0, j=0, k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]) arr[k++]=a[i++];
            else arr[k++] = b[j++];
        }
        while(i<a.length){
            arr[k++]=a[i++];
        }
        while(j<b.length){
            arr[k++]=b[j++];
        }
    }
    int ct=0;
    public void count(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int len = r-l+1;

        int mid = l + len/2;

        int[] a = new int[len/2];

        int b[] = new int[len-(len/2)];
        int k=0;
        for(int i=l;i<mid;i++) a[k++] = nums[i];
        k=0;
        for(int i=mid;i<=r;i++) b[k++] = nums[i];

        count(a, 0, a.length-1);
        count(b, 0, b.length-1);

        int i=0, j=0;

        while(i<a.length && j<b.length){
            long n = (long)2*b[j];
            if(a[i]>n){
                int le = a.length-i;
                ct+=le;
                j++;
            }
            else{
                i++;
            }
        }
        merge(nums, a, b);
    }
    public int reversePairs(int[] nums) {
        count(nums, 0, nums.length-1);
        return ct;
    }
}