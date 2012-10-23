import java.util.Hashtable;
public class Package {
	private Hashtable<String, String> flags;
	public Package(){
		flags = new Hashtable<String, String>();
	}
	public void add(String key, String value){
		flags.put(key, value);
	}
	public boolean doesHaveKey(String key){
		return flags.containsKey(key);
	}
	public boolean keyHasValue(String key, String value){
		return doesHaveKey(key) && flags.get(key).equals(value);
	}
	public String getPackage(){
		return flags.get(DEFAULT_FIELDS[0]);
	}
	public final static String[] DEFAULT_FIELDS = {
		"Package", "Essential", "Status", "Priority",
		"Section", "InstalledSize", "Maintainer",
		"Architecture", "Version", "Depends",
		"PreDepends", "Description", "Name", "Homepage"
	};
	//common constants
	public final static String INSTALLED = "install ok installed";
	public final static String YES_ESSENTIAL = "yes";
}
