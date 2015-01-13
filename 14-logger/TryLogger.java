import java.util.logging.*;
import java.io.IOException;

public class TryLogger{
	private static final Logger logger = Logger.getLogger(TryLogger.class.getName());// or any string.
	public static void main(String [] args){
		try{
			Handler fh = new FileHandler("test.log", true); // name of file, append == true.
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
			logger.setLevel(Level.FINE);
		}catch (IOException e){
			System.out.println(e);
			System.exit(0);
		}

		logger.info("Start logging...");
		try{
			throw new Exception("Hey, go wrong."); // All java standard exception only need a string.
		} catch (Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		logger.exiting(TryLogger.class.getName(), "main");
	}
}