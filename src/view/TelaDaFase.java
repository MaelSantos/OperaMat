package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaDaFase  extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel reiniciarLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("reiniciar.png")));
	private JLabel voltarMenuLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("menu.png")));

	public TelaDaFase(){}
	
	public JLabel getReiniciarLabel() {
		return reiniciarLabel;
	}
	
	public JLabel getVoltarMenuLabel() {
		return voltarMenuLabel;
	}
	
}
