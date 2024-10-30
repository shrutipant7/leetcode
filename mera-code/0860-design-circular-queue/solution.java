class MyCircularQueue {
    private int[] arr;
    private int front, rear, maxSize, curSize;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = rear = -1;
        maxSize = k;
        curSize = 0;
    }
    
    public boolean enQueue(int value) {
        if (curSize == maxSize) return false; //Overflow
        if (front == -1) front = 0;
        rear = (rear+1)%maxSize;
        arr[rear] = value;
        curSize++;
        return true;
    }
    
    public boolean deQueue() {
        if (front == -1) return false; //Underflow
        if (front == rear) front = rear = -1;
        else  front = (front+1)%maxSize;
        curSize--;
        return true;
    }
    
    public int Front() {
        if (curSize == 0) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if (curSize == 0) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if (curSize == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if (curSize == maxSize) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
