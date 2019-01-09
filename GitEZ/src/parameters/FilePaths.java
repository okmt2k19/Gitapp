package parameters;

public class FilePaths {
	
	WhereIam wi = new WhereIam();
	
	
	public  String exepath = "\\Git\\git-bash.exe";
	public  String installerpath = "\\Git installer\\Git-2.19.1-64-bit.exe";
	public  String uninstallerpath = "\\Git\\unins000.exe";
	
	public  String repository = "/sh/set.sh";
	public  String user =  "/sh/user.sh";
	public  String user2 = "/sh/user.sh";
	public  String commit =  "/sh/commit.sh";
	public  String clone = "/sh/clone.sh";
	public  String pull = "/sh/pull.sh";
	
	public  String tmp_repositoryURL = "\\tmp\\tmp_repositoryURL.txt";
	public  String tmp_repositoryName = "\\tmp\\tmp_repositoryName.txt";
	public  String tmp_name = "\\tmp\\tmp_name.txt";
	public  String tmp_email = "\\tmp\\tmp_email.txt";
	public  String tmp_files = "\\tmp\\tmp_files.txt";
	public  String tmp_filepaths = "\\tmp\\tmp_filepaths.txt";
	public  String tmp_message = "\\tmp\\tmp_message.txt";
	public  String repositories = "\\tmp\\repositories.txt";
	public  String selectedRepository = "\\tmp\\selectedrepository.txt";
	public  String tmp_dir = "\\tmp\\dir.txt"; 
	public  String tmp_projectDir = "\\projects"; 
	public  String tmp_projectDirfile = "\\tmp\\projectpath.txt";
	
	

	public String projectDir = "\\projects";
	public String dataDir = "\\data";
	
	
	
	public String getExepath() {
		wi.search();
		return wi.getDir()+exepath;
	}
	public String getInstallerpath() {
		wi.search();
		return wi.getDir()+installerpath;
	}
	public String getUninstallerpath() {
		wi.search();
		return wi.getDir()+uninstallerpath;
	}
	
	
	public String getRepository() {
		wi.search();
		return wi.getDirforBash()+repository;
	}
	public String getUser() {
		wi.search();
		return wi.getDirforBash()+user;
	}
	public String getUser2() {
		wi.search();
		return wi.getDirforBash()+user2;
	}
	public String getCommit() {
		wi.search();
		return wi.getDirforBash()+commit;
	}
	public String getClone() {
		wi.search();
		return wi.getDirforBash()+clone;
	}
	
	public String getPull() {
		wi.search();
		return wi.getDirforBash()+pull;
	}
	
	
	
	public String getTmp_repositoryURL() {
		wi.search();
		return wi.getDir()+tmp_repositoryURL;
	}
	public String getTmp_repositoryName() {
		wi.search();
		return wi.getDir()+tmp_repositoryName;
	}
	public String getTmp_name() {
		wi.search();
		return wi.getDir()+tmp_name;
	}
	public String getTmp_email() {
		wi.search();
		return wi.getDir()+tmp_email;
	}
	public String getTmp_files() {
		wi.search();
		return wi.getDir()+tmp_files;
	}
	public String getTmp_filepaths() {
		wi.search();
		return wi.getDir()+tmp_filepaths;
	}
	public String getTmp_message() {
		wi.search();
		return wi.getDir()+tmp_message;
	}
	public String getRepositories() {
		wi.search();
		return wi.getDir()+repositories;
	}
	public String getSelectedRepository() {
		wi.search();
		return wi.getDir()+selectedRepository;
	}
	public String getTmp_projectDir() {
		return wi.getDirforBash()+tmp_projectDir;
	}
	public String getDir() {
		return tmp_dir;
	}
	public String getDirfile() {
		return wi.getDir()+tmp_dir;
	}
	
	public String getProjectDir() {
		wi.search();
		return wi.getDir()+projectDir;
	}
	public String getProjectDirfile() {
		wi.search();
		return wi.getDir()+tmp_projectDirfile;
	}
	
	public String getDataDir() {
		return wi.getDir()+dataDir;
	}
	
	
}
