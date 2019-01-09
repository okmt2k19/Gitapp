package layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class SomethingWentWrong extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			SomethingWentWrong shell = new SomethingWentWrong(display);
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
	public SomethingWentWrong(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());
		
		Label label = new Label(this, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 10);
		fd_label.top = new FormAttachment(0, 29);
		fd_label.right = new FormAttachment(0, 274);
		label.setLayoutData(fd_label);
		label.setText("\u30A8\u30E9\u30FC\uFF01\u3000\u6700\u521D\u304B\u3089\u3084\u308A\u76F4\u3057\u3066\u307F\u3066\u304F\u3060\u3055\u3044");
		
		Button button = new Button(this, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				close();
			}
		});
		fd_label.bottom = new FormAttachment(button, -6);
		FormData fd_button = new FormData();
		fd_button.left = new FormAttachment(100, -162);
		fd_button.bottom = new FormAttachment(100, -10);
		fd_button.right = new FormAttachment(100, -112);
		button.setLayoutData(fd_button);
		button.setText("\u3068\u3058\u308B");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Something went wrong");
		setSize(300, 150);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
