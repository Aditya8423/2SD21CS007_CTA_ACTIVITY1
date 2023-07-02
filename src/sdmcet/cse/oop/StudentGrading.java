package sdmcet.cse.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Form extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4, t5;
	JButton b1;

	Form(String title) {
		super(title);
		l1 = new JLabel("Grade Calculator");
		l2 = new JLabel("Enter IA-1 Marks");
		l3 = new JLabel("Enter IA-2 Marks");
		l4 = new JLabel("Enter IA-3 Marks");
		l5 = new JLabel("Enter CTA Marks");
		l6 = new JLabel("Enter SEE Marks");
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);
		b1 = new JButton("Calculate");

		add(l1);
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		add(l4);
		add(t3);
		add(l5);
		add(t4);
		add(l6);
		add(t5);
		add(b1);
		add(l7);
		add(l8);
		add(l9);

		setLayout(null);

		l1.setBounds(130, 40, 100, 50);
		l2.setBounds(80, 100, 100, 50);
		t1.setBounds(190, 110, 100, 30);
		l3.setBounds(80, 150, 100, 50);
		t2.setBounds(190, 160, 100, 30);
		l4.setBounds(80, 200, 100, 50);
		t3.setBounds(190, 210, 100, 30);
		l5.setBounds(80, 250, 100, 50);
		t4.setBounds(190, 260, 100, 30);
		l6.setBounds(80, 300, 100, 50);
		t5.setBounds(190, 310, 100, 30);
		b1.setBounds(140, 350, 100, 50);
		l7.setBounds(80, 430, 100, 50);
		l8.setBounds(210, 430, 100, 50);
		l9.setBounds(20, 390, 500, 50);

		b1.addActionListener(this);
	}

	char grade(int marks) {
		char s = 0;
		if (marks >= 90 && marks <= 100) {
			s = 'S';
		} else if (marks >= 80 && marks < 90) {
			s = 'A';
		} else if (marks >= 70 && marks < 80) {
			s = 'B';
		} else if (marks >= 60 && marks < 70) {
			s = 'C';
		} else if (marks >= 50 && marks < 60) {
			s = 'D';
		} else if (marks >= 40 && marks < 50) {
			s = 'E';
		} else if (marks >= 0 && marks < 40) {
			s = 'F';
		}
		return s;
	}

	int ciecal(int ia1, int ia2, int ia3, int cta) {
		int cie = 0;

		if (ia1 <= ia2 && ia1 <= ia3) {
			cie = ia2 + ia3;
		} else if (ia2 <= ia1 && ia2 <= ia3) {
			cie = ia1 + ia3;
		} else if (ia3 <= ia1 && ia3 <= ia1) {
			cie = ia1 + ia2;
		}

		cie = cie + cta;

		return cie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int ia1 = Integer.parseInt(t1.getText());
		int ia2 = Integer.parseInt(t2.getText());
		int ia3 = Integer.parseInt(t3.getText());
		int cta = Integer.parseInt(t4.getText());
		int see = Integer.parseInt(t5.getText());
		int cie = ciecal(ia1, ia2, ia3, cta);
		char gra;
		try {
			if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
				throw new IllegalArgumentException("Invalid marks. IA Marks must be in the range 0-20.");
			} else if (cta < 0 || cta > 10) {
				throw new IllegalArgumentException("Invalid marks. CTA marks must be in the range 0-10.");
			} else if (see < 0 || see > 100) {
				throw new IllegalArgumentException("Invalid marks. SEE marks must be in the range 0-100.");
			} else {
				if (cie < 20) {
					l9.setText("Student is detained from taking SEE");
				} else {
					if (see < 38) {
						gra = 'F';
					} else {
						if (see == 38 || see == 39) {
							see = 40;
						}
						float se = see / 2f;
						if (se > (int) se) {
							se += 1;
						}
						int mark = cie + (int) se;
						gra = grade(mark);
						if (mark < 40 && mark > 0) {
							l9.setText("student is failed");
						}
						l7.setText("total marks : " + mark);
					}
					l8.setText("grade : " + gra);
				}
			}
		} catch (Exception e1) {
			l9.setText(e1.getMessage());
		}
	}
}

public class StudentGrading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new Form("Student Grading System");

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200, 300, 400, 600);
	}

}
