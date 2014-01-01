package org.sd8z.framework.core;

import org.powerbot.script.AbstractScript;

public abstract class JobSet<T extends AbstractScript> extends Job<T> {

    private JobContainer container;
    private String status = "";
    public abstract boolean initiate();

    public JobSet(T script, Job... jobs) {
        super(script);
        this.container = new JobContainer(jobs);
    }

    @Override
    public final void execute() {
        final Job job = container.get();
        if (job != null) {
            status = job.status();
            job.execute();
        }
    }

    @Override
    public String status() {
        return status;
    }

    @Override
    public boolean activate() {
        return initiate();
    }
}