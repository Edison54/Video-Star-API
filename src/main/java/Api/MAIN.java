package Api;

import static Api.JsonUtil.json;

import Entidades.Alquiler;
import Entidades.Clientes;
import Entidades.DetalleAlquiler;
import Entidades.Users;
import Entidades.Videos;
import static spark.Spark.*;

public class MAIN {

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    public static void main(String[] args) {

        port(8080);
        Servicio servicio = new Servicio();
        /*---------------INSERTAR ----------------------------------------------*/
        //POST - Insertar un alquiler en la BD.
        post("/api/alquiler", (request, response) -> {
            String id = request.queryParams("id");
            String plazo = request.queryParams("plazo");
            String montoTotal = request.queryParams("montoTotal");
            String multa = request.queryParams("multa");
            String fecha = request.queryParams("fecha");
            String cedula = request.queryParams("cedula");
            try {
                if (id != null && plazo != null && montoTotal != null && multa != null&& fecha != null&& cedula != null) {
                    Alquiler alquiler = new Alquiler(Integer.parseInt(id), Integer.parseInt(plazo), Double.parseDouble(montoTotal), Double.parseDouble(multa),fecha,Integer.parseInt(cedula) );
                    return servicio.postAlquiler(alquiler);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "Varios valores deben ser numericos";
            }
        }, json());


        //POST - Insertar un cliente en la BD.
        post("/api/clientes", (request, response) -> {
            String cedula = request.queryParams("cedula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String direccion = request.queryParams("direccion");
            String telefono = request.queryParams("telefono");
            String correo = request.queryParams("correo");

            try {
                if (cedula != null && nombre != null && apellido != null && direccion != null && telefono != null && correo != null) {
                    Clientes clientes = new Clientes(Integer.parseInt(cedula), nombre, apellido, direccion, Integer.parseInt(telefono), correo);
                    return servicio.postClientes(clientes);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "La cedula y el telefono deben ser un valor numerico";
            }
        }, json());








        //POST - Insertar un detalleAlquiler en la BD.
        post("/api/detallealquiler", (request, response) -> {
            String id = request.queryParams("id");
            String idPeli = request.queryParams("idPeli");
            String costoAlqui = request.queryParams("costoAlqui");
            String cantidad = request.queryParams("cantidad");
            try {
                if (id != null ) {
                    DetalleAlquiler detalleAlquiler = new DetalleAlquiler(Integer.parseInt(id),Integer.parseInt(idPeli) ,Integer.parseInt(costoAlqui),Integer.parseInt(cantidad));
                    return servicio.postDetalleAlquiler(detalleAlquiler);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "Varios valores deben ser numericos";
            }
        }, json());










        //POST - Insertar un users en la BD.
        post("/api/users", (request, response) -> {
            String id = request.queryParams("id");
            String username = request.queryParams("username");
            String password = request.queryParams("passw");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String correo = request.queryParams("correo");

            try {
                if (id != null && username != null && password != null && nombre != null && apellido != null && correo != null) {
                    Users users = new Users(Integer.parseInt(id), username, password, nombre, apellido, correo);
                    return servicio.postUsers(users);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "Error";
            }
        }, json());

        //POST - Insertar un videos en la BD.
        post("/api/videos", (request, response) -> {
            String id = request.queryParams("id");
            String tituloPeli = request.queryParams("tituloPeli");
            String anio = request.queryParams("anio");
            String genero = request.queryParams("genero");
            String nacionalidad = request.queryParams("nacionalidad");
            String cantidad = request.queryParams("cantidad");
            String imagenHD = request.queryParams("imagenHD");
            String descripcion = request.queryParams("descripcion");
            try {
                if (id != null && tituloPeli != null && anio != null && genero != null && nacionalidad != null & cantidad != null && imagenHD != null && descripcion != null ) {
                    Videos videos = new Videos(Integer.parseInt(id), tituloPeli, Integer.parseInt(anio), genero, nacionalidad,Integer.parseInt(cantidad),imagenHD,descripcion);
                    return servicio.postVideos(videos);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "Varios valores deben ser numericos";
            }
        }, json());







        /*-------------------------Devolver--------------------------------*/

        //GET - Devolver todos alquileres de la BD.
        get("/api/alquiler", (request, response) -> {
            return servicio.getAlquiler();
        }, json());

        //GET - Devolver todos los clientes de la BD.
        get("/api/clientes", (request, response) -> {
            return servicio.getClientes();
        }, json());





        //GET - Devolver todos los detalles de la BD.
        get("/api/detallealquiler", (request, response) -> {
            return servicio.getDetalleAlquiler();
        }, json());




        //GET - Devolver todos los usuarios de la BD.
        get("/api/users", (request, response) -> {
            return servicio.getUsers();
        }, json());

        //GET - Devolver todos los videos de la BD.
        get("/api/videos", (request, response) -> {
            return servicio.getVideos();
        }, json());

        /*-------------------------------------------*/


        //GET - Devolver un alquiler por el codigo.
        get("/api/alquiler/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.getAlquiler(Integer.parseInt(id));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());

        //GET - Devolver un clientes por el codigo.
            get("/api/clientes/:cedula", (request, response) -> {
            String cedula = request.params(":cedula");

            try {
                return servicio.getClientes(Integer.parseInt(cedula));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());






        //GET - Devolver un DetalleAlquler por el codigo.
        get("/api/detallealquiler/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.getDetalleAlquiler(Integer.parseInt(id));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());







        //GET - Devolver un users por el codigo.
        get("/api/users/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.getUsers(Integer.parseInt(id));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());


// GET - Devuelve un género por el Id
        get("/api/videos/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.getVideos(Integer.parseInt(id));
            } catch (NumberFormatException nfe) {
                response.status(400);
                return "Id no válido";
            }
        }, json());



        /*------------------------Actualizar--------------------------------*/


        //PATCH - Actualizar un alquiler en la BD por el número de id
        patch("/api/alquiler/:id", (request, response) -> {
            String id = request.params(":id");
            String plazo = request.queryParams("plazo");
            String montoTotal = request.queryParams("montoTotal");
            String multa = request.queryParams("multa");
            String fecha = request.queryParams("fecha");
            String cedula = request.queryParams("cedula");
            try {
                if ( plazo != null && montoTotal != null && multa != null&& fecha != null&& cedula != null) {
                    Alquiler alquiler = new Alquiler(Integer.parseInt(id), Integer.parseInt(plazo), Double.parseDouble(montoTotal), Double.parseDouble(multa),fecha,Integer.parseInt(cedula) );
                    return servicio.patchAlquiler(alquiler);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "codigo no valido";
            }
        }, json());



        //PATCH - Actualizar un cliente en la BD por el número de cedula
        patch("/api/clientes/:cedula", (request, response) -> {
            String cedula = request.params(":cedula");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String direccion = request.queryParams("direccion");
            String telefono = request.queryParams("telefono");
            String correo = request.queryParams("correo");

            try {
                if ( nombre != null && apellido != null && direccion != null && telefono != null && correo != null) {
                    Clientes clientes = new Clientes(Integer.parseInt(cedula), nombre, apellido, direccion, Integer.parseInt(telefono), correo);
                    return servicio.patchClientes(clientes);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "codigo no valido";
            }
        }, json());













        //PATCH - Actualizar un detalle alquiler en la BD por el número de id
        patch("/api/detallealquiler/:id", (request, response) -> {
            String id = request.params(":id");
            String idPeli = request.queryParams("idPeli");
            String costoAlqui = request.queryParams("costoAlqui");
            String cantidad = request.queryParams("cantidad");
            try {
                if ( idPeli != null && costoAlqui != null  && cantidad != null ) {
                    DetalleAlquiler detalleAlquiler = new DetalleAlquiler(Integer.parseInt(id),Integer.parseInt(idPeli) ,Integer.parseInt(costoAlqui),Integer.parseInt(cantidad));
                    return servicio.patchDetalleAlquiler(detalleAlquiler);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "codigo no valido";
            }
        }, json());
















        //PATCH - Actualizar un user en la BD por el número de id
        patch("/api/users/:id", (request, response) -> {
            String id = request.params(":id");
            String username = request.queryParams("username");
            String password = request.queryParams("passw");
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String correo = request.queryParams("correo");

            try {
                if ( username != null && password != null && nombre != null && apellido != null && correo != null) {
                    Users users = new Users(Integer.parseInt(id), username, password, nombre, apellido, correo);
                    return servicio.patchUsers(users);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "codigo no valido";
            }
        }, json());


        //PATCH - Actualizar un video en la BD por el número de id.
        patch("/api/videos/:id", (request, response) -> {
            String id = request.params(":id");
            String tituloPeli = request.queryParams("tituloPeli");
            String anio = request.queryParams("anio");
            String genero = request.queryParams("genero");
            String nacionalidad = request.queryParams("nacionalidad");
            String cantidad = request.queryParams("cantidad");
            String imagenHD = request.queryParams("imagenHD");
            String descripcion = request.queryParams("descripcion");
            System.out.println(id);
            System.out.println(tituloPeli);
            System.out.println(anio);
            System.out.println(genero);
            System.out.println(nacionalidad);
            System.out.println(cantidad);
            System.out.println(imagenHD);
            System.out.println(descripcion);





            try {
                if ( tituloPeli != null && anio != null && genero != null && nacionalidad != null && cantidad !=null && imagenHD !=null && descripcion !=null) {
                    Videos videos = new Videos(Integer.parseInt(id), tituloPeli, Integer.parseInt(anio), genero, nacionalidad,Integer.parseInt(cantidad),imagenHD,descripcion);
                    return servicio.patchVideos(videos);
                } else {
                    response.status(400);
                    return "Petición incorrecta";
                }
            } catch (NumberFormatException numberFormatException) {
                return "Varios valores deben ser numericos";
            }
        }, json());

        /*--------------------Eliminar -----------------------------------*/

        //DELETE - Eliminar un cliente en la BD por el codigo.
        delete("/api/clientes/:cedula", (request, response) -> {
            String cedula = request.params(":cedula");

            try {
                return servicio.deleteClientes(Integer.parseInt(cedula));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());











        //DELETE - Eliminar un users en la BD por el codigo.
        delete("/api/users/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.deleteUsers(Integer.parseInt(id));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());

        //DELETE - Eliminar un videos en la BD por el codigo.
        delete("/api/videos/:id", (request, response) -> {
            String id = request.params(":id");

            try {
                return servicio.deleteVideos(Integer.parseInt(id));
            } catch (NumberFormatException numberFormatException) {
                return "codigo no válido";
            }
        }, json());









        /*------------------------------cors--------------------------------*/
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.type("application/json");
            response.header("Access-Control-Allow-Origin", "*");
        });
    }
}

