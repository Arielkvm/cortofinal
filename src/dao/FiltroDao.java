package dao;

import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Filtro;

/**
 * @author kevin
 */
public class FiltroDao implements metodos<Filtro>{
    
    private static final String SQL_INSERT = "INSERT INTO personas (AFP, nombre, apellido, profesion, estado) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE personas SET nombre = ?, apellido = ?, profesion = ?, estado=? WHERE AFP = ?";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE AFP = ?";
    private static final String SQL_READ = "SELECT * FROM personas WHERE AFP = ?";
    private static final String SQL_READALL = "SELECT * FROM personas ";
    
    private static final Conexion con = Conexion.conectar();
    
    @Override
    public boolean create(Filtro g) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setInt(1, g.getAFP());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getApellido());
            ps.setString(4, g.getProfesion());
            ps.setBoolean(5, g.getEstado());
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public boolean delete(Object key){
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public boolean update(Filtro c){
        PreparedStatement ps;
        try{
            System.out.println(c.getNombre());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getAFP());
            ps.setString(2,c.getNombre());
            ps.setString(3,c.getApellido());
            ps.setString(4,c.getProfesion());
            ps.setBoolean(5,c.getEstado());
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public Filtro read(Object key){
        Filtro f = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1,key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                f = new Filtro(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getBoolean(5));
            }
            rs.close();
        }catch (SQLException ex) {
             System.out.println(ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return f;
    }
    
    @Override
    public ArrayList<Filtro> readAll() {
        ArrayList<Filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;
        
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            
            while(rs.next()){
                all.add(new Filtro(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getBoolean(5)));
            }
            rs.close();
        } catch (SQLException ex){
            System.out.println("Error");
        }
        return all;
    }
}
