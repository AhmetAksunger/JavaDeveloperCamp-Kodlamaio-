package kodlamaio.core.logging;

public class FileLogger implements Logger{

	public void log(String data) {
		System.out.println("Logged using FileLogger: " + data);
		
	}
	
}
