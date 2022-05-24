class Solution {
    public int reverse(int x) {
        int len=0,res=0;
        int temp=x/10;
        while(temp!=0){
            len++;
            temp=temp/10;
        }
        while(len>=0){
            temp=x%10;
            res+=Math.pow(10, len)*temp;
            len--;
            x=x/10;
        }
        if(res==Integer.MAX_VALUE || res== Integer.MIN_VALUE) return 0;
        return res;
        
    }
}