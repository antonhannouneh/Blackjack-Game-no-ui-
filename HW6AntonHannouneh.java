package hw6antonhannouneh;
// course: CSC 190
// project: Homework 6
// date:10/12/22
// author:Anton Hannouneh
// purpose:BlackJack game

//import our scanner
import java.util.Scanner;
public class HW6AntonHannouneh {
   //method to return a random integer
    public static int getRandomCard(int lower, int upper){
        int range = upper - lower + 1;
        int randomNum = (lower+(int)(Math.random()*range));
        return randomNum; 
    }
    //int method to know the card value
    public static int cardValue(int random){
        //random = getRandomCard(1, 13); *we can do this in main*
        int cardValue;
   
            //if statement to see the value of the card
        if ((random == 11)||(random == 12)||(random == 13))
            cardValue = 10;
        else if(random == 1)
           cardValue = 1;
           else{
                cardValue = random;   
                   }
       // System.out.println(cardValue);
                  return cardValue;              
    }
    //String method to get the card name
    public static String card(int random){
        String card;
        //if statment to decide which card is which
        if(random == 11)
            card = "Jack";
       
        else if(random == 12)
            card = "Queen";
        else if(random == 13)
        card = "King";
        else if(random == 1)
        card = "Ace";
         
        else if(random == 2)
        card = "Two";
        else if(random == 3)
        card = "Three";
        else if(random == 4)
        card = "Four";
        else if(random == 5)
        card = "Five";
        else if(random == 6)
        card = "Six";
        else if(random == 7)
        card = "Seven";
        else if(random == 8)
        card = "Eight";
        else if(random == 9)
        card = "Nine";
        else
            card = "Ten";
        //System.out.println(card);
return card;
    }
    
    
    //method to get the winner getWinner()
    
    public static int getWinner(int total, int totalD){
        if (totalD>21)
            return 5;
        if((total<22)&&(totalD<22)){
            if(total==totalD)
                return 4;
            
        if (totalD > 21){
            return 0;
        }
       else if(total<totalD){
            return 1;
        }
        else
            return 2;
        }
        else
            return 3;
    }
    
