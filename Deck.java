import java.util.ArrayList;
import java.util.Random;
public class Deck {
  private ArrayList<Card> deck=new ArrayList<Card>();
  public Deck() {
    for(int s=1;s<=4;s++) {
      for(int v=1;v<=13;v++) {
        Card card= new Card(v,s);
        deck.add(card);
      }
    }
  }
  public Card draw() {
    return deck.remove(0);
  }
  public void shuffle() {
    Random rand= new Random();
    for(int j=1; j<100; j++) {
      int i=rand.nextInt(52);
      Card card= deck.get(0);
      deck.set(0,deck.get(i));
      deck.set(i,card);
    }
  }
  public String toString() {
    String string="";
    for(int i=0; i<deck.size(); i++) {
      string+=deck.get(i);
      if(i!=deck.size()-1) {
        string+=", ";
      }
    }
    return string;
  }
}