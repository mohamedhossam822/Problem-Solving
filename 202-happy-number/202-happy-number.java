class Solution {
    public boolean isHappy(int n) {
        int number=0;
        HashSet<Integer> numbers=new HashSet<>();
        while(true) {
            number+=(n%10)*(n%10);
            n=n/10;
            if(n==0){
                if(numbers.contains(number)) return false;
                numbers.add(number);
                if(number==1) return true;
                n=number;
                number=0;
            }
        }
    }
}