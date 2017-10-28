package com.mycompany;

import com.mycompany.iface.SimpleNamedNode;
import com.mycompany.impl.SimpleNamedNodeImpl;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UnorderedListTreePage extends WebPage {
    private static final long serialVersionUID = 687301382217727377L;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        SimpleNamedNode root =
                new SimpleNamedNodeImpl("root")
                        .addChild(new SimpleNamedNodeImpl("1")
                                .addChild(new SimpleNamedNodeImpl("11")
                                        .addChild(new SimpleNamedNodeImpl("111")))
                                .addChild(new SimpleNamedNodeImpl("12")
                                        .addChild(new SimpleNamedNodeImpl("121"))
                                        .addChild(new SimpleNamedNodeImpl("122"))))
                        .addChild(new SimpleNamedNodeImpl("2")
                                .addChild(new SimpleNamedNodeImpl("21")
                                        .addChild(new SimpleNamedNodeImpl("211")
                                                .addChild(new SimpleNamedNodeImpl("2111"))))
                                .addChild(new SimpleNamedNodeImpl("22")
                                        .addChild(new SimpleNamedNodeImpl("221"))
                                        .addChild(new SimpleNamedNodeImpl("222"))));


        this.add(new UnorderedListTreePanel<>("tree", createModelForRoot(root)));
    }

    private static IModel<SimpleNamedNode> createModelForRoot(SimpleNamedNode root) {
        return new LoadableDetachableModel<SimpleNamedNode>() {
            private static final long serialVersionUID = -5537618884413932479L;

            @Override
            protected SimpleNamedNode load() {
                return root;
            }
        };
    }
}
