
package gestionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AsistenteBD {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String driver = "org.sqlite.JDBC";
    String nombreBD = "empresa.sqlite";
    String url = "jdbc:sqlite:"+nombreBD;
    
    public void crearBD(){
      try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Base de datos creada con exito!");
    
    }
    
    public void crearTabla(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = "CREATE TABLE CLIENTE "+
                "(ID INT PRIMARY KEY NOT NULL,"+
                "NOMBRE TEXT NOT NULL,"+
                "APELLIDO TEXT NOT NULL,"+
                "EDAD INT NOT NULL)";
        sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Tabla creada con exito!");
    
    
    }
    public void insertarTabla(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = "INSERT INTO CLIENTE "+
                "(ID,"+
                "NOMBRE,"+
                "APELLIDO,"+
                "EDAD) VALUES (2,'diego','parada',21)";
        sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Insertado con exito!");
    
    
    }
    public void insertarTabla2(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        Scanner sn = new Scanner(System.in);
            System.out.println("Ingrese ID");
            int id = sn.nextInt();
            sn.nextLine();
            System.out.println("Ingrese NOMBRE");
            String nom = sn.nextLine();
            System.out.println("Ingrese APELLIDO");
            String ape = sn.nextLine();
            System.out.println("Ingrese EDAD");
            int edad = sn.nextInt();
        String sql = "INSERT INTO CLIENTE "+
                "(ID,"+
                "NOMBRE,"+
                "APELLIDO,"+
                "EDAD) VALUES ("+id+",'"+nom+"','"+ape+"',"+edad+")";
        sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Insertado con exito!");
    }
    
    public void actualizarBD(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        Scanner sn = new Scanner(System.in);
        
            System.out.println("********* MENU ACTUALIZAR **********"+
                    "\n 1. Actualizar ID"+
                    "\n 2. Actualizar NOMBRE"+
                    "\n 3. Actualizar APELLIDO"+
                    "\n 4. Actualizar EDAD");
            System.out.println("Ingrese una opcion");
            int opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese ID del usuario a modificar");
                    int id1 = sn.nextInt();
                    System.out.println("Ingrese ID");
                    int id = sn.nextInt();
                    
                    String sql = "UPDATE CLIENTE SET ID="+id+" WHERE ID="+id1;
                
                sentencia.executeUpdate(sql);
                sentencia.close();
                conexion.close();
                    
                    break;
                case 2:
                    
                    System.out.println("Ingrese ID del usuario a modificar");
                    int id2 = sn.nextInt();
                    System.out.println("Ingrese NOMBRE");
                    sn.nextLine();
                    String nom = sn.nextLine();
                    String sql2 = "UPDATE CLIENTE SET NOMBRE='"+nom+"' WHERE ID="+id2;
                
                sentencia.executeUpdate(sql2);
                sentencia.close();
                conexion.close();
                    break;
                case 3:
                    System.out.println("Ingrese ID del usuario a modificar");
                    int id3 = sn.nextInt();
                    System.out.println("Ingrese APELLIDO");
                    sn.nextLine();
                    String ape = sn.nextLine();
                    String sql3 = "UPDATE CLIENTE SET APELLIDO='"+ape+"' WHERE ID="+id3;
                
                sentencia.executeUpdate(sql3);
                sentencia.close();
                conexion.close();
                    break;
                case 4:
                    System.out.println("Ingrese ID del usuario a modificar");
                    int id4 = sn.nextInt();
                    System.out.println("Ingrese EDAD");
                    int edad = sn.nextInt();
                    String sql4 = "UPDATE CLIENTE SET EDAD="+edad+" WHERE ID="+id4;
                
                sentencia.executeUpdate(sql4);
                sentencia.close();
                conexion.close();
                    break;
                
            }
            System.out.println("-------------------------------------");
            
        
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Actualizado con exito!");
    }
    
    public void mostrarDatos(){
        
         try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = "SELECT * FROM CLIENTE";
        resultados = sentencia.executeQuery(sql);
        while(resultados.next()){
            int id = resultados.getInt("ID");
            String nombre = resultados.getString("NOMBRE");
            String apellido = resultados.getString("APELLIDO");
            int edad = resultados.getInt("EDAD");
            
            System.out.println("\nID: "+id+
                    "\nNOMBRE: "+nombre+
                    "\nAPELLIDO: "+apellido+
                    "\nEDAD: "+edad);
        }
        resultados.close();
        sentencia.close();
        conexion.close();
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
       
    }
    public void eliminar(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese ID del usuario a eliminar");
                    int id = sn.nextInt();
        String sql = "DELETE FROM CLIENTE WHERE ID="+id;
        sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
      }catch(ClassNotFoundException | SQLException e){
          System.out.println("Error: "+e.getMessage());
      }
        System.out.println("Eliminado con exito!");
    
    
    }
    
}
