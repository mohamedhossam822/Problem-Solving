class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res=new ArrayList<>();
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
                if(firstList[i][0]<=secondList[j][0] && firstList[i][1]>=secondList[j][0]){
                    if(firstList[i][1]>secondList[j][1]) {
                        res.add(new int[]{secondList[j][0],secondList[j][1]});
                        j++;
                    }
                    else {
                        res.add(new int[]{secondList[j][0],firstList[i][1]});
                        i++;
                    }
                }
                else if(firstList[i][0]>=secondList[j][0] && firstList[i][0]<=secondList[j][1]){
                    if(secondList[j][1]>firstList[i][1]) {
                        res.add(new int[]{firstList[i][0],firstList[i][1]});
                        i++;
                     }
                    else{
                        res.add(new int[]{firstList[i][0],secondList[j][1]});
                        j++;
                    }
                    
                }
                else{
                    if(firstList[i][1]>secondList[j][1])    j++;
                    else i++;
                }   
            }
        int[][] array = new int[res.size()][2];
        for (i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
        }

    }
