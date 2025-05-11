package com.vaadin.training.router.exercises;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.charts.model.TextAlign;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;


public class MainView extends Composite<VerticalLayout> implements HasComponents, RouterLayout {
    
    private final Div childWrapper = new Div();
    public MainView(){
        getContent().setSizeFull();
        H1 header = new H1("Header");
        header.getStyle().setBackground( "LightBlue");
        header.setWidth("50%");
        header.getStyle().set("text-align", "center");
        add(header);
        
        HorizontalLayout menu = new HorizontalLayout();
        VerticalLayout sideMenu = new VerticalLayout();
        menu.setWidth("20%");
        sideMenu.add(new RouterLink("Home", HomeView.class));
        sideMenu.add(new RouterLink("Lottery", LotteryView.class));
        sideMenu.getStyle().set("background", "lightgray");

        menu.add(sideMenu);
        
        menu.add(childWrapper);
        menu.setFlexGrow(1,childWrapper);

        add(menu);

        H1 footer = new H1("Footer");
        footer.getStyle().setBackground( "LightBlue");
        footer.setWidth("50%");
        footer.getStyle().set("text-align", "center");
        add(footer);

        getContent().setFlexGrow(1, menu);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, header);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, footer);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH, menu);

    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
       childWrapper.getElement().appendChild(content.getElement());
    }
}
