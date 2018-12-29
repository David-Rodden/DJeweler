package tasks;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;

public class WalkToJeweler extends TreeTask {
    private final Area shopArea;

    WalkToJeweler(final JewelryTasks controller) {
        super(true);
        shopArea = controller.getShopArea();
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public int execute() {

        if (!Movement.isDestinationSet()) {
            Movement.walkTo(shopArea.getCenter());
            Time.sleepUntil(Movement::isDestinationSet, 1000);
        }
        return super.execute();
    }

}
