package App;

import view.TelaMenu;
import controle.ControleTelaMenu;

public class App {
	public static void main(String[] args) {
		new ControleTelaMenu(new TelaMenu(), "Opera Mat 2D");
	}
}
