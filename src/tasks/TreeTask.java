package tasks;

import org.rspeer.script.task.Task;

public abstract class TreeTask extends Task {
    private final boolean isLeaf;
    private TreeTask left, right;

    TreeTask(final boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    TreeTask getLeft() {
        return left;
    }

    TreeTask getRight() {
        return right;
    }

    TreeTask setLeft(final TreeTask left) {
        return this.left = left;
    }

    TreeTask setRight(final TreeTask right) {
        return this.right = right;
    }

    @Override
    public abstract boolean validate();

    @Override
    public int execute() {
        return 0;
    }

}
