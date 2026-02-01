class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class RideSharingSystem {
    Map<Integer, ListNode> riderMap;
    ListNode rHead;
    ListNode rTail;
    Map<Integer, ListNode> driverMap;
    ListNode dHead;
    ListNode dTail;

    public RideSharingSystem() {
        rHead = new ListNode(-1);
        rTail = new ListNode(-1);
        rHead.next = rTail;
        rTail.prev = rHead;
        riderMap = new HashMap<>();

        dHead = new ListNode(-1);
        dTail = new ListNode(-1);
        dHead.next = dTail;
        dTail.prev = dHead;
        driverMap = new HashMap<>();
    }

    public void addRider(int riderId) {
        ListNode newRider = new ListNode(riderId, rTail, rTail.prev);
        rTail.prev.next = newRider;
        rTail.prev = newRider;
        riderMap.put(riderId, newRider);
    }

    public void addDriver(int driverId) {
        ListNode newDriver = new ListNode(driverId, dTail, dTail.prev);
        dTail.prev.next = newDriver;
        dTail.prev = newDriver;
        driverMap.put(driverId, newDriver);
    }

    public int[] matchDriverWithRider() {
        if (riderMap.size() == 0 || driverMap.size() == 0)
            return new int[] { -1, -1 };
        ListNode rid = rHead.next;
        ListNode driv = dHead.next;
        rHead.next = rid.next;
        rid.next.prev = rHead;
        rid.next = null;
        rid.prev = null;

        dHead.next = driv.next;
        driv.next.prev = dHead;
        driv.next = null;
        driv.prev = null;

        riderMap.remove(rid.val);
        driverMap.remove(driv.val);

        return new int[] { driv.val, rid.val };
    }

    public void cancelRider(int riderId) {
        if (!riderMap.containsKey(riderId))
            return;
        ListNode getRiderNode = riderMap.get(riderId);
        riderMap.remove(riderId);
        getRiderNode.prev.next = getRiderNode.next;
        getRiderNode.next.prev = getRiderNode.prev;
        getRiderNode.next = null;
        getRiderNode.prev = null;
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
