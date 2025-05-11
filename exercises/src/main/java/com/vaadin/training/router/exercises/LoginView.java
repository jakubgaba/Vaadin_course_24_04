package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("login")
public class LoginView extends Composite<Div> implements HasComponents {

    private final Div loginDiv = new Div();
    public LoginView() {
        loginDiv.setWidthFull();
        loginDiv.getStyle().set("text-align", "center");
        Button loginButton = new Button("Login", e -> {
            VaadinSession.getCurrent().setAttribute("userLoggedIn", true);
            UI.getCurrent().navigate("");
            System.out.println("Session ID: " + VaadinSession.getCurrent().getSession().getId());
        });
        loginDiv.add(loginButton);
        add(loginDiv);
    }

}
// 82DFB64CA8C6D08BF5ADBD3FAC4A00E5