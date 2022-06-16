import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author S Maharaj 217031068
 * Client Pane 
 * Class that connects the Classes to main( By using the functions) , and sets layout of the GUI
 */
public class ClimatePane extends GridPane
{
	//Declare socket, reader and streams
	Socket socket = null;
	InputStream is = null;
	BufferedReader br = null;
	OutputStream os = null;
	BufferedOutputStream bos = null;
	DataOutputStream dos = null;
	
	//Declare image file variable to maintain throughout
	File imageFile;
	
	//Declare all api features
	private String grayscaleURL = "/api/GrayScale";
	private String rotateURL = "/api/Rotate";
	private String erosionURL = "/api/Erosion";
	private String dilationURL = "/api/Dilation";
	private String cropURL = "/api/Crop";
	private String cannyURL = "/api/Canny";
	private String fastURL = "/api/Fast";
	private String orbURL = "/api/ORB";
	
	//Declare gui elements
	private Button btnConnect;
	
	private Label lblOpening;
	private Button btnIndustrialization;
	private Button btnDeforestation;
	private Button btnWaterScarcity;
	
	//Declare gui elements
	private ImageView imgIn;
	private Label lblCategory;
	private Button btnGrayScale;
	private Button btnRotate;
	private Button btnErosion;
	private Button btnDilation;
	private Button btnCrop;
	private Button btnCanny;
	private Button btnFast;
	private Button btnOrb;
	
	//Declare gui elements
	private TextArea textArea;
	private ImageView imgOut;
	
	private Label lblClosing;
	
