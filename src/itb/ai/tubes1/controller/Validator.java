package itb.ai.tubes1.controller;

import itb.ai.tubes1.entity.ListOfCewek;

import java.util.ArrayList;
import java.util.Random;

public class Validator {

  public static ListOfCewek loc = null;

  public static int funcEnlightment(final String stringValid) {
    int en = 0;
    char tempchar;
    for (int i = 0; i < stringValid.length(); i++) {
      tempchar = stringValid.charAt(i);
      if (tempchar == '1') {
        en += Validator.loc.getListOfCewek().get(1 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '2') {
        en += Validator.loc.getListOfCewek().get(2 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '3') {
        en += Validator.loc.getListOfCewek().get(3 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '4') {
        en += Validator.loc.getListOfCewek().get(4 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '5') {
        en += Validator.loc.getListOfCewek().get(5 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '6') {
        en += Validator.loc.getListOfCewek().get(6 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '7') {
        en += Validator.loc.getListOfCewek().get(7 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '8') {
        en += Validator.loc.getListOfCewek().get(8 - 1).getEnlightmentPerJam();
      }
      if (tempchar == '9') {
        en += Validator.loc.getListOfCewek().get(9 - 1).getEnlightmentPerJam();
      }

    }

    return en;
  }

  public static int bestEnlightment(final ArrayList<Integer> ai) {
    int max = 0;
    max = ai.get(0);
    for (int i = 1; i < ai.size(); i++) {
      if (max <= ai.get(i)) {
        max = ai.get(i);
      }
    }
    return max;
  }

  public static String funcRandom(final int jmlHari, final int jmlW,
      final int jmlB) {// JmlW = Jumlah Wanita
    final Random r = new Random();
    final int totalJam = jmlHari * 12;
    final StringBuilder s = new StringBuilder(5 + jmlW + jmlB);
    String alphabet = "gmcu0"; // String Default
    for (int i = 1; i < (jmlW + 1); i++) {
      alphabet = alphabet + i; // String Default + Jumlah wanita
    }
    for (int j = 1; j < (jmlB + 1); j++) {
      alphabet = alphabet + (char) (64 + j);

    }
    for (int i = 0; i < (totalJam); i++) {
      final char tempChar = alphabet.charAt(r.nextInt(alphabet.length()));
      s.append(tempChar);
    }

    return s.toString(); // return String Random
  }
}