class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ct5=0;
        int ct10=0;
        int ct20=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                ct5++;
                continue;
            }
            else if(bills[i] == 10){
                if(ct5 >=1 ){
                    ct10++;
                    ct5--;
                }
                else return false;
            }
            else{
                if(ct10 >=1 && ct5 >= 1){
                    ct10--;
                    ct5--;
                    ct20++;
                }
                else if(ct5>=3){
                    ct5 -= 3;
                    ct20++;
                }
                else return false;
            }
        }
        return true;
    }
}