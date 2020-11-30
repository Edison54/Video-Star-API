package Api;

import Datos.DataBaseManager;
import Entidades.Alquiler;
import Entidades.Clientes;
import Entidades.DetalleAlquiler;
import Entidades.Users;
import Entidades.Videos;

import java.util.List;

public class Servicio {

    DataBaseManager controlador = new DataBaseManager();

    public List<Alquiler> getAlquiler() {
        controlador.abrirBD();
        List<Alquiler> alquiler = controlador.getAlquiler();
        controlador.cerrarBD();
        return alquiler;
    }

    public List<Clientes> getClientes() {
        controlador.abrirBD();
        List<Clientes> clientes = controlador.getClientes();
        controlador.cerrarBD();
        return clientes ;
    }
    public List<DetalleAlquiler> getDetalleAlquiler() {
        controlador.abrirBD();
        List<DetalleAlquiler> detalleAlquiler = controlador.getDetalleAlquiler();
        controlador.cerrarBD();
        return detalleAlquiler;
    }

    public List<Users> getUsers() {
        controlador.abrirBD();
        List<Users> users = controlador.getUsers();
        controlador.cerrarBD();
        return users;
    }
    public List<Videos> getVideos() {
        controlador.abrirBD();
        List<Videos> videos = controlador.getVideos();
        controlador.cerrarBD();
        return videos;
    }




    /*-------------------------------------*/

    public Alquiler getAlquiler(int id) {
        controlador.abrirBD();
        Alquiler alquiler = controlador.getAlquiler(id);
        controlador.cerrarBD();
        return alquiler;
    }

    public Clientes getClientes(int cedula) {
        controlador.abrirBD();
        Clientes clientes = controlador.getClientes(cedula);
        controlador.cerrarBD();
        return clientes;
    }





    public DetalleAlquiler getDetalleAlquiler(int id) {
        controlador.abrirBD();
        DetalleAlquiler detalleAlquiler = controlador.getDetalleAlquiler(id);
        controlador.cerrarBD();
        return detalleAlquiler;
    }






    public Users getUsers(int id) {
        controlador.abrirBD();
        Users users = controlador.getUsers(id);
        controlador.cerrarBD();
        return users;
    }
    public Videos getVideos(int id) {
        controlador.abrirBD();
        Videos videos = controlador.getVideos(id);
        controlador.cerrarBD();
        return videos;
    }

    /*-------------------------------------*/

    public String postAlquiler(Alquiler alquiler) {
        controlador.abrirBD();
        int id = controlador.insertarAlquiler(alquiler);
        controlador.cerrarBD();
        return "El alquiler con el codigo " + id + " ha sido creado.";
    }

    public String postClientes(Clientes clientes) {
        controlador.abrirBD();
        int cedula = controlador.insertarClientes(clientes);
        controlador.cerrarBD();
        return "El cliente con la cedula " + cedula +" ha sido creado.";
    }




    public String postDetalleAlquiler(DetalleAlquiler detalleAlquiler) {
        controlador.abrirBD();
        int id = controlador.insertarDetalleAlquiler(detalleAlquiler);
        controlador.cerrarBD();
        return "El Detalle del aquiler con el codigo " + id + " ha sido creado.";
    }





    public String postUsers(Users users) {
        controlador.abrirBD();
        int id = controlador.insertarUsers(users);
        controlador.cerrarBD();
        return "El usuario con el codigo " + id + " ha sido cread0.";
    }

    public String postVideos(Videos videos) {
        controlador.abrirBD();
        int id = controlador.insertarVideos(videos);
        controlador.cerrarBD();
        return "El video con el id " + id + " ha sido creada satisfactoriamente.";
    }





    /*-------------------------------------*/





    public String patchAlquiler(Alquiler alquiler) {
        controlador.abrirBD();
        Alquiler consulta = controlador.getAlquiler(alquiler.getId());
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.actualizarAlquiler(alquiler);
            controlador.cerrarBD();
            return "El alquiler con el codigo " + alquiler.getId() + " ha sido actualizado.";
        } else {
            return "Alquiler no encontrado";
        }
    }

    public String patchClientes(Clientes clientes) {
        controlador.abrirBD();
        Clientes consulta = controlador.getClientes(clientes.getCedula());
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.actualizarClientes(clientes);
            controlador.cerrarBD();
            return "El Cliente con el codigo " + clientes.getCedula() + " ha sido actualizado.";
        } else {
            return "Cliente no encontrado";
        }
    }




    public String patchDetalleAlquiler(DetalleAlquiler detalleAlquiler) {
        controlador.abrirBD();
        DetalleAlquiler consulta = controlador.getDetalleAlquiler(detalleAlquiler.getId());
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.actualizarDetalleAlquiler(detalleAlquiler);
            controlador.cerrarBD();
            return "El Detalle alquiler con el codigo " + detalleAlquiler.getId() + " ha sido actualizado.";
        } else {
            return "Detalle alquiler no encontrado";
        }
    }





    public String patchUsers(Users users) {
        controlador.abrirBD();
        Users consulta = controlador.getUsers(users.getId());
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.actualizarUsers(users);
            controlador.cerrarBD();
            return "El usuario con el codigo " + users.getId() + " ha sido actualizado.";
        } else {
            return "Usuario no encontrado";
        }
    }
    public String patchVideos(Videos videos) {
        controlador.abrirBD();
        Videos consulta = controlador.getVideos(videos.getId());
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.actualizarVideos(videos);
            controlador.cerrarBD();
            return "El video con el codigo " + videos.getId() + " ha sido actualizado.";
        } else {
            return "Video no encontrado";
        }
    }









    /*-------------------------------------*/





    public String deleteClientes(int cedula) {
        controlador.abrirBD();
        Clientes consulta = controlador.getClientes(cedula);
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.eliminarClientes(cedula);
            controlador.cerrarBD();
            return "El cliente con el codigo " + cedula + " ha sido eliminado.";
        } else {
            return "Cliente no encontrado";
        }
    }








    public String deleteUsers(int id) {
        controlador.abrirBD();
        Users consulta = controlador.getUsers(id);
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.eliminarUsers(id);
            controlador.cerrarBD();
            return "El usuario con el codigo " + id + " ha sido eliminado.";
        } else {
            return "Usuario no encontrado";
        }
    }
    public String deleteVideos(int id) {
        controlador.abrirBD();
        Videos consulta = controlador.getVideos(id);
        controlador.cerrarBD();

        if (consulta != null) {
            controlador.abrirBD();
            controlador.eliminarvideos(id);
            controlador.cerrarBD();
            return "El video con el codigo " + id + " ha sido eliminado.";
        } else {
            return "Video no encontrado";
        }
    }



}