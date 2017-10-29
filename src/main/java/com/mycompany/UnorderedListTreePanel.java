package com.mycompany;

import com.mycompany.iface.TreeNode;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class UnorderedListTreePanel<N extends TreeNode<N>> extends GenericPanel<N> {
    private static final long serialVersionUID = -5596385918996046779L;

    public UnorderedListTreePanel(String id, IModel<N> model) {
        super(id, model);
    }

    // N required for type inference
    @SuppressWarnings("Convert2Diamond")
    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("text", this.getModel()));

        this.add(new FunctionalMarkupRepeater<N>("children", new LambdaModel<>(this.getModel(), TreeNode::getChildren), UnorderedListTreePanel::new));
    }
}
