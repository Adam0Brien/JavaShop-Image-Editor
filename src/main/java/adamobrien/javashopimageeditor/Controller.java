package adamobrien.javashopimageeditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    ImageView view;

    Image imageChosen;
    Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void exit(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    ImageView originalView;
    @FXML
    ImageView greyScaleView;
    @FXML
    ImageView redScaleView;
    @FXML
    ImageView greenScaleView;
    @FXML
    ImageView blueScaleView;

    @FXML
    Label fileName;
    @FXML
    Label fileSize;


    public void open(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose image file");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            file.toURI();

            Image image = new Image(file.toURI().toString(), view.getFitWidth(), view.getFitHeight(), false, true);
            view.setImage(image);

            originalView.setImage(image);

            greyScaleView.setImage(image);
            greyScale(greyScaleView);

            redScaleView.setImage(image);
            redScale(redScaleView);

            greenScaleView.setImage(image);
            greenScale(greenScaleView);


            blueScaleView.setImage(image);
            blueScale(blueScaleView);

            fileName.setText(file.getName());

            fileSize.setText(file.length() +"KB");




        }


    }

    public void setGreyScale(ActionEvent event) {
        greyScale(view);

    }

    public void greyScale(ImageView imageView) throws IndexOutOfBoundsException {


        try {
            //get image width and height
            int width = (int) imageView.getImage().getWidth();
            int height = (int) imageView.getImage().getHeight();
            byte[] buffer = new byte[width * height * 4];
            WritableImage ii = new WritableImage(width, height);

            Image greyScaled = imageView.getImage();
            //read image
            //Image i = imageChosen;

            imageView.getImage().getPixelReader().getPixels(0,
                    0,
                    width,
                    height,
                    PixelFormat.getByteBgraInstance(),
                    buffer,
                    0,
                    width * 4);


            //convert to grayscale
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = imageView.getImage().getPixelReader().getArgb(x, y);

                    int a = (p >> 24) & 255;
                    int r = (p >> 16) & 255;
                    int g = (p >> 8) & 255;
                    int b = p & 255;

                    //calculate average
                    int avg = (r + g + b) / 3;

                    //replace RGB value with avg
                    p = (a << 24) | (avg << 16) | (avg << 8) | avg;


                    //img.setRGB(x, y, p);
                    ii.getPixelWriter().setArgb(x, y, p);
                }
            }
            imageView.setImage(ii);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void redScale(ImageView imageView) throws IndexOutOfBoundsException {

        try {
            //get image width and height
            int width = (int) imageView.getImage().getWidth();
            int height = (int) imageView.getImage().getHeight();
            byte[] buffer = new byte[width * height * 4];
            WritableImage writer = new WritableImage(width, height);


            imageView.getImage().getPixelReader().getPixels(0, 0, width, height, PixelFormat.getByteBgraInstance(),
                    buffer,
                    0,
                    width * 4);

            //convert to redScale
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = imageView.getImage().getPixelReader().getArgb(x, y);

                    int a = (p >> 24) & 255;
                    int r = (p >> 16) & 255;

                    p = (a << 24) | (r << 16) | (0 << 8);

                    writer.getPixelWriter().setArgb(x, y, p);
                }
            }
            imageView.setImage(writer);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void greenScale(ImageView imageView) throws IndexOutOfBoundsException {

        try {
            //get image width and height
            int width = (int) imageView.getImage().getWidth();
            int height = (int) imageView.getImage().getHeight();
            byte[] buffer = new byte[width * height * 4];
            WritableImage writer = new WritableImage(width, height);


            imageView.getImage().getPixelReader().getPixels(0,
                    0,
                    width,
                    height,
                    PixelFormat.getByteBgraInstance(),
                    buffer,
                    0,
                    width * 4);


            //convert to greenScale
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = imageView.getImage().getPixelReader().getArgb(x, y);

                    int a = (p >> 24) & 255;
                    int g = (p >> 8) & 255;

                    p = (a << 24) | (0 << 16) | (g << 8); //bits shift and leaves only a + g , 16 is where red should be but it is set to 0

                    writer.getPixelWriter().setArgb(x, y, p);
                }
            }
            imageView.setImage(writer);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void blueScale(ImageView imageView) throws IndexOutOfBoundsException {

        try {
            //get image width and height
            int width = (int) imageView.getImage().getWidth();
            int height = (int) imageView.getImage().getHeight();
            byte[] buffer = new byte[width * height * 4];
            WritableImage writer = new WritableImage(width, height);


            imageView.getImage().getPixelReader().getPixels(0,
                    0,
                    width,
                    height,
                    PixelFormat.getByteBgraInstance(),
                    buffer,
                    0,
                    width * 4);


            //convert to blueScale
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = imageView.getImage().getPixelReader().getArgb(x, y);

                    int a = (p >> 24) & 255;
                    int b = p & 255;


                    //set new RGB
                    p = (a << 24) | (0 << 16) | (0 << 8) | b;


                    //img.setRGB(x, y, p);
                    writer.getPixelWriter().setArgb(x, y, p);
                }
            }
            imageView.setImage(writer);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


//    public void brightnessSlider() {
//
//        ColorAdjust colorAdjust = new ColorAdjust();
//
//        colorAdjust.setBrightness(0.9);
//
//
//    }
//


    @FXML
    Slider hueSlider;

    public void hueChanger(ActionEvent event) {
        try {


            //get image width and height
            int width = (int) view.getImage().getWidth();
            int height = (int) view.getImage().getHeight();
            byte[] buffer = new byte[width * height * 4];
            WritableImage writer = new WritableImage(width, height);


            // Color hue = imageView.getImage().getPixelReader().getArgb((int)width,height);


            view.getImage().getPixelReader().getPixels(0,
                    0,
                    width,
                    height,
                    PixelFormat.getByteBgraInstance(),
                    buffer,
                    0,
                    width * 4);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = view.getImage().getPixelReader().getArgb(x, y);


                    System.out.println(hueSlider.getValue());


                }


            }
        }catch(Exception e){
            System.out.println("Error:" + e);
        }
    }
}