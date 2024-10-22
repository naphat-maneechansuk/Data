public class DoublyLinkedList implements Collection {

    class node {
        Object data;
        node link;
        node plink;

        node(Object d, node l, node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private node head;
    private node tail;
    private int count;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object value) {

        node new_node = new node(value, null, tail);

        if(isEmpty()){
            head = new_node;
            tail = new_node;
        }else{
            tail.link = new_node;
            tail = new_node;
        }
        count++;

    }

    @Override
    public void add(int index, Object value) {
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("out of bound");
        }
        if(index == size()){
            add(value);
        }else {
            node new_node = new node(value, null, null);
            if(index == 0){
                new_node.link = head;
                head.plink = new_node;
                head = new_node;
            }else {
                int i = 0;
                for (node temp = head; temp != null; temp = temp.link) {
                    if (index == i) {
                        // code here
                        System.out.println("++++++++");
                        System.out.println(temp.data);
                        System.out.println("++++++++");
                    }
                    i++;
                }
            }
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("out of bound");
        }
        int i = 0;
        for(node temp = head; temp != null; temp = temp.link){
            if(index == i) {
                return temp.data;
            }
            i++;
        }
        return null;
    }

    @Override
    public void set(int index, Object value) {

    }

    @Override
    public void remove(Object value) {

    }

    @Override
    public boolean find(Object value) {
        for(node temp = head; temp != null; temp = temp.link){
            if(temp.data == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void show() {
        System.out.print("[");
        for(node temp = head; temp != null; temp = temp.link){
            System.out.print(temp.data);
            if(temp.link !=null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    public void show_backward() {
        System.out.print("[");
        for(node temp = tail; temp != null; temp = temp.plink){
            System.out.print(temp.data);
            if(temp.plink !=null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}