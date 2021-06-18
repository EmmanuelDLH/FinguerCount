import java.util.ArrayList;

public class FingerCount {

    //list of the finguers depending of the hand
    public static String[] finguerListL = {"thumb","index finger","middle finger","ring finger","little finger"};
    public static String[] finguerListR = {"little finger","ring finger","middle finger","index finger","thumb"};

    public static ArrayList<String> finguerToltal = new ArrayList<String>();

    //method to see the position of the finguer no matters the total of hands
    public static int findFingerHand(int countNumber, int handNumber) {
        int ndif = 0;
        int dif = 0;
        int r = 0;

        if (handNumber > 1){
            ndif = (handNumber - 1) * 10;
        }

        dif = 8 + ndif;
        r = countNumber % dif;

        if (r == 0)
            return 2;
        if (r < 5 + (ndif / 2))
            return r;
        else
            return (10 + ndif) - r;
    }

    public static void finguerName(int countNumber,int finguerNumberIndex, int i, int handNumber) {
        
        int countRest = 0;
        int value = countNumber;
        int ndif = 0;
        int dif = 0;
        boolean is_up = true;

        if (handNumber > 1){
            ndif = (handNumber - 1) * 10;
        }

        dif = 8 + ndif;

        do {
            value = value - dif;
            countRest += 1;

            if(value < 0){
                countRest -= 1;
                is_up = false;
            }
        } while (is_up);

        String finguerName = "UnComment finguer name values and it works to say what finguer is until 3 hands";
        if (countRest % 2 == 0) {
            //Esta contando para la derecha (finguerListL)
            if (handNumber == 1) {
                finguerName = finguerListL[finguerNumberIndex];    
                System.out.println("Finguer: " + finguerNumberIndex + " (" + finguerName + ")");
                System.out.println("Hand: " + i + "\n");
            } else{
                //si la mano en la que estoy es par entonces las posciciones del index cambia
                if (i % 2 == 0) { //para cuando se encuentra en una mano de en medio
                    int index = ((handNumber * 5) -5);
                    //finguerName = finguerListL[(index - finguerNumberIndex)];
                    System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                    System.out.println("Hand: " + i + "\n");
                } else {
                    int index = ((handNumber * 5) -5);
                    if ((index < finguerNumberIndex) && (finguerNumberIndex > (index + 5))) {//si se encuentra en la ultima mano
                        //finguerName = finguerListL[(index - finguerNumberIndex)];
                        System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                        System.out.println("Hand: " + i + "\n");
                    } else{
                        //si se encuentra en la primer mano
                        //finguerName = finguerListL[finguerNumberIndex - 1];
                        System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                        System.out.println("Hand: " + i + "\n");
                    }
                }
            }

        } else{
            //Esta contando para la izquierda (finguerListR)
            if (handNumber == 1) {
                finguerName = finguerListL[finguerNumberIndex];    
                System.out.println("Finguer: " + finguerNumberIndex + " (" + finguerName + ")");
                System.out.println("Hand: " + i + "\n");
            } else{
                if (i % 2 == 0) { //para cuando se encuentra en una mano de en medio
                    int index = ((handNumber * 5) -5);
                    //finguerName = finguerListR[(index - finguerNumberIndex)];
                    System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                    System.out.println("Hand: " + i + "\n");
                } else {
                    int index = ((handNumber * 5) -5);
                    if ((index < finguerNumberIndex) && (finguerNumberIndex > (index + 5))) {//si se encuentra en la ultima mano
                        //finguerName = finguerListR[(index - finguerNumberIndex)];
                        System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                        System.out.println("Hand: " + i + "\n");
                    } else{
                        //si se encuentra en la primer mano
                        //finguerName = finguerListR[finguerNumberIndex - 1];
                        System.out.println("Finguer: " + finguerNumberIndex );//+ " (" + finguerName + ")");
                        System.out.println("Hand: " + i + "\n");
                    }
                }
            }
        }
    }

    //start method, this is for seen the exact position of the finguer and the hand
    public static void setExactLocation(int countNumber, int handNumber) {

        int finguerNumberIndex = findFingerHand(countNumber, handNumber);
        for (int i = 1; i <= handNumber; i++) { //I can say to you what hand its righ know
            if (finguerNumberIndex <= (i * 5)) { //This is to say is in that hand or not
                finguerName(countNumber, finguerNumberIndex, i, handNumber);
                break;
            }
        }
    }
}
