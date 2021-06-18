import java.util.Scanner;

public class App {

    public static boolean is_up = true; //condition to stop or not the loop

    //menu for the app
    public static void optionMenu() {
        System.out.println("Selec the option that you want: ");
        System.out.println("1 - Set hand and number to count");
        System.out.println("2 - Quit");
    }

    //menu for the options of inputs
    public static void numbersMenu(){
        try {
            // Using Scanner for Getting Input from User
            Scanner input2 = new Scanner(System.in);
                    
            System.out.println("Number to count: ");
            int nc = input2.nextInt();
            System.out.println("Number of hands: ");
            int nh = input2.nextInt();

            FingerCount.setExactLocation(nc, nh);
            //input2.close();

        } catch (Exception e) {
            System.out.println("Just use numbers \n");
        }
    }

    //do while loop for the menu
    public static void main(String[] args) throws Exception {
        do{
            try {

                optionMenu();

                Scanner input = new Scanner(System.in);
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        numbersMenu();
                        break;
                    case 2:
                        input.close();
                        is_up = false;
                        break;
                    default:
                        System.out.println("Use the options 1 or 2");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Do not use letters");
            }
        } while(is_up);
    }
}
