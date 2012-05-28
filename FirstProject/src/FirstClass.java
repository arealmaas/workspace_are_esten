import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FirstClass implements KeyListener{
	
	public static void main(String [] args)
	{
		String b = new String("HEY, NANANANAAA NANANAAA NANANAANAAA");
		
		for(int i = 0; i <10;i++)
		{
			System.out.println(b + i);
		}
		
		
		
		
		
		
		
	}
	
	
	String stringen = "";

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
			System.out.println("SŒ du tastet" + e.getKeyChar());
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mp3 er fortsatt AWESOME!");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mus");
	}
	

}
