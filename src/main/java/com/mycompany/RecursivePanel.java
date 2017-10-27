package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class RecursivePanel extends Panel {
    private static final long serialVersionUID = -4552450506746361823L;

    public RecursivePanel(String id, int nb) {
        super(id);

        this.add(new Label("label", nb));

        this.add(nb > 0 ? new RecursivePanel("child", nb - 1) : new Label("child", "the end!"));
    }
}
