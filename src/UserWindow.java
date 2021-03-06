
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Color;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import operations.ListTrans;
import operations.Transaction;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField salesfile_field;
	private JTextField months_field;
	private JTextField items_field;
	private String fileName;
	private int items;
	private int months;
	/**
	 * @wbp.nonvisual location=164,369
	 */
	private final JFileChooser salesfile_file = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserWindow() {
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 280);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 34, 148, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setLocationRelativeTo(null);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 0;
		getContentPane().add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel lblNewLabel = new JLabel("TSM Sales Analyzer");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel github_msg = new JLabel("github.com/hugobrancowb");
		github_msg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_github_msg = new GridBagConstraints();
		gbc_github_msg.gridwidth = 4;
		gbc_github_msg.insets = new Insets(0, 0, 5, 5);
		gbc_github_msg.gridx = 1;
		gbc_github_msg.gridy = 2;
		getContentPane().add(github_msg, gbc_github_msg);
		
		Component abaixo_do_titulo = Box.createVerticalStrut(20);
		abaixo_do_titulo.setMinimumSize(new Dimension(0, 10));
		GridBagConstraints gbc_abaixo_do_titulo = new GridBagConstraints();
		gbc_abaixo_do_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_abaixo_do_titulo.gridx = 2;
		gbc_abaixo_do_titulo.gridy = 3;
		getContentPane().add(abaixo_do_titulo, gbc_abaixo_do_titulo);
		
		JLabel salesfile_label = new JLabel("Sales file");
		salesfile_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_salesfile_label = new GridBagConstraints();
		gbc_salesfile_label.insets = new Insets(0, 0, 5, 5);
		gbc_salesfile_label.anchor = GridBagConstraints.EAST;
		gbc_salesfile_label.gridx = 1;
		gbc_salesfile_label.gridy = 4;
		getContentPane().add(salesfile_label, gbc_salesfile_label);
		
		salesfile_field = new JTextField();
		salesfile_field.setFont(new Font("Tahoma", Font.PLAIN, 11));
		salesfile_field.setForeground(Color.LIGHT_GRAY);
		String placeholder_file_msg = "Select a 'Accounting_[realm]_sales.csv' file.";
		salesfile_field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (salesfile_field.getText().compareTo(placeholder_file_msg) == 0) {
					salesfile_field.setText("");
					salesfile_field.setForeground(Color.BLACK);
				}
			}
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (salesfile_field.getText().compareTo("") == 0) {
					salesfile_field.setText(placeholder_file_msg);
					salesfile_field.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		salesfile_field.setText("Select a 'Accounting_[realm]_sales.csv' file.");
		salesfile_label.setLabelFor(salesfile_field);
		GridBagConstraints gbc_salesfile_field = new GridBagConstraints();
		gbc_salesfile_field.gridwidth = 2;
		gbc_salesfile_field.insets = new Insets(0, 0, 5, 5);
		gbc_salesfile_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_salesfile_field.gridx = 2;
		gbc_salesfile_field.gridy = 4;
		getContentPane().add(salesfile_field, gbc_salesfile_field);
		salesfile_field.setColumns(10);
		
		JButton salesfile_browse_button = new JButton("Browse");
		FileNameExtensionFilter csvType = new FileNameExtensionFilter("CSV File (.csv)", "csv");
		salesfile_file.addChoosableFileFilter(csvType);
		salesfile_file.setAcceptAllFileFilterUsed(false);
		salesfile_browse_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = salesfile_file.showOpenDialog((Component)arg0.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = salesfile_file.getSelectedFile();
			        try {
			           fileName = file.toString();
			           salesfile_field.setText(fileName);
			        } catch (Exception ex) {
			          System.out.println("Problem accessing file"+file.getAbsolutePath());
			        }
			    }
			}
		});
		salesfile_browse_button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		salesfile_browse_button.setBackground(Color.WHITE);
		GridBagConstraints gbc_salesfile_browse_button = new GridBagConstraints();
		gbc_salesfile_browse_button.insets = new Insets(0, 0, 5, 5);
		gbc_salesfile_browse_button.gridx = 4;
		gbc_salesfile_browse_button.gridy = 4;
		getContentPane().add(salesfile_browse_button, gbc_salesfile_browse_button);
		
		JLabel months_label = new JLabel("Number of months to be reported");
		months_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_months_label = new GridBagConstraints();
		gbc_months_label.insets = new Insets(0, 0, 5, 5);
		gbc_months_label.anchor = GridBagConstraints.EAST;
		gbc_months_label.gridx = 1;
		gbc_months_label.gridy = 5;
		getContentPane().add(months_label, gbc_months_label);
		
		months_field = new JTextField();
		months_field.setRequestFocusEnabled(false);
		months_label.setLabelFor(months_field);
		months_field.setHorizontalAlignment(SwingConstants.RIGHT);
		months_field.setFocusable(false);
		months_field.setFocusTraversalKeysEnabled(false);
		months_field.setEditable(false);
		GridBagConstraints gbc_months_field = new GridBagConstraints();
		gbc_months_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_months_field.anchor = GridBagConstraints.WEST;
		gbc_months_field.insets = new Insets(0, 0, 5, 5);
		gbc_months_field.gridx = 2;
		gbc_months_field.gridy = 5;
		getContentPane().add(months_field, gbc_months_field);
		months_field.setColumns(5);
		
		JSlider months_slider = new JSlider();
		months_slider.setBackground(Color.WHITE);
		months_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				months = months_slider.getValue();
				months_field.setText(Integer.toString(months));
			}
		});
		months_slider.setValue(3);
		months_slider.setMinorTickSpacing(1);
		months_slider.setMinimum(1);
		months_slider.setMaximum(20);
		months_slider.setMajorTickSpacing(1);
		GridBagConstraints gbc_months_slider = new GridBagConstraints();
		gbc_months_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_months_slider.insets = new Insets(0, 0, 5, 5);
		gbc_months_slider.gridx = 3;
		gbc_months_slider.gridy = 5;
		getContentPane().add(months_slider, gbc_months_slider);
		
		JLabel items_label = new JLabel("Number of items per month's report");
		items_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_items_label = new GridBagConstraints();
		gbc_items_label.insets = new Insets(0, 0, 5, 5);
		gbc_items_label.anchor = GridBagConstraints.EAST;
		gbc_items_label.gridx = 1;
		gbc_items_label.gridy = 6;
		getContentPane().add(items_label, gbc_items_label);
		
		items_field = new JTextField();
		items_field.setRequestFocusEnabled(false);
		items_label.setLabelFor(items_field);
		items_field.setHorizontalAlignment(SwingConstants.RIGHT);
		items_field.setFocusTraversalKeysEnabled(false);
		items_field.setFocusable(false);
		items_field.setEditable(false);
		GridBagConstraints gbc_items_field = new GridBagConstraints();
		gbc_items_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_items_field.anchor = GridBagConstraints.WEST;
		gbc_items_field.insets = new Insets(0, 0, 5, 5);
		gbc_items_field.gridx = 2;
		gbc_items_field.gridy = 6;
		getContentPane().add(items_field, gbc_items_field);
		items_field.setColumns(5);
		
		JSlider items_slider = new JSlider();
		items_slider.setBackground(Color.WHITE);
		items_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				items = items_slider.getValue();
				items_field.setText(Integer.toString(items));
			}
		});
		items_slider.setMajorTickSpacing(1);
		items_slider.setMinorTickSpacing(1);
		items_slider.setMinimum(1);
		items_slider.setMaximum(10);
		items_slider.setValue(3);
		GridBagConstraints gbc_items_slider = new GridBagConstraints();
		gbc_items_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_items_slider.insets = new Insets(0, 0, 5, 5);
		gbc_items_slider.gridx = 3;
		gbc_items_slider.gridy = 6;
		getContentPane().add(items_slider, gbc_items_slider);
		
		Component acima_do_botao = Box.createVerticalStrut(20);
		GridBagConstraints gbc_acima_do_botao = new GridBagConstraints();
		gbc_acima_do_botao.insets = new Insets(0, 0, 5, 5);
		gbc_acima_do_botao.gridx = 2;
		gbc_acima_do_botao.gridy = 7;
		getContentPane().add(acima_do_botao, gbc_acima_do_botao);
		
		JButton report_button = new JButton("Get report");
		report_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* botï¿½o gerar relatorio report button*/
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ListTrans.clearList();
							fileName = salesfile_field.getText();
							ArrayList<Transaction> lista = Files.import_file(fileName);
							
							if(lista != null) {
								ListTrans.setTrans_list(lista);
								ListTrans.printReport(months, items);								
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		report_button.setBackground(Color.WHITE);
		GridBagConstraints gbc_report_button = new GridBagConstraints();
		gbc_report_button.insets = new Insets(0, 0, 5, 5);
		gbc_report_button.gridwidth = 4;
		gbc_report_button.gridx = 1;
		gbc_report_button.gridy = 8;
		getContentPane().add(report_button, gbc_report_button);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea.gridx = 5;
		gbc_rigidArea.gridy = 9;
		getContentPane().add(rigidArea, gbc_rigidArea);
		
		JLabel bug_msg = new JLabel("Report any bugs at hugobrancowb@gmail.com");
		bug_msg.setBorder(new EmptyBorder(0, 0, 0, 5));
		bug_msg.setForeground(Color.LIGHT_GRAY);
		bug_msg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_bug_msg = new GridBagConstraints();
		gbc_bug_msg.anchor = GridBagConstraints.EAST;
		gbc_bug_msg.gridwidth = 4;
		gbc_bug_msg.gridx = 2;
		gbc_bug_msg.gridy = 10;
		getContentPane().add(bug_msg, gbc_bug_msg);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				salesfile_browse_button.requestFocus();
			}
		});
	}
}
