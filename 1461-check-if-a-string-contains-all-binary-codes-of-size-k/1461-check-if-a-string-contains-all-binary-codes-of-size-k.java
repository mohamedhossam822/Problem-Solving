class Solution {
    public boolean hasAllCodes(String s, int k) {
        boolean[] nums=new boolean[(int)Math.pow(2,k)];
        int index,num,valsChecked=(int) Math.pow(2,k);
        for(int i=0;i<=s.length()-k;i++){
            num=0;
            index=i;
            for(int j=k-1;j>=0;j--){
                num+=Math.pow(2,j)*Character. getNumericValue(s.charAt(index));
                index++;
            }
            if(!nums[num]) {
                nums[num]=true;
                valsChecked--;
                if(valsChecked==0) return true;
            }
        }
        return false;
    }
}