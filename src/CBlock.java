
public class CBlock {
	
	private CPoint pos;
	private Boolean hidden;
	private Integer value;
	private char skin;
	public CBlock(Integer x,Integer y) {
		this.setHidden(true);
		this.setValue(0);
		this.setPos(new CPoint(x,y));
	}

	
	
	
	
	/*----------------------GETTER AND SETTER---------------------*/
	public CPoint getPos() {
		return pos;
	}

	public void setPos(CPoint pos) {
		this.pos = pos;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	/*------------------------------------------------------------*/





	public char getSkin() {
		return skin;
	}





	public void setSkin(char skin) {
		this.skin = skin;
	}
}
