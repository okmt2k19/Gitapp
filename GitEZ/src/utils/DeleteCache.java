package utils;

import java.io.File;
import java.io.IOException;

import parameters.FilePaths;

public class DeleteCache {
	public void deletecache()  {
		FilePaths fp = new FilePaths();
		try {
			File repoURL = new File(fp.getTmp_repositoryURL());
			File new_repoURL = new File(fp.getTmp_repositoryURL());
			System.out.println(new_repoURL);
			repoURL.delete();
			new_repoURL.createNewFile();
			File repoName = new File(fp.getTmp_repositoryName());
			File new_repoName = new File(fp.getTmp_repositoryName());
			repoName.delete();
			new_repoName.createNewFile();
			File name = new File(fp.getTmp_name());
			File new_name = new File(fp.getTmp_name());
			name.delete();
			new_name.createNewFile();
			File email = new File(fp.getTmp_email());
			File new_email = new File(fp.getTmp_email());
			email.delete();
			new_email.createNewFile();
			File files = new File(fp.getTmp_files());
			File new_files = new File(fp.getTmp_files());
			files.delete();
			new_files.createNewFile();
			File filepaths = new File(fp.getTmp_filepaths());
			File new_filepaths = new File(fp.getTmp_filepaths());
			filepaths.delete();
			new_filepaths.createNewFile();
			File message = new File(fp.getTmp_message());
			File new_message = new File(fp.getTmp_message());
			message.delete();
			new_message.createNewFile();
			File repositories = new File(fp.getRepositories());
			File new_repositories = new File(fp.getRepositories());
			repositories.delete();
			new_repositories.createNewFile();
			File selected = new File(fp.getSelectedRepository());
			File new_selected = new File(fp.getSelectedRepository());
			selected.delete();
			new_selected.createNewFile();
			File dir = new File(fp.getDirfile());
			File new_dir = new File(fp.getDirfile());
			dir.delete();
			new_dir.createNewFile();
			
			File projects = new File(fp.getProjectDir());
			File new_projects = new File(fp.getProjectDir());
			delete(projects);
			new_projects.mkdirs();
			
			
		}catch(IOException e) {
			
		}		
	}
	public void delete(File f) {
		if(f.exists() == false) {
			return;
		}
		
		if(f.isFile()) {
			f.delete();
		}
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(int i = 0 ; i < files.length ; i++) {
				delete(files[i]);
			}
			f.delete();
		}
		
	}

}