    public static void main(String[] args) {
        //create our scanner
        Scanner input = new Scanner(System.in);
        //declare our variables
        int choice, card1, card2, CARD1, CARD2;
        String pCard1, pCard2, dCard1, dCard2;
        //do while loop to present the menu to the user
        do{
            System.out.println("Welcome to BlackJack!");
        System.out.println("Press any number to play!");
       choice = input.nextInt();
       
       //getting the random int for the cards
       int random = getRandomCard(1, 13);
       //getting the cards and showing them to the player
       //keep overwritting the integer random till so we get diffrent values
       pCard1 = card(random);
       card1 = cardValue(random);
       random = getRandomCard(1, 13);
       pCard2 = card(random);
       card2 = cardValue(random);
       random = getRandomCard(1, 13);
       dCard1 = card(random);
       CARD1 = cardValue(random);
       random = getRandomCard(1, 13);
       dCard2 = card(random);
       CARD2 = cardValue(random);
       //make the user cards a string that way its easier to do the loop for when the user decides to draw a card
       String userCards = pCard1+" "+pCard2;
       //doing the same thing with the dealers card
       String dealerCards = dCard1+" * ";
      System.out.println("\n\nYour cards\t\t Dealer's cards");
      // System.out.println(pCard1+" "+pCard2+"\t\t"+dCard1+" "+"*"); 
      System.out.println(userCards+"\t\t"+dealerCards); 
       //see if the player wnats to cout the ace as 1 or 11
       if(pCard1 == "Ace"){
                int a = 0;
           //do while loop to see the value for the ace
           do{
           System.out.println("You drew an Ace as your first card");
           System.out.println("Do you want to count it as a 1 or 11");
           System.out.println("1.1\n2.11");
            a = input.nextInt();
           }while((a != 1)&&(a!=2));
           
           if (a==1)
               card1=1;
           else
               card1=11;
       }
       //for the second card(Ace problem)
       if(pCard2 == "Ace"){
                int a = 0;
           //do while loop to see the value for the ace
           do{
           System.out.println("You drew an Ace as your second card");
           System.out.println("Do you want to count it as a 1 or 11");
           System.out.println("1.1\n2.11");
            a = input.nextInt();
           }while((a != 1)&&(a!=2));
           
           if (a==1)
               card2=1;
           else
               card2=11;
           System.out.println(userCards+"\t\t"+dealerCards);
       }
       //to see if the computer drawed an ace
       if(dCard1=="Ace"){
        int a=getRandomCard(1, 2);
        if(a==1)
            CARD1=1;
        else
            CARD1=11;
       }
       if(dCard2=="Ace"){
        int a=getRandomCard(1, 2);
        if(a==1)
            CARD2=1;
        else
            CARD2=11;
       }
       
       int total = card1+card2;
       //total for the dealer
       int totalD = CARD1+CARD2;
       
       System.out.println("Your total is: "+ total);
      // System.out.println("dealer total is: "+ totalD); 
            int a;//for the loop
        
       //while loop to see if the player wants to draw another card or not
       do{
          
          System.out.println("\n\n1.Draw a card\n2.Continue");
          a = input.nextInt();
          if(a==1){
              random = getRandomCard(1, 13);
              //to add the card to the user hand 
             int pCard = cardValue(random);
             String Pcard = card(random);
             userCards = userCards+" "+Pcard;
            // total = total+pCard;
             //for the dealer
             random = getRandomCard(1, 13);
             int dCard = cardValue(random);
             String Dcard = card(random);
            // totalD = totalD+dCard;
             dealerCards = dealerCards+" "+Dcard;
             //if the extra card is an ace for both the player and the computer
             //for the player
             if(Pcard == "Ace"){
                
           //do while loop to see the value for the ace
           do{
           System.out.println("You drew an Ace as your card");
           System.out.println("Do you want to count it as a 1 or 11");
           System.out.println("1.1\n2.11");
            a = input.nextInt();
           }while((a != 1)&&(a!=2));
           //if statement to assign the new value
           if (a==1)
             pCard = 1;
           else
               pCard = 11;
           //System.out.println(userCards+"\t\t"+dealerCards);
       }
             else
                // System.out.println(userCards+"\t\t"+dealerCards);
             //for the computer
             if(Dcard=="Ace"){
         a=getRandomCard(1, 2);
        if(a==1)
            dCard=1;
        else
            dCard=11;
       }
             total = total+pCard;
             totalD = totalD+dCard;
             System.out.println(userCards+"\t\t"+dealerCards);
             System.out.println("Your total is: "+total);
                     }
         //to see if the plyer busts
          if (total>21){
              
              a=2;
              
          }

     }while(a!=2);
        
       //calling the getWinner()method to see who won
       //if the dealer is over 21
       if((getWinner(total, totalD))==0){//changed thisbecause of the rules
     System.out.println("\nThe dealer busted");
           System.out.println("You won!");
            System.out.printf("Your total is: %d \nThe dealer's total is: %d\n",total, totalD);
       }
       //if the dealer won
       if((getWinner(total, totalD))==1){
           System.out.println("\nThe dealer has won!");
            System.out.printf("Your total is: %d \nThe dealer's total is: %d\n\n",total, totalD);
        }
       //if the player won
       if((getWinner(total, totalD))==2){
           System.out.println("\nYou won!");
           System.out.printf("Your total is: %d \nThe dealer's total is: %d\n\n",total, totalD);
           }
       if((getWinner(total, totalD))==3){
           System.out.println("\nYou lost!");
           System.out.println("You have busted!");
           System.out.printf("Your total is: %d \nThe dealer's total is: %d\n\n",total, totalD);
           }
       //to see if it is a tie
        if((getWinner(total, totalD))==4){
           System.out.println("\nYou have tied with the dealer!");
                  System.out.printf("Your total is: %d \nThe dealer's total is: %d\n\n",total, totalD);
        }
        //if the dealer busts
        if((getWinner(total, totalD))==5){
           System.out.println("\nYou won!");
            System.out.println("The dealer has busted!");
           System.out.printf("Your total is: %d \nThe dealer's total is: %d\n\n",total, totalD);
           }
        
       //ask the user if they want to play again
       
         System.out.println("1.Play again!\n2.exit");
        choice = input.nextInt();
        
        }while(choice != 2);
    }//close main
    
}//close class

