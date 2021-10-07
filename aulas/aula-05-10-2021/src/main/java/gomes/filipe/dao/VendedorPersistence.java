package gomes.filipe.dao;

import gomes.filipe.entity.Vendedor;
import gomes.filipe.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorPersistence {

    private Connection cnt;

    public VendedorPersistence() {
        try{
            cnt = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public void insere(Vendedor vendedor) {
        try{
            Connection cnt = DataBase.getConnection();
            PreparedStatement ps = cnt.prepareStatement("INSERT INTO vendedores (codigo, cpf, nome, endereco, cidade, uf )" + " VALUES (?,?,?,?,?,?)");
            ps.setString(1, vendedor.getCodigo());
            ps.setString(2, vendedor.getCpf());
            ps.setString(3, vendedor.getNome());
            ps.setString(4, vendedor.getEndereco());
            ps.setString(5, vendedor.getCidade());
            ps.setString(6, vendedor.getUf());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public Vendedor get(String codigo) {
        try {
            PreparedStatement ps = cnt.prepareStatement("SELECT * FROM vendedores WHERE codigo = ?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return new Vendedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ
    public List<Vendedor> lista() {
        List<Vendedor>  vendedores = new ArrayList<>();
        try {
            PreparedStatement ps = cnt.prepareStatement("SELECT * FROM vendedores");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                vendedores.add(new Vendedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    // UPDATE
    public void atualiza(Vendedor vendedor) {
        try {
            PreparedStatement ps = cnt.prepareStatement("UPDATE vendedores SET cpf = ?," +
                    "nome = ?, endereco = ?,cidade = ?, uf = ? WHERE codigo =?");
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getCodigo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void exclui(String codigo) {
        try{
            PreparedStatement ps = cnt.prepareStatement("DELETE FROM vendedores WHERE codigo = ?");
            ps.setString(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
