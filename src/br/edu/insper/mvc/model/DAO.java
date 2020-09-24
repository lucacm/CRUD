package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/meus_dados", "root", "porradesenha");
	}
	
	public List<Cadastro> getListaCadastros() throws SQLException {
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		PreparedStatement stmt = connection.prepareStatement(
				"SELECT * FROM Cadastros");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Cadastro cadastro = new Cadastro();
			cadastro.setId(rs.getInt("id"));
			cadastro.setNome(rs.getString("nome"));
			cadastro.setLogin(rs.getString("login"));
			cadastro.setSenha(rs.getString("senha"));
			cadastros.add(cadastro);
		}
		rs.close();
		stmt.close();
		
		return cadastros;		
	}
	
	public List<Tarefa> getListaTarefas() throws SQLException {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.prepareStatement(
				"SELECT * FROM Tarefas");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCadastroId(rs.getInt("cadastro_id"));
			tarefa.setTarefa(rs.getString("tarefa"));
			tarefa.setCreatedAt(rs.getTimestamp("created_at"));
			tarefa.setUpdatedAt(rs.getTimestamp("updated_at"));
			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
	}
	
	public void adicionaCadastro(Cadastro cadastro) throws SQLException {
		String sql = "INSERT INTO Cadastros" + "(nome,login,senha) VALUES(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, cadastro.getNome());
		stmt.setString(2, cadastro.getLogin());
		stmt.setString(3,cadastro.getSenha());
		stmt.execute();
		stmt.close();
	}
	
	public void adicionaTarefa(Tarefa tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefas" + "(tarefa) VALUES(?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		/*stmt.setInt(1, tarefa.getCadastroId());*/
		stmt.setString(1, tarefa.getTarefa());
		stmt.execute();
		stmt.close();
	}
	
	/* esse método de altera vale apenas para tarefas */ 
	 
	public void altera(Tarefa tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET " + "tarefa=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getTarefa());
		stmt.setLong(2, tarefa.getId());
		stmt.execute();
		stmt.close();
		}
	
	/* esse método de remove vale apenas para tarefas */ 
	 
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("DELETE FROM Tarefas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
	
	public void close() throws SQLException {
		connection.close();
		}
}
