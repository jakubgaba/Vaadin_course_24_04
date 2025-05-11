package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {
    
    public HomeView() {
        VerticalLayout menu = new VerticalLayout();
    }
}
