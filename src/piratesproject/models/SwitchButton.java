package piratesproject.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class SwitchButton extends Label {

    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);

    public SwitchButton() {
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(80);
        switchBtn.setOnAction((ActionEvent t) -> {
            switchedOn.set(!switchedOn.get());
        });

        setGraphic(switchBtn);

        switchedOn.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov,
                    Boolean t, Boolean t1) {
                if (t1) {
                    setText("ON");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setFont(new Font( 24.0));
                    setContentDisplay(ContentDisplay.RIGHT);
                } else {
                    setText("OFF");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                    setFont(new Font( 24.0));
                }
            }
        });

        switchedOn.set(false);
    }
    
    public boolean getState(){
        if(getText().equals("OFF")){
            return false;
        }
        return true;
    }

    public SimpleBooleanProperty switchOnProperty() {
        return switchedOn;
    }

    public void setOnAction(EventHandler<MouseEvent> eventHandler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
