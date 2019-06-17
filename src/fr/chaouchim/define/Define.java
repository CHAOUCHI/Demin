package fr.chaouchim.define;

public class Define {
	//--DEF------------------------------------------------//
	public static void print(String pa,boolean b){
		if(b) {
			System.out.print(pa);
			return ;
		}
		System.out.println(pa);
	}
	
	public static void print(String pa) {
		print(pa,false);
	}
	public static void print(Integer pa) {
		print(pa.toString(),false);
	}
	//----------------------------------------------------//

}
