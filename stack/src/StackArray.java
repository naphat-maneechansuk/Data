public class StackArray implements Stack{

    private int top = -1;
    private ArrayList data;

    StackArray(int size){
        data = new ArrayList(size);
    }

    @Override
    public void push(Object value) {
        top++;
    }

    @Override
    public Object pop() {
        top--;
        return null;
    }

    @Override
    public Object peek() {
        return data.get(top);
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
        return data.isEmpty();
    }

    public boolean isFull(){
        return data.isFull();
    }
}
