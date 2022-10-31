import java.sql.*;

public class Main {
    //private final static Logger LOGGER = Logger.getLogger(Main.class);

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " TIPO varchar(100) NOT NULL "
            + " )";

    private static final String SQL_INSERT =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1, 'Pancho', 'Perro')";
    private static final String SQL_INSERT2 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (2, 'Pillo', 'Gato')";
    private static final String SQL_INSERT3 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (3, 'Cepillo', 'Elefante')";
    private static final String SQL_INSERT4 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (4, 'Pepe', 'Perro')";
    private static final String SQL_INSERT5 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (5, 'Rolo', 'Caballo')";

    private static final String SQL_DELETE =  "DELETE FROM ANIMALES WHERE ID=2";






    public static void main(String[] args) throws SQLException {

        Connection connection= null;
        connection= getConnection();



        try {
            Statement statementCreate= connection.createStatement();
            statementCreate.execute(SQL_CREATE_TABLE);

            Statement statementInsert1= connection.createStatement();
            statementInsert1.execute(SQL_INSERT);

            Statement statementInsert2= connection.createStatement();
            statementInsert2.execute(SQL_INSERT2);

            Statement statementInsert3= connection.createStatement();
            statementInsert3.execute(SQL_INSERT3);

            Statement statementInsert4= connection.createStatement();
            statementInsert4.execute(SQL_INSERT4);

            Statement statementInsert5= connection.createStatement();
            statementInsert5.execute(SQL_INSERT5);

            verListadoAnimales(connection);


        }catch (Exception exception){
            System.out.println("Error!!");

        }finally {
            System.out.println("Finally");
            connection.close();
        }

    }
    public static Connection getConnection(){
        DriverManager driverManager= null;
        Connection connection= null;

        try{
            Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
            connection= driverManager.getConnection("jdbc:h2:~/h2-database", "root","");
        }catch (Exception exception){
            System.out.println("ERROR");

        }
        return connection;

    }

    private  static void verListadoAnimales(Connection connection) throws SQLException {
        String selectAnimales= "SELECT * FROM ANIMALES";
        System.out.println("Ejecutando SELECT de Animales");
        Statement statementSelect= getConnection().createStatement();
        ResultSet rs= statementSelect.executeQuery(selectAnimales);

        while (rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }
    }

}