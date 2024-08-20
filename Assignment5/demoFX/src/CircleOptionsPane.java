/* Author: Caitlin Coulombe, T00756521
 * Date: August 18, 2024
 * Course: COMP 1231
 * Assignment 5 Question 1: Instructions in CircleOptions.java
 *
 */

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Slider;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class CircleOptionsPane extends VBox{
    
    // global objects
    private Text instructions, warning;
    private Circle circle;
    private RadioButton orangeRadio, yellowRadio, blueRadio;
    private Slider slider;
    private MediaPlayer clickSound;

    // global variables
    final private int MAX_RADIUS = 50;

    //-----------------------------------------------------------------------------------------------------------------------
    // CircleOptionsPane executes al the functions needed to set up and properly run the pane
    //-----------------------------------------------------------------------------------------------------------------------
    public CircleOptionsPane()
    {
        setUpLayout();
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // setUpLayout() handles the formatting of the scene to ensure everything is where it should be
    //-----------------------------------------------------------------------------------------------------------------------
    private void setUpLayout()
    {
        // instructions formatting
        instructions = new Text("Change the circle colour using the radio buttons.\nChange the scale of the circle between 0-100% using the slider.");
        instructions.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        instructions.setTextAlignment(TextAlignment.CENTER);

        // radio button formatting
        ToggleGroup group = new ToggleGroup();

        // orange
        orangeRadio = new RadioButton("Orange");
        orangeRadio.setSelected(true);
        orangeRadio.setToggleGroup(group);
        orangeRadio.setOnAction(this::processRadioButtonAction);

        // yellow
        yellowRadio = new RadioButton("Yellow");
        yellowRadio.setToggleGroup(group);
        yellowRadio.setOnAction(this::processRadioButtonAction);

        // blue
        blueRadio = new RadioButton("Blue");
        blueRadio.setToggleGroup(group);
        blueRadio.setOnAction(this::processRadioButtonAction);

        // vbox for the radio buttons
        VBox radioVBox = new VBox(10, orangeRadio, yellowRadio, blueRadio);
        radioVBox.setSpacing(10);
        radioVBox.setAlignment(Pos.TOP_LEFT);

        // circle formatting
        double circleStartRad = 0.25 * MAX_RADIUS;
        circle = new Circle(circleStartRad, Color.ORANGE);
        circle.setManaged(false);
        
        // stackpane for the circle
        StackPane circlePane = new StackPane(circle);
        circlePane.setPrefWidth(MAX_RADIUS * 2);
        circlePane.setPrefHeight(MAX_RADIUS * 2);

        // HBox for the radio buttons and the circle
        HBox radioAndCircle_HBox = new HBox(radioVBox, circlePane);
        radioAndCircle_HBox.setSpacing(115);
        radioAndCircle_HBox.setAlignment(Pos.CENTER);
    
        // slider format
        slider = new Slider(0, 100, 25);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(3);
        slider.setBlockIncrement(5);
        
        // binding the radius of the circle to the slider
        DoubleProperty maxRadProperty = new SimpleDoubleProperty(MAX_RADIUS);
        
        circle.radiusProperty().bind(Bindings.createDoubleBinding(() -> (slider.getValue() / 100) * maxRadProperty.get(), slider.valueProperty()));

        // warning text format
        warning = new Text("Select the radio buttons or the slider only.\nYou'll hear a warning sound if the mouse is clicked elsewhere!");
        warning.setFont(Font.font("Verdana", 12));
        warning.setFill(Color.RED);
        warning.setTextAlignment(TextAlignment.CENTER);

        // vbox with everything in it
        setSpacing(40);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(30, 30, 30, 30));
        getChildren().addAll(instructions, radioAndCircle_HBox, slider, warning);
        VBox.setMargin(radioAndCircle_HBox, new Insets(10, 0, 10, 0)); // Adjust margins to fine-tune the position of the circle
        HBox.setMargin(circlePane, new Insets(35, 0, 0, 0)); // Adjust this to move the circle further to the right

        setOnMousePressed(this::processMousePress);
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // processRadioButtonAction(event) use the triggering event to determine what colour to make the circle
    //-----------------------------------------------------------------------------------------------------------------------
    private void processRadioButtonAction(ActionEvent event)
    {
        // change the colour of the circle based on the button pressed
        if(orangeRadio.isSelected())
        {
            circle.setFill(Color.ORANGE);
        }
        else if(yellowRadio.isSelected())
        {
            circle.setFill(Color.YELLOW);
        }
        else
        {
            circle.setFill(Color.BLUE);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // processMouseClick(event) determines whether the mouse clicked on a control or somewhere else
    //-----------------------------------------------------------------------------------------------------------------------
    private void processMousePress(MouseEvent event) 
    {    
        playSound();
    }
    

    //-----------------------------------------------------------------------------------------------------------------------
    // playSound() plays the audio for clicking somewhere other than the controls
    //-----------------------------------------------------------------------------------------------------------------------
    private void playSound()
    {
        // play the sound
        String soundFilePath = getClass().getResource("/resources/floop.wav").toString();
        Media sound = new Media(soundFilePath);

        if(clickSound != null)
        {
            clickSound.stop();
        }

        clickSound = new MediaPlayer(sound);
        clickSound.play();
    }
}
