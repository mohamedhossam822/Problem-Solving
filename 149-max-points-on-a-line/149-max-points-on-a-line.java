class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Float,HashSet<List<Integer>>> slopes=new HashMap<>();
        HashMap<Integer,HashSet<List<Integer>>> vertical=new HashMap<>();
        HashMap<Integer,HashSet<List<Integer>>> horizontal=new HashMap<>();
        int x1,y1,x2,y2,max=1;
        float slope;
        int n=points.length;
        for(int i=0;i<n-1;i++){
            
            x1=points[i][0];
            y1=points[i][1];
            
            for(int j=i+1;j<n;j++){
                
                x2=points[j][0];
                y2=points[j][1];
                
                //2 points lie on horizontal line y=c;
                if((y2-y1)==0){
                    
                    if(!horizontal.containsKey(y2)) horizontal.put(y2,new HashSet<>());
                    horizontal.get(y2).add(new ArrayList<>(Arrays.asList(x1,y1)));
                    horizontal.get(y2).add(new ArrayList<>(Arrays.asList(x2,y2)));
                    if(horizontal.get(y2).size()>max) max=horizontal.get(y2).size();
                }
                //2 points lie on vertical line x=c;
                else if((x2-x1)==0){
                    
                    if(!vertical.containsKey(x2)) vertical.put(x2,new HashSet<>());
                    vertical.get(x2).add(new ArrayList<>(Arrays.asList(x1,y1)));
                    vertical.get(x2).add(new ArrayList<>(Arrays.asList(x2,y2)));
                    if(vertical.get(x2).size()>max) max=vertical.get(x2).size();
                }
                //Normal slope
                else{
                    
                    slope=(float)(y2-y1)/(float)(x2-x1);
                    if(!slopes.containsKey(slope)) slopes.put(slope,new HashSet<>());
                    slopes.get(slope).add(new ArrayList<>(Arrays.asList(x1,y1)));
                    slopes.get(slope).add(new ArrayList<>(Arrays.asList(x2,y2)));
                    if(slopes.get(slope).size()>max) max=slopes.get(slope).size();
                }  
            }
            slopes.clear();
            vertical.clear();
            horizontal.clear();
        }
        
        return max;
    }
}