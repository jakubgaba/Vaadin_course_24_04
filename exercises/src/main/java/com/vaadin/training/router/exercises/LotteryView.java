package com.vaadin.training.router.exercises;

import java.util.Random;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

@Route("lottery")
public class LotteryView extends Composite<Div> implements HasComponents, HasUrlParameter<String> {

    private final Div lotteryResult = new Div();
    private final TextField numberInput = new TextField();

    public LotteryView() {
        add(new Span("Lottery View"));

        HorizontalLayout inputBar = new HorizontalLayout();
        inputBar.add(numberInput);
        numberInput.setPlaceholder("Input your number");
        
        Button button = new Button("Try my luck!", e -> {
            final String value = numberInput.getValue();
            if (isNotEmpty(value)) {
                try {
                    final Integer number = Integer.parseInt(value);
                    validate(number);
                    updateContent(number);
                    UI.getCurrent().navigate("lottery/" + number);
                } catch (NumberFormatException ex) {
                    lotteryResult.setText("Please enter a valid number");
                } catch (InvalidValueException ex) {
                    lotteryResult.setText("Please enter a number between 1 and 10");
                }
            }
        });
        
        button.setEnabled(false);
        numberInput.addValueChangeListener(e -> {
            button.setEnabled(isNotEmpty(e.getValue()));
            UI.getCurrent().getPage().setTitle("Lottery view: " + e.getValue());
        });
        inputBar.add(button);
        add(inputBar);
        add(lotteryResult);
    }

    private void updateContent(Integer number) {
        if (number == null) {
            lotteryResult.setText("");
        } else {
            final int luckyNumber = new Random().nextInt(10) + 1;
            StringBuilder builder = new StringBuilder();
            if (number.equals(luckyNumber)) {
                builder.append("Congrats, you win! ");
            } else {
                builder.append("Sorry, better luck next time. ");
            }
            builder.append("Your number is: ").append(number).append(", the lucky number is: ").append(luckyNumber);

            lotteryResult.setText(builder.toString());
        }
    }

    private void validate(Integer number) {
        if (number != null) {
            if (number < 1 || number > 10) {
                throw new InvalidValueException();
            }
        }
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            try {
                Integer number = Integer.parseInt(parameter);
                try {
                    //here is the main set up as parameter !
                    numberInput.setValue(parameter);
                } catch (InvalidValueException ex) {
                    lotteryResult.setText("URL parameter must be between 1 and 10");
                }
            } catch (NumberFormatException ex) {
                lotteryResult.setText("Invalid URL parameter: must be a number");
            }
        }
    }
    
    // Add the missing InvalidValueException class
    private static class InvalidValueException extends RuntimeException {
        // Simple custom exception
    }
}