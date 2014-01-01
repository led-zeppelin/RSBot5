package org.sd8z.scripts.srunecrafter;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;
import org.powerbot.script.util.Timer;
import org.sd8z.framework.core.Job;
import org.sd8z.framework.core.JobContainer;
import org.sd8z.framework.painter.Detail;
import org.sd8z.framework.painter.Painter;
import org.sd8z.scripts.srunecrafter.jobs.Bank;
import org.sd8z.scripts.srunecrafter.jobs.Craft;
import org.sd8z.scripts.srunecrafter.jobs.ToAltar;
import org.sd8z.scripts.srunecrafter.jobs.ToBank;
import org.sd8z.scripts.srunecrafter.util.Data;
import org.sd8z.scripts.srunecrafter.util.GUI;

import java.awt.*;
import java.net.URL;
import java.text.DecimalFormat;

@Manifest(name = "sRunecrafter", authors = "SD8Z", description = "AIO F2P Runecrafter", topic = 1130938,version = 0.11)

public class SRunecrafter extends PollingScript implements PaintListener {

    private Data data = null;
    private JobContainer container = new JobContainer();
    private int crafted = 0;
    private int xp = 0;
    private final DecimalFormat formatter = new DecimalFormat("#,###");
    private final Stroke stroke = new BasicStroke(5);
    private final Stroke stroke2 = new BasicStroke(2);
    private final Color gray = new Color(0, 0, 0, 128);

    @Override
    public void start() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI g = new GUI(SRunecrafter.this);
                g.setVisible(true);
            }
        });
    }

    @Override
    public int poll() {
        Job j = container.get();
        if (j != null) {
            j.execute();
        }
        return Random.nextInt(100, 300);
    }

    @Override
    public void repaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        int x = ctx.mouse.getLocation().x;
        int y = ctx.mouse.getLocation().y;
        g.setColor(gray);
        g.fillRoundRect(4, 3, 142, 73, 5, 5);
        g.setColor(Color.WHITE);
        g.drawRoundRect(4, 3, 142, 73, 5, 5);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawLine(x - 3, y, x + 3, y);
        g.drawLine(x, y - 3, x, y + 3);
        g.setStroke(stroke2);
        g.setColor(Color.WHITE);
        g.drawLine(x - 3, y, x + 3, y);
        g.drawLine(x, y - 3, x, y + 3);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf("sRunecrafter | v" + getVersion()), 7, 16);
        g.drawString("Runtime: " + Timer.format(getRuntime()), 7, 30);
        g.drawString("Rune: " + (data == null ? "" : data.toString()), 7, 44);
        g.drawString("Crafted: " + format(crafted) + " (" + perHour(crafted) + ")", 7, 58);
        g.drawString("XP: " + format(xp) + " (" + perHour(xp) + ")", 7, 72);
    }

    private String perHour(double value) {
        return format((int) (value * 3600000D / getRuntime()));
    }

    private String format(long i) {
        return formatter.format(i).replace(".", ",");
    }

    public void submit(Data d) {
        data = d;
        container = new JobContainer(new Bank(this), new Craft(this), new ToAltar(this), new ToBank(this));
    }

    public Data getData() {
        return data;
    }

    public void crafted(int i) {
        crafted += i;
    }

    public void gainXp(int i) {
        xp += i;
    }
}
