public class ArrayList implements Collection {
    private int capacity;
    private int count;
    private Object[] arry;

    public ArrayList(int size) {
        arry = new Object[size];
        capacity = size;
        count = 0;
    }

    @Override
    public void add(Object value) {
        if (!isFull()) {
            add(count, value);
        } else {
            throw new RuntimeException("is full");
        }
    }

    @Override
    public void add(int index, Object value) {
        if (index == count) {
            arry[index] = value;
        } else if (index < count) {
            for (int i = count; i > index; i--) {
                arry[i] = arry[i - 1];
            }
            arry[index] = value;
        } else {
            throw new RuntimeException("out of bounds");
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if (index < count) {
            return arry[index];
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void set(int index, Object value) {
        if (index < count) {
            arry[index] = value;
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void remove(Object value) {
        if (indexOf(value) == -1) {
            throw new RuntimeException("not found");
        }
        Object[] temp_arry = new Object[capacity];
        int temp_count = 0;
        for (int i = 0; i < capacity; i++) {
            if (arry[i] != value) {
                temp_arry[temp_count++] = arry[i];
            } else {
                count--;
            }
        }
        arry = temp_arry;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < count; i++) {
            if (arry[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    public int max_size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }


    public boolean isFull() {
        return count >= capacity;
    }

    @Override
    public void show() {
        System.out.print("[");
        if (!isEmpty())
            for (int i = 0; i < max_size(); i++) {
                if (i == 0) {
                    System.out.print(" ");
                }
                System.out.print(i);
                System.out.print("=>");
                System.out.print(arry[i]);
                if (i < max_size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.print(" ");
                }
            }
        System.out.println("]");
    }

    public void sort_insertion() {
        for (int i = 1; i <= size() - 1; i++) {
            Object temp = get(i);
            int j = i - 1;
            while (j >= 0
                    &&
                    Integer.parseInt(get(j).toString())
                            > Integer.parseInt(temp.toString())
            ) {
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, temp);
        }
    }

    public void sort_selection() {
        for(int i =0; i<=size()-2; i++){
            int min = i;
            for(int j = i+1; j <= size()-1;j++){
                if(Integer.parseInt(get(j).toString())
                        < Integer.parseInt(get(min).toString())){
                    min = j;
                }
            }
            Object temp = get(i);
            set(i,get(min));
            set(min, temp);
        }
    }

    public void sort_bubble() {

        for(int i = 1;i<=size()-1;i++){
            for(int j=size()-1; j>=i; j--){
                if(Integer.parseInt(get(j).toString())
                        < Integer.parseInt(get(j-1).toString())){
                    Object temp = get(j);
                    set(j, get(j-1));
                    set(j-1, temp);
                }
            }
        }

    }

    public void sort_shell() {
        

    }

}