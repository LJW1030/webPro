package swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Ex01 extends JFrame implements ActionListener{

	private Container contenPane;
	private ImageIcon icon;
	private JButton btn;
	private JTextField txt;
	private JComboBox<String> combo;
	private Vector<String> items;
	private JCheckBox check;
	private JLabel bl;
	private JButton bExit;
	
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		icon = new ImageIcon("F:\\webPro\\pic.png");
		btn = new JButton("Button",icon);
		txt = new JTextField(20);
		items = new Vector<String>();
		items.add("가나다"); items.add("ABC"); items.add("1 2 3");
		combo = new JComboBox<String>(items);
		check = new JCheckBox("checkBox");
		bl = new JLabel("");
		bExit = new JButton("EXIT");
		
		contenPane.add(new JLabel("Label"));
		contenPane.add(btn);
		contenPane.add(txt);
		contenPane.add(combo);
		contenPane.add(check);
		contenPane.add(bl);
		contenPane.add(bExit);
		
		btn.setPreferredSize(new Dimension(200,50));
		txt.setPreferredSize(new Dimension(300,50));
		combo.setPreferredSize(new Dimension(100,50));
		check.setPreferredSize(new Dimension(100,50));
		bl.setPreferredSize(new Dimension(200,50));
		bExit.setPreferredSize(new Dimension(100,50));
		setVisible(true);
		//setSize(new Dimension(1100,200));
		pack();
		setLocation(500, 500);
		
		btn.addActionListener(this);
		combo.addActionListener(this);
		check.addActionListener(this);
		bExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			String temp = txt.getText().trim();
			if(temp.equals("")) {
				System.out.println("이놈");
				return;
			}
			combo.addItem(temp);
			bl.setText(txt.getText().trim());
			txt.setText("");
		}else if(e.getSource() == combo) {
			String temp = combo.getSelectedItem().toString();
			int no = combo.getSelectedIndex();
			bl.setText(no+1+"번째"+temp+"선택");
			combo.setSelectedItem("가나다");
		}else if(e.getSource() == check) {
			if(check.isSelected()) {
				bl.setText(check.getText());
			}else {
				bl.setText("");
			}
		}else if(e.getSource() == bExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Ex01("진우!");
	}
}
