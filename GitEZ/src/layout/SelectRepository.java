package layout;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


import parameters.Data;
import parameters.FilePaths;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class SelectRepository extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			SelectRepository shell = new SelectRepository(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public SelectRepository(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(0, 24);
		fd_lblNewLabel.left = new FormAttachment(0, 10);
		fd_lblNewLabel.right = new FormAttachment(100, -10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("\u30EA\u30DD\u30B8\u30C8\u30EA\u3092\u9078\u629E\u3057\u3066\u304F\u3060\u3055\u3044");

		List list = new List(this, SWT.BORDER);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
		});
		FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(lblNewLabel, 150, SWT.BOTTOM);
		fd_list.top = new FormAttachment(lblNewLabel, 17);
		fd_list.left = new FormAttachment(0, 110);
		fd_list.right = new FormAttachment(100, -113);
		FilePaths path = new FilePaths();
		File repository = new File(path.getRepositories());
		try {
			FileReader fr = new FileReader(repository);
			int data;
			int j = 0;
			StringBuilder temp = new StringBuilder();
			while ((data = fr.read()) != -1) {
				temp.append((char)data);
				j++;
			}
			fr.close();
			if(j != 0) {
				String temp2 = temp.toString();
				String [] repositories = temp2.split(";",0);
				for(int i = 0 ; i< repositories.length ; i ++) {
					list.add(repositories[i]);
				}
			}else {
				MessageBox msgBox = new MessageBox(getShell(), SWT.ICON_ERROR);
				msgBox.setText("attention !");
				msgBox.setMessage("リポジトリが選択されていません");
				msgBox.open();
				close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SomethingWentWrong error = new SomethingWentWrong(display);
			error.open();
			close();
		}



		list.setLayoutData(fd_list);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String[] repo = list.getSelection();
				String repo2 = "";
				for (int i = 0 ; i < repo.length ; i ++) {
					if(repo2.isEmpty()) {
						repo2 = repo[i];
					}else {
						repo2+=repo[i];
					}
				}
				Data data = new Data();
				System.out.println("reponame :"+repo2);
				data.setRepository(repo2);
				SelectFile sf = new SelectFile(display);
				sf.open();
				close();
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(list, 21);
		fd_btnNewButton.left = new FormAttachment(0, 181);
		fd_btnNewButton.right = new FormAttachment(0, 252);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("\u9078\u629E\u3059\u308B");
		createContents();
		FilePaths fp = new FilePaths();
		File projects = new File(fp.getProjectDir());
		System.out.println("projectfilepath: "+ fp.getProjectDir());
		File[] filelist = projects.listFiles();
		if(filelist.length == 0) {
			MessageBox msgBox = new MessageBox(getShell(), SWT.ICON_ERROR);
			msgBox.setText("attention !");
			msgBox.setMessage("リポジトリが登録されていません");
			msgBox.open();
			close();
		}
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
