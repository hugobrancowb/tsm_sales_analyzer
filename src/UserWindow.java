
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
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import Operations.ListTrans;

import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class UserWindow extends JFrame {
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
		setBounds(100, 100, 460, 225);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 34, 148, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 0;
		getContentPane().add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel salesfile_label = new JLabel("Sales file");
		salesfile_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_salesfile_label = new GridBagConstraints();
		gbc_salesfile_label.insets = new Insets(0, 0, 5, 5);
		gbc_salesfile_label.anchor = GridBagConstraints.EAST;
		gbc_salesfile_label.gridx = 1;
		gbc_salesfile_label.gridy = 1;
		getContentPane().add(salesfile_label, gbc_salesfile_label);
		
		salesfile_field = new JTextField();
		salesfile_label.setLabelFor(salesfile_field);
		GridBagConstraints gbc_salesfile_field = new GridBagConstraints();
		gbc_salesfile_field.gridwidth = 2;
		gbc_salesfile_field.insets = new Insets(0, 0, 5, 5);
		gbc_salesfile_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_salesfile_field.gridx = 2;
		gbc_salesfile_field.gridy = 1;
		getContentPane().add(salesfile_field, gbc_salesfile_field);
		salesfile_field.setColumns(10);
		
		JButton salesfile_browse_button = new JButton("Browse");
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
		gbc_salesfile_browse_button.gridy = 1;
		getContentPane().add(salesfile_browse_button, gbc_salesfile_browse_button);
		
		JLabel months_label = new JLabel("Number of months to be reported");
		months_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_months_label = new GridBagConstraints();
		gbc_months_label.insets = new Insets(0, 0, 5, 5);
		gbc_months_label.anchor = GridBagConstraints.EAST;
		gbc_months_label.gridx = 1;
		gbc_months_label.gridy = 2;
		getContentPane().add(months_label, gbc_months_label);
		
		months_field = new JTextField();
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
		gbc_months_field.gridy = 2;
		getContentPane().add(months_field, gbc_months_field);
		months_field.setColumns(5);
		
		JSlider months_slider = new JSlider();
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
		gbc_months_slider.gridy = 2;
		getContentPane().add(months_slider, gbc_months_slider);
		
		JLabel items_label = new JLabel("Number of items per month's report");
		items_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_items_label = new GridBagConstraints();
		gbc_items_label.insets = new Insets(0, 0, 5, 5);
		gbc_items_label.anchor = GridBagConstraints.EAST;
		gbc_items_label.gridx = 1;
		gbc_items_label.gridy = 3;
		getContentPane().add(items_label, gbc_items_label);
		
		items_field = new JTextField();
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
		gbc_items_field.gridy = 3;
		getContentPane().add(items_field, gbc_items_field);
		items_field.setColumns(5);
		
		JSlider items_slider = new JSlider();
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
		gbc_items_slider.gridy = 3;
		getContentPane().add(items_slider, gbc_items_slider);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 2;
		gbc_verticalStrut_2.gridy = 4;
		getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);
		
		JButton report_button = new JButton("Get report");
		report_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* botão gerar relatorio report button*/
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ListTrans.setTrans_list(Files.import_file());
							ListTrans.printReport(months, items);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_verticalGlue.gridx = 2;
		gbc_verticalGlue.gridy = 4;
		getContentPane().add(verticalGlue, gbc_verticalGlue);
		report_button.setBackground(Color.WHITE);
		GridBagConstraints gbc_report_button = new GridBagConstraints();
		gbc_report_button.insets = new Insets(0, 0, 5, 5);
		gbc_report_button.gridwidth = 4;
		gbc_report_button.gridx = 1;
		gbc_report_button.gridy = 5;
		getContentPane().add(report_button, gbc_report_button);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridx = 5;
		gbc_rigidArea.gridy = 6;
		getContentPane().add(rigidArea, gbc_rigidArea);
	}
}
