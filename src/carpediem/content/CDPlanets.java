package carpediem.content;

import arc.graphics.*;
import carpediem.content.blocks.*;
import carpediem.maps.planet.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;

public class CDPlanets {
    public static Planet asphodel;

    public static void load() {
        asphodel = new Planet("asphodel", Planets.sun, 1f, 1) {{
            alwaysUnlocked = true;
            generator = new AsphodelPlanetGenerator();

            meshLoader = () -> new HexMesh(this, 6);
            // TODO redo this someday
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, -0.01f, 5, new Color().set(Pal.darkerGray).mul(0.9f).a(0.6f), 2, 0.45f, 0.9f, 0.62f),
                    new HexSkyMesh(this, 1, 0.15f, 0.02f, 5, Color.white.cpy().lerp(Pal.darkerGray, 0.7f).a(0.6f), 2, 0.45f, 1f, 0.59f),
                    new HexSkyMesh(this, 6, 0.6f, 0.11f, 5, Color.white.cpy().lerp(Pal.lightishGray, 0.3f).a(0.5f), 2, 0.45f, 1.3f, 0.41f)
            );
            atmosphereRadIn = 0.05f;
            atmosphereRadOut = 0.2f;
            atmosphereColor = Color.valueOf("4c5a79");

            defaultCore = CDStorage.landingPodT0;
            allowLaunchToNumbered = false;
            prebuildBase = false;

            ruleSetter = r -> {
                r.defaultTeam = CDTeams.coalition;
                // is this even necessary
                r.waveTeam = CDTeams.triage;
                r.deconstructRefundMultiplier = 1f;

                r.fog = true;
                r.staticFog = true;

                r.hideBannedBlocks = true;
                r.blockWhitelist = true;

                // TODO ugly giant wall of crosses
                r.bannedBlocks.addAll(CDTechTree.blocks);
                r.bannedBlocks.addAll(Blocks.itemSource, Blocks.liquidSource, Blocks.payloadSource);
            };

            unlockedOnLand.add(CDStorage.landingPodT0);
        }};
    }
}
