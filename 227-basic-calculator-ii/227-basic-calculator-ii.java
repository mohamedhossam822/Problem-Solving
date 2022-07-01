class Solution {

    public int calculate(String s) {
        return calculate(0, s,new StringBuilder());
    }

    public int calculate(int index, String s,StringBuilder numStr) {
        int num = 0;
        boolean divide = false;
        boolean multi = false;
        
        
        while (index < s.length() && s.charAt(index) != '+' && s.charAt(index) != '-') {
            if(s.charAt(index)==' '){
                index++;
                continue;
            }
            if (s.charAt(index) == '*' || s.charAt(index) == '/') {
                if (divide) {
                    num = num / Integer.parseInt(numStr.toString());
                    divide = false;
                } else if (multi) {
                    num = num * Integer.parseInt(numStr.toString());
                    multi = false;
                } else num = Integer.parseInt(numStr.toString());
                numStr.setLength(0);

                if (s.charAt(index) == '*') multi = true; else divide = true;
            } else numStr.append(s.charAt(index));
            index++;
            
        }
        
        
        if (divide) {
            num = num / Integer.parseInt(numStr.toString());
        } else if (multi) {
            num = num * Integer.parseInt(numStr.toString());
        } else num = Integer.parseInt(numStr.toString());
        numStr.setLength(0);
        if (index == s.length()) return num;
        if (s.charAt(index) == '+') return num + calculate(index + 1, s,numStr);
        numStr.append('-');
        return num + calculate(index + 1, s,numStr);
    }
}
