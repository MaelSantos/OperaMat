package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel jogar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("jogar.png")));
	private JLabel multiplayer = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("multiplayer.png")));
	private JLabel opcoesJogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("opcoesJogo.png")));
	private JLabel creditosLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("credits.png")));
	private JLabel sairLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("sair.png")));
	private JLabel nomeJLabel = new JLabel("Digite seu Nome:");
	private JLabel InformacaoNomeJLabel = new JLabel();
	private JLabel scoreLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("score.png")));
	private JLabel menuImagem = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("backgroundAbertura.png")));
	private Font fonteFont = new Font("Arial", Font.BOLD|Font.BOLD, 20);
	private JTextField nomeField = new JTextField(10);
	
	private JLabel voltarLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("voltar.png")));
	private JLabel divisaoLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("divisaoH.png")));
	private JLabel multiplicacaoLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("multiplicacaoH.png")));
	private JLabel somaLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("soma.png")));
	private JLabel subtracaoLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("subtracaoH.png")));
	private JLabel todasLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("todosH.png")));
	
	public TelaMenu(){}

	public JLabel getNomeJLabel() {	
		return nomeJLabel;
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public JLabel getMenuImagem() {
		return menuImagem;
	}
	public Font getFonteFont() {
		return fonteFont;
	}
	public JLabel getOpcoesJogoLabel() {
		return opcoesJogo;
	}
	public JLabel getCreditosLabel() {
		return creditosLabel;
	}
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
	public JLabel getInformacaoNomeJLabel() {
		return InformacaoNomeJLabel;
	}
	public JLabel getDivisaoLabel() {
		return divisaoLabel;
	}
	public JLabel getMultiplicacaoLabel() {
		return multiplicacaoLabel;
	}
	public JLabel getSomaLabel() {
		return somaLabel;
	}
	public JLabel getSubtracaoLabel() {
		return subtracaoLabel;
	}
	public JLabel getTodasLabel() {
		return todasLabel;
	}
	public JLabel getVoltarLabel() {
		return voltarLabel;
	}

	public JLabel getMultiplayer() {
		return multiplayer;
	}

	public JLabel getJogar() {
		return jogar;
	}

	public void setJogar(JLabel jogar) {
		this.jogar = jogar;
	}

	public JLabel getSairLabel() {
		return sairLabel;
	}
	
	
}
