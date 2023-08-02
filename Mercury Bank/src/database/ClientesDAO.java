package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import clientdata.*;

public class ClientesDAO {
	Connection con;
	PreparedStatement pstm;
	ResultSet resSet;
	ArrayList <Cliente>lista_clientes = new ArrayList<Cliente>();
	
	public void cadastrar_cliente(Cliente objCliente) {
		
		String sql = "INSERT INTO clientes (nome, ano, cpf, usuario, senha) VALUES (?, ?, ?, ?, ?)";
		con = new Connect().connectDB();
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, objCliente.getNome());
			pstm.setString(2, objCliente.getAno());
			pstm.setString(3, objCliente.getCpf());
			pstm.setString(4, objCliente.getUsuario());
			pstm.setString(5, objCliente.getSenha());
			
			pstm.execute();
			pstm.close();
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO: - Método cadastrar_conta: " + e);
		}
	}
	
	public void fechar_cliente(Cliente objCliente) {
		
		String sql = "DELETE FROM clientes WHERE usuario = ?";
		con = new Connect().connectDB();
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, objCliente.getUsuario());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO: - Método fechar_conta: " + e);
		}
	}
	
	public ArrayList<Cliente> listar_cliente() {
		
		String sql = "SELECT * FROM clientes";
		con = new Connect().connectDB();

		try {
			pstm = con.prepareStatement(sql);
			resSet = pstm.executeQuery();
			
			while(resSet.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setNome(resSet.getString("nome"));
				objCliente.setAno(resSet.getString("ano"));
				objCliente.setCpf(resSet.getString("cpf"));
				objCliente.setUsuario(resSet.getString("usuario"));
				objCliente.setSenha(resSet.getString("senha"));
				lista_clientes.add(objCliente);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO - Método listar_conta: " + e);
		}
		
		return lista_clientes;
	}
}
