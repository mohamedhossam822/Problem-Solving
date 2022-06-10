class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //construct an array of managers
        Manager[] Managers=new Manager[n];
        for(int i=0;i<n;i++){
            Managers[i]=new Manager(i,informTime[i]);
        }
        //connect each manager to his employees
        for(int i=0;i<n;i++){
            if(manager[i]==-1) continue;
            Managers[manager[i]].employees.add(Managers[i]);
        }
        return getMax(Managers[headID]);
    }
    
    public int getMax(Manager manag){
        int max=0;
        for(Manager m: manag.employees) max=Math.max(max,getMax(m));
        return manag.informTime+max;
    }
    
    public class Manager{
        int informTime;
        List<Manager> employees;
        public Manager(int id,int informTime){
            employees=new ArrayList<>();
            this.informTime=informTime;
        }
    }
}