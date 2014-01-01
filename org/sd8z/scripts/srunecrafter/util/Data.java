package org.sd8z.scripts.srunecrafter.util;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

public enum Data {

    AIR(556, 2452, 2478, 2465, new Tile[] {
            new Tile(3185, 3433, 0), new Tile(3181, 3429, 0),
            new Tile(3175, 3429, 0), new Tile(3169, 3428, 0),
            new Tile(3163, 3423, 0), new Tile(3158, 3419, 0),
            new Tile(3151, 3416, 0), new Tile(3144, 3413, 0),
            new Tile(3139, 3410, 0), new Tile(3134, 3408, 0),
            new Tile(3128, 3407, 0)}, new Area(new Tile(2839, 4826, 0), new Tile(2849, 4840, 0)), new Area(new Tile(3192, 3432, 0), new Tile(3181, 3446,0))),
    FIRE(554, 76692, 2482, 2469, new Tile[] {
            new Tile(3347, 3238, 0), new Tile(3341, 3233, 0),
            new Tile(3330, 3232, 0), new Tile (3323, 3233, 0),
            new Tile(3319, 3235, 0), new Tile(3312, 3244, 0),
            new Tile(3313, 3253, 0)}, new Area(new Tile(2575, 4847, 0), new Tile(2591, 4832, 0)), new Area(new Tile(3346, 3237, 0), new Tile(3350, 3240,0))),
    WATER(555, 2454, 2480, 2467, new Tile[] {
            new Tile(3093, 3243, 0), new Tile(3098, 3250, 0),
            new Tile(3104, 3248, 0), new Tile(3105, 3241, 0),
            new Tile(3107, 3234, 0), new Tile(3111, 3228, 0),
            new Tile(3115, 3223, 0), new Tile(3120, 3218, 0),
            new Tile(3126, 3214, 0), new Tile(3132, 3210, 0),
            new Tile(3137, 3206, 0), new Tile(3141, 3200, 0),
            new Tile(3146, 3195, 0), new Tile(3149, 3190, 0),
            new Tile(3154, 3185, 0), new Tile(3159, 3180, 0),
            new Tile(3165, 3176, 0), new Tile(3170, 3173, 0),
            new Tile(3177, 3172, 0), new Tile(3181, 3167, 0),
            new Tile(3182, 3166, 0)}, new Area(new Tile(3497, 4831, 0), new Tile(3477, 4842, 0)), new Area(new Tile(3096, 3246, 0), new Tile(3092, 3240, 0))),
    EARTH(557, 2455, 2481, 2468, new Tile[] {
            new Tile(3253, 3420, 0), new Tile(3254, 3429, 0),
            new Tile(3260, 3429, 0), new Tile(3266, 3429, 0),
            new Tile(3271, 3429, 0), new Tile(3278, 3429, 0),
            new Tile(3284, 3431, 0), new Tile(3286, 3438, 0),
            new Tile(3286, 3445, 0), new Tile(3287, 3452, 0),
            new Tile(3289, 3458, 0), new Tile(3294, 3463, 0),
            new Tile(3300, 3464, 0), new Tile(3304, 3468, 0),
            new Tile(3306, 3471, 0) }, new Area(new Tile(2654, 4828, 0), new Tile(2664, 4846, 0)), new Area(new Tile(3250, 3423, 0), new Tile(3257, 3419, 0))),
    MIND(558, 2453, 2479, 2466, new Tile[] {
            new Tile(2945, 3370, 0), new Tile(2945, 3375, 0),
            new Tile(2950, 3378, 0), new Tile(2955, 3381, 0),
            new Tile(2961, 3382, 0), new Tile(2964, 3387, 0),
            new Tile(2965, 3394, 0), new Tile(2966, 3400, 0),
            new Tile(2965, 3407, 0), new Tile(2965, 3413, 0),
            new Tile(2959, 3416, 0), new Tile(2953, 3420, 0),
            new Tile(2947, 3425, 0), new Tile(2948, 3431, 0),
            new Tile(2948, 3438, 0), new Tile(2947, 3445, 0),
            new Tile(2947, 3451, 0), new Tile(2949, 3457, 0),
            new Tile(2950, 3464, 0), new Tile(2954, 3469, 0),
            new Tile(2959, 3471, 0), new Tile(2963, 3474, 0),
            new Tile(2968, 3479, 0), new Tile(2972, 3485, 0),
            new Tile(2975, 3491, 0), new Tile(2978, 3497, 0),
            new Tile(2981, 3502, 0), new Tile(2982, 3508, 0),
            new Tile(2982, 3512, 0)}, new Area(new Tile(2795, 4826, 0), new Tile(2278, 4874, 0)), new Area(new Tile(2949, 3368, 0), new Tile(2943, 3373, 0))),
    BODY(559, 2457, 2483, 2470, new Tile[] {
            new Tile(3092, 3490, 0), new Tile(3085, 3487, 0),
            new Tile(3080, 3481, 0), new Tile(3079, 3474, 0),
            new Tile(3079, 3467, 0), new Tile(3085, 3464, 0),
            new Tile(3079, 3462, 0), new Tile(3072, 3461, 0),
            new Tile(3067, 3455, 0), new Tile(3062, 3450, 0),
            new Tile(3056, 3445, 0), new Tile(3053, 3443, 0)}, new Area(new Tile(2514, 4847, 0), new Tile(2528, 4833, 0)), new Area(new Tile(3091, 3488, 0), new Tile(3097, 3496, 0)));

    private int rune, ruin, altar, portal;
    private Tile[] pathToRuins;
    private Area altarArea, bank;

    private Data(int rune, int ruin, int altar, int portal, Tile[] pathToRuins, Area altarArea, Area bank) {
        this.rune = rune;
        this.ruin = ruin;
        this.altar = altar;
        this.portal = portal;
        this.pathToRuins = pathToRuins;
        this.altarArea = altarArea;
        this.bank = bank;
    }

    public int getRune() {
        return rune;
    }

    public int getRuin() {
        return ruin;
    }

    public int getAltar() {
        return altar;
    }

    public int getPortal() {
        return portal;
    }

    public TilePath getRuinsPath(MethodContext ctx) {
        return ctx.movement.newTilePath(pathToRuins).randomize(-1, 1);
    }

    public TilePath getBankPath(MethodContext ctx) {
        return getRuinsPath(ctx).reverse();
    }

    public Area getAltarArea() {
        return altarArea;
    }

    public Area getBankArea() {
        return bank;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
