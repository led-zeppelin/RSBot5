package org.sd8z.scripts.srunecrafter.jobs;

import org.powerbot.script.util.Condition;
import org.sd8z.scripts.srunecrafter.SRunecrafter;
import org.sd8z.scripts.srunecrafter.util.Crafter;

import java.util.concurrent.Callable;

public class Bank extends Crafter {

    public Bank(SRunecrafter sRunecrafter) {
        super(sRunecrafter);
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().id(1436).isEmpty() && data.getBankArea().contains(ctx.players.local());
    }

    @Override
    public void execute() {
        if (ctx.bank.open()) {
            if (!ctx.backpack.select().isEmpty()) {
                if (ctx.bank.depositInventory()) {
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return ctx.backpack.select().isEmpty();
                        }
                    });
                }
            }
            if (!ctx.bank.select().id(1436).isEmpty()) {
                if (ctx.bank.withdraw(1436, 0)) {
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !ctx.backpack.select().isEmpty();
                        }
                    });
                    ctx.bank.close();
                }
            } else {
                script.log.info("[sRunecrafter] can't find more rune essence in the bank, stopping script.");
                script.getController().stop();
            }
        }
    }
}
