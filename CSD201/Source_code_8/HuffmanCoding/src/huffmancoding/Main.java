/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffmancoding;

public class Main {
    public static void main(String[] args) {
        String str = "Hellooo!";
        /*
            H   0.125
            e   0.125
            l   0.25
            o   0.375
            !   0.125
        
            o       l       H       e       !
          0.375    0.25    0.125  0.125   0.125
         
                         e!Hlo                  H = 110
                           1                    e = 1111  
                       1 /   \ 0                l = 10
                      e!Hl    o                 o = 0
                      0.625  0.375              ! = 1110
                   1 /     \ 0
                   e!H      l                   Hellooo!
                  0.375    0.25                 110111110100001110
                1 /   \ 0
                e!     H
               0.25  0.125
             1 /  \ 0
              e    !
            0.125 0.125
        */
        System.out.println("Source: " + str);
        HuffmanCoding h = new HuffmanCoding().process(str);
        String encoded = h.encode();
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + h.decode(encoded));
    }
}
