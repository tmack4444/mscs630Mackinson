
public class AESCipher {

  private static final int[] Rcon =
  {0x8D, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8, 0xAB, 0x4D, 0x9A,
   0x2F, 0x5E, 0xBC, 0x63, 0xC6, 0x97, 0x35, 0x6A, 0xD4, 0xB3, 0x7D, 0xFA, 0xEF, 0xC5, 0x91, 0x39,
   0x72, 0xE4, 0xD3, 0xBD, 0x61, 0xC2, 0x9F, 0x25, 0x4A, 0x94, 0x33, 0x66, 0xCC, 0x83, 0x1D, 0x3A,
   0x74, 0xE8, 0xCB, 0x8D, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8,
   0xAB, 0x4D, 0x9A, 0x2F, 0x5E, 0xBC, 0x63, 0xC6, 0x97, 0x35, 0x6A, 0xD4, 0xB3, 0x7D, 0xFA, 0xEF,
   0xC5, 0x91, 0x39, 0x72, 0xE4, 0xD3, 0xBD, 0x61, 0xC2, 0x9F, 0x25, 0x4A, 0x94, 0x33, 0x66, 0xCC,
   0x83, 0x1D, 0x3A, 0x74, 0xE8, 0xCB, 0x8D, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B,
   0x36, 0x6C, 0xD8, 0xAB, 0x4D, 0x9A, 0x2F, 0x5E, 0xBC, 0x63, 0xC6, 0x97, 0x35, 0x6A, 0xD4, 0xB3,
   0x7D, 0xFA, 0xEF, 0xC5, 0x91, 0x39, 0x72, 0xE4, 0xD3, 0xBD, 0x61, 0xC2, 0x9F, 0x25, 0x4A, 0x94,
   0x33, 0x66, 0xCC, 0x83, 0x1D, 0x3A, 0x74, 0xE8, 0xCB, 0x8D, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
   0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8, 0xAB, 0x4D, 0x9A, 0x2F, 0x5E, 0xBC, 0x63, 0xC6, 0x97, 0x35,
   0x6A, 0xD4, 0xB3, 0x7D, 0xFA, 0xEF, 0xC5, 0x91, 0x39, 0x72, 0xE4, 0xD3, 0xBD, 0x61, 0xC2, 0x9F,
   0x25, 0x4A, 0x94, 0x33, 0x66, 0xCC, 0x83, 0x1D, 0x3A, 0x74, 0xE8, 0xCB, 0x8D, 0x01, 0x02, 0x04,
   0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8, 0xAB, 0x4D, 0x9A, 0x2F, 0x5E, 0xBC, 0x63,
   0xC6, 0x97, 0x35, 0x6A, 0xD4, 0xB3, 0x7D, 0xFA, 0xEF, 0xC5, 0x91, 0x39, 0x72, 0xE4, 0xD3, 0xBD,
   0x61, 0xC2, 0x9F, 0x25, 0x4A, 0x94, 0x33, 0x66, 0xCC, 0x83, 0x1D, 0x3A, 0x74, 0xE8, 0xCB, 0x8D};

