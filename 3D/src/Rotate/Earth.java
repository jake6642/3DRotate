package Rotate;

import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;

/* creates a sphere and applies a material to it */
public class Earth extends Sphere {
	public Earth(double rad) {
		super(rad);
		setEarth(this);
	}

	/* This method applies the earth skin to the sphere */
	private void setEarth(Shape3D earth) {

		//get input files
		InputStream diffuse = getClass().getClassLoader().getResourceAsStream("texture.jpg");
		InputStream bump = getClass().getClassLoader().getResourceAsStream("normal.jpg");
		InputStream specular = getClass().getClassLoader().getResourceAsStream("specular.jpg");

		//apply the material to the sphere
		PhongMaterial earthMaterial = new PhongMaterial();
		earthMaterial.setDiffuseMap(new Image(diffuse));
		earthMaterial.setBumpMap(new Image(bump));
		earthMaterial.setSpecularMap(new Image(specular));
		earth.setMaterial(earthMaterial);
	}

}
