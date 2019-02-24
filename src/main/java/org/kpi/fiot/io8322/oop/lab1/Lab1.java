package org.kpi.fiot.io8322.oop.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


/**
 * C2 = 0 O1 = "+"
 * C3 = 0 C = 0
 * C5 = 1 O2 = "/"
 * C7 = 6  i,j - double
 */
public class Lab1 {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
    public static void main(String[] argc){
        double S = 0;
        final int a = 1;
        final int n = 2;
        final int b = 1;
        final int m = 2;
        final int C = 1;
        for (double i = (double) a; i <= n; i++) {
            for (double j = (double) b; j <= m; j++) {
                if (j == 0 || (i + C == 0)) {
                    log.error("Invalid variables");
                    System.exit(1);
                }
                S += ((i / j) / (i + C));
            }
        }
        log.info("S = "+S);
    }
}
