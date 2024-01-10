import java.sql.*;

public class bbdd {
	private static final String USER = "vuestroUsuario";
	private static final String PWD = "vuestraContraseña";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";


	private static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		System.out.println("Conectados a la base de datos");

		return con;
	}

	
	private static void novaCompra(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Compra registrada correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
	
	private static void devolucioCompra(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Compra devuelta correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
	
	/*
	private static void costultarPunts(Connection con, String sql) {
	try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String dni = rs.getString("DNI");
					String nombre = rs.getString("NOMBRE");

					System.out.println(persona.toString());

				}
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void costultarHistorial(Connection con, String sql) {
	try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String dni = rs.getString("DNI");
					String nombre = rs.getString("NOMBRE");


					System.out.println(persona.toString());

				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
