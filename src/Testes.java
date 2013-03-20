import javax.swing.UIManager;


public class Testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UIManager.LookAndFeelInfo[] lookAndFeelInfo = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < lookAndFeelInfo.length; i++) {
			System.out.println(lookAndFeelInfo[i].getClassName());
		}
		
	}

}
