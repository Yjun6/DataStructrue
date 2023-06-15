class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n != 0){
            if((n&1) == 1){
               if(n == 1){
                   return true; 
               }else{
                   return false;
               }
            }
            n = n >> 1;
        }

        return false;
    }
}