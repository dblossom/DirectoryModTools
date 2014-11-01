package DirectoryModTools;
import java.io.File;


/**
 * Give a root will rename all directories that are not hidden to lowercase
 * @author D. Blossom
 *
 */
public class LowercaseFolderNames 
{
	
	public LowercaseFolderNames(String rootDirectory)
	{
		File myDir = new File(rootDirectory);
		
		String[] fileList = myDir.list();
		
		for(int i = 0; i < fileList.length; i++)
		{
			//keep hidden files hidden
			File temp = new File(rootDirectory + fileList[i].toString());
			if(!fileList[i].startsWith(".") && temp.isDirectory())
			{
				temp.renameTo(new File(temp.toString().toLowerCase()));
			}
		}
	}
	
	public static void main(String[] args)
	{
		LowercaseFolderNames lfn = new LowercaseFolderNames("/home/user/test/");
	}
	
}
