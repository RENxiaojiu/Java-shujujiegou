package Test0131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pokerGame3 {
    public static final String[] suits = {"♠", "♥", "♣", "♦"};

    public static void main(String[] args) {
        List<Card3> poker = buyPoker();
        System.out.println(poker);

        Collections.shuffle(poker);

        List<List<Card3>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++) {
                Card3 top = poker.remove(0);
                List<Card3> player = players.get(j);
                player.add(top);
            }
        }

        for (int i = 0; i < players.size(); i++) {
            List<Card3> player = players.get(i);
            System.out.println("玩家" + i + "的手牌是：" + player);
        }
    }

    private static List<Card3> buyPoker() {
        List<Card3> poker= new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card3(suits[i], "" + j));
            }
            poker.add(new Card3(suits[i], "J"));
            poker.add(new Card3(suits[i], "Q"));
            poker.add(new Card3(suits[i], "K"));
            poker.add(new Card3(suits[i], "A"));
        }
        poker.add(new Card3("", "boss"));
        poker.add(new Card3("", "joker"));

        return poker;
    }




}
