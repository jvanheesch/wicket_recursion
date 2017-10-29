package com.mycompany;

import com.mycompany.iface.TreeNode;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;

public class DivTreePanel<N extends TreeNode<N>> extends GenericPanel<N> {
    private static final long serialVersionUID = -5596385918996046779L;

    private static final String CSS_FILENAME = "DivTreePanel.css";

    public DivTreePanel(String id, IModel<N> model) {
        super(id, model);
    }

    // N required for type inference
    @SuppressWarnings("Convert2Diamond")
    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("text", this.getModel()));

        this.add(new FunctionalMarkupRepeater<N>("children", new LambdaModel<>(this.getModel(), TreeNode::getChildren), DivTreePanel::new));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(new CssResourceReference(WicketApplication.class, CSS_FILENAME)));
    }
}
