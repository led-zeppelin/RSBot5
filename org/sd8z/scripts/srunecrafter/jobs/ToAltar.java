package org.sd8z.scripts.srunecrafter.jobs;

import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Path;
import org.powerbot.script.wrappers.TilePath;
import org.sd8z.scripts.srunecrafter.SRunecrafter;
import org.sd8z.scripts.srunecrafter.util.Crafter;

import java.util.EnumSet;
import java.util.concurrent.Callable;

public class ToAltar extends Crafter {

    public ToAltar(SRunecrafter sRunecrafter) {
        super(sRunecrafter);
    }

    @Override
    public boolean activate() {
        return !data.getAltarArea().contains(ctx.players.local()) && !ctx.backpack.select().id(1436).isEmpty();
    }

    @Override
    public void execute() {
        GameObject ruin = ctx.objects.select().id(data.getRuin()).poll();
        if (ruin.isOnScreen()) {
            if (ruin.interact("Enter")) {
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return data.getAltarArea().contains(ctx.players.local());
                    }
                });
            }
        } else {
            ctx.camera.turnTo(ruin);
            TilePath path = data.getRuinsPath(ctx);
            if (path.traverse(EnumSet.allOf(Path.TraversalOption.class)))
                sleep(2000, 3000);
        }
    }
}
