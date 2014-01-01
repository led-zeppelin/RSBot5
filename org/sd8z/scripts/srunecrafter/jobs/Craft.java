package org.sd8z.scripts.srunecrafter.jobs;

import org.powerbot.script.methods.Skills;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.*;
import org.sd8z.scripts.srunecrafter.SRunecrafter;
import org.sd8z.scripts.srunecrafter.util.Crafter;

import java.util.EnumSet;
import java.util.concurrent.Callable;

public class Craft extends Crafter {

    public Craft(SRunecrafter sRunecrafter) {
        super(sRunecrafter);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(data.getAltar()).isEmpty() && !ctx.backpack.select().id(1436).isEmpty();
    }

    @Override
    public void execute() {
        int xp = ctx.skills.getExperience(Skills.RUNECRAFTING);
        final int count = ctx.backpack.select().id(data.getRune()).poll().getStackSize();
        for (GameObject o : ctx.objects) {
            if (o.isOnScreen()) {
                if (o.interact("Craft-Rune")) {
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !ctx.backpack.select().id(data.getRune()).isEmpty() ||
                                    ctx.backpack.poll().getStackSize() != count;
                        }
                    });
                    script.crafted(ctx.backpack.poll().getStackSize() - count);
                    script.gainXp(ctx.skills.getExperience(Skills.RUNECRAFTING) - xp);

                }
            } else {
                ctx.camera.turnTo(o);
                LocalPath path = ctx.movement.findPath(o);
                if (path.traverse(EnumSet.allOf(Path.TraversalOption.class)));
                    sleep(1000, 1500);
            }
        }
    }
}
