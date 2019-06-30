package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaCreditos extends JFrame{
private static final long serialVersionUID = 1L;
	
	private JLabel creditoLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("fundoTelaCreditos.png")));
	
	public TelaCreditos(){
		super("Créditos");
		add(creditoLabel).setBounds(0,0,449, 449);
		setLayout(null);
		setSize(465,470);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	} 
}
