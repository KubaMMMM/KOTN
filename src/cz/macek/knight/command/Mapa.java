package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Mapa implements Command{


    @Override
    public String execute(String param, Game game) {


        String C = "C";
        String H = "H";
        String D = "D";
        String P = "P";
        String V = "V";
        String F = "F";
        String B = "B";
        String W = "W";
        String M = "M";
        String J = "J";



        StringBuilder sb = new StringBuilder();


        sb.append("\nLegenda:\n");
        sb.append("V = vesnice, H = hrad, F = les, B = pláž\n");
        sb.append("M = louka, J = jeskyně, C = útesy\n");
        sb.append("W = chýše, P = cesta k drakovi, D = drak\n");

        sb.append("\n");

        sb.append("===== MAPA =====\n\n");

        sb.append("             ").append(C).append("      ").append(H).append("\n");
        sb.append("             |      |\n");
        sb.append("      ").append(D)
                .append(" ---- ").append(P)
                .append(" ---- ").append(V)
                .append(" ---- ").append(F)
                .append(" ---- ").append(B).append("\n");
        sb.append("             |      |\n");
        sb.append("             ").append(W)
                .append("      ").append(M)
                .append(" ---- ").append(J).append("\n");



        return sb.toString();
    }

}

