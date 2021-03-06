package com.project.javafx;

import com.google.gson.Gson;
import com.project.javafx.controllerfx.AdminDashboardController;
import com.project.javafx.model.CreditMajor;
import com.project.javafx.model.CreditStudent;
import com.project.javafx.model.Student;
import com.project.javafx.ulti.DateUtil;
import com.project.javafx.ulti.ViewConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        showLoginStage();
    }

    public void showLoginStage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ViewConstants.LOGIN_VIEW));
        Scene scene = new Scene(root);

        primaryStage.setTitle(ViewConstants.APP_NAME);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
//        primaryStage.getIcons().add(new Image("resources/img/icons8_Graduation_Cap_32px.png"));
        primaryStage.show();
        createReference();
    }

    private void createReference() {
        AdminDashboardController.setMainApp(this);
    }


    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/hello", (req, res)->"Hello, world");
        launch(args);
    }
}
