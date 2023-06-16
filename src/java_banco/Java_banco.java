/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_banco;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose-
 */
public class Java_banco {
private static String cedula,nombre,cuenta; //privadas el nombre del animal , dueño , raza , ced

private static double monto,montoen; // precio    
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op=0;
		do
		{
                        String menu[]={"1.Ingresar Cliente","2.Consultar Clientes","3.Buscar de Cliente","4.Modificar Clientes","5.Eliminar Clientes","6.Salir"};
		        String cad="";
                        cad=JOptionPane.showInputDialog(null,menu,"Menu Principal",JOptionPane.QUESTION_MESSAGE);
		        op=Integer.parseInt(cad);
		
			switch(op)
			{
				case 1:
					Escribir();
					break;
				case 2:
					Mostrar();
					break;
				case 3:
					cad=JOptionPane.showInputDialog(null,"Ingrese numero de cedula (cedula): ");
					Buscar(cad);
					break;
				case 4:
					cad=JOptionPane.showInputDialog(null,"Ingrese numero de cedula (cedula): ");
					Modificar(cad);
					break;
				case 5:
					cad=JOptionPane.showInputDialog(null,"Ingrese numero de cedula (cedula): ");
					Eliminar(cad);
			}
		}
		while(op!=6);
    }
    public static void Escribir()
	{
		cedula=JOptionPane.showInputDialog(null,"Cèdula: ");
                nombre=JOptionPane.showInputDialog(null,"Nombre del cliente: ");
                cuenta=JOptionPane.showInputDialog(null,"Tipo de cuenta: ");
		monto=Integer.parseInt(JOptionPane.showInputDialog(null,"Monto de deposito: "));
		montoen= montoen+monto;
                JOptionPane.showMessageDialog(null,"Saludos "+nombre+"\nNumero de cedula: "+cedula+"\nEl monto en su cuenta es de: "+montoen);        
		
                
                
                //aqui el calculos
                
                
                
                
		try
		{                  
			DataOutputStream odo=new DataOutputStream(new FileOutputStream("banco.dat",true));
			odo.writeUTF(cedula);
			odo.writeUTF(nombre);
			odo.writeUTF(cuenta);
			odo.writeDouble(monto);
			odo.writeDouble(montoen);
			odo.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo....");
		}
	}
public  static void Mostrar()
	{
		try
		{
			DataInputStream odi=new DataInputStream(new FileInputStream("banco.dat"));
			try
			{
				while(true)
				{
					cedula=odi.readUTF();
					nombre=odi.readUTF();
					cuenta=odi.readUTF();
					monto=odi.readDouble();
					montoen=odi.readDouble();
					JOptionPane.showMessageDialog(null,"Nuemero de documento:"+cedula+"\nNombre:"+nombre+"\nCuenta:"+cuenta+""
                                                + "\nMonto en cuenta:"+montoen);
				}
			}
			catch(EOFException e)
			{
				odi.close(); 
                                JOptionPane.showMessageDialog(null,"No se Encontro Datos.......");
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No se Encontro el Archivo.......");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo.....");
		}
	}
	
	public  static  void Buscar(String cad)
	{
		boolean nexis=true; //cad 3 // verifica 
		try
		{
			DataInputStream odi=new DataInputStream(new FileInputStream("banco.dat"));
			try
			{
				while(true)
				{
					cedula=odi.readUTF();
					nombre=odi.readUTF();
					cuenta=odi.readUTF();
					monto=odi.readDouble();
					montoen=odi.readDouble();
					if(cedula.equals(cad))
					{
						JOptionPane.showMessageDialog(null,"Nuemero de documento:"+cedula+"\nNombre:"+nombre+"\nCuenta:"+cuenta+""
                                                + "\nMonto en cuenta:"+montoen);
						nexis=false;
					}
				}
			}
			catch(EOFException e)
			{
				odi.close();
				if(nexis)
					JOptionPane.showMessageDialog(null,"No se encontro el cliente....");
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No se Encontro el Archivo......");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo......");
		}
	}
	
	public  static void Modificar(String cad)//123
	{

                String lectura="";
                int opc=0;
                String menu[]={"1.Clave","2.Nombre de la Mascota","3.Raza","4.Nombre del Dueño","5.Costo","6.Regresar"};
		lectura=JOptionPane.showInputDialog(null,menu,"Modificar",JOptionPane.QUESTION_MESSAGE);
                opc=Integer.parseInt(lectura);
		try
		{
			DataInputStream odi=new DataInputStream(new FileInputStream("banco.dat"));
			DataOutputStream odo=new DataOutputStream(new FileOutputStream("Auxiliar.dat"));
			try
			{
				while(true)
				{
					cedula=odi.readUTF();
					nombre=odi.readUTF();
					cuenta=odi.readUTF();
					monto=odi.readDouble();
					montoen=odi.readDouble();
					if(cedula.equals(cad))
					{
							switch(opc)
							{
								case 1:
									cedula=JOptionPane.showInputDialog(null,"Nuevo de cedula: ");
                                                                        //aqui calculos
									break;
								case 2:
                                                                    
									nombre=JOptionPane.showInputDialog(null,"Nombre del cliente: ");
                                                                        //aqui calculos
									break;
								case 3:
									cuenta=JOptionPane.showInputDialog(null,"Tipo de cuenta: ");
                                                                        //aqui calculos
									break;
								
                                                                        
							}
					}
					odo.writeUTF(cedula);
			                odo.writeUTF(nombre);
			                odo.writeUTF(cuenta);
				}
			}
			catch(EOFException e)
			{
				odo.close();
				odi.close();
				Intercambio();
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No se Encontro el Archivo......");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo......");
		}
	}
	
	public  static void Eliminar(String cad)
	{
		try
		{
			DataInputStream odi=new DataInputStream(new FileInputStream("banco.dat"));
			DataOutputStream odo=new DataOutputStream(new FileOutputStream("Auxiliar.dat"));
			try
			{
				while(true)
				{
					cedula=odi.readUTF();
					nombre=odi.readUTF();
					cuenta=odi.readUTF();
					
					if(!cedula.equals(cad))
					{
						odo.writeUTF(cedula);
			                        odo.writeUTF(nombre);
			                        odo.writeUTF(cuenta);
			                        odo.writeDouble(monto);
			                        odo.writeDouble(montoen);
					}
				}
			}
			catch(EOFException e)
			{
				odo.close();
				odi.close();
				Intercambio();
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No se Encontro el Archivo......");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo......");
		}
	}
	
	private  static  void Intercambio()
	{
		try
		{
			DataInputStream odi=new DataInputStream(new FileInputStream("banco.dat"));
			DataOutputStream odo=new DataOutputStream(new FileOutputStream("banco.dat"));
			try
			{
				while(true)
				{
					cedula=odi.readUTF();
					nombre=odi.readUTF();
					cuenta=odi.readUTF();
					monto=odi.readDouble();
					montoen=odi.readDouble();
					odo.writeUTF(cedula);
			                        odo.writeUTF(nombre);
			                        odo.writeUTF(cuenta);
			                        odo.writeDouble(monto);
			                        odo.writeDouble(montoen);
				}
			}
			catch(EOFException e)
			{
				odo.close();
				odi.close();
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No se Encontro el Archivo......");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error en el Dispositivo......");
		}
	}


}
