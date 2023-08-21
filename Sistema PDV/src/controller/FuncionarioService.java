package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FuncionarioModel;
import model.ProdutoModel;

public class FuncionarioService {
	
	public boolean insertFuncionario(FuncionarioModel funcionario) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String insertQuery = "INSERT INTO funcionarios (codigo, nome, cargo, tipo, usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, funcionario.getCodigo());
                preparedStatement.setString(2, funcionario.getNome());
                preparedStatement.setString(3, funcionario.getCargo());
                preparedStatement.setString(4, funcionario.getTipo());
                preparedStatement.setString(5, funcionario.getUsuario());
                preparedStatement.setString(6, funcionario.getSenha());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }
	
	public FuncionarioModel buscarFuncionarioPorUsuarioESenha(String usuario, String senha) {
	    FuncionarioModel funcionario = null;
	    try {
	        Connection conn = SQLiteConnection.connect();
	        if (conn != null) {
	            String selectQuery = "SELECT * FROM funcionarios WHERE usuario = ? AND senha = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
	            preparedStatement.setString(1, usuario);
	            preparedStatement.setString(2, senha);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                funcionario = new FuncionarioModel(	resultSet.getString("codigo"), 
								                		resultSet.getString("nome"), 
								                		resultSet.getString("cargo"), 
								                		resultSet.getString("tipo"), 
								                		resultSet.getString("usuario"), 
								                		resultSet.getString("senha"));
	            }

	            resultSet.close();
	            preparedStatement.close();
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return funcionario;
	}
	
	public FuncionarioModel buscarFuncionarioPorCodigo(String codigo) {
	    FuncionarioModel funcionario = null;
	    try {
	        Connection conn = SQLiteConnection.connect();
	        if (conn != null) {
	            String selectQuery = "SELECT * FROM funcionarios WHERE codigo = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
	            preparedStatement.setString(1, codigo);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	     
	            	funcionario = new FuncionarioModel(	resultSet.getString("codigo"), 
										                resultSet.getString("nome"), 
										                resultSet.getString("cargo"), 
										                resultSet.getString("tipo"),
										                resultSet.getString("usuario"),
										                resultSet.getString("senha"));
	            	
	            	funcionario.setId(resultSet.getInt("id"));
	            }

	            resultSet.close();
	            preparedStatement.close();
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return funcionario;
	}
	
	public boolean editarFuncionario(FuncionarioModel funcionario) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String updateQuery = "UPDATE funcionarios SET codigo = ?, nome = ?, cargo = ?, tipo = ?, usuario = ?, senha = ? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setString(1, funcionario.getCodigo());
                preparedStatement.setString(2, funcionario.getNome());
                preparedStatement.setString(3, funcionario.getCargo());
                preparedStatement.setString(4, funcionario.getTipo());
                preparedStatement.setString(5, funcionario.getUsuario());
                preparedStatement.setString(6, funcionario.getSenha());
                preparedStatement.setInt(7, funcionario.getId());
                int rowsAffected = preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
