import java.util.*; 
class Solution {
    public String intToRoman(int num) {
        Hashtable<Integer,Character> table=new Hashtable<>();
        StringBuilder res=new StringBuilder();
        table.put(1,'I');
        table.put(6,'V');
        table.put(2,'X');
        table.put(7,'L');
        table.put(3,'C');
        table.put(8,'D');
        table.put(4,'M');
        
        int n;
        int position=1;
        while(num!=0){
            n=num%10;
            if(n==4){
                res.append(table.get(5+position));
                res.append(table.get(position));
                
            }
            else if(n==9){
                res.append(table.get(1+position));
                res.append(table.get(position));
                
            }
            else{
                if(n>=5){
                    n=n-5;
                    for(int i=0;i<n;i++){
                        res.append(table.get(position));
                    }
                    res.append(table.get(5+position));
                }
                else for(int i=0;i<n;i++){
                    res.append(table.get(position));
                }
                
            }
            position++;
            num=num/10; 
        }
        return res.reverse().toString();
    }
}