package Rotate;

import Rotate.Const.MATERIAL;
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
			shape.setMaterial(getMaterial(MATERIAL.GOLD));
			break;
		case Const.CYL:
			shape = new Cylinder(150, 300, 300);
			shape.setMaterial(getMaterial(MATERIAL.DIAMOND));
			break;
		case Const.ETH:
			shape = new Earth(150);
			break;
		case Const.SPH:
			shape = new Sphere(150);
			shape.setMaterial(getMaterial(MATERIAL.GREEN));
			break;
		case Const.TRI:
			shape = new Prism(150, 300);
			shape.setMaterial(getMaterial(MATERIAL.ORANGE));
			break;
		default:
			shape = new Box(100, 100, 100);
			break;
		}
		Driver.resetSlides();
		shape.setTranslateY(100);
		shapeBox.getChildren().add(shape);
	}

	
	/* This method will return PhongMaterial with the color requested */
	private PhongMaterial getMaterial(MATERIAL material) {
		PhongMaterial mat = new PhongMaterial();
		
		switch (material) {
		case GOLD:
			mat.setDiffuseColor(Color.DARKGOLDENROD);
			mat.setSpecularColor(Color.WHITE);
			break;
		case DIAMOND:
			mat.setDiffuseColor(Color.BLANCHEDALMOND);
			mat.setSpecularColor(Color.WHITE);
			break;
		case ORANGE:
			mat.setDiffuseColor(Color.DARKORANGE);
			mat.setSpecularColor(Color.WHITE);
			break;
		case GREEN:
			mat.setDiffuseColor(Color.LAWNGREEN);
			mat.setSpecularColor(Color.BURLYWOOD);
		}
		return mat;
	}

}
