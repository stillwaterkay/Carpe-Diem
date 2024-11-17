package carpediem.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.world.*;

import static mindustry.content.TechTree.*;
import static carpediem.content.blocks.CDCrafting.*;
import static carpediem.content.blocks.CDDistribution.*;
import static carpediem.content.blocks.CDPower.*;
import static carpediem.content.blocks.CDStorage.*;
import static carpediem.content.CDItems.*;

public class CDTechTree {
    public static Seq<Block> blocks = new Seq<>();

    public static void load() {
        TechNode root = nodeRoot("planet", landingPod, () -> {
            node(belt, () -> {
                node(beltMerger, () -> {
                    node(beltSplitter);
                    node(beltBridge);
                });
            });

            node(crudeSmelter, () -> {
                node(crudePress);
                node(crudeRollingMill, () -> {
                    node(cableNode, () -> {
                        node(cableTower);
                    });
                });
                node(crudeAssembler, () -> {
                    node(smelter);
                    node(press);
                    node(rollingMill);
                    node(refinery, () -> {
                        node(mixer);
                        node(assembler);
                    });
                });
            });

            node(industryHub);

            nodeProduce(rawAluminum, () -> {
                nodeProduce(waterIce, () -> {
                    nodeProduce(Liquids.water, () -> {
                        nodeProduce(biomass, () -> {
                            nodeProduce(charcoal, () -> {
                                nodeProduce(Items.pyratite, () -> {});
                                nodeProduce(Items.silicon, () -> {
                                    nodeProduce(siliconSheet, () -> {});
                                });
                            });
                        });

                        nodeProduce(CDLiquids.petroleum, () -> {
                            nodeProduce(Liquids.oil, () -> {
                                nodeProduce(Items.plastanium, () -> {
                                    nodeProduce(plastaniumSheet, () -> {});
                                });
                            });
                        });
                    });
                });

                nodeProduce(sulfur, () -> {
                    nodeProduce(aluminum, () -> {
                        nodeProduce(aluminumPlate, () -> {
                            nodeProduce(aluminumCogwheel, () -> {});
                        });
                        nodeProduce(aluminumRod, () -> {
                            nodeProduce(aluminumWire, () -> {});
                        });

                        nodeProduce(nickel, () -> {
                            nodeProduce(nickelPlate, () -> {});
                            nodeProduce(nickelRod, () -> {
                                nodeProduce(nickelWire, () -> {
                                    nodeProduce(controlCircuit, () -> {
                                        nodeProduce(calculationCircuit, () -> {
                                            nodeProduce(processingUnit, () -> {});
                                        });
                                    });

                                    nodeProduce(powerCell, () -> {});
                                    nodeProduce(electronicMotor, () -> {});
                                });
                            });

                            nodeProduce(silver, () -> {
                                nodeProduce(silverPlate, () -> {
                                    nodeProduce(silverCogwheel, () -> {});

                                    nodeProduce(liquidCell, () -> {});
                                });
                                nodeProduce(silverRod, () -> {
                                    nodeProduce(silverWire, () -> {});
                                });

                                nodeProduce(platinum, () -> {
                                    nodeProduce(platinumPlate, () -> {});
                                    nodeProduce(platinumRod, () -> {
                                        nodeProduce(platinumWire, () -> {});
                                    });
                                });

                                nodeProduce(carbonAlloy, () -> {
                                    nodeProduce(alloyPlate, () -> {
                                        nodeProduce(alloyCogwheel, () -> {});
                                    });
                                    nodeProduce(alloyRod, () -> {});
                                });
                            });
                        });
                    });
                });

                nodeProduce(Items.sand, () -> {});

                nodeProduce(rawNickel, () -> {});
                nodeProduce(rawSilver, () -> {});
                nodeProduce(rawPlatinum, () -> {});
            });
        });
        CDPlanets.planet.techTree = root;

        root.each(node -> {
            if (node.content instanceof Block block) {
                blocks.add(block);
            }
        });
    }
}