	/**
	 * Default constructor that sets layout and buttons actions
	 */
	public ClimatePane(Stage stage)
	{
		setUpGui();
		
		//Click connect button and call helper functions
		btnConnect.setOnAction(e ->
		{
			connect();
		});
		
		//Click industrialization button and call helper functions
		btnIndustrialization.setOnAction(e ->
		{
			//Implements a file chooser to select image in category
			FileChooser fc = new FileChooser();
			fc.setTitle("Select an image");
			fc.setInitialDirectory(new File("data/Industrialization"));
			imageFile = fc.showOpenDialog(null);
			
			//Store retrieved image in an imageView to display
			Image read;
			try 
			{
				read = new Image(new FileInputStream(imageFile));
				imgIn.setImage(read);
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}	
		});
		
		//Click deforestation button and call helper functions
		btnDeforestation.setOnAction(e ->
		{
			//Implements a file chooser to select image in category
			FileChooser fc = new FileChooser();
			fc.setTitle("Select an image");
			fc.setInitialDirectory(new File("data/Deforestation"));
			imageFile = fc.showOpenDialog(null);
			
			//Store retrieved image in an imageView to display
			Image read;
			try 
			{
				read = new Image(new FileInputStream(imageFile));
				imgIn.setImage(read);
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}	
		});
		
		//Click water scarcity button and call helper functions
		btnWaterScarcity.setOnAction(e ->
		{
			//Implements a file chooser to select image in category
			FileChooser fc = new FileChooser();
			fc.setTitle("Select an image");
			fc.setInitialDirectory(new File("data/Water_Scarcity"));
			imageFile = fc.showOpenDialog(null);
			
			//Store retrieved image in an imageView to display
			Image read;
			try 
			{
				read = new Image(new FileInputStream(imageFile));
				imgIn.setImage(read);
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}	
		});
		
		//Click grayscale button and call helper functions
		btnGrayScale.setOnAction((event)->
		{
			helper(dos, imageFile, grayscaleURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click rotate button and call helper functions
		btnRotate.setOnAction((event)->
		{
			helper(dos, imageFile, rotateURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click erosion button and call helper functions
		btnErosion.setOnAction((event)->
		{
			helper(dos, imageFile, erosionURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click dilation button and call helper functions
		btnDilation.setOnAction((event)->
		{
			helper(dos, imageFile, dilationURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click crop button and call helper functions
		btnCrop.setOnAction((event)->
		{
			helper(dos, imageFile, cropURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click canny button and call helper functions
		btnCanny.setOnAction((event)->
		{
			helper(dos, imageFile, cannyURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click fast button and call helper functions
		btnFast.setOnAction((event)->
		{
			helper(dos, imageFile, fastURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
		
		//Click orb button and call helper functions
		btnOrb.setOnAction((event)->
		{
			helper(dos, imageFile, orbURL);

			textArea.appendText("POST command sent \r\n");

			String base = base64(br);

			Image im = imageHelper(base);
			imgOut.setImage(im);
			
			//reconnect
			connect();
		});
	}
	
	private void setUpGui()
	{
		//set alignment and spacing
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		
		//instantiate gui elements and provide texts and element colors
		btnConnect = new Button("CONNECT");
		btnConnect.setStyle("-fx-background-color: #B4F7B0;");
		
		lblOpening = new Label("Please select a climate change category you wish to analyze:");
		btnIndustrialization = new Button("INDUSTRIALIZATION");
		btnIndustrialization.setStyle("-fx-background-color: #F6A0DF;");
		btnDeforestation = new Button("DEFORESTATION");
		btnDeforestation.setStyle("-fx-background-color: #F6A0DF;");
		btnWaterScarcity = new Button("WATER SCARCITY");
		btnWaterScarcity.setStyle("-fx-background-color: #F6A0DF;");
		
		imgIn = new ImageView();
		
		//instantiate gui elements and provide texts and element colors
		lblCategory = new Label("Please select the api you would like to implement:");
		btnGrayScale = new Button("GRAYSCALE");
		btnGrayScale.setStyle("-fx-background-color: #B0F5F7;");
		btnRotate = new Button("ROTATE");
		btnRotate.setStyle("-fx-background-color: #B0F5F7;");
		btnErosion = new Button("EROSION");
		btnErosion.setStyle("-fx-background-color: #B0F5F7;");
		btnDilation = new Button("DILATION");
		btnDilation.setStyle("-fx-background-color: #B0F5F7;");
		btnCrop = new Button("CROP");
		btnCrop.setStyle("-fx-background-color: #B0F5F7;");
		btnCanny = new Button("CANNY");
		btnCanny.setStyle("-fx-background-color: #B0F5F7;");
		btnFast = new Button("FAST");
		btnFast.setStyle("-fx-background-color: #B0F5F7;");
		btnOrb = new Button("ORB");
		btnOrb.setStyle("-fx-background-color: #B0F5F7;");
		
		//instantiate gui elements and provide texts and element colors
		textArea = new TextArea();
		textArea.setPrefHeight(70);
		textArea.setPrefWidth(10);
		textArea.setStyle("-fx-background-color: #FF0000;");
		imgOut = new ImageView();
		
		//instantiate gui elements and provide texts and element colors
		lblClosing = new Label("We hope your research was helpful in working towards climate change solutions.");
		lblClosing.setTextFill(Color.web("#FF0000"));
		
		//Add elements to interface
		add(btnConnect, 0, 0);
		
		add(lblOpening, 0, 1);
		add(btnIndustrialization, 1, 2);
		add(btnDeforestation, 2, 2);
		add(btnWaterScarcity, 3, 2);

		add(imgIn, 0, 3);
		add(imgOut, 1, 3);
		
		//Add elements to interface
		add(lblCategory, 0, 4);
		add(btnGrayScale, 1, 5);
		add(btnRotate, 2, 5);
		add(btnErosion, 3, 5);
		add(btnDilation, 4, 5);
		add(btnCrop, 1, 6);
		add(btnCanny, 2, 6);
		add(btnFast, 3, 6);
		add(btnOrb, 4, 6);
		
		//Add elements to interface
		add(textArea, 0, 7);
		
		add(lblClosing, 0, 8);
	}
	
	/**
	 * A method to send an Image file across a DataStream
	 * @param dos , A DataOutputStream that the data is being sent too
	 * @param imageFile, A File that is the image
	 * @param url , A String URL, that represents where the image can be found
	 */
	public void helper(DataOutputStream dos, File imageFile, String url)
	{
		this.imageFile = imageFile;
		String encodedFile = null;
		try 
		{
			//DOS(BOS(OS))
			//read the File into a FileInputStream
			FileInputStream fileInputStreamReader = new FileInputStream(imageFile);
			//Put the file contents into a byte[]
			byte[] bytes = new byte[(int)imageFile.length()];
			fileInputStreamReader.read(bytes);
			//Encode the bytes into a base64 format string
			encodedFile = new String(Base64.getEncoder().encodeToString(bytes));
			//get the bytes of this encoded string
			byte[] bytesToSend = encodedFile.getBytes();

			//Construct a POST HTTP REQUEST
			/** CODE FOR THE POST REQUEST HERE *** 
			 * //read text response
			 */
			dos.write(("POST " + url + " HTTP/1.1\r\n").getBytes());
			dos.write(("Content-Type: " + "application/text\r\n").getBytes());
			dos.write(("Content-Length: " + encodedFile.length() + "\r\n").getBytes());
			dos.write(("\r\n").getBytes());
			dos.write(bytesToSend);
			dos.flush();
			dos.write(("\r\n").getBytes());
			dos.flush();

			fileInputStreamReader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param br, BufferedReader
	 * @return String, which represents image Data
	 */
	public static String base64(BufferedReader br)
	{
		try
		{
			//receiving response (header response first)
			String response = "";
			String line = "";
			while(!(line = br.readLine()).equals(""))
			{
				response += line +"\n";
			}
			System.out.println(response);
	
			//Receive the image data
			String imgData = "";
			while((line = br.readLine())!=null)
			{
				imgData += line;
			}
			System.out.println(imgData);
	
			//Server image response format: (img:b'datareceived')
			String base64Str = imgData.substring(imgData.indexOf('\'') + 1, imgData.lastIndexOf('}') - 1);
			System.out.println(base64Str);
			return base64Str;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param base64Str, String
	 * @return Image
	 */
	public static Image imageHelper(String base64Str)
	{
		//decode the base64 string received
		byte[] decodedString = Base64.getDecoder().decode(base64Str);

		/** CODE FOR EXTRACTING THE BASE64 STRING **/
		/** DECODE THE base64 String received**/
		//Display the image
		Image image = new Image(new ByteArrayInputStream(decodedString));
		return image;
	}
	
	/**
	 * Helper method to connect to server
	 */
	private void connect()
	{
		try 
		{
			//Instantiate streams and socket
			socket = new Socket("localhost", 5000);
			textArea.appendText("Client connected to the server \r\n");
			//bind streams
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os = socket.getOutputStream();
			bos = new BufferedOutputStream(os);
			dos = new DataOutputStream(bos);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
