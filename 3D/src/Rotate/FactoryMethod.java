package Rotate;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

public class FactoryMethod {
	static Shape3D shape;

	public void factory(String type, VBox shapeBox) {

		switch (type) {
		case Const.BOX:
			shape = new Box(250, 250, 250);
			shape.setMaterial(getMaterial(1));
			break;
		case Const.CYL:
			shape = new Cylinder(150, 300, 300);
			shape.setMaterial(getMaterial(2));
			break;
		case Const.ETH:
			shape = new Earth(150);
			break;
		case Const.SPH:
			shape = new Sphere(150);
			shape.setMaterial(getMaterial(4));
			break;
		case Const.TRI:
			shape = new Prism(150, 300);
			shape.setMaterial(getMaterial(3));
			break;
		default:
			shape = new Box(100, 100, 100);
			break;
		}
		Driver.resetSlides();
		shape.setTranslateY(100);
		shapeBox.getChildren().add(shape);
	}

	private PhongMaterial getMaterial(int color) {
		PhongMaterial mat = new PhongMaterial();
		switch (color) {
		case 1:
			mat.setDiffuseColor(Color.DARKGOLDENROD);
			mat.setSpecularColor(Color.WHITE);
			break;
		case 2:
			mat.setDiffuseColor(Color.BLANCHEDALMOND);
			mat.setSpecularColor(Color.WHITE);
			break;
		case 3:
			mat.setDiffuseColor(Color.DARKORANGE);
			mat.setSpecularColor(Color.WHITE);
			break;
		case 4:
			mat.setDiffuseColor(Color.LAWNGREEN);
			mat.setSpecularColor(Color.BURLYWOOD);
		}
		return mat;
	}

}
