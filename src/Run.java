import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;


public class Run {

	
	
	public static void main(String[] args) {
		File fileOut = new File("./out.sql");
	    File fileIn = new File("./in.sql");        
	    int rows = 10000;
	    
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))){
	    	 
	    	StringBuilder contentBuilder = new StringBuilder();
	    	try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) 
	    	{
	    		int row=1;
	    		String sCurrentLine;
	    	    writer.append("BEGIN");
	    	    writer.newLine();
	    	    while ((sCurrentLine = br.readLine()) != null) 
	    	    {	    	    	
	    	    	if((row%rows)==0) {
	    	    		writer.append("COMMIT;");
	    	    		writer.newLine();
	    	    		writer.append("END;");
	    	    		writer.newLine();
	    	    		writer.append("/");
	    	    		writer.newLine();
	    	    		writer.append("BEGIN");
	    	    		writer.newLine();
	    	    	}
	    	    	writer.append(sCurrentLine);
	    	    	writer.newLine();
	    	    	row +=1;
	    	    }
	    	    writer.append("COMMIT;");
	    	    writer.newLine();
	    	    writer.append("END;");
	    	    writer.newLine();
	    	    writer.append("/");
	    	} 
	    	catch (IOException e) 
	    	{ 
	    	    e.printStackTrace();    	    
	    	}

	      
	    } catch (Exception e) {    	
	    	e.printStackTrace();
	    }

	}

}
