public class StackLink implements Stack {

    private int top = -1;
    private LinkedList data;

    StackLink(){
        data = new LinkedList();
    }

    @Override
    public void push(Object value) {
        data.add(value);
        top++;
    }

    @Override
    public Object pop() {
        Object value = peek();
        data.removeIndex(top);
        top--;
        return value;
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
}
