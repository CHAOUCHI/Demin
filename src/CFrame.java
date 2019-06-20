import java.util.*;
import fr.chaouchim.define.*;

public class CFrame {
	
	private CPoint size;
	private Integer rateMine;
	private CBlock[][] matrice;
	private Scanner sc;
	
	public CFrame() {
		sc = new Scanner(System.in);
		Init();
	}
	
	private boolean Init() {
		DefSize();		//Definition de la taille de la matrice par l'utilisateur
		DefRateMine();	//Definition du taux de présence des mines par l'utilisateur
		setMatrice();
		
		return false;
	}
	public boolean DefSize() {
		CPoint point = new CPoint();
		do {
			if(point == null) 
				Define.print("\nVeuillez saisir un entier");
			point = CAppli.AskPos("Saisissez le nombres de Colonne(s) voulu:","Saisissez le nombre de Ligne(s) voulu:",sc);
		}while(point == null);
		this.setSize(point);
		
		return false;
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

		return false;
	}
	
	public boolean Draw(boolean hide) {			//Draw the frame hidden or not
		Define.print("");
		/*Affichage de la marge en x---------------*/
		Define.print(" ",true);
		Define.print(" ",true);
		Define.print(" ",true);
		for (int i = 0; i < this.getSize().x; i++) {
			if(i<10)
				Define.print(" "+i+" ",true);
			else
				Define.print(" "+i,true);
		}
		Define.print("");

		for (int i = 0; i < this.getSize().y; i++) {		
			/*Affichage de la marge en y---------------*/
			if(i<10)
				Define.print(" "+i+"|",true);
			else
				Define.print(i+"|",true);
			
			for (int j = 0; j < this.getSize().x; j++) {
				if(matrice[i][j].getHidden() && hide) {
					Define.print(" . ",true);	//Affichage  case cacher
				}
				else {
					if(matrice[i][j].getValue() == -1)
						Define.print(" X ",true);	//Affichage mine
					else
						Define.print(" "+matrice[i][j].getValue()+" ",true);	//Affichage  autre
				}
			}
			Define.print("");
		}
		Define.print("");

		
		return false;
	}
	
	public boolean Draw() {		//Draw the frame hidden
		return 	Draw(true);
	}

	public boolean Reveal() {
		return 	Draw(false);
	}
	
	public CBlock[][] CheckAround(CPoint pt){
		for (int k = pt.y-1; k <= pt.y+1; k++) {	//lignes de n-1 à n+1
			for (int l = pt.x-1; l <= pt.x+1; l++) {	//colonne de n-1 à n+1
				
				if(k>=0 && l >=0 && k <this.getSize().y && l<this.getSize().x && matrice[k][l].getValue() >=0)
					matrice[k][l].setValue(matrice[k][l].getValue()+1);
			}
		}
		
		return matrice;
		
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
		this.matrice = new CBlock[this.getSize().y][this.getSize().x];		//Definition taille de la matrice
		
		for (int i = 0; i < this.getSize().y; i++) {	//ligne
			
			for (int j = 0; j < this.getSize().x; j++) {	//colonnes
				matrice[i][j] = new CBlock(i,j);			//Itération des objetsCBlock dans la matrice
				
				/*GESTION RANDOM DES MINES-------------*/
				int rand = (int)(Math.random() *100);
				if(rand <=this.getRateMine()) {
					matrice[i][j].setValue(-1);
				}
				else {
					matrice[i][j].setValue(0);		
				}
			}
		}
		
		/*CheckAround-------------------------*/
		for (int i = 0; i < this.getSize().y; i++) {	//lignes
			for (int j = 0; j < this.getSize().x; j++) {	//colonnes
				
				if(matrice[i][j].getValue() == -1) {	//si Mine
					for (int k = i-1; k <= i+1; k++) {	//lignes de n-1 à n+1
						for (int l = j-1; l <= j+1; l++) {	//colonne de n-1 à n+1
							
							if(k>=0 && l >=0 && k <this.getSize().y && l<this.getSize().x && matrice[k][l].getValue() >=0)
								matrice[k][l].setValue(matrice[k][l].getValue()+1);
						}
					}
				}
				
			}
		}
	}

	
	public Integer getRateMine() {
		return rateMine;
	}
	
	public void setRateMine(Integer rateMine) {
		this.rateMine = rateMine;
	}
	//----------------------------------------------------------------------------------------//


	
}
