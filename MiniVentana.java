import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Ventana extends JFrame{

	private JButton bSave,bSaveFile,bLoad;
	private JPanel panelPrincipal;
	private ListaMiembro listaMiembro;
	private JLabel lListaMiembro;
	private JTextField tNombre,tDireccion,tTelefono,tPos;

	public Ventana(){
		listaMiembro = new ListaMiembro();
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Membresias");
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		panelPrincipal= new JPanel();
		bSave= new JButton("Guardar");
		bSave.addActionListener(new BotonListener());
		panelPrincipal.add(bSave);
		bSaveFile= new JButton("Guardar archivo");
		bSaveFile.addActionListener(new BotonSaveFileListener());
		panelPrincipal.add(bSaveFile);
		bLoad= new JButton("Cargar archivo");
		bLoad.addActionListener(new BotonLoadListener());
		panelPrincipal.add(bLoad);

		lListaMembresia= new JLabel();
		panelPrincipal.add(lListaMembresia);
		add(panelPrincipal);
	}

	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String nombre= tNombre.getText();
			String direccion= tDireccion.getText();
			String telefono= tTelefono.getText();
			Miembro m= new Miembro(nombre,direccion);
			int pos= Integer.parseInt(tPos.getText());
			listaMiembro.addContacto(m,pos);
			imprimeListaMiembro();
		}
	}

	public class BotonSaveFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				JOptionPane pane= new JOptionPane();
				String fileName=pane.showInputDialog("¿Cuál es el nombre del archivo?");
				FileOutputStream fout = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(listaMiembro);
				oos.close();				
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}catch(IOException ex){
				ex.printStackTrace();
			}


		}
	}

	public class BotonLoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fileChooser= new JFileChooser();
			fileChooser.showOpenDialog(null);
			try{
				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fin = new FileInputStream(selectedFile);
				ObjectInputStream ois = new ObjectInputStream(fin);
				listaMiembro= (listaMiembro)ois.readObject();
				imprimeListaMembresia();
			}catch(FileNotFoundException ex){
				System.out.println("Aun no hay archivo");
			}catch(IOException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}			
		}
	}

	public void imprimeListaMiembro(){
		String listaMiembroString="<html>";
		for(int i=0;i<listaMiembro.getMiembro().length;i++){
			try{
				listaMiembroString= lisaMiembroString+i+".- "+listaMiembro.getMiembro()[i].getNombreUsuario()+" "+listaMiembro.getMiembro()[i].getNombreUsuario()+"<br/>";
			}catch(NullPointerException e){
				listaMiembroString=listaMiembroString+i+".- Vacío <br/>";
			}
		}
		listaMiembroString=listaMiembroString+"</html>";
		lListaMiembro.setText(listaMiembroString);
	}

}
