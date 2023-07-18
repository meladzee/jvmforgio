package com.example.jvm_lm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;

public class Tvshows {
    int price;
    int duration;
    String name;
    String genre;
    public Tvshows(int pricen, int durationn, String namen, String genren){
        price = pricen;
        duration = durationn;
        name = namen;
        genre = genren;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() { return genre; }

    public static void getTvshows(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tvshows");
        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("genre"));
            System.out.println(rs.getInt("price"));
            System.out.println(rs.getString("duration"));
        }
    }
    public static ResultSet getTvshowsForChart(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM tvshows");
        return rs;
    }
    public static void addTvshows(Connection con,String name,String genre,String price,String duration) throws SQLException {
        if (name == "")
//        if (genre == "")
//            System.out.println("Input Valid Genre");
        if (price == "") System.out.println("Input Valid price");
        if (duration == "")
            System.out.println("Input Valid duration");
        else {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO tvshows (name, genre, price, duration) VALUES (" + "'" + name + "'" + ", " + "'" + genre + "'" + ", " + price + ", " + genre + ")");
            System.out.println("Executed operation -> " + "INSERT INTO tvshows (name, genre, price, duration) VALUES (" + "'" + name + "'" + ", " + "'" + genre + "'" + ", " + price + ", " + duration + ")");
        }
    }
    public static void getDurationChart(Connection con, PieChart PieChart) throws SQLException {
        ResultSet rs = getTvshowsForChart(con);
        ArrayList<Tvshows> tvshowsList = new ArrayList<>();
        while (rs.next()){
            tvshowsList.add(new Tvshows(rs.getInt("price"), rs.getInt("duration"), rs.getString("name"), rs.getString("genre")));
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(int i = 0; i<tvshowsList.size(); i++){
            pieChartData.add(new PieChart.Data(tvshowsList.get(i).getName(), 1));
        }
        PieChart.setData(pieChartData);
    }
}