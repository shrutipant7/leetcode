class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
            for(int i=0; i< numRows; i++) {
                if(i == 0) {
                    res.add(new ArrayList<>(Arrays.asList(1)));
                }
                else if(i == 1) {
                    res.add(new ArrayList<>(Arrays.asList(1, 1)));
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    for(int j=0; j<=i; j++) {
                        if( j==0 || j==i) list.add(1);
                        else {
                            list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                        }
                    }
                    res.add(list);
                }
            }
    return res;
    }
}
