package Rotate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Driver extends Application {

	// globally declared shape
	Shape3D shape;

	VBox mainBox;
	VBox shapeBox;
	static Slider xSlider;
	static Slider ySlider;
	static Slider zSlider;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		buildBoxes();
		Scene scene = new Scene(mainBox, 600, 600);

		/* Set the Stage */
		stage.setScene(scene);
		stage.setMinHeight(scene.getHeight() + 20);
		stage.setMinWidth(scene.getWidth() + 10);
		stage.setTitle("Factory Demo");
		stage.show();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void buildBoxes() {
		mainBox = new VBox();
		shapeBox = new VBox();
		Insets inset = new Insets(5, 10, 5, 10);
		mainBox.setAlignment(Pos.TOP_CENTER);
		mainBox.setBackground(
				new Background(new BackgroundFill(Color.color(.12f, .12f, .12f), CornerRadii.EMPTY, Insets.EMPTY)));
		shapeBox.setPadding(new Insets(50, 50, 50, 50));
		shapeBox.setAlignment(Pos.BOTTOM_CENTER);
		/* Create the slides */
		xSlider = new Slider(0, 3.6, 0);
		ySlider = new Slider(0, 3.6, 0);
		zSlider = new Slider(0, 3.6, 0);
		xSlider.setPadding(inset);
		ySlider.setPadding(inset);
		zSlider.setPadding(inset);
		/* Add the items to the combobox */
		ObservableList<String> options = FXCollections.observableArrayList(Const.BOX, Const.CYL, Const.ETH, Const.SPH,
				Const.TRI);
		ComboBox combo = new ComboBox(options);
		combo.autosize();
		// set the default value
		combo.setValue(Const.BOX);

		mainBox.getChildren().addAll(xSlider, ySlider, zSlider, combo, shapeBox);
		FactoryMethod fm = new FactoryMethod();
		fm.factory(Const.BOX, shapeBox);

		// listener for combobox
		combo.setOnAction((Event ev) -> {
			if (shapeBox.getChildren().size() > 0) {
				shapeBox.getChildren().remove(shapeBox.getChildren().size() - 1);
			}
			fm.factory(combo.getSelectionModel().getSelectedItem().toString(), shapeBox);
		});

		// slider for x rotation
		xSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (new_val.doubleValue() < old_val.doubleValue())
					rotateIt(Rotate.X_AXIS, -new_val.doubleValue());
				else
					rotateIt(Rotate.X_AXIS, new_val.doubleValue());
			}
		});
		// slider for y rotation
		ySlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (new_val.doubleValue() < old_val.doubleValue())
					rotateIt(Rotate.Y_AXIS, -new_val.doubleValue());
				else
					rotateIt(Rotate.Y_AXIS, new_val.doubleValue());
			}
		});
		// slider for z rotation
		zSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (new_val.doubleValue() < old_val.doubleValue())
					rotateIt(Rotate.Z_AXIS, -new_val.doubleValue());
				else
					rotateIt(Rotate.Z_AXIS, new_val.doubleValue());
			}
		});

	}

	/* method that rotates based on slider input */
	private void rotateIt(Point3D dir, double val) {
		Rotate rotateAbout = new Rotate(val, dir);
		FactoryMethod.shape.getTransforms().add(rotateAbout);
	}

	static void resetSlides() {
		xSlider.setValue(0);
		ySlider.setValue(0);
		zSlider.setValue(0);
	}

}
