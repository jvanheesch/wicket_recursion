package com.mycompany;

import com.mycompany.iface.TreeNode;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class UnorderedListTreePanel<N extends TreeNode<N>> extends GenericPanel<N> {
    private static final long serialVersionUID = -5596385918996046779L;

    public UnorderedListTreePanel(String id, IModel<N> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("text", this.getModel()));

        this.add(new UnorderedListTreeListView("children", this.getModel()));
    }

    private class UnorderedListTreeListView extends ListView<N> {
        private static final long serialVersionUID = -6236048229516630926L;

        UnorderedListTreeListView(String id, IModel<N> rootNodeModel) {
            super(id, new LambdaModel<>(rootNodeModel, TreeNode::getChildren));
        }

        @Override
        protected void populateItem(ListItem<N> item) {
            UnorderedListTreePanel<N> childPanel = new UnorderedListTreePanel<>("childPanel", item.getModel());
            childPanel.setRenderBodyOnly(true);
            item.add(childPanel);
        }
    }
}
