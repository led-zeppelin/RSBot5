package org.sd8z.framework.painter;

import org.powerbot.script.AbstractScript;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Timer;

import java.awt.*;
import java.text.DecimalFormat;

public class Painter {

    private final String name;
    private final double version;
    private final AbstractScript script;
    private final MethodContext ctx;
    private final DecimalFormat formatter = new DecimalFormat("#,###");
    private final Font font = new Font("Arial", Font.PLAIN, 12);
    private final Stroke stroke = new BasicStroke(5);
    private final Stroke stroke2 = new BasicStroke(2);
    private final Color gray = new Color(0, 0, 0, 128);

    public Painter(AbstractScript script) {
        this.script = script;
        name = script.getName();
        version = script.getVersion();
        ctx = script.getContext();
    }

    public void drawMouse(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = ctx.mouse.getLocation().x;
        int y = ctx.mouse.getLocation().y;
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawLine(x - 3, y, x + 3, y);
        g.drawLine(x, y - 3, x, y + 3);
        g.setStroke(stroke2);
        g.setColor(Color.WHITE);
        g.drawLine(x - 3, y, x + 3, y);
        g.drawLine(x, y - 3, x, y + 3);
    }

    public void draw(Graphics g, int width, Detail... details) {
        g.setFont(font);
        int lines = 0;
        for (Detail d : details) {
            lines += d.hasTwoLines() ? 2 : 1;
        }
        int height = (lines + 2) * 14 + 3;
        g.setColor(gray);
        //TO-DO: width
        g.fillRoundRect(4, 3, width, height, 5, 5);
        g.setColor(Color.WHITE);
        g.drawRoundRect(4, 3, width, height, 5, 5);
        g.drawString(name + " | v" + version, 7, 16);
        g.drawString("Runtime: " + Timer.format(script.getRuntime()), 7, 30);
        int added = 0;
        for (int i = 0; i < details.length; i++) {
            Detail d = details[i];
            String name = d.getName() + ": ";
            String content = name + format(d.getObject()) +
                    (d.perHour() && !d.hasTwoLines() ? perHour((Integer) d.getObject()) : "");
            g.drawString(content, 7, 30 + 14 * (i + 1 + added));
            if (d.perHour() && d.hasTwoLines()) {
                int x = g.getFontMetrics().stringWidth(name);
                g.drawString(perHour((Integer) d.getObject()), x, 30 + 14 * (i + 2 + added));
                added++;
            }
        }
        drawMouse(g);
    }

    public void draw(Graphics g, Detail... details) {
        draw(g, 117, details);
    }

    private String perHour(int i) {
        return " (" + format(i * 3600000L / script.getRuntime()) + ")";
    }

    private String format(Object o) {
        if (!(o instanceof String))
            return formatter.format(o).replace(".", ",");
        return (String) o;
    }
}
