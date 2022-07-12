package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class Ex02 extends JFrame implements ActionListener{
	
	private Container contenPane;
	private JPanel jp;
	private JTextField name;
	private JTextField tel;
	private JTextField age;
	private JPanel jp2;
	private ImageIcon icon;
	private ImageIcon icon2;
	private JButton btnIn;
	private JButton btnOut;
	ArrayList<Person> p = new ArrayList<Person>();
	
	public Ex02(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp =  new JPanel(new GridLayout(3,2));
		name = new JTextField();
		tel = new JTextField();
		age = new JTextField();
		jp2 = new JPanel();
		icon = new ImageIcon("F:\\webPro\\Note\\sqldeveloper-21.4.3.063.0100-x64\\sqldeveloper\\icon.png");
		icon2 = new ImageIcon("F:\\webPro\\Note\\sqldeveloper-21.4.3.063.0100-x64\\sqldeveloper\\icon.png");
		btnIn = new JButton("입력", icon);
		btnOut = new JButton("출력", icon2);
		
		contenPane.add(jp, BorderLayout.CENTER);
		jp.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jp.add(name);
		jp.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jp.add(tel);
		jp.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jp.add(age);
		contenPane.add(jp2, BorderLayout.SOUTH);
		jp2.add(btnIn);
		jp2.add(btnOut);
		
		setVisible(true);
		setSize(new Dimension(300,200));
		setLocation(500,500);
		
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIn) {
			String n, t;
			int a;
			n = name.getText().trim();
			t = tel.getText().trim();
			try {
				a = Integer.parseInt(age.getText());
			} catch (Exception e2) {
				a = -1;
			}
			if(!name.equals("") && !tel.equals("") && a !=-1) {
				p.add(new Person(n, t, a));
				name.setText("");
				tel.setText("");
				age.setText("");
			}else {
				System.out.println("유효하지 않는 값입니다");
			}
				System.out.println(p);
		}else if(e.getSource() == btnOut) {
			OutputStream os = null;
			try {
				os = new FileOutputStream("F:\\webPro\\source\\GUI\\src\\swing\\person.txt");
				os.write(p.toString().getBytes());
			} catch (FileNotFoundException e1) {
				System.out.println("오류");
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
			try {
				if(os != null)
					os.close();
			} catch (Exception e2) {
			}
			
		}
	}
	}
	
	public static void main(String[] args) {
		new Ex02("진우");
	}
	
}