  private static final int[] S_BOX =
  {0x63 ,0x7c ,0x77 ,0x7b ,0xf2 ,0x6b ,0x6f ,0xc5 ,0x30 ,0x01 ,0x67 ,0x2b ,0xfe ,0xd7 ,0xab ,0x76
   ,0xca ,0x82 ,0xc9 ,0x7d ,0xfa ,0x59 ,0x47 ,0xf0 ,0xad ,0xd4 ,0xa2 ,0xaf ,0x9c ,0xa4 ,0x72 ,0xc0
   ,0xb7 ,0xfd ,0x93 ,0x26 ,0x36 ,0x3f ,0xf7 ,0xcc ,0x34 ,0xa5 ,0xe5 ,0xf1 ,0x71 ,0xd8 ,0x31 ,0x15
   ,0x04 ,0xc7 ,0x23 ,0xc3 ,0x18 ,0x96 ,0x05 ,0x9a ,0x07 ,0x12 ,0x80 ,0xe2 ,0xeb ,0x27 ,0xb2 ,0x75
   ,0x09 ,0x83 ,0x2c ,0x1a ,0x1b ,0x6e ,0x5a ,0xa0 ,0x52 ,0x3b ,0xd6 ,0xb3 ,0x29 ,0xe3 ,0x2f ,0x84
   ,0x53 ,0xd1 ,0x00 ,0xed ,0x20 ,0xfc ,0xb1 ,0x5b ,0x6a ,0xcb ,0xbe ,0x39 ,0x4a ,0x4c ,0x58 ,0xcf
   ,0xd0 ,0xef ,0xaa ,0xfb ,0x43 ,0x4d ,0x33 ,0x85 ,0x45 ,0xf9 ,0x02 ,0x7f ,0x50 ,0x3c ,0x9f ,0xa8
   ,0x51 ,0xa3 ,0x40 ,0x8f ,0x92 ,0x9d ,0x38 ,0xf5 ,0xbc ,0xb6 ,0xda ,0x21 ,0x10 ,0xff ,0xf3 ,0xd2
   ,0xcd ,0x0c ,0x13 ,0xec ,0x5f ,0x97 ,0x44 ,0x17 ,0xc4 ,0xa7 ,0x7e ,0x3d ,0x64 ,0x5d ,0x19 ,0x73
   ,0x60 ,0x81 ,0x4f ,0xdc ,0x22 ,0x2a ,0x90 ,0x88 ,0x46 ,0xee ,0xb8 ,0x14 ,0xde ,0x5e ,0x0b ,0xdb
   ,0xe0 ,0x32 ,0x3a ,0x0a ,0x49 ,0x06 ,0x24 ,0x5c ,0xc2 ,0xd3 ,0xac ,0x62 ,0x91 ,0x95 ,0xe4 ,0x79
   ,0xe7 ,0xc8 ,0x37 ,0x6d ,0x8d ,0xd5 ,0x4e ,0xa9 ,0x6c ,0x56 ,0xf4 ,0xea ,0x65 ,0x7a ,0xae ,0x08
   ,0xba ,0x78 ,0x25 ,0x2e ,0x1c ,0xa6 ,0xb4 ,0xc6 ,0xe8 ,0xdd ,0x74 ,0x1f ,0x4b ,0xbd ,0x8b ,0x8a
   ,0x70 ,0x3e ,0xb5 ,0x66 ,0x48 ,0x03 ,0xf6 ,0x0e ,0x61 ,0x35 ,0x57 ,0xb9 ,0x86 ,0xc1 ,0x1d ,0x9e
   ,0xe1 ,0xf8 ,0x98 ,0x11 ,0x69 ,0xd9 ,0x8e ,0x94 ,0x9b ,0x1e ,0x87 ,0xe9 ,0xce ,0x55 ,0x28 ,0xdf
   ,0x8c ,0xa1 ,0x89 ,0x0d ,0xbf ,0xe6 ,0x42 ,0x68 ,0x41 ,0x99 ,0x2d ,0x0f ,0xb0 ,0x54 ,0xbb ,0x16};




   public static String[][] AESSeq(String key, String plaintext){
     String[] keys = roundKeysHex(key);
     String[][] result = AESStateXOR(stringToMatrix(key), stringToMatrix(plaintext));
     helperOut(result);
     for(int i = 0; i < keys.length-1; i++){
       result = AESNibbleSub(result);
       helperOut(result);
       result = AESShiftRow(result);
       helperOut(result);
       result = AESMixColumn(result);
       helperOut(result);
       result = AESStateXOR(result, stringToMatrix(keys[i]));
       helperOut(result);
     }
     //steps for the last round
     result = AESNibbleSub(result);
     helperOut(result);
     result = AESShiftRow(result);
     helperOut(result);
     result = AESStateXOR(stringToMatrix(keys[keys.length-1]), result);
     helperOut(result);
     return result;
   }

   //Helper function to convert a 16 length string into a 4x4 matrix of
   public static String[][] stringToMatrix(String orig){
     int iteration = 0;
     String[][] result = new String[4][4];
     for(int i = 0; i < 4; i++){
       for(int j = 0; j < 4; j++){
         result[i][j] = orig.substring(iteration, iteration + 2);
         iteration += 2;
       }
     }
     return result;
   }

  public static String[] roundKeysHex (String KeyHex){
    //System.out.println(KeyHex);
    String[][] W = new String[4][44];
    int iteration = 0;
    //this loop will go through the columns
    for(int j = 0; j < 44; j++){
      // start with our base case, the first round of this we make the first 4 columns
      //System.out.println(j % 4);
        if(j < 4){
          for(int i = 0; i < 4; i++){
            W[i][j] = (KeyHex.substring(iteration, iteration + 2));
            iteration += 2;
          }
          //now, working through instruction cases
          //if column index is not multiple of 4, XOR the 4th past and last col
        } else if(j % 4 != 0){
          for(int i = 0; i < 4; i++){
            W[i][j] = Integer.toHexString((Integer.parseInt(W[i][j-4], 16) ^ (Integer.parseInt(W[i][j-1], 16)))) + "";
          }
        } else if(j % 4 == 0){
          //for the construction of this col, use the previous cols elements
          String[] wNew = new String [4];
          for(int copy = 0; copy < 4; copy++){
            wNew[copy] = W[copy][j-1];
          }

          //then shift all vals to the left
          for(int k = 0; k < 3; k++){
            String temp = wNew[k];
            wNew[k] = wNew[k+1];
            wNew[k+1] = temp;
          }
            //System.out.println("wNew[k]: " + wNew[k]);
          //Then transform each byte using an SBox junction
          for(int l = 0; l < 4; l++){
            wNew[l] = aesSBox(wNew[l] + "");
          }
          String rConst = aesRcon((j/4) + "");
          wNew[0] = Integer.toHexString(Integer.parseInt(rConst, 16) ^ Integer.parseInt(wNew[0], 16) ) + "";
          for(int p = 0; p < 4; p++){
            //Get the Rcon(p) constant for p th round w/ table 2
            //perform XOR using the round constant from prev step
            //Finally, define w[j] as w(j) = w(j-4) XOR wNew
            W[p][j] = Integer.toHexString(Integer.parseInt(W[p][j-4], 16) ^ Integer.parseInt(wNew[p], 16) ) + "";
          }

        }
      }
    //Build our output string
    String[] result = new String[11];
    int keyNum = 0;
    result[0] = "";
    for(int c = 0; c < 44; c++){
      for(int r = 0; r < 4; r++){
        if(W[r][c].length() == 1){
          result[keyNum] += "0";
        }
        result[keyNum] += W[r][c];
        if(result[keyNum].length() >= 32){
          keyNum++;
          if(keyNum < 11){
            result[keyNum] = "";
          }
        }
      }
    }
    return result;
  }


