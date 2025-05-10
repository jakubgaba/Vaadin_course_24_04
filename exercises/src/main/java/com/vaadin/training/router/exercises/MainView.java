package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

@Route("")
@RouteAlias("menu")
public class MainView extends Composite<VerticalLayout> implements HasComponents {
    
    private final Div childWrapper = new Div();
    public MainView(){
        getContent().setSizeFull();
        H1 header = new H1("Header");
        add(header);
        
        HorizontalLayout menu = new HorizontalLayout();
        VerticalLayout sideMenu = new VerticalLayout();
        menu.setWidth("20%");
        sideMenu.add(new RouterLink("Home", HomeView.class));
        sideMenu.add(new RouterLink("Lottery", LotteryView.class));
        menu.add(sideMenu);
        
        menu.add(childWrapper);
        menu.setFlexGrow(1,childWrapper);

        add(menu);

        H1 footer = new H1("Footer");
        add(footer);
    }
}
