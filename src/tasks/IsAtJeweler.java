package tasks;

import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;

public class IsAtJeweler extends TreeTask {
    private final Area shopArea;

    IsAtJeweler(final JewelryTasks controller) {
        super(false);
        shopArea = controller.getShopArea();
    }

    @Override
    public boolean validate() {
        return shopArea.contains(Players.getLocal());
    }
}
