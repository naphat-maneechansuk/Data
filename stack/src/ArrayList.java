
public class ArrayList implements Collection {

    private int capacity;
    private int count;
    private Object[] arry;

    ArrayList(int size_arr){
        count = 0;
        capacity = size_arr;
        arry = new Object[size_arr];
    }
    @Override
    public void add(Object value) {
        add(count, value);
    }

    @Override
    public void add(int index, Object value) {
        if(index > count){
            throw new RuntimeException("Array Out of Bounds");
        }
        if(isFull()){
            throw new RuntimeException("Array Out of Bounds");
        }
        for(int i = capacity-1; i > index; i--){
            arry[i] = arry[i-1];
        }
        arry[index] = value;
        count++;
    }

    @Override
    public Object get(int index) {
        if(index > count - 1 ){
            throw new RuntimeException("Array Out of Bounds");
        }

        return arry[index];
    }

    @Override
    public void set(int index, Object value) {
        if(index > count - 1 ){
            throw new RuntimeException("Array Out of Bounds");
        }

        arry[index] = value;
    }

    @Override
    public void remove(Object value) {
        int index = indexOf(value);
        while (index != -1) {
            for (int i = index; i < count - 1; i++) {
                arry[i] = arry[i + 1];
            }
            arry[count - 1] = null; // Optional: Clear the last element after shifting
            count--;
            index = indexOf(value); // Update index in case of multiple occurrences
        }
    }

    public void removeIndex(int index){

    }

    @Override
    public boolean find(Object value) {
        for(int i =0; i < count; i++){
            if(arry[i] == value){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value){
        for(int i =0; i < count; i++){
            if(arry[i] == value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for(int i =0; i < capacity; i++){
            System.out.print(i);
            System.out.print("=>");
            System.out.print(arry[i]);
            if(i+1 != capacity) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public int size() {
        return count;
    }

    public int maxSize(){
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull(){
        return count == capacity;
    }



}
