package layout;





import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import git.LaunchGit;
import parameters.FilePaths;
import utils.BackslashChange;
import utils.CutString;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

public class SelectFile2 extends Shell {
	Table table;
	ArrayList <String> filenameArray = new ArrayList <String> ();
	ArrayList <String> filepathArray = new ArrayList <String> ();
	private Text tbox_message;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			SelectFile shell = new SelectFile(display);
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
	public SelectFile2(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FormLayout());

		Label label = new Label(this, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 10);
		fd_label.top = new FormAttachment(0, 20);
		fd_label.right = new FormAttachment(0, 574);
		label.setLayoutData(fd_label);
		label.setText("\u30EA\u30E2\u30FC\u30C8\u306B\u53CD\u6620\u3057\u305F\u3044\u30D5\u30A1\u30A4\u30EB\u3092\u9078\u629E\u3057\u3066\u304F\u3060\u3055\u3044\u3002\r\n\u9078\u629E\u304C\u7D42\u308F\u3063\u305F\u3089\u30B3\u30DF\u30C3\u30C8\u30E1\u30C3\u30BB\u30FC\u30B8\u3092\u5165\u529B\u3057\u3066\u3001\u9078\u629E\u3092\u7D42\u4E86\u3059\u308B\u3092\u62BC\u3057\u3066\u304F\u3060\u3055\u3044");

		Button button = new Button(this, SWT.NONE);
		fd_label.bottom = new FormAttachment(button, -6);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				FileDialog dialog = new FileDialog(getShell() , SWT.OPEN | SWT.MULTI);
				String path = "c:\\";
				dialog.setFilterPath(path);
				filenameArray.add(dialog.open());
				filepathArray.add(dialog.getFilterPath());

				//System.out.print(filepathArray.get(0));
				if (filenameArray != null || filenameArray.size() != 0) {
					table.setHeaderVisible(true);
					table.setLinesVisible(true);
					//					for(int i=0;i < filenameArray.size();i++){
					//						TableItem item = new TableItem(table,SWT.NULL);
					//						item.setText(filenameArray.get(i));
					//						System.out.println(filenameArray.get(i));
					//					}
					TableItem item = new TableItem(table,SWT.NULL);
					item.setText(filenameArray.get(filenameArray.size()-1));
				}
				if (filepathArray != null || filepathArray.size() != 0) {

				}
			}
		});
		FormData fd_button = new FormData();
		fd_button.left = new FormAttachment(0, 38);
		button.setLayoutData(fd_button);
		button.setText("\u30D5\u30A1\u30A4\u30EB\u3092\u9078\u3076");

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (filenameArray != null || filenameArray.size() != 0) {
					FilePaths path = new FilePaths();
					try {
						String message = tbox_message.getText();
						File mfile = new File(path.getTmp_message());
						File filepaths = new File(path.getTmp_filepaths());
						File files = new File(path.getTmp_files());
						FileWriter fw = new FileWriter(files , false);
						FileWriter fw2 = new FileWriter(filepaths,false);
						FileWriter fw3 = new FileWriter(mfile , false);
						StringBuilder builder1 = new StringBuilder();
						StringBuilder builder2 = new StringBuilder();
						BackslashChange bc = new BackslashChange();
						CutString cs = new CutString();
						FilePaths fp = new FilePaths();
						for (int i = 0 ; i < filenameArray.size() ; i ++) {
							
							builder1.append(cs.cutFIilename(bc.change(filenameArray.get(i)+";")));
							builder2.append(cs.cutPath(bc.change((filepathArray.get(i)+"/"+";"))));
							Path from = Paths.get(filenameArray.get(i));
							Path to = Paths.get(fp.getProjectDir()+"\\"
									+cs.cutPathforjava(filepathArray.get(i))+
									"\\"+cs.cutFIilename(bc.change(filenameArray.get(i))));
							Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
						}
						String projectDirfile = fp.getProjectDirfile();
						File pp = new File(fp.getProjectDirfile());
						System.out.println(fp.getProjectDirfile());
						FileWriter fw4 = new FileWriter(pp , false);
						fw.write(builder1.toString());
						System.out.println(builder1.toString());
						fw2.write(builder2.toString());
						System.out.println(builder2.toString());
						fw3.write(message);
						fw4.write(projectDirfile);
						fw.close();
						fw2.close();
						fw3.close();
						fw4.close();
						
						LaunchGit lg = new LaunchGit();
						lg.run(path.getCommit());
						close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						SomethingWentWrong error = new SomethingWentWrong(display);
						error.open();
						close();
					}
				}else {
					MessageBox msgBox = new MessageBox(getShell(), SWT.ICON_ERROR);
					msgBox.setText("attention !");
					msgBox.setMessage("ファイルが選択されていません！");
					msgBox.open();
					close();
				}


			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -10);
		fd_btnNewButton.left = new FormAttachment(0, 223);
		fd_btnNewButton.right = new FormAttachment(100, -240);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("\u9078\u629E\u3092\u7D42\u4E86\u3059\u308B");

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		fd_button.bottom = new FormAttachment(table, -6);
		FormData fd_table = new FormData();
		fd_table.left = new FormAttachment(0, 38);
		fd_table.top = new FormAttachment(0, 102);
		fd_table.right = new FormAttachment(100, -51);
		String[] cols = {"ファイル名"};
		for(int i=0;i<cols.length;i++){
			TableColumn col = new TableColumn(table,SWT.LEFT);
			col.setText(cols[i]);
			col.setWidth(500);
		}
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Button button_1 = new Button(this, SWT.NONE);
		fd_button.right = new FormAttachment(button_1, -149);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				filenameArray = new ArrayList <String> ();
				filepathArray = new ArrayList <String> ();
				SelectFile sf = new SelectFile(display);
				sf.open();
				close();
			}
		});
		FormData fd_button_1 = new FormData();
		fd_button_1.left = new FormAttachment(0, 390);
		fd_button_1.right = new FormAttachment(100, -51);
		fd_button_1.top = new FormAttachment(button, 0, SWT.TOP);
		button_1.setLayoutData(fd_button_1);
		button_1.setText("\u9078\u629E\u3092\u3084\u308A\u76F4\u3059");

		Label label_1 = new Label(this, SWT.NONE);
		fd_table.bottom = new FormAttachment(label_1, -6);
		label_1.setAlignment(SWT.CENTER);
		FormData fd_label_1 = new FormData();
		fd_label_1.left = new FormAttachment(button, 0, SWT.LEFT);
		fd_label_1.right = new FormAttachment(100, -51);
		label_1.setLayoutData(fd_label_1);
		label_1.setText("\u30B3\u30DF\u30C3\u30C8\u30E1\u30C3\u30BB\u30FC\u30B8\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044");

		tbox_message = new Text(this, SWT.BORDER | SWT.CENTER);
		fd_label_1.bottom = new FormAttachment(tbox_message, -6);
		tbox_message.setText("default message");
		FormData fd_tbox_message = new FormData();
		fd_tbox_message.top = new FormAttachment(0, 295);
		fd_tbox_message.bottom = new FormAttachment(btnNewButton, -6);
		fd_tbox_message.left = new FormAttachment(button, 0, SWT.LEFT);
		fd_tbox_message.right = new FormAttachment(100, -51);
		tbox_message.setLayoutData(fd_tbox_message);


		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u30D5\u30A1\u30A4\u30EB\u9078\u629E");
		setSize(600, 400);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
