
public class NokkelKnekker {
	String nokkel;
	String tekst;
	
	String[] alfabet={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
			"v", "w", "x", "y", "z", "ae", "oe", "aa"};
	String[] fiksaAlfabet=new String[29];
	
	NokkelKnekker(String nokkel, String tekst) {
		this.nokkel=nokkel;
		this.tekst=tekst;
		setNokkel();
	}
	
	public void setNokkel() {
		for (int i=0; i<nokkel.length(); i++) {
			fiksaAlfabet[i]=Character.toString(nokkel.charAt(i));
		}
		
		String sisteBokstav=fiksaAlfabet[nokkel.length()];
		int sisteBokstavPos=finnSisteBokstavPos(sisteBokstav);
		
		int bokstavPos=sisteBokstavPos+1;
		for (int i=nokkel.length(); i<alfabet.length; i++) {
			if (bokstavPos>alfabet.length)
				bokstavPos-=alfabet.length;
			if (isGood(alfabet[bokstavPos])) {
				fiksaAlfabet[i]=alfabet[bokstavPos];
			}
			bokstavPos++;
		}
	}
	
	private int finnSisteBokstavPos(String sisteBokstav) {
		for (int i=0; i<alfabet.length; i++) {
			if (alfabet[i].equals(sisteBokstav)) 
				return i;
		}
		return 0;
	}
	
	private boolean isGood(String bokstav) {
		for (int i=0; i<fiksaAlfabet.length; i++) {
			if (bokstav.equals(fiksaAlfabet[i]))
				return false;
		}
		return true;
	}
}
