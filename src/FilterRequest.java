
public class FilterRequest {
private boolean ignoreValue;
private String key, value;
public String getKey() {return key;}
public String getValue() {return value;}
public boolean IgnoreValue() {return ignoreValue;}
public FilterRequest(String key){
	this.key = key;
	ignoreValue = true;
}
public FilterRequest(String key, String value){
	this.key = key;
	this.value = value;
	ignoreValue = false;
}
}
