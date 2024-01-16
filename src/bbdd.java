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

	
	private static void insert(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Insert hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
	
	private static void update(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Update hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Update " + e);
		}
	}
	
	private static void delete(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Delete hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Delete " + e);
		}
	}
	
	private static String[] select(Connection con, String sql, String[] listaElementosSeleccionados) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);


			if (rs.isBeforeFirst()) {
				String[] arrayS = new String[listaElementosSeleccionados.length];
				while (rs.next()) {
					for (int i = 0; i < listaElementosSeleccionados.length; i++) {
						arrayS[i] = rs.getString(listaElementosSeleccionados[i]);
					}
				}
				return arrayS;
			} else {
				System.out.println("No se ha encontrado nada");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new String[0];
		}
		
		System.out.println("Unexpected error");
		return new String[0];
	}
	
	private static void print(Connection con, String sql, String[] listaElementosSeleccionados) {
		try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				if (rs.isBeforeFirst()) {
					while (rs.next()) {
						for (int i = 0; i < listaElementosSeleccionados.length; i++) {
							System.out.println(listaElementosSeleccionados[i] + 
									": " + rs.getString(listaElementosSeleccionados[i]));
						}
					}
				} else {
					System.out.println("No se ha encontrado nada");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/*
	private static void selectPersona(Connection con, String sql) {
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
