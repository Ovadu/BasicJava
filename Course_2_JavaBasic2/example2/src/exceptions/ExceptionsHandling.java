package exceptions;

public class ExceptionsHandling {
	
	public void loadTruck (int ld) throws Exception { //this method can throw an exception
		if(ld>1000)
		{
			throw new Exception();
		}
	}
	
	//because I used throw, when I call loadTruck method, I need to put the code in a try / catch block
	public void tryMethod()
	{		
		try{
			loadTruck(1100);
		}catch (Exception e){
			System.out.println("Don't load over 1000 pounds," + " it can't handle! "  + e);
		}finally{
			System.out.println("Executing no matter what happens in try/catch");
		}
		
		//if you want to test multiple values at once
		int[] data = {1100, 1200, 30000, 70};
		for (int i=0; i<data.length; i++){
		try{
				loadTruck(data[i]);
				System.out.println("test passed " + i);
		}catch (Exception e){
			System.out.println("Don't load over 1000 pounds," + " it can't handle! "  + e);
		}finally{
				System.out.println("Executing no matter what happens in try/catch");
		}
		}
	}
	
	public static void main(String[] args)
	{
		ExceptionsHandling ex = new ExceptionsHandling();
		ex.tryMethod();
	}

}
