import java.io.*;


//Program som krever tekstfil som input.

public class Anagram 
{
	
	public static void main( String [] args)
	{
		Anagram anagram = new Anagram();
		
	}
	
	
	public Anagram()
	{
		
		String [] s = null;
		try{
		
			s = lesFraFil("tekstfil.txt");
		}
		catch(IOException ioe)
		{
			System.out.println("Noke e gale!!");
		}
		catch(NullPointerException npe)
		{
			System.out.println("Tekstfilen er tom");
		}
		
		for(String a:s)
			System.out.println(a+"");
		
	}
	
	public String[] lesFraFil(String filnavn) throws IOException
	{
		BufferedReader input;
		
		InputStream inp = ClassLoader.getSystemClassLoader().getResourceAsStream(filnavn);  // Åpner filen uavhengig av operativsystem
		input = new BufferedReader(new InputStreamReader(inp));

		String str = "", temp = "";
		
		temp = input.readLine() != null? temp: "";

		if(temp.equals(""))
			return null;
		
		while((temp = input.readLine()) != null)	
		{
			str+=",";
			str+=temp;
		}
		
		
		return str.split(",");
		
	}

	

}


