package app.data;

public abstract class Media extends Item implements Consultabil {
	
	protected String suport;
	

	@Override
	public void consulta() {
		
		if(this.disponibil = true) {
			this.disponibil = false;
		}

	}

	@Override
	public void elibereaza() {
		
		if(this.disponibil = false) {
			this.disponibil = true;
		}

	}
	

}
