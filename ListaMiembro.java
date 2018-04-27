import java.io.Serializable;

public class ListaMiembro implements Serializable{

	private Miembro[] miembros;


	public ListaMiembro(){
		miembros= new Miembro[100];
	}

	public Miembro[] getMiembros(){
		return miembros;
	}

	public void addMiembro(Miembro miembro, int index){
		miembros[index]=miembro;
	}
}
