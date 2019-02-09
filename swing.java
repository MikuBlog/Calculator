package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import java.util.jar.Pack200;

import javax.print.DocFlavor.STRING;
import javax.swing.*;

public class swing extends JFrame{
	double z;
	public swing(){
		setSize(550,600);
		setTitle("计算器");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		JPanel p2 = new JPanel(new GridLayout(6,4,3,3));
		JTextField text = new JTextField("0");
		text.setSize(550,300);
		text.setColumns(34);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.enable(false);
		text.setFont(new Font("宋体",Font.BOLD,40));
		add(text);
		JButton[] btn = new JButton[24];
		p2.add(btn[0] = new JButton("→"));
		p2.add(btn[1] = new JButton("C"));
		p2.add(btn[2] = new JButton("CE"));
		p2.add(btn[3] = new JButton("√"));
		p2.add(btn[20] = new JButton("X^2"));
		p2.add(btn[21] = new JButton("sin"));
		p2.add(btn[22] = new JButton("cos"));
		p2.add(btn[23] = new JButton("tan"));
		p2.add(btn[4] = new JButton("7"));
		p2.add(btn[5] = new JButton("8"));
		p2.add(btn[6] = new JButton("9"));
		p2.add(btn[7] = new JButton("/"));
		p2.add(btn[8] = new JButton("4"));
		p2.add(btn[9] = new JButton("5"));
		p2.add(btn[10] = new JButton("6"));
		p2.add(btn[11] = new JButton("*"));
		p2.add(btn[12] = new JButton("1"));
		p2.add(btn[13] = new JButton("2"));
		p2.add(btn[14] = new JButton("3"));
		p2.add(btn[15] = new JButton("-"));
		p2.add(btn[16] = new JButton("0"));
		p2.add(btn[17] = new JButton("."));
		p2.add(btn[18] = new JButton("="));
		p2.add(btn[19] = new JButton("+"));
		add(p2,BorderLayout.SOUTH);
		for(int i = 0 ; i < btn.length ; i++) {
			btn[i].setPreferredSize(new Dimension(50,70));
			btn[i].setFont(new Font("宋体",Font.BOLD,20));
			btn[i].setFocusPainted(false);
		}
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().length()>0&&!text.getText().equals("0")){
					text.setText(text.getText().substring(0,text.getText().length()-1));
				}
				if(text.getText().equals("")) {
					text.setText("0");
				}
			}
		});
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("0");
			}
		});
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("0");
			}
		});
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = Double.parseDouble(text.getText());
				z = Math.sqrt(a);
				text.setText(z+"");
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("7");
				else
					text.setText(text.getText()+"7");
			}
		});
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("8");
				else
					text.setText(text.getText()+"8");
			}
		});
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("9");
				else
					text.setText(text.getText()+"9");
			}
		});
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = 0;
				String pattern1 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*/-?[0-9]+.?[0-9]*";
				String pattern2 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[*]-?[0-9]+.?[0-9]*";
				String pattern3 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*-[0-9]+.?[0-9]*";
				String pattern4 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[+][0-9]+.?[0-9]*";
				if(text.getText().matches(pattern1)){
					System.out.println(text.getText().split("/")[0]);
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*/-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					text.setText(a+"/");
				}else if(text.getText().matches(pattern2)) {

					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*[*]-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					text.setText(a+"/");
				}else if(text.getText().matches(pattern3)) {
					try {
						a = Double.parseDouble(text.getText().split("-")[0])-Double.parseDouble(text.getText().split("-")[1]);
					}catch(Exception E) {
						a = -Double.parseDouble(text.getText().split("-")[1])-Double.parseDouble(text.getText().split("-")[2]);
					}
					text.setText(a+"/");
				}else if(text.getText().matches(pattern4)) {
					a = Double.parseDouble(text.getText().split("[+]")[0])+Double.parseDouble(text.getText().split("[+]")[1]);
					text.setText(a+"/");
				}else {
					if(text.getText().matches("[-]?[0-9]+[.]?[0-9]*[E]?[0-9]*")&&!text.getText().equals("0."))
						text.setText(text.getText()+"/");
				}
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("4");
				else
					text.setText(text.getText()+"4");
			}
		});
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("5");
				else
					text.setText(text.getText()+"5");
			}
		});
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("6");
				else
					text.setText(text.getText()+"6");
			}
		});
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = 0;
				String pattern1 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*/-?[0-9]+.?[0-9]*";
				String pattern2 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[*]-?[0-9]+.?[0-9]*";
				String pattern3 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*-[0-9]+.?[0-9]*";
				String pattern4 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[+][0-9]+.?[0-9]*";
				if(text.getText().matches(pattern1)){
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*/-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					text.setText(a+"*");
				}else if(text.getText().matches(pattern2)) {
					a = 0;
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*[*]-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					text.setText(a+"*");
				}else if(text.getText().matches(pattern3)) {
					try {
						a = Double.parseDouble(text.getText().split("-")[0])-Double.parseDouble(text.getText().split("-")[1]);
					}catch(Exception E) {
						a = -Double.parseDouble(text.getText().split("-")[1])-Double.parseDouble(text.getText().split("-")[2]);
					}
					text.setText(a+"*");
				}else if(text.getText().matches(pattern4)) {
					a = Double.parseDouble(text.getText().split("[+]")[0])+Double.parseDouble(text.getText().split("[+]")[1]);
					text.setText(a+"*");
				}else {
					if(text.getText().matches("[-]?[0-9]+[.]?[0-9]*[E]?[0-9]*")&&!text.getText().equals("0."))
						text.setText(text.getText()+"*");
				}
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("1");
				else
					text.setText(text.getText()+"1");
			}
		});
		btn[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("2");
				else
					text.setText(text.getText()+"2");
			}
		});
		btn[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("3");
				else
					text.setText(text.getText()+"3");
			}
		});
		btn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = 0;
				String pattern1 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*/-?[0-9]+.?[0-9]*";
				String pattern2 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[*]-?[0-9]+.?[0-9]*";
				String pattern3 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*-[0-9]+.?[0-9]*";
				String pattern4 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[+][0-9]+.?[0-9]*";
				if(text.getText().matches(pattern1)){
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*/-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					text.setText(a+"-");
				}else if(text.getText().matches(pattern2)) {
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*[*]-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					text.setText(a+"-");
				}else if(text.getText().matches(pattern3)) {
					try {
						a = Double.parseDouble(text.getText().split("-")[0])-Double.parseDouble(text.getText().split("-")[1]);
					}catch(Exception E) {
						a = -Double.parseDouble(text.getText().split("-")[1])-Double.parseDouble(text.getText().split("-")[2]);
					}
					text.setText(a+"-");
				}else if(text.getText().matches(pattern4)) {
					a = Double.parseDouble(text.getText().split("[+]")[0])+Double.parseDouble(text.getText().split("[+]")[1]);
					text.setText(a+"-");
				}else {
					if(text.getText().equals("0.")) {
						text.setText("-");
					}
					else if(text.getText().matches("[-]?[0-9]+[.]?[0-9]*[E]?[0-9]*[/*]?")) {
						text.setText(text.getText()+"-");
					}
				}
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text.getText().equals(z+"")||text.getText().equals("0"))
					text.setText("0");
				else
					text.setText(text.getText()+"0");
			}
		});
		btn[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((text.getText().matches(".*[-]?[0-9]+")||text.getText().matches("[-]?[0-9]+[.]?[0-9]*E?[-]?[0-9]*[+]?[-/]?[*]?[0-9]+"))&&!text.getText().matches("[-]?[0-9]+.?[0-9]*E[0-9]+")&&!text.getText().matches("[-]?[0-9]+[.][0-9]+")&&!text.getText().matches("[-]?[0-9]+[.]?[0-9]*E?[-]?[0-9]*[+]?[-/]?[*]?[-]?[0-9]+[.][0-9]+"))
						text.setText(text.getText()+".");
			}
		});
		btn[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = 0;
				String pattern1 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*/-?[0-9]+.?[0-9]*";
				String pattern2 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[*]-?[0-9]+.?[0-9]*";
				String pattern3 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*-[0-9]+.?[0-9]*";
				String pattern4 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[+][0-9]+.?[0-9]*";
				if(text.getText().matches(pattern1)){
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*/-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					text.setText(a+"");
				}else if(text.getText().matches(pattern2)) {

					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*[*]-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					text.setText(a+"");
				}else if(text.getText().matches(pattern3)) {
					try {
						a = Double.parseDouble(text.getText().split("-")[0])-Double.parseDouble(text.getText().split("-")[1]);
					}catch(Exception E) {
						a = -Double.parseDouble(text.getText().split("-")[1])-Double.parseDouble(text.getText().split("-")[2]);
					}
					text.setText(a+"");
				}else if(text.getText().matches(pattern4)) {
					a = Double.parseDouble(text.getText().split("[+]")[0])+Double.parseDouble(text.getText().split("[+]")[1]);
					text.setText(a+"");
				}
				z = a;
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = 0;
				String pattern1 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*/-?[0-9]+.?[0-9]*";
				String pattern2 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[*]-?[0-9]+.?[0-9]*";
				String pattern3 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*-[0-9]+.?[0-9]*";
				String pattern4 = "[-]?[0-9]+.?[0-9]*[E]?[0-9]*[+][0-9]+.?[0-9]*";
				if(text.getText().matches(pattern1)){
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*/-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("/")[0])/Double.parseDouble(text.getText().split("/")[1]);
					}
					text.setText(a+"+");
				}else if(text.getText().matches(pattern2)) {
					if(text.getText().matches("-[0-9]+.?[0-9]*[E]?[0-9]*[*]-[0-9]+.?[0-9]*")) {
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					else{
						a = Double.parseDouble(text.getText().split("[*]")[0])*Double.parseDouble(text.getText().split("[*]")[1]);
					}
					text.setText(a+"+");
				}else if(text.getText().matches(pattern3)) {
					try {
						a = Double.parseDouble(text.getText().split("-")[0])-Double.parseDouble(text.getText().split("-")[1]);
					}catch(Exception E) {
						a = -Double.parseDouble(text.getText().split("-")[1])-Double.parseDouble(text.getText().split("-")[2]);
					}
					text.setText(a+"+");
				}else if(text.getText().matches(pattern4)) {
					a = Double.parseDouble(text.getText().split("[+]")[0])+Double.parseDouble(text.getText().split("[+]")[1]);
					text.setText(a+"+");
				}else {
					if(text.getText().matches("[-]?[0-9]+[.]?[0-9]*[E]?[0-9]*")&&!text.getText().equals("0."))
						text.setText(text.getText()+"+");
					
				}
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = Math.pow(Double.parseDouble(text.getText()), 2);
				z = a ;
				text.setText(a+"");
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = Math.sin(Double.parseDouble(text.getText())*Math.PI/180);
				z = a ;
				text.setText(a+"");
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = Math.cos(Double.parseDouble(text.getText())*Math.PI/180);
				z = a ;
				text.setText(a+"");
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		btn[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a = Math.tan(Double.parseDouble(text.getText())*Math.PI/180);
				z = a ;
				text.setText(a+"");
				}catch(Exception ee) {
					text.setText("运算出错！");
				}
			}
		});
		setVisible(true);		
	}
	public static void main(String[] args) {
		new swing();
	}
}

