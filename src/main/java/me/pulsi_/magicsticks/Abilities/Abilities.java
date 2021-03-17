package me.pulsi_.magicsticks.Abilities;

public enum Abilities {
    STRENGTH, SPEED, RESISTANCE, HEALTHBOOST;

    public static Abilities getAbilityByName(String s) {
        String str;
        switch ((str = s).hashCode()) {
            case -1221262756:
                if (!str.equals("healthboost"))
                    break;
                return HEALTHBOOST;
            case 387153076:
                if (!str.equals("speed"))
                    break;
                return SPEED;
            case 1791316033:
                if (!str.equals("strength"))
                    break;
                return STRENGTH;
            case 1863800889:
                if (!str.equals("resistance"))
                    break;
                return RESISTANCE;
        }
        return null;
    }
}