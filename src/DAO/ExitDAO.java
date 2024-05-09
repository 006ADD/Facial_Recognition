package DAO;

import Entity.Exit;
import Util.Connecor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExitDAO {

    private Connecor connect = new Connecor();

    public void insert(Exit exit) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.
                prepareStatement("INSERT INTO Exit (id, person_id, enterdate) VALUES (?, ?, ?)")) {
            statement.setInt(1, exit.getId());
            statement.setInt(2, exit.getPersonId());
            statement.setString(3, exit.getExitDate());
            statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public ResultSet getAll() throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("SELECT * FROM Exit")) {
            return statement.executeQuery();
        }
    }

    public void delete(int id) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("DELETE FROM Exit WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
