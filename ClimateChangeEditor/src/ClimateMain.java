import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author S Maharaj 217031068
 * Main Client 
 */
public class ClimateMain extends Application
{
    /**
     * Main method launches application
     * @param args
     */
	public static void main(String[] args) 
	{
		//Launch the JavaFX Application
		launch(args);
	}

	/**
	 * Start method to run the interface
	 *@param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		//Create the ClientPane, set up the Scene and Stage
		primaryStage.setTitle("Climate Change");
		ClimatePane pane = new ClimatePane(primaryStage);
		Scene scene = new Scene(pane, 1200, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
