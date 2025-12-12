class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[][] userStatus = new int[numberOfUsers][2];
        int globalMentions = 0;

        Collections.sort(events, (a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB)
                return timeA - timeB;

            int aOff = a.get(0).equals("OFFLINE") ? 0 : 1;
            int bOff = b.get(0).equals("OFFLINE") ? 0 : 1;
            return aOff - bOff;
        });

        for (List<String> ev : events) {
            String type = ev.get(0);
            int time = Integer.parseInt(ev.get(1));
            String users = ev.get(2);

            if (type.equals("MESSAGE")) {
                if (users.equals("ALL")) {
                    globalMentions++;
                } else if (users.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (userStatus[i][0] <= time)
                            userStatus[i][1]++;
                    }
                } else {
                    String[] ids = users.split(" ");
                    for (String id : ids) {
                        int idx = Integer.parseInt(id.replace("id", ""));
                        userStatus[idx][1]++;
                    }
                }
            } else {
                int idx = Integer.parseInt(users);
                userStatus[idx][0] = time + 60;
            }
        }

        int[] res = new int[numberOfUsers];
        for (int i = 0; i < numberOfUsers; i++) {
            res[i] = userStatus[i][1] + globalMentions;
        }
        return res;
    }
}
