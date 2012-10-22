import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
public class Parser {
	private ArrayList<Package> packages;
	public Parser(String status) throws IOException{	//status file from /var/lib/dpkg
		packages = new ArrayList<Package>();
		populatePackageList(status);
	}
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
				}
				for(int i = 0; i < line.length(); i++){
					if (i < term_pos) key += line.charAt(i);
					if (i > term_pos + 1 /* there's a space too*/) value += line.charAt(i);
				}
				p.add(key, value);
			}
		}
	}
	public ArrayList<Package> getInstalledPackages(){
		//just keeps packages that are installed - what 99% of people probably want
		FilterRequest[] options = {new FilterRequest(Package.DEFAULT_FIELDS[0]), new FilterRequest(Package.DEFAULT_FIELDS[2], Package.INSTALLED)};
		return filter(options);
	}
	public ArrayList<Package> getEssentialPackages(){
		FilterRequest[] options = {new FilterRequest(Package.DEFAULT_FIELDS[1], Package.YES_ESSENTIAL)};
		return filter(options);
	}
	public ArrayList<Package> filter(FilterRequest[] options){
		ArrayList<Package> new_packages = new ArrayList<Package>();
		for(FilterRequest option : options){
			for(Package p : packages){
				if(option.IgnoreValue()){
					if(!p.doesHaveKey(option.getKey())) new_packages.add(p);
				}
				else{
					if(!p.keyHasValue(option.getKey(), option.getValue())) new_packages.add(p);
				}
			}
		}
		return new_packages;
	}
}
