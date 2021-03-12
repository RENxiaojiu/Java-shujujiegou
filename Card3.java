package Test0131;

public class Card3 {
    public String suit;
    public String rank;

    public Card3(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + this.suit + this.rank + ")";
    }
}
