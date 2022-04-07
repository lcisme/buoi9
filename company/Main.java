package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static ObservableList<NhapTT> nttList = FXCollections.observableArrayList();

    public static Stage rootStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("ttsdt.fxml"));
        primaryStage.setTitle("Session9 lab1");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        nttList.add(new NhapTT("Le Ceng","0966876014"));
        nttList.add(new NhapTT("Nguyet Cam","09485453"));
        nttList.add(new NhapTT("Duc Duy","097472543"));
        nttList.add(new NhapTT("Ha Linh","093456783"));
        launch(args);
    }
}
