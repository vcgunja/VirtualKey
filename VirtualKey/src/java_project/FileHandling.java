package java_project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;  

public class FileHandling {
	
	public static void DisplayMenu() {
		System.out.println("==== Select Option ====");
		System.out.println("1. Open Folder");
		System.out.println("2. Add File");
		System.out.println("3. Delete File");
		System.out.println("4. Search File");
		System.out.println("5. Display Menu");
		System.out.println("6. Exit");
	}
	
	public static String[] OpenFolder(String path) {
		 
		try {
		File directory = new File(path);
		String contents[] = contents = directory.list();
	    Arrays.sort(contents);
	    return contents;
		}
		catch (Exception e) {
			String[] error = {"Error occured, Check the path specified."};
			return error;
		}
	}
	
	public static void AddFile(String filename) {
		try {
		      File file = new File(filename);
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static boolean SearchFile(String filename,String path) {
		String[] contents = FileHandling.OpenFolder(path);
		boolean flag = Arrays.asList(contents).contains(filename); 
		return flag;
	}
	
	public static void DeleteFile(String filename) {
		File file = new File(filename);
		if(file.delete())
        {
            System.out.println(file.getName()+" deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
	}

}
