package Datos;


import Entidades.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {

    private final String host = "localhost:3306";//Contiene el host de la BD.
    private final String database = "videoc";//Contiene el nombre de la BD.
    private final String URL = "jdbc:mysql://" + host + "/" + database + "?autoReconnect=true&useSSL=false";//Contiene la dirección de la BD.
    private final String USER = "root";//Contiene el usuario de la BD.
    private final String PASS = "86304122";//Contiene el password de la BD.
    private final String DRIVER = "com.mysql.jdbc.Driver";//Contiene la dirección del Driver de MySQL.
    Connection connection = null;//Inicializa la variable conexión a la BD.
    Statement statement = null;//Inicializa la variable statement de la BD.
    ResultSet resultSet = null;//Inicializa la variable tipo ResultSet.

    /**
     * Abre la Base de Datos.
     */
    public void abrirBD() {

        try {

            Class.forName(DRIVER);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASS);//Crea la conexión a la BD.
            statement = (Statement) connection.createStatement();//Crea el Statement.

        }//Fin de try
        catch (Exception ex) {

            System.err.println(ex);

        }//Fin de catch

    }//Fin de clase abrirBD




/*--------------------------------------------INSERTAR--------------------------------------------------------*/
    public int insertarAlquiler(Alquiler alquiler) {
        ResultSet result;
        int id = -1;

        try {

            //Forma de insertar utilizando el Prepared Statement
            String sql = "INSERT INTO alquiler VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, alquiler.getId());
            preparedStatement.setInt(2, alquiler.getPlazo());
            preparedStatement.setDouble(3, alquiler.getMontoTotal());
            preparedStatement.setDouble(4, alquiler.getMulta());
            preparedStatement.setString(5, alquiler.getFecha());
            preparedStatement.setInt(6, alquiler.getCedula());

            preparedStatement.executeUpdate();

            result = preparedStatement.getGeneratedKeys();

            if (result.first()) {
                id = result.getInt(1);
            }

            preparedStatement.close();

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return id;
    }


    public int insertarClientes(Clientes clientes) {
        int filasModificadas = 0;



        try {

            //Forma de insertar utilizando el Prepared Statement
            String sql = "INSERT INTO clientes VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, clientes.getCedula());
            preparedStatement.setString(2, clientes.getNombre());
            preparedStatement.setString(3, clientes.getApellido());
            preparedStatement.setString(4, clientes.getDireccion());
            preparedStatement.setInt(5, clientes.getTelefono());
            preparedStatement.setString(6, clientes.getCorreo());

            filasModificadas = preparedStatement.executeUpdate();




            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return filasModificadas;
    }


    public int insertarDetalleAlquiler(DetalleAlquiler detalleAlquiler) {
        ResultSet result;
        int id = -1;

        try {

            //Forma de insertar utilizando el Prepared Statement
            String sql = "INSERT INTO detallealquiler VALUES (?,?,?,?)";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, detalleAlquiler.getId());
            preparedStatement.setInt(2, detalleAlquiler.getIdPeli());
            preparedStatement.setInt(3, detalleAlquiler.getCostoAlqui());
            preparedStatement.setInt(4, detalleAlquiler.getCantidad());

            preparedStatement.executeUpdate();

            result = preparedStatement.getGeneratedKeys();

            if (result.first()) {
                id = result.getInt(1);
            }

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println(ex);

        }//Fin de catch

        return id;
    }
    public int insertarUsers(Users users) {
        ResultSet result;
        int id = -1;

        try {

            //Forma de insertar utilizando el Prepared Statement
            String sql = "INSERT INTO users VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getUsername());
            preparedStatement.setString(3, users.getPassword());
            preparedStatement.setString(4, users.getNombre());
            preparedStatement.setString(5, users.getApellido());
            preparedStatement.setString(6, users.getCorreo());

            preparedStatement.executeUpdate();

            result = preparedStatement.getGeneratedKeys();

            if (result.first()) {
                id = result.getInt(1);
            }

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return id;
    }
    public int insertarVideos(Videos videos) {
        ResultSet result;
        int id = -1;

        try {

            //Forma de insertar utilizando el Prepared Statement
            String sql = "INSERT INTO videos VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, videos.getId());
            preparedStatement.setString(2, videos.getTituloPeli());
            preparedStatement.setInt(3, videos.getAnio());
            preparedStatement.setString(4, videos.getGenero());
            preparedStatement.setString(5, videos.getNacionalidad());
            preparedStatement.setInt(6, videos.getCantidad());
            preparedStatement.setString(7, videos.getImagenHD());
            preparedStatement.setString(8, videos.getDescripcion());




            preparedStatement.executeUpdate();

            result = preparedStatement.getGeneratedKeys();

            if (result.first()) {
                id = result.getInt(1);
            }

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.out.println(ex);

        }//Fin de catch

        return id;
    }
/*-----------------------------------Actualizar---------------------------------*/
    public void actualizarAlquiler(Alquiler alquiler) {
        try {

            //Forma de insertar utilizando el Prepared Statement

            String sql = "UPDATE alquiler SET plazo = ?, montoTotal = ?, multa = ?, fecha = ?,cedula = ? WHERE id = ?";
            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);



            preparedStatement.setInt(1, alquiler.getPlazo());
            preparedStatement.setDouble(2, alquiler.getMontoTotal());
            preparedStatement.setDouble(3, alquiler.getMulta());
            preparedStatement.setString(4, alquiler.getFecha());
            preparedStatement.setInt(5, alquiler.getCedula());
            preparedStatement.setInt(6, alquiler.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch
    }

    public void actualizarClientes(Clientes clientes) {
        try {

            //Forma de insertar utilizando el Prepared Statement

            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ? WHERE cedula = ?";
            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            preparedStatement.setString(1, clientes.getNombre());
            preparedStatement.setString(2, clientes.getApellido());
            preparedStatement.setString(3, clientes.getDireccion());
            preparedStatement.setInt(4, clientes.getTelefono());
            preparedStatement.setString(5, clientes.getCorreo());
            preparedStatement.setInt(6, clientes.getCedula());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch
    }
    public void actualizarDetalleAlquiler(DetalleAlquiler detalleAlquiler) {
        try {

            //Forma de insertar utilizando el Prepared Statement

            String sql = "UPDATE detallealquiler SET idPeli = ?, costoAlqui = ?, cantidad = ? WHERE id = ?";
            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            preparedStatement.setInt(1, detalleAlquiler.getIdPeli());
            preparedStatement.setInt(2, detalleAlquiler.getCostoAlqui());
            preparedStatement.setInt(3, detalleAlquiler.getCantidad());
            preparedStatement.setInt(4, detalleAlquiler.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch
    }
    public void actualizarUsers(Users users) {
        try {

            //Forma de insertar utilizando el Prepared Statement

            String sql = "UPDATE users SET username = ?, passw = ?, nombre = ?, apellido = ?, correo = ? WHERE id = ?";
            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getNombre());
            preparedStatement.setString(4, users.getApellido());
            preparedStatement.setString(5, users.getCorreo());
            preparedStatement.setInt(6, users.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch
    }
    public void  actualizarVideos(Videos videos) {
        try {

            //Forma de insertar utilizando el Prepared Statement

            String sql = "UPDATE videos SET  tituloPeli = ?, anio = ?, genero = ?, nacionalidad = ?, cantidad = ?,imagenHD = ? ,descripcion = ? WHERE id = ?";
            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);


            preparedStatement.setString(1, videos.getTituloPeli());
            preparedStatement.setInt(2, videos.getAnio());
            preparedStatement.setString(3, videos.getGenero());
            preparedStatement.setString(4, videos.getNacionalidad());
            preparedStatement.setInt(5, videos.getCantidad());
            preparedStatement.setString(6, videos.getImagenHD());
            preparedStatement.setString(7, videos.getDescripcion());
            preparedStatement.setInt(8, videos.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println(ex);

        }//Fin de catch
    }





/*------------------------------eliminar--------------------------------*/
    public void eliminarClientes(int cedula) {

        try {

            String sql = "DELETE FROM clientes WHERE cedula = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, cedula);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

    }

    public void eliminarUsers(int id) {

        try {

            String sql = "DELETE FROM users WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

    }

    public void eliminarvideos(int id) {

        try {

            String sql = "DELETE FROM videos WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } //Fin de try
        catch (SQLException ex) {

            System.err.println(ex);

        }//Fin de catch

    }




    /*---------------------LOS GET---------------------------------------*/


    public List<Alquiler> getAlquiler() {
        List alquileres = new ArrayList();

        try {

            String sql = "SELECT * FROM alquiler";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Alquiler alquiler = new Alquiler();
                alquiler.setId(resultSet.getInt("id"));
                alquiler.setPlazo(resultSet.getInt("plazo"));
                alquiler.setMontoTotal(resultSet.getDouble("montoTotal"));
                alquiler.setMulta(resultSet.getDouble("multa"));
                alquiler.setFecha(resultSet.getString("fecha"));
                alquiler.setCedula(resultSet.getInt("cedula"));

                alquileres.add(alquiler);

            }

        } //Fin de try //Fin de try //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return alquileres;
    }

    public List<Clientes> getClientes() {
        List Clientes = new ArrayList();

        try {

            String sql = "SELECT * FROM clientes";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Clientes cliente = new Clientes();
                cliente.setCedula(resultSet.getInt("cedula"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                cliente.setCorreo(resultSet.getString("correo"));

                Clientes.add(cliente);

            }

        } //Fin de try //Fin de try //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return Clientes;
    }


    public List<DetalleAlquiler> getDetalleAlquiler() {
        List DetalleAlquiler = new ArrayList();

        try {

            String sql = "SELECT * FROM detallealquiler";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                DetalleAlquiler detalleAlquiler = new DetalleAlquiler();

                detalleAlquiler.setId(resultSet.getInt("id"));
                detalleAlquiler.setIdPeli(resultSet.getInt("idPeli"));
                detalleAlquiler.setCostoAlqui(resultSet.getInt("costoAlqui"));
                detalleAlquiler.setCantidad(resultSet.getInt("cantidad"));

                DetalleAlquiler.add(detalleAlquiler);

            }

        } //Fin de try //Fin de try //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return DetalleAlquiler;
    }

    public List<Users> getUsers() {
        List Users = new ArrayList();

        try {

            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("passw"));
                users.setNombre(resultSet.getString("nombre"));
                users.setApellido(resultSet.getString("apellido"));
                users.setCorreo(resultSet.getString("correo"));

                Users.add(users);

            }

        } //Fin de try //Fin de try //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return Users;
    }

    public List<Videos> getVideos() {
        List Videos = new ArrayList();

        try {

            String sql = "SELECT * FROM  videos";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Videos videos = new Videos();
                videos.setId(resultSet.getInt("id"));
                videos.setTituloPeli(resultSet.getString("tituloPeli"));
                videos.setAnio(resultSet.getInt("anio"));
                videos.setGenero(resultSet.getString("genero"));
                videos.setNacionalidad(resultSet.getString("nacionalidad"));
                videos.setCantidad(resultSet.getInt("cantidad"));
                videos.setImagenHD(resultSet.getString("imagenHD"));
                videos.setDescripcion(resultSet.getString("descripcion"));
                Videos.add(videos);

            }

        } //Fin de try //Fin de try //Fin de try //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return Videos;
    }





    /*--------------------parte2 los get-------------------------*/




        public  Alquiler getAlquiler(int id) {
        Alquiler alquiler = null;
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM alquiler WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {

                alquiler = new Alquiler();
                alquiler.setId(resultSet.getInt("id"));
                alquiler.setPlazo(resultSet.getInt("plazo"));
                alquiler.setMontoTotal(resultSet.getDouble("montoTotal"));
                alquiler.setMulta(resultSet.getDouble("multa"));
                alquiler.setFecha(resultSet.getString("fecha"));
                alquiler.setCedula(resultSet.getInt("cedula"));


                System.out.println(alquiler);
            }

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return alquiler;
    }







    public Clientes getClientes(int cedula) {
        Clientes clientes = null;
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM clientes WHERE cedula = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, cedula);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {

                clientes = new Clientes();
                clientes.setCedula(resultSet.getInt("cedula"));
                clientes.setNombre(resultSet.getString("nombre"));
                clientes.setApellido(resultSet.getString("apellido"));
                clientes.setDireccion(resultSet.getString("direccion"));
                clientes.setTelefono(resultSet.getInt("telefono"));
                clientes.setCorreo(resultSet.getString("correo"));

                System.out.println(clientes);
            }

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return clientes;
    }




    public DetalleAlquiler getDetalleAlquiler(int id) {
        DetalleAlquiler detalleAlquiler = null;
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM detallealquiler WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {

                detalleAlquiler = new DetalleAlquiler();
                detalleAlquiler.setId(resultSet.getInt("id"));
                detalleAlquiler.setIdPeli(resultSet.getInt("idPeli"));
                detalleAlquiler.setCostoAlqui(resultSet.getInt("costoAlqui"));
                detalleAlquiler.setCantidad(resultSet.getInt("cantidad"));


                System.out.println(detalleAlquiler);
            }

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return detalleAlquiler;
    }




    public Users getUsers(int id) {
        Users users = null;
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM users WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {

                users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("passw"));
                users.setNombre(resultSet.getString("nombre"));
                users.setApellido(resultSet.getString("apellido"));
                users.setCorreo(resultSet.getString("correo"));

                System.out.println(users);
            }

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return users;
    }




    public  Videos getVideos(int id) {
        Videos videos = null;
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM videos WHERE id = ?";

            PreparedStatement preparedStatement;

            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {
                videos = new Videos();
                videos.setId(resultSet.getInt("id"));
                videos.setTituloPeli(resultSet.getString("tituloPeli"));
                videos.setAnio(resultSet.getInt("anio"));
                videos.setGenero(resultSet.getString("genero"));
                videos.setNacionalidad(resultSet.getString("nacionalidad"));
                videos.setCantidad(resultSet.getInt("cantidad"));
                videos.setImagenHD(resultSet.getString("imagenHD"));
                videos.setDescripcion(resultSet.getString("descripcion"));

                System.out.println(videos);
            }

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al acceder a la Base de Datos");

        }//Fin de catch

        return videos;
    }
    /**
     * Cierra la Base de Datos.
     */
    public void cerrarBD() {

        try {

            statement.close();//Cierra el Statement.
            connection.close();//Termina la conxión con la BD.

        } //Fin de try
        catch (SQLException ex) {

            System.err.println("Hubo un error al cerrar la Base de Datos");

        }//Fin de catch

    }//Fin del método cerrarBD
}
