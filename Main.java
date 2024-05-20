import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;
@SuppressWarnings("unused")
class Main {
  public static void main(String[] args){
		String hightext="";
    Scanner scanner= new Scanner(System.in);
    String inp;
    boolean a=true;
    String mode="";
		String high="";
    System.out.println("Would you like to play in Classic mode (c) or Any Bet Mode (b)? This cannot be changed until the game is rerun.");
    inp=scanner.next();
    if(inp.equalsIgnoreCase("c")){
      System.out.println("You have chosen Classic mode.");
       mode="classic";
			hightext="ClassicHigh.txt";
    } else if(inp.equalsIgnoreCase("b")){
      System.out.println("You have chosen Any Bet mode.");
       mode="bet";
			hightext="BetHigh.txt";
    }else {
      System.out.println("Invalid input. I'm too lazy to code this right, so just restart the program.");
    }
    while(a==true) {
      clear();
      if(mode=="classic") {
				high=Integer.toString(readHigh(hightext));
				clear();
      classic(high,scanner,hightext);
      } else {
				high=Integer.toString(readHigh(hightext));
				clear();
        bet(high,scanner,hightext);
      }
      System.out.println("Type y to restart the program.");
      inp=scanner.next();
      if(!inp.equalsIgnoreCase("y")) {
        a=false;
      }
    }
  }
  public static boolean isNum(String str) { 
    try {  
      Double.parseDouble(str);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }
  
  public static int bee(Scanner scanner, int total) {
    System.out.println("How much would you like to bet? Please only put the number. Your current total is $"+total);
    String inp=scanner.next();  
    if(!isNum(inp)) {
      System.out.println("Not a valid input.");
      inp=Integer.toString(bee(scanner,total));
    }else if(Float.parseFloat(inp)%1!=0)
		{
			System.out.println("Please don't do that. I know who you are. I know where you live.b");
			inp=Integer.toString(bee(scanner,total));
		} else if(Integer.parseInt(inp)>total) {
      System.out.println("You can't bet more than you have! No loan sharks here- trust me, you don't want to deal with them.");
      inp=Integer.toString(bee(scanner,total)); 
    } else if(Integer.parseInt(inp)<1) {
    System.out.println("You can't bet less than you have!");
    inp=Integer.toString(bee(scanner,total)); 
    }
    return Integer.parseInt(inp);
  }
  public static void bet(String high,Scanner scanner, String hightext){
    int game=0;
      int again=1;
      int total=100;
      int bet=10;
      int[] why = new int[3];
      String inp="";
      System.out.println("Welcome to Blackjack!");
      System.out.println("You start with $"+total+".");
      System.out.println("The high score is $"+high+".");
     while (again==1) {
       bet=bee(scanner,total);
       inp="";
       System.out.println("Bet: $"+bet+" Total: $"+total);
       game=game(scanner);
       if(game==1) {
        total+=bet;
         System.out.println("You now have a total of $"+total+".");
       if (total==0) {
         again=0;
         break;
       }
         System.out.println("Would you like to continue playing (y)  or end the game (e)?");
      } 
      else if (game==0) {
        total-=bet;
        bet=10;
        if(total<0) {
          total=0;
        }
        System.out.println("You now have a total of $"+total+".");
       if (total==0) {
         again=0;
         break;
       }
       System.out.println("Would you like to continue playing (y) or end the game (e)?");
      } 
      else {
        System.out.println("Uh oh somethings wrong aaaaaaa");
      }
      //start
      why=choiceb(scanner,inp,bet,again,game,total);
       bet=why[0];
       again=why[1];
       total=why[2];
       if(again==0) {
         break;
       }
      //end
      }
      System.out.println("You end with a total of $"+total);
      if(total==0) {
        System.out.println("You are out of money, so the game automatically ends");
      }
      if(total>Integer.parseInt(high)) {
        System.out.println("That's a new high score!");
				setHigh(total,hightext);
      } 
      else {
        System.out.println("The high score is $"+high);
      }
      System.out.println("END OF GAME");
  }
  public static int[] choiceb(Scanner scan,String inp,int bet, int again, int game, int total) {
    inp=scan.next();
        if (inp.equalsIgnoreCase("e")) {
         clear();
         again=0;
       }
       else if (inp.equalsIgnoreCase("y")) {
         clear();
       if (bet>10) {
         bet=10;
       }
       }
       else {
         clear();
         System.out.println("That is not a valid option");
         if(game==1) {
           System.out.println("Would you like to continue playing (y) or end the game (e)?");
         } else {
        System.out.println("Would you like to continue playing (y) or end the game (e)?");
         }
         choiceb(scan,inp,bet,again,game,total);
       }
    int[] why= new int [3];
      why [0]=bet;
      why [1]=again;
      why [2]=total;
    return why;
    }
  public static void classic(String high, Scanner scanner,String hightext){
    int game=0;
      int again=1;
      int total=100;
      int bet=10;
      int[] why = new int[3];
      String inp="";
      System.out.println("Welcome to Blackjack!");
      System.out.println("You start with $"+total+" and you bet a minimum of $10.");
      System.out.println("The high score is $"+high);
     while (again==1) {
       inp="";
       System.out.println("Bet: $"+bet+". Total: $"+total);
       game=game(scanner);
       if(game==1) {
        total+=bet;
         System.out.println("You now have a total of $"+total+".");
       if (total==0) {
         again=0;
         break;
       }
         System.out.println("Would you like to continue playing (y), continue and double your bet (d) or end the game (e)?");
      } 
      else if (game==0) {
        total-=bet;
        bet=10;
        if(total<0) {
          total=0;
        }
        System.out.println("You now have a total of $"+total+".");
       if (total==0) {
         again=0;
         break;
       }
       System.out.println("Would you like to continue playing (y) or end the game (e)?");
      } 
      else {
        System.out.println("Uh oh somethings wrong aaaaaaa");
      }
      //start
      why=choice(scanner,inp,bet,again,game,total);
       bet=why[0];
       again=why[1];
       total=why[2];
       if(again==0) {
         break;
       }
      //end
      }
      System.out.println("You end with a total of $"+total);
      if(total==0) {
        System.out.println("You are out of money, so the game automatically ends");
      }
      if(total>Integer.parseInt(high)) {
        System.out.println("That's a new high score!");
        setHigh(total,hightext);
      } 
      else {
        System.out.println("The high score is $"+high);
      }
      System.out.println("END OF GAME");
  }
  public static int[] choice(Scanner scan,String inp,int bet, int again, int game, int total) {
    inp=scan.next();
       if (inp.equalsIgnoreCase("d")&&game==1) {
         clear();
         bet*=2;
         System.out.println("You now have a bet of $"+bet);
       }
       else if (inp.equalsIgnoreCase("e")) {
         clear();
         again=0;
       }
       else if (inp.equalsIgnoreCase("y")) {
         clear();
       if (bet>10) {
         bet=10;
         System.out.println("Your bet has been reset to $10");
       }
       }
       else {
         clear();
         System.out.println("That is not a valid option");
         if(game==1) {
           System.out.println("Would you like to continue playing (y), continue and double your bet (d) or end the game (e)?");
         } else {
        System.out.println("Would you like to continue playing (y) or end the game (e)?");
         }
         choice(scan,inp,bet,again,game,total);
       }
    int[] why= new int [3];
      why [0]=bet;
      why [1]=again;
      why [2]=total;
    return why;
    }
  
  public static int game(Scanner scanner) {
    Deck deck= new Deck();
    deck.shuffle();
    ArrayList<Card> player= new ArrayList<Card>();
    Card ace= new Card(1,1);
    Card king= new Card(13,1);
    player.add(deck.draw());
    player.add(deck.draw());
    ArrayList<Card> house= new ArrayList<Card>();
    house.add(deck.draw());
    house.add(deck.draw());
    System.out.println("Dealer has "+house.get(0)+" and Face Down");
    System.out.println("You have "+player.get(0)+" and "+player.get(1));
    System.out.println("Your total is "+ total(player));
    String inp="";
    while(input(scanner,inp,player,deck)==0){}
    if((total(player))<=21) {
      System.out.println("Dealer had a "+house.get(1));
      System.out.println("Dealer is now drawing...");
      String text="Dealer now has ";
      while(total(house)<16) {
        house.add(deck.draw());
        System.out.println("Dealer got a "+house.get(house.size()-1));
      }
      for(int i=0;i<house.size();i++) {
        if(i==house.size()-1) {
          text+=" and ";
        }
        text+=house.get(i);
        if(i<house.size()-2) {
          text+=", ";
        }
      }
      System.out.println(text);
      System.out.println("Dealer's total is "+total(house));
      if(total(house)>21) {
        System.out.println("Dealer busts!");
        System.out.println("YOU WIN!");
        return 1;
      }
      else if(total(house)>total(player)) {
        System.out.println("Dealer has a higher total!");
        System.out.println("YOU LOST!");
        return 0;
      }
      else if(total(house)==total(player)) {
        System.out.println("It's a tie...");
        System.out.println("But the house always wins!");
        System.out.println("YOU LOST!");
        return 0;
      }
      else if(total(house)<total(player)) {
        System.out.println("You have a higher total!");
        System.out.println("YOU WIN!");
        return 1;
      }
    }
    else {
      return 0;
    }
    return 2;
  }

  public static void clear() {
    System.out.print("\033[H\033[2J");
System.out.flush();
  }
  public static int input (Scanner scanner, String inp, ArrayList<Card> player, Deck deck) {
    if(total(player)>20) {
      if(total(player)>21){
        System.out.println("That's a bust!");
        System.out.println("YOU LOST!");
      } 
      else {
        System.out.println("Blackjack!");  
      } 
      return 1;
    }
    System.out.println("Would you like to Hit (h) or Stand (s)?");
    inp= scanner.next();
    if(inp.equalsIgnoreCase("hit")||inp.equalsIgnoreCase("h")) {
      player.add(deck.draw());
      String text="You now have ";
      for (int i=0;i<player.size();i++) {
        if(i==player.size()-1) {
          text+=" and ";
        }
        text+=player.get(i);
        if(i<player.size()-2) {
          text+=", ";
        }
      }
      System.out.println(text);
      System.out.println("Your total is "+ total(player));
      if(total(player)>21) {
        System.out.println("That's a bust!");
        System.out.println("YOU LOST!");
        return 1;
      }
    } 
    else if(inp.equalsIgnoreCase("Stand")||inp.equalsIgnoreCase("s")) {
      return 1;
    } 
    else {
      System.out.println("Please only input 'hit' or 'stand'.");
      if (input(scanner,inp,player,deck)==1) {
        return 1;
      }
    }
    return 0;
  }

  public static int total (ArrayList<Card> hand) {
    int total=0;
    int value=0;
    int ace=0;
    for(int i=0;i<hand.size();i++) {
      value=(hand.get(i)).getValue();
      if(value>10) {
        value=10;
      }
      if(value==1) {
        value=11;
        ace++;
      }
      total+=value;
    }
    if(total>21&&ace>0) {
      while(total>21&&ace>0) {
        total-=10;
        ace--;
      }
    }
    return total;
  }
	public static void setHigh(int val,String hightext) {
		try {
			PrintWriter pw = new PrintWriter(hightext, "utf8");
			pw.print(val);
			pw.close();
		} catch(Exception err) {
			System.out.println(err);
		}
	}
	public static int readHigh(String hightext) {
		try {
			File myObj = new File(hightext);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				return Integer.valueOf(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return 0;
	}
}