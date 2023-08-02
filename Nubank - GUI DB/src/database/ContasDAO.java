package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import clientside.*;

public class ContasDAO {
	Connection con;
	PreparedStatement pstm;
	ResultSet resSet;
	ArrayList <Conta>lista_contas = new ArrayList<Conta>();
	
	public void cadastrar_conta(Conta objConta) {
		
		String sql = "INSERT INTO conta (nome, nascimento, cpf, usuario, senha, tipo, dinheiro, mensal, emprestimo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con = new Connect().connectDB();
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, objConta.getNome());
			pstm.setString(2, objConta.getNascimento());
			pstm.setString(3, objConta.getCpf());
			pstm.setString(4, objConta.getUsuario());
			pstm.setString(5, objConta.getSenha());
			pstm.setString(6, objConta.getTipo());
			pstm.setFloat(7, objConta.getDinheiro());
			pstm.setFloat(8, objConta.getMensal());
			pstm.setBoolean(9, objConta.getEmprestimo());
			
			pstm.execute();
			pstm.close();
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO: - Método cadastrar_conta: " + e);
		}
	}
	
	public void fechar_conta(Conta objConta) {
		
		String sql = "DELETE FROM conta WHERE usuario = ?";
		con = new Connect().connectDB();
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, objConta.getUsuario());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO: - Método fechar_conta: " + e);
		}
	}
	
	public ArrayList<Conta> listar_conta() {
		
		String sql = "SELECT * FROM conta";
		con = new Connect().connectDB();

		try {
			pstm = con.prepareStatement(sql);
			resSet = pstm.executeQuery();
			
			while(resSet.next()) {
				Conta objConta = new Conta();
				objConta.setId(resSet.getInt("id"));
				objConta.setNome(resSet.getString("nome"));
				objConta.setNascimento(resSet.getString("nascimento"));
				objConta.setCpf(resSet.getString("cpf"));
				objConta.setUsuario(resSet.getString("usuario"));
				objConta.setSenha(resSet.getString("senha"));
				objConta.setTipo(resSet.getString("tipo"));
				objConta.setDinheiro(resSet.getFloat("dinheiro"));
				objConta.setMensal(resSet.getFloat("mensal"));
				objConta.setEmprestimo(resSet.getBoolean("emprestimo"));
				lista_contas.add(objConta);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO - Método listar_conta: " + e);
		}
		
		return lista_contas;
	}
	
	public void alterar_conta(Conta objConta) {
		
		String sql = "UPDATE conta SET dinheiro = ?, mensal = ?, emprestimo = ? WHERE usuario = ?";
		
		con = new Connect().connectDB();
		
		try {
			pstm = con.prepareStatement(sql);

			pstm.setFloat(1, objConta.getDinheiro());
			pstm.setFloat(2, objConta.getMensal());
			pstm.setBoolean(3, objConta.getEmprestimo());
			pstm.setString(4, objConta.getUsuario());
			
			pstm.execute();
			pstm.close();
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Classe ContasDAO: - Método alterar_conta: " + e);
		}
		
	}
	
}
