import java.util.Scanner;
import java.util.Random;
class Game{
    int systemInput;
    int userInput;
    int noofGuesses=0;
    Game(){
        Random random=new Random();
        this.systemInput=random.nextInt(100)+1;

    }
    public boolean takeUserInput(){
        if(noofGuesses<10){
            System.out.print("Guess the number:");
            this.userInput=GuessTheNumber.takeIntegerInput(100);
            noofGuesses++;
            return false;
        }
        else{
            System.out.println(" Number of Attempts finished...! Better Luck next time\n");
            return true;
        }
    }
public boolean isCorrrectGuess(){

    
    if ( systemInput == userInput) {
        System.out.println("Congratulations, You guess the number"+ systemInput+"in"+noofGuesses+"guesses");
        switch(noofGuesses){
            case 1:
            System.out.println("your score is 100");
            break;
            case 2:
            System.out.println("your score is 90");
            break;
            case 3:
            System.out.println("your score is 80");
            break;
            case 4:
            System.out.println("your score is 70");
            break;
            case 5:
            System.out.println("your score is 60");
            break;
            case 6:
            System.out.println("your score is 50");
            break;
            case 7:
            System.out.println("your score is 40");
            break;
            case 8:
            System.out.println("your score is 30");
            break;
            case 9:
            System.out.println("your score is 20");
            break;
            case 10:
            System.out.println("your score is 10");
            break;
        }
        System.out.println();
        return true;

    }
    else if(noofGuesses<10 && userInput>systemInput){
        if(userInput - systemInput > 10){
            System.out.println("Too High");
        }
        else{
            System.out.println("Little High");
        }
    }
    else if(noofGuesses<10 && userInput < systemInput){
        if(userInput - systemInput > 10){
            System.out.println("Too Low");
        }
        else{
            System.out.println("Little Low");
        }
    }
    return false;
 }
}
 public class GuessTheNumber {
    public static int takeIntegerInput(int limit)
{
    int input = 0;
    boolean flag = false;
    while(!flag){
        try{
            Scanner sc=new Scanner(System.in);
            input =sc.nextInt();
            flag=true;
            if(flag && input>limit||input<1){
                System.out.println("choose the number between 1 to"+limit);
                flag=false;
            }
        }
        catch(Exception e){
            System.out.println("enter only integer value");
            flag = false;
        }
    };
    return input;


}
public static void main(String[] args){
    System.out.println("1.Start the Game\n 2. exit");
    System.out.print("Enter your choice:");
    int choice = takeIntegerInput(2);
    int nextRound=1;
    int noofRound=0;
    if(choice==1){
        while(nextRound==1){
            Game game=new Game();
            boolean isMatched=false;
            boolean isLimitCross=false;
            System.out.println("\n Round"+ ++noofRound+"starts..");
            while(!isMatched && !isLimitCross){
                isLimitCross = game.takeUserInput ();
                isMatched = game.isCorrrectGuess ();
            }
            System.out.println("1. Next Round \n2. Exit");
            System.out.println("Enter your choice:");
            nextRound = takeIntegerInput(2);
            if(nextRound != 1){
                System.exit(0);
            }
        }
    }
    else{
        System.exit(0);
    }
} 
 }