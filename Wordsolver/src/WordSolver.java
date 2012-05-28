
public class WordSolver {
	Node[] noder;
	
	WordSolver(String word) {
		fillNodes(word);
		anagrams();
	}
	
	public static void main(String[] args) {
		new WordSolver(args[0]);
	}
	
	private void fillNodes(String word) {
		noder=new Node[word.length()];
		for (int i=0; i<noder.length; i++) {
			noder[i].setValue(word.charAt(i));
		}
	}
	
	private void anagrams() {
		String total="";
		
		for (int i=0; i<noder.length; i++) {
			if (noder[i].isNotUsed()) {
				String total+=Character.toString(noder[i].getValue());
			}
			for (int j=0; i<noder.length; i++) {
				if (noder[j].isNotUsed()) {
					String total+=Character.toString(noder[j].getValue());
				}
				for (int k=0; i<noder.length; i++) {
					if (noder[k].isNotUsed()) {
						String total+=Character.toString(noder[k].getValue());
					}
					for (int l=0; i<noder.length; i++) {
						if (noder[l].isNotUsed()) {
							String total+=Character.toString(noder[l].getValue());
						}
						for (int m=0; i<noder.length; i++) {
							if (noder[m].isNotUsed()) {
								String total+=Character.toString(noder[m].getValue());
							}
							for (int n=0; i<noder.length; i++) {
								if (noder[n].isNotUsed()) {
									String total+=Character.toString(noder[n].getValue());
								}
								for (int o=0; i<noder.length; i++) {
									if (noder[o].isNotUsed()) {
										String total+=Character.toString(noder[o].getValue());
									}
									for (int p=0; i<noder.length; i++) {
										if (noder[p].isNotUsed()) {
											String total+=Character.toString(noder[p].getValue());
										}
										for (int q=0; i<noder.length; i++) {
											if (noder[q].isNotUsed()) {
												String total+=Character.toString(noder[q].getValue());
											}
											for (int r=0; i<noder.length; i++) {
												if (noder[r].isNotUsed()) {
													String total+=Character.toString(noder[r].getValue());
												}
												for (int s=0; i<noder.length; i++) {
													if (noder[s].isNotUsed()) {
														String total+=Character.toString(noder[s].getValue());
													}
													
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private class Node {
		char value;
		boolean used=false;
	
		public void setValue(char value) {
			this.value=value;
		}
		
		public char getValue() {
			return value;
		}
		
		public boolean isNotUsed() {
			if (!used) {
				used=!used;
				return true;
			} else
				return false;
		}
	}
}
		
		
		
		
		

