# Demin
démineur en java projet
class :
	CMenu		//Le lobby, les requetes a l'utilisateur(Row?Col?PositionToCheck?);
		Init()	//Initatilise l'appli et l'objet CFrame et son contenu;
		
		
	
	CFrame		//contient les blocks, la matrice,les methodes d'affichage
		Integer xMax
		Integer yMax
		CBlock matrice[nbRow(x)][nbCol(y)]  //tableau de CBlock a double entrées 
		
		Print()								//Affichage de la matrice dans la console
		AskSizeFrame();	//Demamnde a l'utilisatur la taille de la matrice.
		
				
	CBlock	
		CPoint position 			// coordonnée en x et y dans la matrice
		Boolean hidden				// etat du block  0 : visible || 1 : caché
		Integer value					// -1 : mine || 0 à n : indication
		
		Checkaround():				//verifie les blocks adjacent a block et chache leur etat en fonction
			Switch(block.value){
				case -1:	//mine
					this.hidden = 1;
				break;
				
				case 0:
					this.hidden = 0;
					for(CFrame::matrice[this.position.x][this.position.y] : it){
						it.CheckAround();
					}
				break;
				
				default:
					this.hidden = 0;
				break;
			}
				
	CPoint
		Integer x
		Integer y
		
	j--	  		j	        j++
	
i--	[i--][j--]  [i--][j] [i--][j++]		
i	 [i][j--] 	 [i][j]   [i][j++]	
i++	[i++][j--]  [i++][j] [i++][j++]
	
