class Solution {
    public int findTheWinner(int n, int k) {
        int curP=0;
        ArrayList<String> table=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            table.add(Integer.toString(i+1));
        }
        k--;
        int inc=k;
        while(n!=1){
            while(k>=n) k=k-n;
            table.remove(k);
            k=k+inc;
            n--;
        }
        return Integer. parseInt(table.get(0));
    }
}