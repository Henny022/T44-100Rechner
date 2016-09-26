package de.henny022.T44100Rechner;

/**
 * Created by henny on 26.09.16.
 */
public class Utils
{
    public static String textColorByProgress(int progress, int mean, int total)
    {
        if(progress <= 0)
        {
            return FontColors.RED;
        }
        else if (progress < mean)
        {
            return FontColors.LIGHT_RED;
        }
        else if (progress >= total)
        {
            return FontColors.GREEN;
        }
        else if (progress >= mean)
        {
            return FontColors.LIGHT_GREEN;
        }


        return "";
    }
}
