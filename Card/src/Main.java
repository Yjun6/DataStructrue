import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static final String[] color1 = {"♥", "♣", "♦", "♠"};

    //创建牌
    public static List<Card> buildCard(){
        List<Card> card = new ArrayList<>();
        for(int i =1; i <= 52; i++){
            Card card1;
           for(int j = 0; j < color1.length; j++){
               card1 = new Card(color1[j], i);
               card.add(card1);
           }
        }
        return card;
    }

    //洗牌
    public static void shuffle(List<Card> card){
        Random random = new Random();
        for (int i = 0; i < card.size(); i++) {
            int card1 = random.nextInt(card.size());
            Card card2 = card.get(card1);
            card.set(card1, card.get(i));
            card.set(i,card2);
        }
    }
    //发牌
    public static void putCard(List<Card> card) {
        List<List<Card>> card1 = new ArrayList<>();
        List<Card> card11 = new ArrayList<>();
        List<Card> card12 = new ArrayList<>();
        List<Card> card13 = new ArrayList<>();
        card1.add(card11);
        card1.add(card12);
        card1.add(card13);

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                int card3 = random.nextInt(card.size());
                Card card111 = card.get(card3);
                card1.get(j).add(card111);
                card.remove(card111);
            }
        }
    }

    public static void main(String[] args) {
        List<Card> card = buildCard();
        shuffle(card);
        putCard(card);
        System.out.println(card);
    }
}