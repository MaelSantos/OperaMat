package App;

import view.Resultado;
import view.TelaMenu;
import controle.ControleTelaMenu;

public class App {
	public static void main(String[] args) {
		
		TelaMenu menu = new TelaMenu();
		Resultado resultado = new Resultado(menu);
		new ControleTelaMenu(menu, resultado, "OperaMat");
	}
}
