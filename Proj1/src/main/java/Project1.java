import java.util.*;


public class Project1 {

    private static final int NUMOFGARAGES = 3;
    private static final String QUESTION = "Which garage : (1,2 or 3)";


    private static void printMenu(){
        System.out.println("O - Open door");
        System.out.println("C - Close door");
        System.out.println("P - Pull car in");
        System.out.println("B - Back car out");
        System.out.println("F - Find an empty space");
        System.out.println("D - Display space state");
        System.out.println("E - Exit the program");
    }

    private static int getValidChoice(String question, int min, int max, Scanner in){
        int inputGarage;
        do{
            System.out.println(question);
            inputGarage = in.nextInt();
        } while(inputGarage < min || inputGarage > max);
        return inputGarage;
    }

    private static void findEmptySpace(Garage[] garageArray){
        for(int i = 0; i < NUMOFGARAGES; i++){
            if(garageArray[i].isEmpty()){
                System.out.printf("Garage %d is empty\n", i+1 );
                return;
            }
        }
        System.out.println("All the Garages are full, please park somewhere else");
    }

    public static void main(String[] args){


        String inputChar;
        int inputGarage;
        Scanner in;
        Garage[] Garages = new Garage[NUMOFGARAGES];

        for(int i=0;i<NUMOFGARAGES;i++){
            Garages[i] = new Garage();
        }

        do{

            in = new Scanner(System.in);
            printMenu();
            inputChar = in.next();

            if (inputChar.charAt(0) == 'O' || inputChar.charAt(0) == 'o'){
                inputGarage = getValidChoice(QUESTION,1,3,in);
                if (Garages[inputGarage-1].openDoor()){
                    System.out.println("The door has been open");
                }
                else{
                    System.out.println("The door is not operational");
                }
            }
            else if (inputChar.charAt(0) == 'C' || inputChar.charAt(0) == 'c') {
                inputGarage = getValidChoice(QUESTION,1,3,in);
                if (Garages[inputGarage - 1].closeDoor()){
                    System.out.println("The door has been closed");
                }
                else{
                    System.out.println("The garage is not operational");
                }

            }
            else if (inputChar.charAt(0) == 'P' || inputChar.charAt(0) == 'p') {
                inputGarage = getValidChoice(QUESTION,1,3,in);
                if (Garages[inputGarage - 1].pullCarIn() == 1){
                    System.out.println("The door is not operational");
                }else if(Garages[inputGarage - 1].pullCarIn() == 2){
                    System.out.println("You broke the garage door");
                }else if(Garages[inputGarage - 1].pullCarIn() == 3){
                    System.out.println("The garage has met an accident");
                }else{
                    System.out.println("The car has been pulled in");
                }
            }
            else if (inputChar.charAt(0) == 'B' || inputChar.charAt(0) == 'b') {
                inputGarage = getValidChoice(QUESTION,1,3,in);
                if (Garages[inputGarage - 1].backCarOut() == 1){
                    System.out.println("The door is not operational");
                }else if(Garages[inputGarage - 1].backCarOut() == 2){
                    System.out.println("You broke the garage door");
                }else if(Garages[inputGarage - 1].backCarOut() == 3){
                    System.out.println("There is no car in the garage");
                }else{
                    System.out.println("The car has been backed out from this garage");
                }
            }
            else if (inputChar.charAt(0) == 'F' || inputChar.charAt(0) == 'f') {
                findEmptySpace(Garages);
            }
            else if (inputChar.charAt(0) == 'D' || inputChar.charAt(0) == 'd'){
                inputGarage = getValidChoice(QUESTION,1,3,in);
                System.out.println(Garages[inputGarage - 1]);
            }
            else if (inputChar.charAt(0) == 'E' || inputChar.charAt(0) == 'e') {
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }

        } while(in.hasNextLine());
    }
}
