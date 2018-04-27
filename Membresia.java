import java.io.Serializable;

public class Membresia implements Serializable{
	private String nombreUsuario;
	private String tipoMembresia;
	

	public Contacto(String nombreUsuario,String direccion){
		this.nombreUsuario=nombreUsuario;
		this.direccion=direccion;
		this.telefono=telefono;
	}

	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario=nombreUsuario;
	}

	public String getNombreUsuario(){
		return nombreUsuario;
	}

	public void setTipoMembresia(String direccion){
		this.tipoMembresia=tipoMembresia;
	}

	public String getTipoMembresia(){
		return tipoMembresia;
	}

}
