class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    private void discardEvent(int startTime, int endTime) {
        if (map.get(startTime) == 1)
            map.remove(startTime);
        else
            map.put(startTime, map.getOrDefault(startTime, 0) - 1);

        if (map.get(endTime) == -1)
            map.remove(endTime);
        else
            map.put(endTime, map.getOrDefault(endTime, 0) + 1);
    }

    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int maxParallelMeeting = 0;
        for (TreeMap.Entry<Integer, Integer> entry : map.entrySet()) {
            maxParallelMeeting += entry.getValue();
            if (maxParallelMeeting > 2) {
                discardEvent(startTime, endTime);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
