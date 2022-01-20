package java_project;

import java.util.Scanner;

public class VirtualKey {
	public static void main(String[] args) {
		
		// Don't forget to add '\\' at the end of the path.
		String path = "C:\\Users\\vgunja\\OneDrive - Cisco\\Desktop\\Cisco\\Git\\";		
		
		boolean flag = true;
		FileHandling.DisplayMenu();
		int option=0;
		while (flag){
			System.out.print("\nEnter your Option : ");
			Scanner input = new Scanner(System.in);
			
			String ip = input.next();
			try {
				option=Integer.parseInt(ip); 
			}
			catch(Exception e) {
				option=0;
			}
			switch(option) {
			
			case 1:
				System.out.println("Contents in folder :");
				String[] contents = FileHandling.OpenFolder(path);
				for(int i=0; i<contents.length; i++) {
			         System.out.println(contents[i]);
			      }
				break;
				
			case 2:
				System.out.print("Enter filename to create a file: ");
				String filename = input.next();
				filename = path + filename;
				FileHandling.AddFile(filename);
				break;
				
			case 3:
				System.out.print("Enter filename to delete a file: ");
				filename = input.next();
				filename = path + filename;
				FileHandling.DeleteFile(filename);
				break;
				
			case 4:
				System.out.print("Enter filename to search : ");
				filename = input.next();
				boolean exists = FileHandling.SearchFile(filename, path);
				if (exists) {
					System.out.println("File with filename "+filename + " exists");
				}
				else {
					System.out.println("File with filename "+filename + " does not exists");
				}
				break;
				
			case 5:
				FileHandling.DisplayMenu();
				break;
				
			case 6:
				flag=false;
				input.close();
				System.out.println("Thank you");
				break;
				
			default:
				System.out.println("Enter one of the specified options");
				FileHandling.DisplayMenu();
			
			}
		}
	}
}
