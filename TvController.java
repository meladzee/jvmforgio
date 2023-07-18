package com.example.jvm_lm;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

import static com.example.jvm_lm.Tvshows.getDurationChart;

public class TvController {
    SQLConnector sqlcon = new SQLConnector();
    Connection con = sqlcon.createConnection();
    @FXML
    private Button fetchbtn;
    @FXML
    private Button getbtn;

    @FXML
    private TextField nameinp;
    @FXML
    private TextField genreinp;
    @FXML
    private TextField priceinp;
    @FXML
    private TextField durationinp;
    @FXML
    private PieChart piechart;
    @FXML
    private Button addchart;

    public TvController() throws SQLException {
    }


    @FXML
    protected void onGetButtonClick() throws SQLException {
        Tvshows.getTvshows(con);
    }

    @FXML
    protected void onAddButtonClick() throws SQLException {
        Tvshows.addTvshows(con, nameinp.getText(), genreinp.getText(), priceinp.getText(), durationinp.getText());
    }

    @FXML
    protected void addpiechart() throws SQLException {
        getDurationChart(con, piechart);
    }

}