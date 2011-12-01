public class App{

	public static void main(String[] args){
		Deck deck = new Deck();
		deck.fillDeck();
		deck.insert();
		System.out.println(deck.toString());
		deck.shuffle();
		System.out.println(deck.toString());
		deck.sort();
		System.out.println(deck.toString());
	}
}