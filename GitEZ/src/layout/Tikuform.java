package layout;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import swing2swt.layout.BorderLayout;

public class Tikuform extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Tikuform shell = new Tikuform(display);
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
	public Tikuform(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new BorderLayout(0, 0));
		Label lblTiku = new Label(this, SWT.CENTER);
		lblTiku.setLayoutData(BorderLayout.NORTH);
		lblTiku.setText("TIKU");
		Label lblimage = new Label(this,SWT.CENTER);
		lblimage.setLayoutData(BorderLayout.CENTER);
	//	Path kdmimage = Paths.get("Z:\\you\\image\\04.jpg");
		Image photo = new Image(display,"Z:\\you\\image\\04.jpg");
		lblimage.setImage(photo);
		
		createContents();
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
