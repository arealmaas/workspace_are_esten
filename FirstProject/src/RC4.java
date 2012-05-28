import java.awt.EventQueue;

import javax.swing.JFrame;


public class RC4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RC4 window = new RC4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RC4() 
	{
		initialize();
		
		int [] k = new int[256];
		
		initializationPhase
		
	}
		
		// Description:  	encrypt a given “string,” i.e. plaintext 
		// Input: 		plaintext
		// Output: 		cyphertext, i.e. scrambled up input

		/*Review: what is mod? It is a function that takes two operands. 
		x mod y produces the reminder of x/y. It is always a non-negative integer. 
		// Description:  	keylen bytes are transferred from K to T; 
//		 			if keylen<256, T is filled with repeated keylen bytes
		// Input: 		array K of length keylen
		// Output: 		filled-in array S of length 256; filled in temporary array  T of length 256
		*/
		public int [] initializationPhase(int [] k, int [] s)
		{
			int [] T = new int[k.length];
			
			int keylen = k.length;
			
			for(int i = 0;i < 256;i++)
			{
				s[i] = i;
				T[i] = k[i % keylen];				
			}
		
			return T;
		}
		
		// Description:  	jumble up contents of S 
		// Input: 		arrays S and T
		// Output: 		modified S
		
		public void initialPermutation(int [] s, int [] T)
		{
			int j = 0;
			
			for(int i = 0; i < 256;i++)
			{
				j = (j + s[i] + T[i]) % 256;
		
			swap(i, j, s);									//Using a method called swap that swapd the two values in the given array.
			}
							
		}
			
		
		// Description:  	encrypt or decrypt
		// Input: 		array S 
		// Output: 		value k used for encryption of the next piece of input

		public void streamGeneration(int [] s, int k)
		{
			int i = 0;
			int j = 0;
			int t = 0;
			
			while(true)
			{
				i = (i+1) % 256;
				j = (j + s[i]) % 256;
				
				swap(i, j, s);			//Using a method called swap that swaps the two values in the given array.
				
				t = (s[i] + s[j]) % 256;
				k = s[t];
				
			
		        StringBuilder output = new StringBuilder();
		    
		    
		        for(int i = 0; i < inputString.length();i++) 
		        {
		          char c = inputString.charAt(i);
		          char[] keys = key.toCharArray();
		          for(int y = 0;y < keys.length;y++) 
		          {
		              output.append(c^keys[y]);
		          }    
		        }
		        return output.toString();
		     
			
				
				//To encrypt: k XOR next byte of plaintext, i.e. input text
				//To decrypt: k XOR next byte of cyphertext, i.e. encrypted data
			}
			
		}
		
		public void swap(int i, int j, int [] s)
		{
			int k = s[i];
			s[i] = s[j];
			s[j] = k;		
		}
		


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
