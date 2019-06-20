import java.util.*;
import fr.chaouchim.define.*;

public class CAppli {
	//Attributes
	private CFrame frame;
	private Scanner sc;
	Integer intbuf;
	
	//Methods
	public CAppli() {	//init
		panneauDAffichage();
		frame =  new CFrame();	//Init rateMine sizeOfMatrice : asked to the user
		sc = new Scanner(System.in);
	}
	
	public void Run() {	//running
		//Define.print("y : "+frame.getMatrice().length);
		//Define.print("x :"+frame.getMatrice()[0].length);
		//frame.getMatrice()[2][2].setValue(2);
		frame.Draw(false);
	}
	
	public static CPoint AskPos(String msgX,String msgY,Scanner sc) {
		CPoint point = new CPoint();
		Define.print(msgX);
		String x = sc.nextLine();	
		
		Define.print(msgY);
		String y = sc.nextLine();	

		try {
			point.x = Integer.parseInt(x);
			point.y = Integer.parseInt(y);
		} catch (Exception e) {
			point = null;
		} 
		
		return point;
	}
	
	/*
	 *returned codes: 
	 *		null : WRONG_INPUT_NOT_INTEGER
	*/
	public static Integer AskInt(Scanner sc) {
		Integer i;
		String str = sc.nextLine();
		try {
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = null;
		}
		return i;
	}
	public void panneauDAffichage() {
		Define.print("***********************************************************************************\n"+
		"**********_________********_________******__ **** _*****___*****___*****_**********\n"+
		"*********|  _____  |******|   _____ |****|  "
		+ "\\"
		+ "   /  |***|___|***|   "
		+ "\\"
		+ "***| |*********\n"+
		"*********| |     |  |*****|  |_____||****| |"
		+ "\\\\"
		+ "_//| |****___****| |"
		+ "\\"
		+ " "
		+ "\\**| |*********\n"+
		"*********| |      | |*****|  _______|****| |*"
		+ "\\"
		+ "_/*| |***|   |***| |*"
		+ "\\"
		+ " "
		+ "\\"
		+ "*| |*********\n"+
		"*********| |      | |*****| |************| |*****| |***|   |***| |**"
		+ "\\"
		+ " "
		+ "\\"
		+ "| |*********\n"+
		"*********| |_____|  |*****| |_______*****| |*****| |***|   |***| |***"
		+ "\\"
		+ "   |*********\n"+
		"*********|_________|*******_________|****|_|*****|_|***|___|***|_|****"
		+ "\\"
		+ "__|*********\n"+
		"***********************************************************************************\n"+
		"***********************************************************************************");

	}
}

