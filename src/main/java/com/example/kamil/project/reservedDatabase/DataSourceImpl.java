package com.example.kamil.project.reservedDatabase;

/**
 * Created by Kamil on 01.01.2018.
 */
import com.example.kamil.project.entity.Account;
import com.example.kamil.project.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DataSourceImpl {

    private final DataSource primaryDataSource;
    private final DataSource secondaryDataSource;

    @Autowired
    public DataSourceImpl(final DataSource primaryDataSource,
                          @Qualifier("reservedDataSource") final DataSource secondaryDataSource) {
        this.primaryDataSource = primaryDataSource;
        this.secondaryDataSource = secondaryDataSource;
    }

    private void saveObject(String sql,int id, float amount){
        Connection conn = null;

        try {
            conn = secondaryDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1,amount);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    private Account findAccount(String sql, String name, int number){
        Connection conn = null;

        try {
            conn = secondaryDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            if(name!=null) ps.setString(1, name);
            else ps.setInt(1,number);
            Account account = null;
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                account = new Account(rs.getInt("id"),rs.getString("name"),rs.getString("password"),
                        rs.getInt("number"),rs.getFloat("amount"));
                System.out.println(account.getAmount());
            }
            rs.close();
            ps.close();
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    private Card findCard(String sql, String name, int number){
        Connection conn = null;

        try {
            conn = secondaryDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            if(name!=null) ps.setString(1, name);
            else ps.setInt(1,number);
            Card card = null;
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                card = new Card(rs.getInt("id"),rs.getString("name"),rs.getString("password"),
                        rs.getInt("number"),rs.getFloat("amount"),rs.getInt("money_limit"));
                System.out.println(card.getAmount());
            }
            rs.close();
            ps.close();
            return card;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }





    public Account findAccountByName(String name){

        String sql = "SELECT * FROM accountsecond WHERE name = ?";
        return findAccount(sql,name,0);
    }

    public Account findAccountByNumber(int number){
        String sql = "SELECT * FROM accountsecond WHERE number = ?";
        return findAccount(sql,null,number);
    }

    public Card findCardByName(String name){
        String sql = "SELECT * FROM cardsecond WHERE name = ?";
        return findCard(sql,name,0);
    }

    public Card findCardByNumber(int number){
        String sql = "SELECT * FROM cardsecond WHERE number = ?";
        return findCard(sql,null,number);
    }

    public void save(Account account){
        String sql = "UPDATE accountsecond SET amount = ? WHERE ID = ?";
        saveObject(sql,account.getId(),account.getAmount());
    }

    public void save(Card card){
        String sql = "UPDATE cardsecond SET amount = ? WHERE ID = ?";
        saveObject(sql,card.getId(),card.getAmount());
    }


}