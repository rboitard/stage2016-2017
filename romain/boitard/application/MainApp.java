package romain.boitard.application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import romain.boitard.application.controller.ViewController;

import java.awt.Label;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @FXML 
    private ScatterChart<Number, Number> chart;
    
    @FXML
    private Label labelStation;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Modelisation reseau");

        initRootLayout();

        loadViews();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void loadViews() {
        try {
            // Load View.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/View.fxml"));
            GridPane personOverview = (GridPane) loader.load();

            // Set View into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
       try {
            // Load EditStationView.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditStationView.fxml"));
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private ScatterChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        final ScatterChart<Number,Number> lineChart =
            new ScatterChart<>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        XYChart.Series<Number, Number> series = new XYChart.Series<>(
          "My portfolio", FXCollections.<XYChart.Data<Number, Number>>observableArrayList(
            new XYChart.Data<Number, Number>(1, 23),
            new XYChart.Data<Number, Number>(2, 14),
            new XYChart.Data<Number, Number>(3, 15),
            new XYChart.Data<Number, Number>(4, 24),
            new XYChart.Data<Number, Number>(5, 34),
            new XYChart.Data<Number, Number>(6, 36),
            new XYChart.Data<Number, Number>(7, 22),
            new XYChart.Data<Number, Number>(8, 45),
            new XYChart.Data<Number, Number>(9, 43),
            new XYChart.Data<Number, Number>(10, 17),
            new XYChart.Data<Number, Number>(11, 29),
            new XYChart.Data<Number, Number>(12, 25)
        )
        );

        lineChart.getData().add(series);
        return lineChart;
      }
}
