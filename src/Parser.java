import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
public class Parser {
	private ArrayList<Package> packages;
	public Parser(String status){	//status file from /var/lib/dpkg
	public Parser(String status) throws IOException{	//status file from /var/lib/dpkg
		packages = new ArrayList<Package>();
		obtainPackages(status);
		populatePackageList(status);
	}
	private void obtainPackages(String status){
	private void populatePackageList(String status) throws IOException{
		BufferedReader reader = new BufferedReader(new StringReader(status));
		
		String line;
		Package p = new Package();
		while((line = reader.readLine()) != null){
			if(line.equals("\n")){
				if(p.doesHaveKey(Package.DEFAULT_FIELDS[0])){	//useful corner case - make sure it IS actually a package so we don't throw in whitespace packages
					packages.add(p);
					p = new Package();
				}
			}
			else{
				int term_pos = -1;
				String key = "", value = "";
				for (int i = 0; i < line.length() + 1; i++){
					if (line.charAt(i) == ':' && line.charAt(i + 1) == ' '){
						term_pos = i;
						break;
					}
				p.add(key, value);
			}
		}
	}
	}
}
