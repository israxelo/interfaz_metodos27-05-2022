package application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


public class Conexion_y_metodos extends Main{
	Conexion_y_metodos(){
		conectar();
	}
	private static String bd = "XE";
	private static String login="PROYECTO";
	private static String password="proyecto";
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	static Connection conexion =null;
	static Statement st =null;
	static ResultSet rs =null;
	static CallableStatement cs =null;
	static String email = null;
	static String contra = null;

	public static void conectar() {
		System.out.println("------------------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion =DriverManager.getConnection(url,login,password);
			if(conexion !=null) {
				System.out.println("conexion realizada correctamente");
				System.out.println("------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String ver_todo(int num) {
		String cadena ="";
		try {
			st = conexion.createStatement();
			switch (num) {
			case 0:
				rs = st.executeQuery("select * from videojuego");
				break;
			case 1:
				rs = st.executeQuery("select * from videojuego where categoria = 'Acción'");
				break;
			case 2:
				rs = st.executeQuery("select * from videojuego where categoria = 'Aventura'");
				break;
			case 3:
				rs = st.executeQuery("select * from videojuego where categoria = 'Carrera'");
				break;
			case 4:
				rs = st.executeQuery("select * from videojuego where categoria = 'Deporte'");
				break;
			case 5:
				rs = st.executeQuery("select * from videojuego where categoria = 'Rol'");
				break;
			case 6:
				rs = st.executeQuery("select * from videojuego where categoria = 'Terror'");
				break;
			}
			while(rs.next()) {
				cadena +=(rs.getString("COD_VIDEOJUEGO") + "---" + rs.getString("TITULO") +"--" + rs.getString("CATEGORIA") + "--" + rs.getDouble("PRECIO") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadena;

	}
	public static void Registro(String email2,String contra2) throws SQLException {
		st = conexion.createStatement();
		st.executeUpdate("insert into CLIENTES values ('"+email2+"','" + contra2+"')");
		st.executeUpdate("commit");
		email = email2;
		contra = contra2;
	}
	public static int Iniciar_Sesion(String email2,String contra2) {
		int aux = -1;
		try {
			cs = conexion.prepareCall("{ ? = call REGISTRO(?,?)}");
			cs.setString(2, email2);
			cs.setString(3,contra2);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			aux = cs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(aux==-1) {
			return -1;
		}
		email = email2;
		contra = contra2;
		return 1;
	}
	public static void ConsolasInsertar(String modelo,String descripcion,String direccion) throws SQLException {
		st = conexion.createStatement();
		st.executeUpdate("insert into CONSOLAS_ROTAS values ('"+modelo+"','" + descripcion+"', ' "+direccion+"','"+email+"')");
		st.executeUpdate("commit");
	}
	public static String VerPedidos() {
		String cadena = null;
		try {
			cs = conexion.prepareCall("{ ? = call VER_REPARACIONES(?)}");
			cs.setString(2, email);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			cadena = cs.getNString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadena;
	}
	public static boolean HacerPedidos(String cod,String tipo,int dias) {
		int aux = 0;
		try {
			cs = conexion.prepareCall("{ ? = call HACER_PEDIDO(?,?,?,?)}");
			cs.setString(2,cod);
			cs.setString(3,tipo);
			cs.setString(4,email);
			cs.setInt(5, dias);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			aux = cs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(aux == 1) {return true;}
		else
			return false;
	}
	public static String ListaPedidos() {
		String cadena ="";
		try {
			st = conexion.createStatement();
			rs = st.executeQuery("select * from PEDIDOS where EMAIL ='" +email+"'");
			while(rs.next()) {
				cadena +=(rs.getString("TIPO") + "---" + rs.getString("TITULO") +"--" + rs.getString("EMAIL") + "--" + rs.getDouble("PRECIO") +"--"+rs.getDate("FECHA") +"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadena;
	}



}