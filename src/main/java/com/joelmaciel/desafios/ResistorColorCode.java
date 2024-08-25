package com.joelmaciel.desafios;

import java.util.HashMap;
import java.util.Map;

public class ResistorColorCode {

    private static final Map<Integer, String> colorMap = new HashMap<>();
    private static final String TOLERANCE_COLOR = "dourado";

    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static void main(String[] args) {
        System.out.println(getColorCode("10 ohms"));
        System.out.println(getColorCode("100 ohms"));
        System.out.println(getColorCode("220 ohms"));
        System.out.println(getColorCode("330 ohms"));
        System.out.println(getColorCode("470 ohms"));
        System.out.println(getColorCode("680 ohms"));
        System.out.println(getColorCode("1k ohms"));
        System.out.println(getColorCode("2M ohms"));
    }

    public static String getColorCode(String ohmsValue) {
        String value = ohmsValue.replace(" ohms", "").trim();
        int multiplier = 0;

        if (value.endsWith("k")) {
            value = value.replace("k", "");
            multiplier = 3;
        } else if (value.endsWith("M")) {
            value = value.replace("M", "");
            multiplier = 6;
        }

        double numericValue = Double.parseDouble(value);
        long resistorValue = Math.round(numericValue * Math.pow(10, multiplier));

        String valueStr = Long.toString(resistorValue);

        StringBuilder colorCode = new StringBuilder();

        colorCode.append(colorMap.get(Character.getNumericValue(valueStr.charAt(0)))).append(" ");

        colorCode.append(colorMap.get(Character.getNumericValue(valueStr.charAt(1)))).append(" ");

        int power = valueStr.length() - 2;
        colorCode.append(colorMap.get(power)).append(" ");

        colorCode.append(TOLERANCE_COLOR);

        return colorCode.toString().trim();
    }
}
