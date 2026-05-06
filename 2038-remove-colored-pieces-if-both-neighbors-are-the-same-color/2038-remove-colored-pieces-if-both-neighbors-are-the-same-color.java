class Solution {
    public boolean winnerOfGame(String colors) {
        int A=0;
        int B=0;
        int i=1;
        int n=colors.length();
        while(i<n-1){
            char curr=colors.charAt(i);
            char pre=colors.charAt(i-1);
            char next=colors.charAt(i+1);

            if(curr == 'A' && pre == 'A' && next=='A')A++;
            if(curr == 'B' && pre == 'B' && next=='B')B++;

            i++;
        }
        System.out.println(A+" "+ B);
        int diff = A-B;
        if(diff <=0 ) return false;
        return true;

        
    }
}