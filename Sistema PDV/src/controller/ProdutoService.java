package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import model.FuncionarioModel;
import model.ProdutoModel;

public class ProdutoService {
	public boolean insertProduto(ProdutoModel produto) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String insertQuery = "INSERT INTO produtos (codigo, nome, marca, preco) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, produto.getCodigo());
                preparedStatement.setString(2, produto.getNome());
                preparedStatement.setString(3, produto.getMarca());
                preparedStatement.setFloat(4, produto.getPreco());
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
	
	public ProdutoModel buscarProdutoPorCodigo(String codigo) {
	    ProdutoModel produto = null;
	    try {
	        Connection conn = SQLiteConnection.connect();
	        if (conn != null) {
	            String selectQuery = "SELECT * FROM produtos WHERE codigo = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
	            preparedStatement.setString(1, codigo);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	     
	            	produto = new ProdutoModel(	resultSet.getString("codigo"), 
								                resultSet.getString("nome"), 
								                resultSet.getString("marca"), 
								                resultSet.getFloat("preco"));
	            	
	            	produto.setId(resultSet.getInt("id"));
	            }

	            resultSet.close();
	            preparedStatement.close();
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produto;
	}
	
	public boolean editarProduto(ProdutoModel produto) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String updateQuery = "UPDATE produtos SET codigo = ?, nome = ?, marca = ?, preco = ? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                preparedStatement.setString(1, produto.getCodigo());
                preparedStatement.setString(2, produto.getNome());
                preparedStatement.setString(3, produto.getMarca());
                preparedStatement.setFloat(4, produto.getPreco());
                preparedStatement.setInt(5, produto.getId());
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
	
	public boolean insertCompra(String total, String funcionario) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String insertQuery = "INSERT INTO compras (total, funcionario) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, total);
                preparedStatement.setString(2, funcionario);
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

    public boolean insertDescricao(int compraId, String nomeProduto, String precoProduto) {
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String insertQuery = "INSERT INTO descricao (compra_id, nome_produto, preco_produto) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, compraId);
                preparedStatement.setString(2, nomeProduto);
                preparedStatement.setString(3, precoProduto);
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
    
    public int obterUltimoId() {
        int lastInsertedId = -1;
        try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                String query = "SELECT id FROM compras ORDER BY id DESC LIMIT 1";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    lastInsertedId = resultSet.getInt("id");
                }
                resultSet.close();
                statement.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastInsertedId;
    }
    
    public void generatePDF() {
        Document document = new Document();
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório PDF");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath() + ".pdf";
                
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);

                Paragraph titleParagraph = new Paragraph("Relatório", titleFont);
                titleParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(titleParagraph);

                Connection conn = SQLiteConnection.connect();
                if (conn != null) {
                    Statement statement = conn.createStatement();
                    String query = "SELECT * FROM compras";
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        int compraId = resultSet.getInt("id");
                        String total = resultSet.getString("total");
                        String funcionario = resultSet.getString("funcionario");

                        document.add(Chunk.NEWLINE);

                        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                        Paragraph compraParagraph = new Paragraph("Compra #" + compraId, boldFont);
                        compraParagraph.setAlignment(Element.ALIGN_CENTER);
                        document.add(compraParagraph);

                        document.add(new Paragraph("Total: " + total));
                        document.add(new Paragraph("Funcionário: " + funcionario));

                        document.add(Chunk.NEWLINE);
                        String descricaoQuery = "SELECT nome_produto, preco_produto FROM descricao WHERE compra_id = " + compraId;
                        Statement descricaoStatement = conn.createStatement();
                        ResultSet descricaoResultSet = descricaoStatement.executeQuery(descricaoQuery);

                        while (descricaoResultSet.next()) {
                            String nomeProduto = descricaoResultSet.getString("nome_produto");
                            String precoProduto = descricaoResultSet.getString("preco_produto");

                            document.add(new Paragraph("Produto: " + nomeProduto));
                            document.add(new Paragraph("Preço: " + precoProduto));

                            document.add(Chunk.NEWLINE);
                        }
                        descricaoResultSet.close();
                        descricaoStatement.close();
                    }
                    resultSet.close();
                    statement.close();
                    conn.close();
                }
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

}
