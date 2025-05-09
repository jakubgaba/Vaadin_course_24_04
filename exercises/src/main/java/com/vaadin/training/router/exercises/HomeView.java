package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

@Route("")
@RouteAlias("home")
public class HomeView extends Composite<VerticalLayout> implements HasComponents {
    
    public HomeView() {
        VerticalLayout menu = new VerticalLayout();
        menu.add(new RouterLink("Home", HomeView.class));
        menu.add(new RouterLink("Lottery", LotteryView.class));
        getContent().add(menu);
    }
}
