/* Author: Caitlin Coulombe, T00756521
 * Date: August 18, 2024
 * Course: COMP 1231
 * Assignment 5 Question 1: Design and implement a JavaFX application that allows the user to change the colour 
 * of a displayed circle by selecting a colour out of three options provided by a set of radio buttons. The 
 * application also comes with a slider that controls the size of the circle. You must use the JavaFX property 
 * value to observe the slider value change and then update the circle size based on the slider value. In addition, 
 * the application expects he user to select either a radio button or the slider control only. When the user 
 * selects areas other than these controls, a sound effect with each mouse click on these areas will be played.
 * 
 * Your application shuold closely resemble the output format as shown in the diagrams in the moodle. The diagrams 
 * show two different scenarios when the application is running. The application must fulfill the following 
 * requirements:
 *      * The app has instruction (i.e. change the circle colour...) about its usage. It is placed at the top of 
 *      the app window.
 *      * The set of radio buttons and the circle shape are placed below the isntruction. The three radio buttons 
 *      must be aligned and placed on the left side of the app window. The circle is placed on the right side of 
 *      the app window. The colour of the circle is changed immediately based on the choice of the radio button.
 *      * A slider is placed horizontally below both the set of radio buttons and the circle shape. The size of 
 *      the circle (between 0% and 100%) is updated when the slider is moving along its scale.
 *      * When the app is launched, the radio button "orange" has been selected, the displayed circle is orange, 
 *      the size of the orange is 25% and the knob of the slider is selected at 25% on the scale.
 *      * A warning message (i.e. Select the radio buttons...) is placed at the bottom of the application
 *      * The app plays a warning sound when the user is selecting neither any radio button nor the slider. An 
 *      example of the sound is "a beeping sound". Search a sound clip online or create it yourself.
 * 
 * 
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CircleOptions extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // Start(primaryStage) sets the stage and initialize the pane
    //-----------------------------------------------------------------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        CircleOptionsPane pane = new CircleOptionsPane();
        pane.setStyle("-fx-background-color: lightyellow");

        Scene scene = new Scene(pane, 475, 375);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Changing Circle");
        primaryStage.show();

        
    }

}
