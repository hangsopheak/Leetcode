/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 *
 * @author SONGSONG
 */
public class Anvato {

    static final char[] CANDIDATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '_', '.', '@', '+'};

    static final String INPUT = "da69072d3c25b5f660bc578aa4a36e6d8b4a9e43f9607b1245eb"
            + "b0c46ded9f40c8a4096e25ddee9dc9927f9159f6079b0c553a32c50ed1f"
            + "e1fa3c8e83289ade54d232c785277662a85043568ee46bdf4554af04dc7"
            + "6fef4e9c4061b4f17f0ac5d4bc0ee3ed70db20d1d2d3b9fbca014863fd9"
            + "939bcb3fdc636236c7879122b6479916505662a1c7c4d9fa7355971105"
            + "6a7724269c7adbb120f0478ab05301611a7282b4f174bcfc56ae6a5acaf7"
            + "44fcc6a73797cd3db91dc6a86773ef2be2be434eccfc221b4b1e27715c70"
            + "ca09fdf790a4c3921d282c28cff9a205c030de3436c387b5981eb096b6"
            + "b9352a06915c70348b80f1368d659e9c99088ab839b228c9465d623f3c"
            + "96f821f3c7a64d56b4cad96a0056a2c0382e65b0363165d9d72ce83d913"
            + "797a440b1126840ea4af8edbdcdd4f19175214a338415eaeb6821bd1d71"
            + "76603ab5c8ad6d2ad169ba01ad9c66baa4d2b0a5514c6bb39c74764214e"
            + "d5519755a4c27946af166d6fbe7a8465f1b6bf6808094cdc8b878ded67ef"
            + "8796d6d39f7c6fd136cd6dbb5fcf1b189d34cf2b49c44870750b84a1a143"
            + "c08f9c166cbdc080ed8c83943b63c9a599e90cffd1be7a6b2e6d294650cce83f0477def584d5";

    /**
     *
     * @param input
     * @param prefixes
     * @return new prefixes with two more digits
     */
    public static String decode(String input, String prefixes) {
        MD5 md5 = new MD5();
        String email = md5.crypt("wansongsong.jack@gmail.com");

        // try all the possible new two digits to find out the correct one
        for (int i = 0; i < CANDIDATES.length; i++) {
            for (int j = 0; j < CANDIDATES.length; j++) {
                StringBuilder tmp = new StringBuilder(email);
                StringBuilder newprefixes = new StringBuilder(prefixes);
                newprefixes.append(CANDIDATES[i]);
                newprefixes.append(CANDIDATES[j]);
                tmp.append(newprefixes);
                tmp.append(md5.crypt(newprefixes.toString()));
                if (md5.crypt(tmp.toString()).equals(input)) {
                    return newprefixes.toString();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        int length = INPUT.length();
        String[] md5s = new String[length / 32];
        for (int i = 0; i < md5s.length; i++) {
            md5s[i] = INPUT.substring(i * 32, (i + 1) * 32);
        }

        String result = "";
        for (int i = 0; i < md5s.length; i++) {
            result = decode(md5s[i], result);
        }
        System.out.println(result);
    }
}
