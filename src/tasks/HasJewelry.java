package tasks;

import org.rspeer.runetek.api.component.tab.Inventory;

public class HasJewelry extends TreeTask {
    HasJewelry() {
        super(false);
    }

    @Override
    public boolean validate() {
        return Inventory.contains("Diamond ring");
    }
}
