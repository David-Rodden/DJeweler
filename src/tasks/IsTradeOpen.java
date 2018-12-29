package tasks;

import org.rspeer.runetek.api.component.Shop;

public class IsTradeOpen extends TreeTask {
    IsTradeOpen() {
        super(false);
    }

    @Override
    public boolean validate() {
        return Shop.isOpen();
    }
}