  public static String aesSBox(String inHex){
    int coords = Integer.parseInt(inHex, 16);
      //System.out.println("inHex: " + inHex);
      //System.out.println("coords: " + coords);
      //System.out.println("S_BOX[coords]: " + S_BOX[coords]);
    return Integer.toHexString(S_BOX[coords]);
  }

  public static String aesRcon(String round){
    int coords = Integer.parseInt(round);
    //System.out.println("Rcon[coords]: " + Rcon[coords]);
    return Integer.toHexString(Rcon[coords]);
  }

  public static String[][] AESStateXOR(String[][] sHex, String[][] keyHex){
    String[][] result = new String [4][4];
    for(int i = 0; i < 4; i++ ){
      for(int j = 0; j < 4; j++ ){
        int tempRes = 0;
        result[i][j] = Integer.toHexString((Integer.parseInt(sHex[i][j], 16) ^ Integer.parseInt(keyHex[i][j], 16)));
      }
    }
    return result;
  }

  public static String[][] AESNibbleSub(String[][] inStateHex){
    String[][] result = new String [4][4];
    for(int i = 0; i < 4; i++ ){
      for(int j = 0; j < 4; j++ ){
        //System.out.println(inStateHex[i][j]);
        result[i][j] = aesSBox(inStateHex[i][j]);
      }
    }
    return result;
  }

  public static String[][] AESShiftRow(String[][] inStateHex){
    String[][] result = new String [4][4];
    String temp = "";
    //Will do research based on the resources you provided, but for now here's a hardcoded solution

    for(int k = 0; k < 3; k++){
      temp = inStateHex[k][1];
      inStateHex[k][1] = inStateHex[k+1][1];
      inStateHex[k+1][1] = temp;
    }
    for(int j = 0; j < 2; j++){
      temp = inStateHex[j][2];
      inStateHex[j][2] = inStateHex[j+2][2];
      inStateHex[j+2][2] = temp;
    }

    for(int l = 0; l < 3; l++){
      temp = inStateHex[l][3];
      inStateHex[l][3] = inStateHex[3][3];
      inStateHex[3][3] = temp;
    }
    for(int c = 0; c < 4; c++){
      for(int r = 0; r < 4; r++){
        result[r][c] = inStateHex[r][c];
      }
    }
    return result;

  }

  public static String[][] AESMixColumn(String[][] inStateHex){
    String[][] result = new String [4][4];
    String[][] multMatrix = {{"02", "03", "01", "01"},
                            {"01", "02", "03", "01"},
                            {"01", "01", "02", "03"},
                            {"03", "01", "01", "02"}};
    String leftMostBitXOR = "00011011";
    for(int r = 0; r < 4; r++){
      String[] colR = inStateHex[r];
      for(int i = 0; i < 4; i++){
        String currRow = colR[i];
        String multVal = multMatrix[r][i];
        String leftMostCheck = Integer.toBinaryString(Integer.parseInt(currRow, 16));
        currRow = leftShift(currRow);
        if(leftMostCheck.charAt(leftMostCheck.length()-1) == '1'){
          colR[i] = Integer.toHexString((Integer.parseInt(currRow, 16) ^ Integer.parseInt(leftMostBitXOR, 2)));
        }
      }
      result[r] = colR;
    }
    return result;
  }

  public static String leftShift(String hexString){
    String result = "";
    for(int i = 0; i < hexString.length()-1; i++){
      result = hexString.charAt(i) + "";
    }
    result += "0";
    return result;
  }

  public static void helperOut(String[][] printMe){
    for(int c = 0; c < 4; c++){
      for(int r  = 0; r < 4; r++){
        if(printMe[r][c].length() == 1){
          printMe[r][c] = "0" + printMe[r][c];
        }
        System.out.print(printMe[r][c]);
      }
      System.out.println();
    }
    System.out.println();
  }

}
