package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// CREATE TABLE IF NOT EXISTS PokemonSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     PokemonID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (PokemonID) REFERENCES Pokemon(PokeID)
// );

// CREATE TABLE IF NOT EXISTS PokemonSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     PokemonID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (PokemonID) REFERENCES Pokemons(PokemonID)
// );



@Service
public class PokemonSalesServiceImplementation {

    @Autowired
    static List<PokemonSales> PokemonSalesList = new ArrayList<PokemonSales>();
    Connection connection;

    public PokemonSalesServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }



    
    public PokemonSales getPokemonSale(String sale_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM PokemonSales WHERE SalesID=" + sale_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            PokemonSales pokemon_sale = new PokemonSales(rs.getInt(1), rs.getInt(2));
            return pokemon_sale;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   

    public List<PokemonSales> getUserPokemonSales(String pokemon_id)
    {
        PokemonSalesList = new ArrayList<PokemonSales>();  
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM PokemonSales WHERE PokemonID=" + pokemon_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                PokemonSales pokemon = new PokemonSales(rs.getInt(1), rs.getInt(3));
                PokemonSalesList.add(pokemon);                    
            }
            return PokemonSalesList;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   


    
    public Boolean addPokemonSale(String sales_id, String pokemon_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO PokemonSales (SalesID, PokemonID) VALUES ('" + sales_id + "', " + pokemon_id + ")");
            stmt.executeQuery();
            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    } 
    
    
    public Boolean deletePokemonSales(String sales_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM Sales WHERE salesID=" + sales_id);
            stmt.executeQuery();
            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }   

    public Boolean buyStockPokemon(Sales sales, Integer pokemon_template_id)
    {
        try {
            String str_pokemon_template_id = String.valueOf(pokemon_template_id);
            
            String query = "";
            
            connection.setAutoCommit(false);

            query = "UPDATE users SET money=money-" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getPurchaser() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO Pokemon (Username, PokeTemplateID) VALUES ('" + sales.getPurchaser() + "', " + str_pokemon_template_id + "); ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO sales (Purchaser, Price) VALUES ('" + sales.getPurchaser() + "', " + String.valueOf(sales.getPrice()) + "); ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO PokemonSales (salesID, PokemonID) SELECT MAX(s.salesID), MAX(i.PokeID) FROM sales s, Pokemon i; ";
            connection.prepareStatement(query).executeUpdate();

            connection.commit();

            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }   

    public Boolean buySellerPokemon(Sales sales, Integer pokemon_id)
    {
        try {
            String str_pokemon_id = String.valueOf(pokemon_id);
            String query = "";
            System.out.println(str_pokemon_id);
            connection.setAutoCommit(false);

            query = "UPDATE users SET money=money-" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getPurchaser() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "UPDATE users SET money=money+" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getSeller() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "UPDATE Pokemon SET Username='" + sales.getPurchaser() + "' WHERE PokeID=" + str_pokemon_id + "; ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO sales (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" + sales.getPurchaser() + "', " + String.valueOf(sales.getPrice()) + "); "; 
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO PokemonSales (salesID, PokemonID) SELECT MAX(s.salesID)," + str_pokemon_id + " FROM sales s; ";
            connection.prepareStatement(query).executeUpdate();

            connection.commit();

            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    
    

    








    // public Boolean addPokemonSales(Sales sales, String Pokemon_id)
    // {
    //     try {
    //         String query = "START TRANSACTION; ";
    //         // String query = "";
    //         if (sales.getPurchaser() == null) {
    //             query = query + "INSERT INTO sales VALUE (Seller, Price) VALUES ('" + sales.getSeller() + "', " + sales.getPrice() + ";";
    //         } else if (sales.getSeller() == null) {
    //             query = query + "INSERT INTO sales VALUE (Purchaser, Price) VALUES ('" + sales.getPurchaser() + "', " + sales.getPrice() + ";";
    //         } else {
    //             query = query + "INSERT INTO sales VALUE (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" +  sales.getPurchaser()+ "', " + sales.getPrice() + ";";
    //         }
    //         query = query + " INSERT INTO PokemonSales (salesID, PokemonID) SELECT MAX(salesID), " + Pokemon_id + " FROM sales; ";
    //         query = query + " COMMIT;";            
    //         // INSERT INTO 
    //         // customers( customer_id, firstname, surname )
    //         // SELECT MAX( customer_id ) + 1, 'jim', 'sock' FROM customers;            
    //         PreparedStatement stmt = connection
    //             .prepareStatement(query);
    //         stmt.executeQuery();
    //         return true;    
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }   



    // MAKE A JAR FILE FOR APPLICATION


    

    // public List<PokemonSales> getPokemonSales(String username, String Pokemon_template_id)
    // {
    //     PokemonSalesList = new ArrayList<PokemonSales>();  
    //     try {
    //         String query_str = "SELECT * FROM Pokemons WHERE PokemonTemplateID=" + Pokemon_template_id + " AND username='" + username + "'";
    //         PreparedStatement stmt = connection
    //                 .prepareStatement(query_str);
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         {
    //             PokemonSales Pokemon = new PokemonSales(rs.getInt(1), rs.getString(2), rs.getInt(3));
    //             PokemonSalesList.add(Pokemon);                    
    //         }
    //         return PokemonSalesList;
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }   

    

    // public List<PokemonSales> getExistingTemplatePokemons(String Pokemon_template_id)
    // {
    //     PokemonSalesList = new ArrayList<PokemonSales>();  
    //     try {
    //         PreparedStatement stmt = connection
    //                 .prepareStatement("SELECT * FROM Pokemons WHERE PokemonTemplateID=" + Pokemon_template_id);
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         {
    //             PokemonSales Pokemon = new PokemonSales(rs.getInt(1), rs.getString(2), rs.getInt(3));
    //             PokemonSalesList.add(Pokemon);                    
    //         }
    //         return PokemonSalesList;
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }   


    // public Boolean changeOwnerUsername(String Pokemon_id, String new_username)
    // {
    //     try {
    //         // UPDATE Customers
    //         // SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
    //         // WHERE CustomerID = 1;
    //         PokemonSales Pokemon = this.getPokemonSale(Pokemon_id);
    //         PreparedStatement stmt = connection
    //                 .prepareStatement("UPDATE Pokemons SET PokemonID=" + Pokemon_id + ", username='"+new_username + "', PokemonTemplateID="+Pokemon.getPokemon_template_id() + " WHERE PokemonID=" + Pokemon_id);
    //         stmt.executeQuery();

    //         return true;    
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }   




    

}