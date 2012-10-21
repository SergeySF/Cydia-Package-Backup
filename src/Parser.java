import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.StringReader;
public class Parser {
	private ArrayList<Package> packages;
	public Parser(String status){	//status file from /var/lib/dpkg
		packages = new ArrayList<Package>();
		obtainPackages(status);
	}
	private void obtainPackages(String status){
		BufferedReader reader = new BufferedReader(new StringReader(status));
		
	}
}
