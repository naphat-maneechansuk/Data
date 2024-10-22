// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Object [] arr = new Object[3];
        Object [] temp = new Object[2];
        temp[0] = 123;
        arr[0] = temp;
        arr[1] = "789";
        Object [] temp2 = ((Object[]) arr[0]);
//        temp2[0] = "123";
        ((Object[]) arr[0])[1] = "456";

        System.out.println(arr[0]);
        System.out.println(((Object[]) arr[0])[0]);
        System.out.println(((Object[]) arr[0])[1]);
        System.out.println(arr[1]);
    }
}