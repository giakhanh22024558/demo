package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleChatBox extends Application {

    private ScrollPane chatArea;
    private VBox chatContainer;
    private TextField inputField;
    Button sendButton = new Button("Send");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Chat Box");

        chatContainer = new VBox(10);
        chatArea = new ScrollPane(chatContainer);
        chatArea.setFitToWidth(true);
        chatArea.setFitToHeight(true);
        chatContainer.setAlignment(Pos.TOP_RIGHT);
        chatArea.setPadding(new Insets(10));

        inputField = new TextField();
        inputField.setPromptText("Type your message...");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("call");
                Label label = new Label(inputField.getText());
                label.setStyle("-fx-background-color: #5FBDFF; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 2 5 2 5;" +
                        "-fx-background-radius: 5px");
                if(!label.getText().isEmpty()){
                    chatContainer.getChildren().add(label);
                    inputField.clear();
                }
            }
        };
        sendButton.setOnAction(event);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setCenter(chatArea);
        root.setBottom(createInputArea());

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BorderPane createInputArea() {
        BorderPane inputArea = new BorderPane();
        inputArea.setCenter(inputField);
        inputArea.setRight(sendButton);
        return inputArea;
    }

}
