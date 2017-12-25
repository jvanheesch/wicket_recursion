package com.github.jvanheesch;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends WebPage> getHomePage() {
        return DropDownPage.class;
    }

    @Override
    protected void init() {
        super.init();

        this.getMarkupSettings().setStripWicketTags(true);

        Bootstrap.install(this, new BootstrapSettings());
    }
}
