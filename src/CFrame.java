import java.util.*;
import fr.chaouchim.define.*;

public class CFrame {
	
	private CPoint size;
	private Integer rateMine;
	private CBlock matrice[][];
	private Scanner sc;
	
	public CFrame() {
		setSize(new CPoint());
		setMatrice();
		sc = new Scanner(System.in);
		
	}
	
	public boolean DefSize() {
		CPoint point = new CPoint();
		do {
			if(point == null) 
				Define.print("\nVeuillez saisir un entier");
			point = CAppli.AskPos("Saisissez le nombres de Colonne(s) voulu:","Saisissez le nombre de Ligne(s) voulu:",sc);
		}while(point == null);
		this.setSize(point);
		
		return true;
	}
	
	public boolean DefRateMine() {
		Define.print("Saissisez le pourcentage de mines présente:");
		Integer intbuf;
		do {
			intbuf = CAppli.AskInt(sc);
			if(intbuf == null)
				Define.print("Veuillez saisir un entier:");
		} while (intbuf == null);
		this.setRateMine(intbuf);

		return true;
	}
	
	//--------------------GETTER AND SETTER--------------------------------------------------//
	public CPoint getSize() {
		return size;
	}
	
	public void setSize(CPoint size) {
		this.size = size;
	}
	public void setSize(Integer x,Integer y) {
		CPoint point = new CPoint();
		point.x = x;
		point.y = y;
		this.setSize(point);
	}

	
	public CBlock[][] getMatrice() {
		return matrice;
	}
	
	public void setMatrice() {
		
	}

	
	public Integer getRateMine() {
		return rateMine;
	}
	
	public void setRateMine(Integer rateMine) {
		this.rateMine = rateMine;
	}
	//----------------------------------------------------------------------------------------//

	
}
