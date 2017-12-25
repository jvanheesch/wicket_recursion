package com.github.jvanheesch;

import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
    private static final long serialVersionUID = -8896769873107976128L;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new RecursivePanel("recursivePanel", 7));
    }
}
