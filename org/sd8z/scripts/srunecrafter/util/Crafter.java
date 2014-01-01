package org.sd8z.scripts.srunecrafter.util;

import org.sd8z.framework.core.Job;
import org.sd8z.scripts.srunecrafter.SRunecrafter;

public abstract class Crafter extends Job<SRunecrafter> {

    protected Data data;

    public Crafter(SRunecrafter sRunecrafter) {
        super(sRunecrafter);
        this.data = sRunecrafter.getData();
    }
}
