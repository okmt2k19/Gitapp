package layout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.widgets.Text;

import git.LaunchGit;
import parameters.FilePaths;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Input_repository extends Shell {
	private Text f_repoURL;
	private Text f_repoName;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Input_repository shell = new Input_repository(display);
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
	public Input_repository(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.left = new FormAttachment(0, 10);
		fd_lblNewLabel_2.right = new FormAttachment(100, -10);
		fd_lblNewLabel_2.top = new FormAttachment(0, 25);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("\u767B\u9332\u3057\u305F\u3044\u30EA\u30DD\u30B8\u30C8\u30EA\u306E\u60C5\u5831\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String repoURL = f_repoURL.getText();
				String repoName = f_repoName.getText();
				String repositoryname = repoName + ";";
				FilePaths paths = new FilePaths();
				File repoURLfile = new File(paths.getTmp_repositoryURL());
				File repoNamefile = new File(paths.getTmp_repositoryName()); 
				File repositories = new File(paths.getRepositories());
				try {
					FileWriter repoURLfilefw = new FileWriter(repoURLfile , false);
					FileWriter repoNamefilefw = new FileWriter(repoNamefile , false);
					repoURLfilefw.write(repoURL);
					repoNamefilefw.write(repoName);
					repoURLfilefw.close();
					repoNamefilefw.close();
					LaunchGit lg = new LaunchGit();
					FilePaths ssp = new FilePaths();
					lg.run(ssp.getRepository());
					FileWriter repofw = new FileWriter(repositories , true);
					repofw.write(repositoryname);
					repofw.close();
					
					close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -22);
		fd_btnNewButton.right = new FormAttachment(100, -95);
		fd_btnNewButton.left = new FormAttachment(0, 103);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("submit");
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_3 = new FormData();
		fd_lblNewLabel_3.right = new FormAttachment(lblNewLabel_2, 0, SWT.RIGHT);
		fd_lblNewLabel_3.left = new FormAttachment(lblNewLabel_2, 0, SWT.LEFT);
		lblNewLabel_3.setLayoutData(fd_lblNewLabel_3);
		lblNewLabel_3.setText("repository URL");
		
		f_repoURL = new Text(this, SWT.BORDER | SWT.CENTER);
		f_repoURL.setText("https://github.com/okmt2k19/Sotsuken.git");
		FormData fd_f_repoURL = new FormData();
		fd_f_repoURL.top = new FormAttachment(lblNewLabel_3, 6);
		fd_f_repoURL.left = new FormAttachment(lblNewLabel_2, 0, SWT.LEFT);
		fd_f_repoURL.right = new FormAttachment(lblNewLabel_2, 0, SWT.RIGHT);
		f_repoURL.setLayoutData(fd_f_repoURL);
		
		Label lblNewLabel_4 = new Label(this, SWT.NONE);
		lblNewLabel_4.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_4 = new FormData();
		fd_lblNewLabel_4.top = new FormAttachment(lblNewLabel_2, 28);
		fd_lblNewLabel_4.left = new FormAttachment(lblNewLabel_2, 0, SWT.LEFT);
		fd_lblNewLabel_4.right = new FormAttachment(lblNewLabel_2, 0, SWT.RIGHT);
		lblNewLabel_4.setLayoutData(fd_lblNewLabel_4);
		lblNewLabel_4.setText("repository name");
		
		f_repoName = new Text(this, SWT.BORDER | SWT.CENTER);
		fd_lblNewLabel_3.top = new FormAttachment(f_repoName, 32);
		f_repoName.setText("Sotsuken");
		FormData fd_f_repoName = new FormData();
		fd_f_repoName.top = new FormAttachment(lblNewLabel_4, 6);
		fd_f_repoName.right = new FormAttachment(lblNewLabel_2, 0, SWT.RIGHT);
		fd_f_repoName.left = new FormAttachment(0, 10);
		f_repoName.setLayoutData(fd_f_repoName);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("input form");
		setSize(450,300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
