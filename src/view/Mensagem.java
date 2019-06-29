package view;

import javax.swing.JOptionPane;

public class Mensagem {
	
	public static void exibirMensagemFimJogo(String jogador, String resultado, int pontos){
		JOptionPane.showMessageDialog(null, jogador + 
				"\n\n" + resultado + "\n\n" + "NOTA: " +(pontos * 0.5)+ "\n\n");
	}
	
	public static boolean exibirMensagemVoltaMenu(){
		if (JOptionPane.showConfirmDialog(null, "Deseja realmente voltar ao Menu Principal?",
				"Voltar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			return true;
		else return false;
	}
	
	public static void exibirMensagemFimJogoMult(int pontosJog1, int pontosJog2){
		if(pontosJog1 > pontosJog2)
			JOptionPane.showMessageDialog(null, "Jogador 1 Venceu, Parabéns");
		if(pontosJog2>pontosJog1)
			JOptionPane.showMessageDialog(null, "Jogador 2 Venceu, Parabéns");
		if(pontosJog1 == pontosJog2)
			JOptionPane.showMessageDialog(null, "Empate");
	}
}
