package tasks;

import org.rspeer.runetek.api.movement.position.Area;

public class JewelryTasks {
    private static final int KILL_PROCESS = -1;
    private final Area shopArea;
    private final TreeTask head;

    public JewelryTasks() {
        shopArea = Area.rectangular(0, 0, 0, 0);    // Find the correct Area
        head = new HasJewelry();
        TreeTask left = head.setLeft(new HasMoney()), right = head.setRight(new IsAtJeweler(this));
        // Configure the left side of the tree
        left = left.setRight(new IsAtGrandExchange());
        left.setLeft(new WalkToGrandExchange());
        left = left.setRight(new IsExchangeOpen());
        left.setLeft(new OpenExchange());
        left.setRight(new PutInBuyOffer());
        // Now configure the right side of the tree
        right.setLeft(new WalkToJeweler(this));
        right = right.setRight(new IsTradeOpen());
        right.setLeft(new OpenTrade());
        right.setLeft(new BuyAmount());
        // The entire conditional tree has been constructed, tasks can now be invoked
    }

    public int traverseTree() {
        TreeTask current = head;
        while (current != null && !current.isLeaf())
            current = current.validate() ? current.getRight() : current.getLeft();
        return current != null ? current.execute() : KILL_PROCESS;
    }

    Area getShopArea() {
        return shopArea;
    }
}
