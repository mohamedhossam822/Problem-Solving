class Solution {

    public String frequencySort(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();

        ArrayList<Character>[] arr = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<Character>();
        }

        Map<Character, Integer> Freq = new HashMap<Character, Integer>();
        char c;
        for (int i = 0; i < n; i++) {
            c=s.charAt(i);
            if (Freq.containsKey(c)) Freq.put(c, Freq.get(c) + 1);
            else Freq.put(c, 1);
        }

        for (Map.Entry<Character, Integer> set : Freq.entrySet())
            arr[set.getValue()].add(set.getKey());

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < arr[i].size(); j++) {
                for(int k=0;k<i;k++)
                res.append(arr[i].get(j));
            }
        }
        return res.toString();
    }
}
