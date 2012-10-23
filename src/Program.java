import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;
public class Program {
	public static void main(String[] args) throws IOException{
		String status = "", s;
			final BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream("status"))));
			while(( s = reader.readLine()) != null){
				status += s + "\n";
			}
			final Parser parser = new Parser(status);
			final Scanner scanner = new Scanner(System.in);
			final String[] options = {
				"installed packages",
				"essential packages",
				"custom packages"
			};
			for(int i = 0; i < options.length; i++) System.out.println("Press " + i + " to back up " + options[i]);
			ArrayList<Package> packages = null;
			String input = scanner.nextLine();
			if(input.equals("0"))	packages = parser.getInstalledPackages();
			else if(input.equals("1")) packages = parser.getEssentialPackages();
			else{
				ArrayList<FilterRequest> requests = new ArrayList<FilterRequest>();
				final String instructions = "(Type y if you do...)";
				for(int i = 0; i < Package.DEFAULT_FIELDS.length; i++){
					System.out.println("Do you care about:\t" + Package.DEFAULT_FIELDS[i] + "? " + instructions);
					input = scanner.nextLine();
					if(input.equals("y")){
						System.out.println("\tDo you want to only look for specific values in this field? " + instructions);
						FilterRequest request = null;
						if(scanner.nextLine().equals("y")){
							System.out.println("\t\tEnter in the specific value you want to look for...");
							request = new FilterRequest(Package.DEFAULT_FIELDS[i], scanner.nextLine());
						}
						else request = new FilterRequest(Package.DEFAULT_FIELDS[i]);
						requests.add(request);
					}
				}
				FilterRequest[] r = new FilterRequest[requests.size()];
				for(int i = 0; i < r.length; i++) r[i] = requests.get(i);
				packages = parser.filter(r);
			}
		}
}
