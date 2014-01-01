package org.sd8z.framework.painter;

public class Detail {

    private String name;
    private boolean calcPerHour;
    private Object object;
    private boolean twoLine;

    public Detail(String detail, boolean calcPerHour, boolean twoLine) {
        this.name = detail;
        this.calcPerHour = calcPerHour;
        this.twoLine = twoLine;
    }

    public String getName() {
        return name;
    }

    public boolean perHour() {
        return calcPerHour;
    }

    public Object getObject() {
        return object;
    }

    public Detail setObject(Object o) {
        object = o;
        return this;
    }

    public boolean hasTwoLines() {
        return twoLine;
    }
}
