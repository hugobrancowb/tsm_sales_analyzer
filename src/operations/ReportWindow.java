package operations;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class ReportWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane title_panel;
	JTextPane textPane = new JTextPane();
	private JPanel panel;
	private JButton savereport_button;
	/**
	 * Create the frame.
	 */
	public ReportWindow() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(450, 500));
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{291, 215, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		title_panel = new JTextPane();
		title_panel.setRequestFocusEnabled(false);
		title_panel.setFocusable(false);
		title_panel.setFocusTraversalKeysEnabled(false);
		title_panel.setFocusCycleRoot(false);
		title_panel.setDisabledTextColor(Color.WHITE);
		title_panel.setEditable(false);
		title_panel.setBorder(new EmptyBorder(0, 20, 0, 0));
		title_panel.setContentType("text/html");
		title_panel.setText("<h2 style='font-family:tahoma;'>Report by month</h2>");
		GridBagConstraints gbc_title_panel = new GridBagConstraints();
		gbc_title_panel.fill = GridBagConstraints.BOTH;
		gbc_title_panel.gridx = 0;
		gbc_title_panel.gridy = 0;
		contentPane.add(title_panel, gbc_title_panel);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		savereport_button = new JButton("Save report");
		savereport_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String output_report = "Report by month:\r\n\r\n";
				output_report = output_report.concat(textPane.getText());
				
				try (PrintStream out = new PrintStream(new FileOutputStream("data/report.txt"))) {
				    out.print(output_report);
				} catch (FileNotFoundException e) {
					error_popup("FileNotFoundException");
				}
			}
		});
		
		savereport_button.setRequestFocusEnabled(false);
		savereport_button.setBackground(Color.WHITE);
		savereport_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_savereport_button = new GridBagConstraints();
		gbc_savereport_button.gridx = 0;
		gbc_savereport_button.gridy = 0;
		panel.add(savereport_button, gbc_savereport_button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textPane.setBorder(new EmptyBorder(0, 20, 0, 20));
				
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);		
	}
	
	public void addToPanel(String s) {
		String oldtext = textPane.getText();
		String newtext = oldtext.concat(s);
		newtext = newtext.concat("\r\n\r\n");
		textPane.setText(newtext);
	}
	
	private static void error_popup(String msg) {
		JFrame errorframe = new JFrame("Show Message Box");
    	errorframe.setBackground(Color.WHITE);
    	JOptionPane.showMessageDialog(errorframe, msg);
		System.exit(1);
	}
}
