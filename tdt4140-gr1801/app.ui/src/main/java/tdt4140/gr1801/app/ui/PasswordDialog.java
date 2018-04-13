package tdt4140.gr1801.app.ui;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

// All code in this class is collected from https://gist.github.com/drguildo/ba2834bf52d624113041
// Author: Simon Morgan
public class PasswordDialog extends Dialog<String> {
  private PasswordField passwordField;

  public PasswordDialog() {
    setTitle("Enter password to delete client");
    setHeaderText("NB! Deleting client cannot be undone.\n ");

    ButtonType passwordButtonType = new ButtonType("Delete client", ButtonData.OK_DONE);
    
    getDialogPane().getButtonTypes().addAll(passwordButtonType, ButtonType.CANCEL);

    passwordField = new PasswordField();
    passwordField.setPromptText("Delete client");

    HBox hBox = new HBox();
    hBox.getChildren().add(passwordField);
    hBox.setPadding(new Insets(10));
    HBox.setHgrow(passwordField, Priority.ALWAYS);

    getDialogPane().setContent(hBox);

    Platform.runLater(() -> passwordField.requestFocus());

    setResultConverter(dialogButton -> {
      if (dialogButton == passwordButtonType) {
        return passwordField.getText();
      }
      return null;
    });
  }

  public PasswordField getPasswordField() {
    return passwordField;
  }
}