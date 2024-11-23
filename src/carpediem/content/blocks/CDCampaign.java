package carpediem.content.blocks;

import carpediem.content.*;
import carpediem.world.blocks.campaign.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;

public class CDCampaign {
    public static Block
    archiveVaultTerminal,
    cargoLoadingPadT0, cargoLoadingPadT1,
    launchPlatformT0, launchPlatformT1, launchPlatformT2;

    public static void load() {
        archiveVaultTerminal = new ArchiveBlock("archive-vault-terminal") {{
            requirements(Category.effect, BuildVisibility.editorOnly, ItemStack.with());
            size = 5;
        }};

        launchPlatformT0 = new LaunchPlatform("launch-platform-t0") {{
            requirements(Category.effect, BuildVisibility.campaignOnly, ItemStack.with());
            size = 5;
            itemCapacity = 100;
            regionSuffix = "-dark";

            launchBlocks.add(CDStorage.landingPodT0);

            consumeItem(CDItems.sulfur, 100);
        }};
    }
}
