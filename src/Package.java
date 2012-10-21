public class Package {
	private String 
		Package,
		Essential,
		Status,
		Priority,
		Section,
		InstalledSize,
		Maintainer,
		Architecture,
		Version,
		Depends,
		PreDepends,
		Description,
		Name,
		Homepage;
	public Package(String Package, String Essential, String Status, String Priority, String Section, String InstalledSize, String Maintainer, String Architecture, 
			String Version, String Depends, String PreDepends, String Description, String Name, String Homepage){
		this.Package = Package;
		this.Essential = Essential;
		this.Status = Status;
		this.Priority = Priority;
		this.Section = Section;
		this.InstalledSize = InstalledSize;
		this.Maintainer = Maintainer;
		this.Architecture = Architecture;
		this.Version = Version;
		this.Depends = Depends;
		this.PreDepends = PreDepends;
		this.Description = Description;
		this.Name = Name;
		this.Homepage = Homepage;
	}
	public String getPackage() {return Package;}
	public String getEssential() {return Essential;}
	public String getStatus() {return Status;}
	public String getPriority() {return Priority;}
	public String getSection() {return Section;}
	public String getInstalledSize() {return InstalledSize;}
	public String getMaintainer() {return Maintainer;}
	public String getArchitecture() {return Architecture;}
	public String getVersion() {return Version;}
	public String getDepends() {return Depends;}
	public String getPreDepends() {return PreDepends;}
	public String getDescription() {return Description;}
	public String getName() {return Name;}
	public String getHomepage() {return Homepage;}
	
	public static String[] FIELDS = {
		"Package", "Essential", "Status", "Priority",
		"Section", "InstalledSize", "Maintainer",
		"Architecture", "Version", "Depends",
		"PreDepends", "Description", "Name", "Homepage"
	};
}
