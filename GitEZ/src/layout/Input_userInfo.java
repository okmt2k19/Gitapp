package layout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;

import git.LaunchGit;
import parameters.FilePaths;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Input_userInfo extends Shell {
	private Text f_name;
	private Text f_email;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Input_userInfo shell = new Input_userInfo(display);
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
	public Input_userInfo(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.left = new FormAttachment(100, -424);
		fd_lblNewLabel.right = new FormAttachment(100, -10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("GitHub\u3067\u4F7F\u7528\u3057\u3066\u3044\u308B\u30E6\u30FC\u30B6\u30CD\u30FC\u30E0\u3068\u30E1\u30FC\u30EB\u30A2\u30C9\u30EC\u30B9\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044");

		f_name = new Text(this, SWT.BORDER | SWT.CENTER);
		f_name.setText("your name");
		FormData fd_f_name = new FormData();
		fd_f_name.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		f_name.setLayoutData(fd_f_name);

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		fd_f_name.left = new FormAttachment(lblNewLabel_1, 10, SWT.LEFT);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		fd_lblNewLabel.bottom = new FormAttachment(lblNewLabel_1, -15);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		fd_lblNewLabel_1.left = new FormAttachment(lblNewLabel, 0, SWT.LEFT);
		fd_lblNewLabel_1.bottom = new FormAttachment(100, -196);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("user name");

		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		fd_f_name.bottom = new FormAttachment(lblNewLabel_2, -19);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.left = new FormAttachment(0, 188);
		fd_lblNewLabel_2.top = new FormAttachment(0, 111);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("email address");

		f_email = new Text(this, SWT.BORDER | SWT.CENTER);
		f_email.setText("you@example.com");
		FormData fd_f_email = new FormData();
		fd_f_email.top = new FormAttachment(lblNewLabel_2, 6);
		fd_f_email.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		fd_f_email.left = new FormAttachment(f_name, 0, SWT.LEFT);
		f_email.setLayoutData(fd_f_email);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String name = f_name.getText();
				String email = f_email.getText();
				FilePaths paths = new FilePaths();
				File namefile = new File(paths.getTmp_name());
				File emailfile = new File(paths.getTmp_email());
				try {
					FileWriter namefw = new FileWriter(namefile , false);
					FileWriter emailfw = new FileWriter(emailfile , false);
					namefw.write(name);
					emailfw.write(email);
					namefw.close();
					emailfw.close();
					LaunchGit lg = new LaunchGit();
					FilePaths ssp = new FilePaths();
					lg.run(ssp.getUser());
					close();
				}catch (IOException ioe) {
					ioe.printStackTrace();
					SomethingWentWrong error = new SomethingWentWrong(display);
					error.open();
					close();
				}
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.left = new FormAttachment(100, -260);
		fd_btnNewButton.right = new FormAttachment(100, -173);
		fd_btnNewButton.bottom = new FormAttachment(100, -32);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("submit");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("input user info");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
