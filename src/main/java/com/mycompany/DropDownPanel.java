package com.mycompany;

import com.mycompany.iface.TreeNode;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class DropDownPanel<N extends TreeNode<N>> extends GenericPanel<N> {
    private static final long serialVersionUID = -5596385918996046779L;

    public DropDownPanel(String id, IModel<N> model) {
        super(id, model);
    }

    // N required for type inference
    @SuppressWarnings("Convert2Diamond")
    @Override
    protected void onInitialize() {
        super.onInitialize();

        WebMarkupContainer button = new WebMarkupContainer("button");
        this.add(button);

        button.add(new Label("buttonText", this.getModel()));

        WebMarkupContainer ul = new WebMarkupContainer("ul");
        this.add(ul);

        ul.add(new FunctionalMarkupRepeater<N>("children", new LambdaModel<>(this.getModel(), TreeNode::getChildren), UnorderedListTreePanel::new));
    }
}
