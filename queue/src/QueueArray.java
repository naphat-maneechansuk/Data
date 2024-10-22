public class QueueArray implements Queue{
    ArrayList data;
    int first = 0;
    int back = 0;
    QueueArray(int size){
        data = new ArrayList(size);
    }
    @Override
    public void enqueue(Object value) {
        data.add(value);
        back++;
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object peek() {
        return data.get(first);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void show() {
        data.show();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public boolean isFull(){
        return false;
    }
}
