package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Resultado extends JPanel {

	private static final long serialVersionUID = -3792969622223059913L;
	
	private JPanel pnlFundo;
	private ImageIcon fundo, voltar, exportar;
	private JTextArea txaResultados;
	private JButton btnVoltar, btnExportar;
	
	public Resultado(JFrame frame) {
//		super(frame, "Resultados", true);
		
		fundo = new ImageIcon(getClass().getClassLoader().getResource("backgroundAbertura.png"));
		voltar = new ImageIcon(getClass().getClassLoader().getResource("voltar.png"));
		exportar = new ImageIcon(getClass().getClassLoader().getResource("exportar.png"));
//		fundo = new ImageIcon(getClass().getClassLoader().getResource("OperaMat.png"));
		
		pnlFundo = new JPanel();
		
		pnlFundo.setSize(300, 400);
		pnlFundo.setBounds(0, 0, 300, 400);
		
		txaResultados = new JTextArea(19, 19);
		txaResultados.setEditable(false);
		
		btnVoltar = new JButton(voltar);
		btnExportar = new JButton(exportar);
		
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setFocusPainted(false);
		
		btnExportar.setContentAreaFilled(false);
		btnExportar.setBorderPainted(false);
		btnExportar.setFocusPainted(false);
		
		pnlFundo.add(new JScrollPane(txaResultados));
		pnlFundo.add(btnVoltar);
		pnlFundo.add(btnExportar);
		add(pnlFundo);
		
		pnlFundo.setBackground(new Color(255,255,255,0));
		
		setBounds(300, 40, 500, 400);
		setLayout(null);
		setBackground(new Color(255,255,255,0));
		setVisible(false);
	}
	public void atualizar(String resultados)
	{
		txaResultados.setText(resultados);
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	
}
