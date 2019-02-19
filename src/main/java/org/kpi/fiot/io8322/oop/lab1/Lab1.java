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
        int n = 2;
        int b = 1;
        int m = 2;
        int C = 1;
        for (double i = (double) a; i <= n; i++) {
            for (double j = (double) b; j <= m; j++) {
                S = S + ((i / j) / (i + C));
                if (i + C == 0) {
                    log.error("invalid variable");
                    System.exit(1);
                }
            }
        }
        log.info("S = "+S);
    }
}
