import java.awt.*;
import java.awt.event.*;
import java.swing.*;
import java.io.*;



public class Ventana extends JFrame{

	private JPanel panelC, panelMiembro;
	private JLabel lNombre, lTipoMembresia;
	private JButton bGuardar, bCargar, bCargar;
	private JFileChooser filechooser;
	private JTextField tNombre, tTipoMembresia;
	private Membresia membresia;



	public Ventana(){
		membresia = new Membresia[100];
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		SetTitle("GYM MEMBERS");
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		setLayout(new GridLayout(1,2));
		panelC= new JPanel();
		panelC.setLayout(new GridLayout(8,1));
		lNombre= new JLabel("Ingresa nombre del miembro");
		tNombre= new JTextField();
		lTipoMembresia= new JLabel("Tipo de Membresía");
		tTipoMembresia= new JTextField();
		lPosicion= new JLabel("Tipo de Membresía");
		tPosicion= new JTextField();
		bGuardar= new JButton("Guardar");
		bCargar= new JButton("Cargar");
		bSalvar= new JButton("Salvar");
		bSave.addActionListener(new BotonListener());
		panelC.add(lNombre);
		panelC.add(tNombre);
		panelC.add(lTipoMembresia);
		panelC.add(tTipoMembresia);
		panelC.add(bGuardar);
		panelC.add(bCargar);
		panelC.add(bSalvar);


		

		if(tTipoMembresia==0){
        panelMiembro.setMiembro(membresia+ tNombre);
    }
	

		

		public void imprimeMembresia(){
		String membresiaString= "<html";
		for(int i=0; i<membresia.getMiembro().length;i++){
			try{
				membresiaString= membresiaString+i+"-"+miembro.getContactos()[i].getNombre()+
			}catch(NullPointerException e){
				membresiaString= membresiaString+i+".-Vacío <br/>";
			}
		}
		membresiaString=membresiaString+"</html>";	
		lMembresia.setText(membresiaString);		

		}	
	}

		panelMiembros= new JPanel();
		
	}