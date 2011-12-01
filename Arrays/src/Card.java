public class Card{

	private static final String[] kleurValue = {"Harte", "Schoppen", "Ruite", "Klaver"};
	private static final String[] symbolValue = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private static int[][][] occurrences = new int[4][13][1];
	private int symbol, kleur;
	
	public Card(int kleur, int symbol){
		this.symbol = symbol;
		this.kleur = kleur;
		occurrences[kleur][symbol][0]++;
	}
	
	public void setSymbol(int symbol){
		this.symbol = symbol;
	}
	
	public int getSymbol(){
		return symbol;
	}
	
	public void setKleur(int kleur){
		this.kleur = kleur;
	}
	
	public int getKleur(){
		return kleur;
	}
	
	public String toString(){
		return kleurValue[kleur] + " " + symbolValue[symbol] + "\n";
	}
	
	public static int getMaxOccurences(){
		int max=0;
		for(int kleur = 0; kleur<4 ; kleur++){
				int symbol=0;
				while(symbol<13){
					if(occurrences[kleur][symbol][0]>max) max=occurrences[kleur][symbol][0];
					symbol++;
				}
		}
		return max;
	}
}