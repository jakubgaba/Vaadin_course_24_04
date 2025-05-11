package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;

public class LoginView extends Composite<Div> implements HasComponents  {
   
    Button loginButton = new Button("Login", e -> {
        
    });

    @Override
    public Element getElement() {
        // TODO Auto-generated method stub
        return null;
    }
}
