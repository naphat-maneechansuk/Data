import java.util.Scanner;

public class RunIntoPost {
    static public void run(){
        Scanner input = new Scanner(System.in);
        String checker = "";

        while(true){
            checker = input.nextLine();
            if(checker.equals("exit")){
                break;
            }
            for(int i =0; i < checker.length(); i++){
                System.out.print(checker.charAt(i));
                
            }
        }
    }

}
