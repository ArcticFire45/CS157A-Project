package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImplementation {
    @Autowired
    static List<Items> itemList = new ArrayList<Items>();

    Connection connection;

    public ItemServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<Items> getItemData() {
        try {
            itemList = new ArrayList<Items>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ItemTemplate");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Items item = new Items(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getFloat(5),
                        rs.getString(6));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    public List<Items> searchItemByName(String name) {
        try {
            itemList = new ArrayList<Items>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ItemTemplate WHERE ItemName LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Items item = new Items(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getFloat(5),
                        rs.getString(6));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

}
