package DirectoryModTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Given a text file list creates directories in a root for each
 * line in the text document.
 * 
 * TODO: remove code from "main"
 * @author D Blossom
 *
 */
public class DirCreate {
	
	public static void main(String[] args){
		
		try {
		    BufferedReader file = new BufferedReader(new FileReader(args[0]));
		    String folder;
		    while((folder = file.readLine()) != null) {
		    	
		    	// SO This IF could be removed, it was unique to the dirs I was making with this tool
		    	// I had name listed as "hello world, the" and wanted to move "the" to the front and
		    	// remove the quotes.
				if(folder.charAt(0) == '\"'){
					
					int index = folder.indexOf(',');
					
					folder = folder.substring(1, index);
					
					folder = "The " + folder;
					
				}
		    	
				// Change value here for different root.
		    	boolean created = DirCreate.makeDir(folder, "/home/user/Videos/toConvert");
		    	
		    	if(!created){
					System.out.println(folder + " Failed!");
		    	}
				
		    }
		    file.close();
		} catch(Exception ex) {
		    System.out.println(ex);
		}
		
	}
	
	public DirCreate(){} // default
	
	public static boolean makeDir(String folderName, String folderLocation){
		
		File tempFile = new File(folderLocation + "/" + folderName);
		
		if(tempFile.mkdir()){
			return true;
		}else{
			return false;
		}

	}

}
