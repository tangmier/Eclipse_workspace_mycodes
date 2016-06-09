package youxi1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonTest extends JApplet
implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtf;
	public void init(){
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JRadioButton b1 = new JRadioButton("A");
		b1.addActionListener(this);
		contentPane.add(b1);
		JRadioButton b2 = new JRadioButton("B");
		b2.addActionListener(this);
		contentPane.add(b2);
		JRadioButton b3 = new JRadioButton("C");
		b3.addActionListener(this);
		contentPane.add(b3);
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		jtf = new JTextField(15);
		contentPane.add(jtf);
		
 }
	public void actionPerformed(ActionEvent ae){
		jtf.setText(ae.getActionCommand());
	}
}