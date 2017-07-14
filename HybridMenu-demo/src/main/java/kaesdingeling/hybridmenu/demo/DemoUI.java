package kaesdingeling.hybridmenu.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.HybridMenuBuilder;
import kaesdingeling.hybridmenu.data.MenuItemBuilder;
import kaesdingeling.hybridmenu.demo.page.HomePage;
import kaesdingeling.hybridmenu.demo.page.MemberPage;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;
import kaesdingeling.hybridmenu.page.DefaultPage;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("HybridMenu Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = true, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        HybridMenu hybridMenu = HybridMenuBuilder.get()
                .withItemTitle(EMenuPosition.LEFT, "General", true)
                .withItem(EMenuPosition.LEFT, "Home", VaadinIcons.HOME, HomePage.class, true)
                .withItem(EMenuPosition.LEFT, "Default", VaadinIcons.COG, DefaultPage.class, true)
                .withItem(
                        MenuItemBuilder.get("Home", VaadinIcons.FILE_TREE, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withStyleName(ETopMenuPosition.RIGHT.toString())
                                .build())
                .withItem(
                        MenuItemBuilder.get("Home", VaadinIcons.FILE_TREE, HomePage.class, true)
                                .withSubMenuItem(
                                        MenuItemBuilder.get("Home", VaadinIcons.HOME, HomePage.class, true)
                                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                                .build())
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("Home", VaadinIcons.HOME, HomePage.class, true)
                                .withStyleName(ETopMenuPosition.RIGHT.toString())
                                .build()
                )
                .withItem(null, VaadinIcons.SIGN_OUT.getHtml() + "Logout", MemberPage.class, false)
                .build();
    	/*H
        ybridMenu hybridMenu = new HybridMenu();
    	hybridMenu.createItemTitle(EMenuPosition.LEFT, "General", true);
    	hybridMenu.createItem(EMenuPosition.LEFT, "Home", FontAwesome.HOME, HomePage.class, true);
    	hybridMenu.createItem(EMenuPosition.LEFT, "Settings", FontAwesome.COG, SettingsPage.class, true);
    	MenuItem subMenu = hybridMenu.createItem(EMenuPosition.LEFT, "Settings", FontAwesome.COG, null, false);
    	MenuItem settingsPage = hybridMenu.createItem(EMenuPosition.LEFT, "Settings", FontAwesome.COG, SettingsPage.class, false);
    	MenuItem groupPage = hybridMenu.createItem(EMenuPosition.LEFT, "Groups", FontAwesome.USERS, null, false);
    	MenuItem memberPage = hybridMenu.createItem(EMenuPosition.LEFT, "Member", FontAwesome.USER, MemberPage.class, false);
    	
    	subMenu.addSubMenuItem(settingsPage);
    	subMenu.addSubMenuItem(groupPage);
    	subMenu.addSubMenuItem(memberPage);
    	
    	hybridMenu.addItem(subMenu);
    	
    	hybridMenu.createItemIconTitle(EMenuPosition.LEFT, FontAwesome.DASHBOARD.getHtml() + "General", true);
    	hybridMenu.createItem(EMenuPosition.LEFT, "Home", FontAwesome.HOME, HomePage.class, true);
    	hybridMenu.createItem(EMenuPosition.LEFT, "Settings", FontAwesome.COG, SettingsPage.class, true);
    	hybridMenu.createItem(EMenuPosition.LEFT, "Default", FontAwesome.COG, DefaultPage.class, true);
    	
    	MenuItem topHomePage = hybridMenu.createItem(EMenuPosition.TOP, "Home", FontAwesome.HOME, HomePage.class, true);
    	
    	topHomePage.getButton().addStyleName(ETopMenuPosition.RIGHT.toString());
    	
    	
    	MenuItem userSettings = hybridMenu.createItem(EMenuPosition.TOP, new ThemeResource("images/profilDummy.jpg"), false);
    	MenuItem logout = hybridMenu.createItem(null, FontAwesome.SIGN_OUT.getHtml() + "Logout", MemberPage.class, false);
    	
    	userSettings.getButton().addStyleName("buttonWithoutCaption");
    	userSettings.getButton().addStyleName(ETopMenuPosition.RIGHT.toString());
    	userSettings.addSubMenuItem(logout);
    	
    	hybridMenu.addItem(userSettings);*/

        setContent(hybridMenu);
        VaadinSession.getCurrent().setAttribute(HybridMenu.class, hybridMenu);
    }
}
