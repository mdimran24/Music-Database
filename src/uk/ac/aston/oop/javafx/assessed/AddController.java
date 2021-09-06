package uk.ac.aston.oop.javafx.assessed;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import uk.ac.aston.oop.javafx.assessed.model.CD;

public class AddController {
	@FXML private Label playTime;
	@FXML private Label numTracks;
	@FXML private Slider sliderPT;
	@FXML private Slider sliderNT;
	@FXML private TextField inputTitle;
	@FXML private TextField inputArtist;
	@FXML private CheckBox owned;
	private boolean confirmed = false;
	int PT;
	int NT;
	
	public AddController() {
		
	}
	
	@FXML
	public void initialize() {
//		sliderPT.valueProperty().addListener(property, oldValue, newValue);
		sliderPT.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				playTime.setText("Playing time: "+ String.valueOf(newValue.intValue()));
				PT = newValue.intValue();
			}
		});
		sliderNT.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				numTracks.setText("Number of tracks: "+ String.valueOf(newValue.intValue()));
				NT = newValue.intValue();
			}
		});	
		
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}
	
	@FXML
	public void cancelPressed() {
		playTime.getScene().getWindow().hide();
	}
	
	@FXML
	public CD createPressed() {
		confirmed = true;
		//System.out.println(owned.selectedProperty());
		CD nCD = new CD(inputTitle.getText(), inputArtist.getText(), NT, PT);
		nCD.setOwn(owned.selectedProperty().getValue());
		playTime.getScene().getWindow().hide();
		return nCD;
		
	}
}
