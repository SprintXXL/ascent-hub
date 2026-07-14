import com.sprintxxl.ascenthub.gui.AscentGUI;
import com.sprintxxl.ascenthub.gui.cosmetic.CosmeticData;
import com.sprintxxl.ascenthub.gui.icons.IconData;
import com.sprintxxl.ascenthub.gui.slots.SlotData;

import static com.sprintxxl.ascenthub.gui.icons.IconDefinition.progressIcon;
import static com.sprintxxl.ascenthub.gui.icons.Icons.FLAME;
import static com.sprintxxl.ascenthub.gui.slots.SlotDefinition.largeSlot;
import static com.sprintxxl.ascenthub.gui.slots.SlotDefinition.slot;
import static com.sprintxxl.ascenthub.gui.slots.SlotGroup.inputSlots;
import static com.sprintxxl.ascenthub.gui.slots.SlotGroup.outputSlots;

public class TestGuiDefinition {

    public static final AscentGUI TEST =
            new AscentGUI(
                    new CosmeticData(
                            "#8518f4",
                            "Wooden Chest"
                    ),
                    new IconData(
                            progressIcon(FLAME, -1, -1, -1, -1)
                    ),
                    new SlotData(
                            inputSlots(
                                    slot(30, 30)
                            ),
                            outputSlots(
                                    largeSlot(30, 30)
                            )
                    )
            );
}
