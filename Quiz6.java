package Quiz6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Quiz6 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create pane
		BorderPane pane = new BorderPane();
		
		//Print Hello World as text and center it
		Text text = new Text(180,190,"Hello World");
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		
		//Create CheckBox for each color
		CheckBox red = new CheckBox("Red");
		red.setLayoutX(7);
		red.setLayoutY(160);
		CheckBox blue = new CheckBox("Green");
		blue.setLayoutX(7);
		blue.setLayoutY(190);
		CheckBox green = new CheckBox("Green");
		green.setLayoutX(7);
		green.setLayoutY(220);
		
		//Create text for each color
		Text redText = new Text(30,165,"Red");
		Text blueText = new Text (30, 195, "Blue");
		Text greenText = new Text (30, 225, "Green");
				
		//Action Event for check boxes
		//ORDER IS CORRECT
		EventHandler<ActionEvent> handler = e-> {
			if (blue.isSelected() && red.isSelected() && green.isSelected()) {
				text.setFill(Color.BLACK);
			}
			else if (red.isSelected() && blue.isSelected()) {
				text.setFill(Color.PURPLE);
			}
			else if (red.isSelected() && green.isSelected()) {
				text.setFill(Color.YELLOW);
			}
			else if (red.isSelected()) {
				text.setFill(Color.RED);
			}
			else if (blue.isSelected() && green.isSelected()) {
				text.setFill(Color.CYAN);
			}
			else if (blue.isSelected()) {
				text.setFill(Color.BLUE);
			}
			else if (green.isSelected()) {
				text.setFill(Color.GREEN);
			}
			else {
				text.setFill(Color.WHITE);
			}
		};
		//Allow handler to function
		red.setOnAction(handler);
		blue.setOnAction(handler);
		green.setOnAction(handler);
		
		//Create Radio buttons for font
		RadioButton Courier = new RadioButton("Times New Roman");
		Courier.setLayoutX(7);
		Courier.setLayoutY(250);
		RadioButton Calibri = new RadioButton("Calibri");
		Calibri.setLayoutX(7);
		Calibri.setLayoutY(280);
		RadioButton Papyrus = new RadioButton ("Arial");
		Papyrus.setLayoutX(7);
		Papyrus.setLayoutY(310);
		
		//Create text for radio buttons
		Text CourierText = new Text (30, 255, "Courier");
		Text CalibriText = new Text (30, 285, "Calibri");
		Text PapyrusText = new Text (30, 315, "Papyrus");
		
		//Create new fonts
		Font fontNormal = Font.font("Times New Roman",
				FontWeight.NORMAL, FontPosture.REGULAR,20);
		Font fontCourier = Font.font("Courier",
				FontWeight.NORMAL, FontPosture.REGULAR, 20);
		Font fontCalibri = Font.font("Calibri",
				FontWeight.NORMAL, FontPosture.REGULAR, 20);
		Font fontPapyrus = Font.font("Papyrus",
				FontWeight.NORMAL, FontPosture.REGULAR, 20);
		text.setFont(fontNormal);
		
		//Button Action Event
		EventHandler<ActionEvent> handler2 = e-> {
			if (Papyrus.isSelected()) {
				text.setFont(fontPapyrus);
			}
			else if (Calibri.isSelected()) {
				text.setFont(fontCalibri);
			}
			else if (Courier.isSelected()){
				text.setFont(fontCourier);
			}
			else {
				text.setFont(fontNormal);
			}
		};
		//Allow handler2 to function
		Courier.setOnAction(handler2);
		Calibri.setOnAction(handler2);
		Papyrus.setOnAction(handler2);
		
		//Top must have user input to change text
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5,5,5,5));
		paneForTextField.setStyle("-fx-border-color: black");
		paneForTextField.setLeft(new Label("Enter a new message: "));
		//Create textfield 
		TextField input = new TextField();
		input.setAlignment (Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(input);
		pane.setTop(paneForTextField);
		//Action to change text on user input
		input.setOnAction(e->text.setText(input.getText()));
		
		
		
		//EXTRA CREDIT
		//I was not sure if by the directions you meant comboBox
		//NOTE: I used the following website to use ComboBox: CodeJava.net LINK: https://www.codejava.net/java-se/swing/jcombobox-basic-tutorial-and-examples
		
		//Create BorderPane for Combo Box
		BorderPane paneForComboBox = new BorderPane();
		paneForComboBox.setPadding(new Insets(5,5,5,5));
		paneForComboBox.setStyle("-fx-border-color: black");
		paneForComboBox.setLeft(new Label("Choose a degree: "));
		
		ComboBox<Integer> comboBox = new ComboBox (FXCollections.observableArrayList(30,60,90,120,150,180,210,240,270,300,330,360));
		
		comboBox.setLayoutX(20);
		comboBox.setLayoutY(10);
		paneForComboBox.setCenter(comboBox);
		pane.setBottom(paneForComboBox);
		comboBox.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e) {
			Rotate rotateText = new Rotate();
			rotateText.setAngle((double)comboBox.getValue());
			text.getTransforms().add(rotateText);
				
		}
			
		});

		//Add to pane
		pane.getChildren().addAll(red, redText, blue, blueText, green, greenText, Courier, CourierText, Calibri, CalibriText, Papyrus, PapyrusText);
	
		//Create new scene
		Scene scene = new Scene (pane, 450, 450);
		//Set primary stage title
		primaryStage.setTitle("Quiz 6");
		//Set scene
		primaryStage.setScene(scene);
		//Show scene
		primaryStage.show();
		
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}




