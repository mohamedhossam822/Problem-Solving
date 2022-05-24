class Solution {
    public String convert(String s, int numRows) {
        int i=0,j=0,cIndex=0;
        ArrayList<ArrayList<Character>> res=new ArrayList<>();
        while(cIndex<s.length()){
            ArrayList<Character> list=new ArrayList<>();
            if(j==0){
                for(j=0;j<numRows;j++){
                    if(cIndex>=s.length()) list.add(' ');
                    else list.add(s.charAt(cIndex));
                    cIndex++;
                }
                j--;
            }
            else{
               for(int k=0;k<numRows;k++){
                    if(k==j){
                        list.add(s.charAt(cIndex));
                        cIndex++;
                    }else list.add(' ');
                    
                } 
            }
            res.add(list);
            j--;
            if(j<0) j=0;
        }
        System.out.println(res);
        StringBuilder str=new StringBuilder();
        char c;
        for(i=0;i<numRows;i++){
            for(j=0;j<res.size();j++){
                c=res.get(j).get(i);
                if(c!=' ') str.append(c);
            }
        }
        return str.toString();
        
    }
}