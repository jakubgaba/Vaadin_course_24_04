package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("home")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {
    
    public HomeView() {
        VerticalLayout menu = new VerticalLayout();
    }
}
