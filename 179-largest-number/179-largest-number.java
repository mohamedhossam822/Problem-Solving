class Solution {
    public String largestNumber(int[] nums) {
        List<String> numbers=new ArrayList<>();
        for(int num : nums){
            numbers.add(String.valueOf(num));
        }
        Collections.sort(numbers, (a,b)->{
            String s1=a+b;
            String s2=b+a;
            return s2.compareTo(s1);
        });
        StringBuilder str=new StringBuilder();
        for(String s : numbers) str.append(s);
        if(str.charAt(0)=='0') return "0";
        return str.toString();
    }
}