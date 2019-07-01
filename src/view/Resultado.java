package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Resultado extends JDialog {

	private static final long serialVersionUID = -3792969622223059913L;
	
	private JPanel pnlFundo;
	private ImageIcon fundo, voltar, exportar;
	private JTextArea txaResultados;
	private JButton btnVoltar, btnExportar;
	
	public Resultado(JFrame frame) {
		super(frame, "Resultados", true);
		
		fundo = new ImageIcon(getClass().getClassLoader().getResource("OperaMat.png"));
		voltar = new ImageIcon(getClass().getClassLoader().getResource("voltar.png"));
//		fundo = new ImageIcon(getClass().getClassLoader().getResource("OperaMat.png"));
		
		pnlFundo = new JPanel() {
			private static final long serialVersionUID = -1090441492036530722L;
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(fundo.getImage(), 0, 0, null);
			};
		};
		
		pnlFundo.setSize(300, 400);
		pnlFundo.setBounds(0, 0, 300, 400);
		
		txaResultados = new JTextArea(19, 19);
		txaResultados.setEditable(false);
		
		btnVoltar = new JButton(voltar);
		btnExportar = new JButton("Exportar");
		
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setFocusPainted(false);
		
		btnVoltar.addActionListener(e ->{
			setVisible(false);
		});
		
		pnlFundo.add(new JScrollPane(txaResultados));
		pnlFundo.add(btnVoltar);
//		pnlFundo.add(btnExportar);
		add(pnlFundo);
		
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setVisible(false);
	}
	public void atualizar(String resultados)
	{
		txaResultados.setText(resultados);
	}
	
}
