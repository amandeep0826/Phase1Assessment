import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Assessment {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String con = "";

		System.out.println("Application name: LockedMe.com");
		System.out.println();
		System.out.println("Developed By: Amandeep");
		System.out.println();
		do {
			System.out.println("Please select one of the options from below: ");
			System.out.println();
			System.out.println("1: To view all the files available in current directory.");
			System.out.println("2: To know other operations");
			System.out.println("3: To close the Application");
			System.out.println();
			try {
				int mainOption = input.nextInt();
				switch(mainOption) {
				
				case 1:
					File folder = new File("./");
					File[] listOfFiles = folder.listFiles();
					System.out.println("The sorted files in the current directory are: ");
					for(File file: listOfFiles) {
						System.out.print(file.getName() + ", ");
					}
					System.out.println();
					break;
					
				case 2:
					System.out.println("Please select one of the operations from below: ");
					System.out.println();
					System.out.println("1: To add a file in the current directory.");
					System.out.println("2: To delete a file from the current directory");
					System.out.println("3: To search a file in the current directory");
					System.out.println("4: To go back to the main Menu");
					System.out.println();
					int subOption = input.nextInt();
					
					switch(subOption) {
					
					case 1:
						System.out.println("Please enter the name of the file you want to add");
						String fileNameAdd = input.next();
						String fileNameAddFinal = String.format("./%s.txt", fileNameAdd);
						boolean flag = false;
						File file = new File(fileNameAddFinal);
						try {
							flag = file.createNewFile();
						} catch (IOException ioe) {
							System.out.println("Error while creating the file");
						}
						System.out.println();
						System.out.println("File created Successfully");
						con = "y";
						break;
						
					case 2:
						System.out.println("Please enter the name of the file you want to delete");
						String fileNameDelete = input.next();
						String fileNameDeleteFinal = String.format("./%s.txt", fileNameDelete);
						File f = new File(fileNameDeleteFinal);
						if(f.delete()) {
							System.out.println("File deleted successfully");
						}
						else {
							System.out.println("File Not Found");
						}
						con = "y";
						break;
						
					case 3:
						System.out.println("Please enter the name of the file that you are looking for");
						String fileNameForSearch = input.next();
						String fileNameForSearchFinal = String.format("%s.txt", fileNameForSearch);
						File ff = new File("./");
						boolean flagForSearch = false;
						File[] listOfFilesToSearch = ff.listFiles();
						for(File files: listOfFilesToSearch) {
							if(files.getName().equals(fileNameForSearchFinal)) {
								System.out.print("File exists");
								System.out.println();
								flagForSearch = true;
								break;
							}
						}
						if(flagForSearch==false) {
							System.out.println("File does not exist");
						}
						con = "y";
						break;
						
					case 4:
						con = "y";
						break;
					}
					break;
					
				case 3:
					System.out.println();
					System.out.println("Thank you for using this Application");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("You did not choose any of the given options");
				con = "z";
		
			}
		
		}while(con.equalsIgnoreCase("y"));
		System.out.println();
		System.out.println("Thank you for using this Application");
		
	}

}
