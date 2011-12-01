import java.util.Random; 
public class Deck{

	private Card[] deck;
	private int ArrayLength;
	
	public Deck(){
		deck = new Card[52];
		ArrayLength = 0;
	}
	
	
	public void fillDeck(){
		for(int kleur = 0; kleur < 4; kleur++)
			for(int symbol = 0; symbol < 13; symbol++)
				deck[ArrayLength++] = new Card(kleur, symbol);
	}
	
	public void shuffle(){
		Random random = new Random();
		int count=0;
		while(count!=100){
			int indexOne = random.nextInt(52);
			int indexTwo = random.nextInt(52);
			Card card1 = deck[indexOne];
			deck[indexOne]=deck[indexTwo];
			deck[indexTwo]=card1;
			count++;
		}
	}
	

	public void sort(){
		Card[][][] temp = new Card[4][13][Card.getMaxOccurences()];
		for(Card card : deck){

			boolean notInserted = true;
			int index = 0;
			int kleur = card.getKleur();
			while(notInserted){
				if(temp[card.getKleur()][card.getSymbol()][index]==null){
					temp[card.getKleur()][card.getSymbol()][index]=card;
					index = 0; notInserted=false;}
				else{ index++;}
			}
		}
		ArrayLength = 0;
		for(int kleur = 0; kleur < 4; kleur++){
			for(int symbol = 0; symbol < 13; symbol++){
				for(int x = 0; x < Card.getMaxOccurences(); x++){
					if(temp[kleur][symbol][x]!=null){
							deck[ArrayLength++]= temp[kleur][symbol][x];
						}
				}
			}
		}
	}
	
	public String toString(){
		String returnString = "";
		for(int i = 0; i < ArrayLength; i++){
			returnString += deck[i].toString();
		}
		return returnString;
	}

/**
	public int cardCount(){
		int length = 0;
		for(Card card : deck) if(card!=null) length +=1;
		return length;
	}
	
	
	public void reduceOrExpand(){
		int index = 0;
		Card[] temp = new Card[cardCount()];
		for(Card card : deck){
			if(card!=null){ 
				temp[index] = card;
				index +=1;
			}
		}
		deck = temp;
		temp = null;
	}
	*/
	
	public void insert(){
		int inner=0;
		Card card = new Card(0,2);
		Card[] temp = new Card[(ArrayLength+1)];
		for(Card x : deck){
			temp[inner++] = x;
		}
		temp[inner] = card;
	 deck = new Card[(ArrayLength+1)];
	 ArrayLength = 0;
	 for(Card y : temp){
		deck[ArrayLength++]=y;
	 }
	
	}
}