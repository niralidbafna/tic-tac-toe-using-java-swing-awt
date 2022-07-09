import java.awt.event.*;
import javax.swing.*;
public class game extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4;
	JButton[] b=new JButton[10];
	JTextField tf1,tf2,tf3,tf4,tf5;
	int chance=1;
	game(){
		setTitle("TIC TAC TOE");
		l1=new JLabel("Enter Player 1's Name: ");
		l2=new JLabel("Enter Player 2's Name: ");
		l1.setBounds(100,100,200,30);
		l2.setBounds(100,150,200,30);
		tf1=new JTextField();
		tf2=new JTextField();
		tf1.setBounds(300,100,200,30);
		tf2.setBounds(300,150,200,30);
		b[0]=new JButton("PLAY");
		b[0].setBounds(350,200,100,30);
		b[0].addActionListener(this);
		
		add(l1); add(l2);
		add(tf1); add(tf2);
		add(b[0]);
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		
	}
	public void display() {

		for(int i=1;i<=9;i++) {
			b[i]=new JButton("");
			add(b[i]);
			b[i].addActionListener(this);
		}
		b[1].setBounds(220, 350, 70, 70);
		b[2].setBounds(295, 350, 70, 70);
		b[3].setBounds(370, 350, 70, 70);
		b[4].setBounds(220, 425, 70, 70);
		b[5].setBounds(295, 425, 70, 70);
		b[6].setBounds(370, 425, 70, 70);
		b[7].setBounds(220, 500, 70, 70);
		b[8].setBounds(295, 500, 70, 70);
		b[9].setBounds(370, 500, 70, 70);
	}
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b[0]) {
			tf3=new JTextField("");
			tf4=new JTextField("");
			tf5=new JTextField("");
			tf3.setEditable(false);
			tf4.setEditable(false);
			tf5.setEditable(false);
			add(tf3); add(tf4); add(tf5);
			tf3.setBounds(250,300,100,30);
			tf4.setBounds(220,600,200,30);
			tf5.setBounds(220,650,200,30);
			l3=new JLabel(tf1.getText()+": X");
			l4=new JLabel(tf2.getText()+": O");
			l3.setBounds(250,260,100,30);
			l4.setBounds(360,260,100,30);
			add(l3); add(l4);
			display();
			tf3.setText(tf1.getText()+"'s chance");
		}
		else if(chance%2!=0) {
			if(((JButton) e.getSource()).getText()!="X" && ((JButton)e.getSource()).getText()!="O") {
				
				((JButton)e.getSource()).setText("X");
				
				if((b[1].getText()=="X" && b[2].getText()=="X" && b[3].getText()=="X") ||
				   (b[4].getText()=="X" && b[5].getText()=="X" && b[6].getText()=="X") ||	
				   (b[7].getText()=="X" && b[8].getText()=="X" && b[9].getText()=="X") ||
				   (b[1].getText()=="X" && b[4].getText()=="X" && b[7].getText()=="X") ||
				   (b[2].getText()=="X" && b[5].getText()=="X" && b[8].getText()=="X") ||
				   (b[3].getText()=="X" && b[6].getText()=="X" && b[9].getText()=="X") ||
				   (b[1].getText()=="X" && b[5].getText()=="X" && b[9].getText()=="X") ||
				   (b[3].getText()=="X" && b[5].getText()=="X" && b[7].getText()=="X") ) {
						tf5.setText(tf1.getText()+" wins!!!");
						tf4.setText("GAME OVER!");
						for(int i=0;i<=9;i++) {
							b[i].setEnabled(false);
						}
					}else {
						chance++;
						tf4.setText("");
						tf3.setText(tf2.getText()+"'s chance");	
					}
				}
				else {
					tf3.setText(tf1.getText()+"'s chance");
					tf4.setText("Place marker in an empty square");
				}			
		}
		else if(chance%2==0) {
			if(((JButton) e.getSource()).getText()!="X" && ((JButton)e.getSource()).getText()!="O") {
				
				((JButton)e.getSource()).setText("O");
				
				if((b[1].getText()=="O" && b[2].getText()=="O" && b[3].getText()=="O") ||
				   (b[4].getText()=="O" && b[5].getText()=="O" && b[6].getText()=="O") ||	
				   (b[7].getText()=="O" && b[8].getText()=="O" && b[9].getText()=="O") ||
				   (b[1].getText()=="O" && b[4].getText()=="O" && b[7].getText()=="O") ||
				   (b[2].getText()=="O" && b[5].getText()=="O" && b[8].getText()=="O") ||
				   (b[3].getText()=="O" && b[6].getText()=="O" && b[9].getText()=="O") ||
				   (b[1].getText()=="O" && b[5].getText()=="O" && b[9].getText()=="O") ||
				   (b[3].getText()=="O" && b[5].getText()=="O" && b[7].getText()=="O") ) {
						tf5.setText(tf2.getText()+" wins!!!");
						tf4.setText("GAME OVER!");
						for(int i=0;i<=9;i++) {
							b[i].setEnabled(false);
						}
					}else {
						chance++;
						tf4.setText("");
						tf3.setText(tf1.getText()+"'s chance");
					}	
			}
			else {
				tf3.setText(tf2.getText()+"'s chance");
				tf4.setText("Place marker in an empty square");
			}
		}
		 if(chance>9){
			tf4.setText("GAME OVER!");
			tf5.setText("DRAW MATCH!");
			for(int i=0;i<=9;i++) {
				b[i].setEnabled(false);
			}
		}
	}
	public static void main(String[]args) {
		new game();
	}
}
