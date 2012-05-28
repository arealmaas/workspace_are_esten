
public class CaesarKnekker {
	String[] alfabet={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
					"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
					"v", "w", "x", "y", "z", "ae", "oe", "aa"};
	
	String originalTekst=null;
	
	CaesarKnekker(String tekst) {
		this.originalTekst=tekst;
	}
	
	public void print() {
		String provetekst;
		for (int i=0; i<alfabet.length; i++) {
			provetekst="";
			for (int j=0; j<originalTekst.length(); j++) {
				if (originalTekst.charAt(j)==' ')
					provetekst+=" ";
				else {
					int plassering=finnPlassering(originalTekst.charAt(j));
					int nyPlassering=plassering+i;
					if (nyPlassering>alfabet.length-1)
						nyPlassering-=alfabet.length;
					provetekst+=alfabet[nyPlassering];
				}
			}
			System.out.println(provetekst);
		}
	}
	
	public int finnPlassering(char c) {
		for (int i=0; i<alfabet.length; i++) {
			if (Character.toString(c).equals(alfabet[i]))
				return i;
		}
		return 0;
	}
}
