package DAO;

import Entity.Enter;
import Util.Connecor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnterDAO {

    private Connecor connect = new Connecor();

    public void insert(Enter enter) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.
                prepareStatement("INSERT INTO Enter (id, person_id, enterdate) VALUES (?, ?, ?)")) {
            statement.setInt(1, enter.getId());
            statement.setInt(2, enter.getPersonId());
            statement.setString(3, enter.getEnterDate());
            statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public ResultSet getAll() throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("SELECT * FROM Enter")) {
            return statement.executeQuery();
        }
    }

    public void delete(int id) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("DELETE FROM Enter WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connect.disconnect();
        }catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
