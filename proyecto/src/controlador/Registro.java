/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Estado;
import modelo.Producto;

/**
 *
 * @author pp
 */
public class Registro {
//AGREGAR PRODUCTO

    public boolean agregar(Producto producto) {
        String query;
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            query = "INSERT INTO producto(nombre,marca,descripcion,precio,stock,tipo,disponible) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getMarca());
            stmt.setString(3, producto.getDescripcion());
            stmt.setInt(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setString(6, producto.getTipo());
            stmt.setBoolean(7, producto.isDisponible());

            stmt.executeUpdate(); //inserta en la B.D
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Producto" + e.getMessage());
            return false;
        }
    }
//REGISTRAR CLIENTE

    public boolean agregarCliente(Cliente cliente) {
        String query;
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            query = "INSERT INTO cliente(rut,nombre,email,telefono,direccion) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, cliente.getRut());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());

            stmt.executeUpdate(); //inserta en la B.D
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }
    }

//buscar con PK RUT CLIENTE
    public Cliente buscarPK(String rut) {
        Cliente c = new Cliente();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut,nombre,email,telefono FROM cliente WHERE rut = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, rut);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c.setRut(rs.getString("rut"));
                c.setNombre(rs.getString("nombre"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));

            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Cliente" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Cliente" + e.getMessage());
        }
        return c;
    }

//buscar con IDPRODUCTO
    public List<Producto> buscarIdproducto(int idproducto) {
        List<Producto> lista = new ArrayList<Producto>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto,nombre,marca,descripcion,precio,stock,tipo,disponible FROM producto WHERE idproducto = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idproducto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setDisponible(rs.getBoolean("disponible"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto" + e.getMessage());
        }
        return lista;
    }

    //buscar todos los productos
    public List<Producto> buscarTodos() {
        List<Producto> lista = new ArrayList<Producto>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto,nombre,marca,descripcion,precio,stock,tipo,disponible FROM producto";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery(); //select en BD

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setDisponible(rs.getBoolean("disponible"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto" + e.getMessage());
        }
        return lista;
    }

//buscar por marca
    public List<Producto> buscarMarca(String marca) {
        List<Producto> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto,nombre,marca,descripcion,precio,stock,tipo,disponible FROM producto WHERE marca = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, marca);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setDisponible(rs.getBoolean("disponible"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto" + e.getMessage());
        }
        return lista;
    }

    //buscar por nombre
    public List<Producto> buscarNombre(String nombre) {
        List<Producto> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto,nombre,marca,descripcion,precio,stock,tipo,disponible FROM producto WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setDisponible(rs.getBoolean("disponible"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto" + e.getMessage());
        }
        return lista;
    }

//MODIFICAR ESTADO    
    public boolean modificarEstado(Estado est) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE estado SET fase = ?, fecha_estado = SYSDATE() WHERE idestado = ?;";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setInt(1, est.getIdestado());
            stmt.setString(2, est.getFase());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al Modificar Estado" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al Modificar Estado" + e.getMessage());
            return false;
        }
    }

//ELIMINAR PRODUCTO
    public boolean eliminar(Producto pro) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM producto WHERE idproducto = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, pro.getIdproducto());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar Producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar Producto" + e.getMessage());
            return false;
        }
    }

    public List<Producto> buscarTipo(String tipo) {
        List<Producto> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto,nombre,marca,descripcion,precio,stock,tipo,disponible FROM producto WHERE tipo = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, tipo);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getInt("precio"));
                p.setStock(rs.getInt("stock"));
                p.setTipo(rs.getString("tipo"));
                p.setDisponible(rs.getBoolean("disponible"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto" + e.getMessage());
        }
        return lista;
    }

    public List<Producto> buscarIdproducto(String idproductoTexto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
