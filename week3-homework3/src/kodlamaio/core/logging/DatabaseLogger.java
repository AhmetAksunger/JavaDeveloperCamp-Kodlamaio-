package kodlamaio.core.logging;

public class DatabaseLogger implements Logger{

	public void log(String data) {
		System.out.println("Logged using DatabaseLogger: " + data);
		
	}
	
}
