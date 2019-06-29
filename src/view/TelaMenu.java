package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel jogar = new JLabel(new ImageIcon("imagens/jogar.png"));
	private JLabel multiplayer = new JLabel(new ImageIcon("imagens/multiplayer.png"));
	private JLabel opcoesJogo = new JLabel(new ImageIcon("imagens/opcoesJogo.png"));
	private JLabel creditosLabel = new JLabel(new ImageIcon("imagens/credits.png"));
	private JLabel nomeJLabel = new JLabel("Digite seu Nome:");
	private JLabel InformacaoNomeJLabel = new JLabel();
	private JLabel scoreLabel = new JLabel(new ImageIcon("imagens/score.png"));
	private JLabel menuImagem = new JLabel(new ImageIcon("imagens/imagemDeFundo.png"));
	private Font fonteFont = new Font("Serif", Font.BOLD|Font.BOLD, 20);
	private JTextField nomeField = new JTextField(20);
	
	private JLabel voltarLabel = new JLabel(new ImageIcon("imagens/voltar.png"));
	private JLabel divisaoLabel = new JLabel(new ImageIcon("imagens/divisao.png"));
	private JLabel multiplicacaoLabel = new JLabel(new ImageIcon("imagens/multiplicacao.png"));
	private JLabel somaLabel = new JLabel(new ImageIcon("imagens/soma.png"));
	private JLabel subtracaoLabel = new JLabel(new ImageIcon("imagens/subtracao.png"));
	private JLabel todasLabel = new JLabel(new ImageIcon("imagens/todos.png"));
	
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
	
	
}
