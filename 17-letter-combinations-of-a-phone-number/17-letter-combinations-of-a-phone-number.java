class Solution {
    List<String> res=new ArrayList<>();
    String[] Dict;
    public List<String> letterCombinations(String digits) {
        //Dictionary
        Dict=new String[10];
        Dict[2]="abc";
        Dict[3]="def";
        Dict[4]="ghi";
        Dict[5]="jkl";
        Dict[6]="mno";
        Dict[7]="pqrs";
        Dict[8]="tuv";
        Dict[9]="wyxz";
        
        //Function that get all combination of numbers
        getCombinations(digits,0,new StringBuilder());
        return res;
    }
    
    public void getCombinations(String digits,int index, StringBuilder str){
        if(digits.length()==0) return;
        if(digits.length()==str.length()){
            res.add(str.toString());
            return;
        }
        
        String s=Dict[digits.charAt(index)-'0'];
        char ch;
        for(int i=0;i<s.length();i++){
            str.append(s.charAt(i));
            getCombinations(digits,index+1,str);
            str.setLength(str.length()-1);
        }
    }
}