class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            temp.add(new int[] { position[i], speed[i] });
        }
        Collections.sort(temp, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < position.length; i++) {
            double d = target - temp.get(i)[0];
            double s = temp.get(i)[1];
            double t = d / s;
            if (!st.isEmpty() && st.peek() >= t)
                continue;
            st.push(t);
        }
        return st.size();
    }
}
