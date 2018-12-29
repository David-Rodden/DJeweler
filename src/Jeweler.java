import org.rspeer.script.Script;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import tasks.JewelryTasks;

@ScriptMeta(name = "DJeweler", category = ScriptCategory.MONEY_MAKING, developer = "Dungeonqueer", desc = "Sells jewelry for profit")
public class Jeweler extends Script {
    private JewelryTasks tasks;

    @Override
    public void onStart() {
        tasks = new JewelryTasks();
    }

    @Override
    public int loop() {
        return tasks.traverseTree();
    }


}
