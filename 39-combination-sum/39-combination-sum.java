class Solution {
    List<HashSet<List<Integer>>> dp;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dp = new ArrayList<HashSet<List<Integer>>>(target + 1);
        List<Integer> temp;
        for (int i = 0; i <= target; i++) {
            dp.add(null);
        }
        for (int j = 0; j < candidates.length; j++) {
            if (target >= candidates[j]) {
                if (dp.get(candidates[j]) == null) dp.set(candidates[j], new HashSet<>());
                temp = new ArrayList<>();
                temp.add(candidates[j]);
                dp.get(candidates[j]).add(temp);
            }
        }
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j <= i / 2; j++) {
                if (dp.get(j) == null || dp.get(i - j) == null) continue;
                if (dp.get(i) == null) dp.set(i, new HashSet<>());
                List<List<Integer>> list1 = new ArrayList<>(dp.get(j));
                List<List<Integer>> list2 = new ArrayList<>(dp.get(i - j));
                for (int a = 0; a < dp.get(j).size(); a++) {
                    for (int b = 0; b < dp.get(i - j).size(); b++) {
                        temp = new ArrayList<>();
                        temp.addAll(list1.get(a));
                        temp.addAll(list2.get(b));
                        Collections.sort(temp);
                        dp.get(i).add(temp);
                    }
                }
            }
        }
        // dp[2]=[{2}];
        // d[3]=[{3}];
        // dp[4]][{2,2}];
        // d[5]=[{5},{2,3}];
        // dp[6]=[{2,2,2,},{3,3}];
        // dp[7]=[{2,5},{2,2,3}];
        // dp[8]=[{2,2,2,2,},{2,3,3},{3,5},{3,2,3}];
        if (dp.get(target) == null) return new ArrayList<>();
        return new ArrayList<>(dp.get(target));
    }
}
