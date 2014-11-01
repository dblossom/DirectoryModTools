package DirectoryModTools;

import java.io.File;

/**
 * Grabs the last folder in a tree and changes all spaces with '_' char
 * 
 * @author D Blossom
 */
public class DirectoryRename {
	
	public static void main(String[] args){
		
		// change this string to root.
		String root = "/media/movies_box/blankFolders";
		
		DirectoryRename.DirectoryTreeRename(root);
	}
	
	public DirectoryRename(){}
	
	public static void DirectoryTreeRename(String root){
		
		File[] files = new File(root).listFiles();
		
		for(int i = 0; i < files.length; i++){
			
			// get the path
			String s = files[i].getAbsolutePath();
			// find the last folder in patch
			int lastslash = s.lastIndexOf("/");
			// grab just the name without / and stuff
			String ss = s.substring(lastslash+1, s.length());
			// grab the roots to that folder that is ..
			// dir1/dir2/dir3 we grabbed dir3 but need to retain its
			// location so dir1/dir2
			s = s.substring(0, lastslash+1);
			// replaces " " with _ for "dir3" in example above
			ss = ss.replaceAll(" " , "_");
			// put it back together
			s = s+ss;
			// rename to a new one
			files[i].renameTo(new File(s));
			// delete original if still around
			files[i].delete();
			
		}
		
	}

}
