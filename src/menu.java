import java.sql.Connection;

public class menu {
	public static Connection con;

	public static void main(String[] args) {
		
		//Ejemplo de uso con la tabla ACTOR y las columnas NACTOR NOMBRE FECHAN
		Connection con = bbdd.conectarBaseDatos();
		String[] a = {"NACTOR", "NOMBRE", "FECHAN"};
		bbdd.print(con, "SELECT * FROM ACTOR", a);
		System.out.println("Insert");
		bbdd.insert(con, "INSERT INTO ACTOR (\"NACTOR\", \"NOMBRE\", \"FECHAN\")\n"
				+ "VALUES (2, 'John Doe', TO_DATE('2024-01-18', 'YYYY-MM-DD'))");
		bbdd.print(con, "SELECT * FROM ACTOR", a);
		System.out.println("Update");
		bbdd.update(con, "UPDATE ACTOR\n"
				+ "SET \"NOMBRE\" = 'New Name'\n"
				+ "WHERE \"NACTOR\" = 2 ");
		bbdd.print(con, "SELECT * FROM ACTOR", a);
		System.out.println("Delete");
		bbdd.delete(con, "DELETE FROM ACTOR\n"
				+ "WHERE \"NACTOR\" = 2");
		bbdd.print(con, "SELECT * FROM ACTOR", a);
		System.out.println("Select");
		String[] b = bbdd.select(con, "SELECT * FROM ACTOR", a);
		for (int i = 0; i < a.length; i++) {
			System.out.println("Columna " + a[i] + " resultado " + b[i]);
		}
	}

}
