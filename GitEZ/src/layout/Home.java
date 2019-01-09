package layout;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import git.InstallGit;
import git.UninstallGit;
import parameters.WhereIam;
import utils.DeleteCache;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

public class Home extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Home shell = new Home(display);
			WhereIam wi = new WhereIam();
			wi.search();
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
	public Home(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblgitgitHttpsgithubcomokmtkgitezpz = new Label(this, SWT.NONE);
		lblgitgitHttpsgithubcomokmtkgitezpz.setAlignment(SWT.CENTER);
		lblgitgitHttpsgithubcomokmtkgitezpz.setText("\r\n\u547C\u5438\u59CB\u3081\u305F\u3070\u304B\u308A\u306E\u65B0\u751F\u5150\u3067\u3082Git\u304C\u4F7F\u3048\u308B\u3088\u3046\u306B\u958B\u767A\u3057\u307E\u3057\u305F\u3002\r\n\u30BD\u30FC\u30B9 \u2192 https://github.com/okmt2k19/Gitapp");
		
		Button btnSetup = new Button(this, SWT.NONE);
		btnSetup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Input_repository ir = new Input_repository(display);
				ir.open();
				
			}
		});
		btnSetup.setText("\u65B0\u3057\u3044\u30EA\u30DD\u30B8\u30C8\u30EA\u3092\u4F5C\u6210");
		
		Button btnCloneRepository = new Button(this, SWT.NONE);
		btnCloneRepository.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				SelectRepository2 sr2 = new SelectRepository2(display);
				sr2.open();
				
			}
		});
		btnCloneRepository.setText("\u30EA\u30DD\u30B8\u30C8\u30EA\u3092\u6700\u65B0\u306B\u66F4\u65B0");
		
		Button btnReflectYourSorce = new Button(this, SWT.NONE);
		btnReflectYourSorce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				SelectRepository sr = new SelectRepository(display);
				sr.open();
				
			}
		});
		btnReflectYourSorce.setText("\u4F5C\u696D\u3092\u30EA\u30E2\u30FC\u30C8\u306B\u53CD\u6620");
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Input_userInfo iu = new Input_userInfo(display);
				iu.open();
			}
		});
		button_1.setText("\u30A2\u30AB\u30A6\u30F3\u30C8\u3092\u8A2D\u5B9A\uFF08\u521D\u56DE\u306E\u307F\uFF09");
		
		Button btnSetupYourAccount = new Button(this, SWT.NONE);
		btnSetupYourAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Update_Input_userinfo uu = new Update_Input_userinfo(display);
				uu.open();
			}
		});
		btnSetupYourAccount.setText("\u30A2\u30AB\u30A6\u30F3\u30C8\u3092\u518D\u8A2D\u5B9A");
		
		Button btnInstallGit = new Button(this, SWT.NONE);
		btnInstallGit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				MessageBox msgBox = new MessageBox(getShell(),SWT.OK|SWT.CANCEL |SWT.ICON_INFORMATION);
				msgBox.setText("info");
				msgBox.setMessage("インストール先は配ったフォルダの中にしてください");
				int result = msgBox.open();
				if(result == SWT.OK) {
					InstallGit ig = new InstallGit();
					ig.run();
				}
				
				
			}
		});
		btnInstallGit.setText("Git\u3092\u30A4\u30F3\u30B9\u30C8\u30FC\u30EB");
		
		Button btnUninstallGit = new Button(this, SWT.NONE);
		btnUninstallGit.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				UninstallGit ug = new UninstallGit();
				ug.run();
				
			}
		});
		btnUninstallGit.setText("Git\u3092\u30A2\u30F3\u30A4\u30F3\u30B9\u30C8\u30FC\u30EB");
		
		Button btnTiku = new Button(this, SWT.NONE);
		btnTiku.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int max = 20;
				for (int i = 0 ; i < max ; i++) {
					Tikuform tf = new Tikuform(display);
					tf.open();
				}
				Tikuform tf = new Tikuform(display);
				tf.open();
				WhereIam wi = new WhereIam();
				wi.search();
			}
		});
		btnTiku.setText("tiku\u3299");
		
		Button button = new Button(this, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				DeleteCache dc = new DeleteCache();
				dc.deletecache();
				MessageBox msgBox = new MessageBox(getShell(), SWT.ICON_INFORMATION);
				msgBox.setText("attention !");
				msgBox.setMessage("削除しました");
				msgBox.open();
				
			}
		});
		button.setText("\u30C7\u30FC\u30BF\u524A\u9664(\u30D5\u30A1\u30A4\u30EB\u30AD\u30E3\u30C3\u30B7\u30E5\u3068\u30D7\u30ED\u30B8\u30A7\u30AF\u30C8)");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Git EZ by okmt");
		setSize(400,500);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
