
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class Procenti {
    
    public static void main(String[] args) throws IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
        
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(bf.readLine());
        BigDecimal m = new BigDecimal(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        
        for (int i = 0; i < n; i++) {
            //long p = Long.parseLong(bf.readLine());
            BigDecimal  bi = new BigDecimal(bf.readLine());
            BigDecimal simts = new BigDecimal(100);
            BigDecimal dala = bi.divide(m);
            dala = dala.multiply(simts);
            dala = dala.round(MathContext.UNLIMITED.getRoundingMode().DOWN);
            pw.println(bi.divide(m));
        }
    
        pw.flush();
        pw.close();
    }
    
}
