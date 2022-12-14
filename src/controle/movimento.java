package controle;

import javax.swing.*;

import modelos.blocos;

public class movimento {
    public static final int movimento = 0;//velocidade do movimento dos blocos//
    public static int larg = blocos.WIDTH;

    public static void movimentoBlocos(blocos blocos, blocos espacoVazio, JPanel painel) {
        String direcao = movimentodirecao(blocos, espacoVazio);

        int MoverParaX = blocos.getX();
        int MoverParaY = blocos.getY();

        switch (direcao) {
            case "RIGHT":
                new Thread(() -> {
                    for (int i = 0; i < larg; i++) {
                        try {
                            Thread.sleep(movimento);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        blocos.setX(blocos.getX() + modelos.blocos.WIDTH / larg);
                        moveespacoVazio(espacoVazio, MoverParaX, MoverParaY);
                        painel.repaint();
                    }
                }).start();
                break;
            case "LEFT":
                new Thread(() -> {
                    for (int i = 0; i < larg; i++) {
                        try {
                            Thread.sleep(movimento);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        blocos.setX(blocos.getX() - 1);
                        moveespacoVazio(espacoVazio, MoverParaX, MoverParaY);
                        painel.repaint();
                    }
                }).start();
                break;
            case "DOWN":
                new Thread(() -> {
                    for (int i = 0; i < larg; i++) {
                        try {
                            Thread.sleep(movimento);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        blocos.setY(blocos.getY() + modelos.blocos.HEIGHT / larg);
                        moveespacoVazio(espacoVazio, MoverParaX, MoverParaY);
                        painel.repaint();
                    }
                }).start();
                break;
            case "UP":
                new Thread(() -> {
                    for (int i = 0; i < larg; i++) {
                        try {
                            Thread.sleep(movimento);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        moveespacoVazio(espacoVazio, MoverParaX, MoverParaY);
                        blocos.setY(blocos.getY() - modelos.blocos.HEIGHT / larg);
                        painel.repaint();
                    }
                }).start();
                break;
        }
    }

    private static void moveespacoVazio(blocos espacoVazio, int MoverParaX, int MoverParaY) {
        espacoVazio.setX(MoverParaX);
        espacoVazio.setY(MoverParaY);
    }

    public static String movimentodirecao(blocos blocos, blocos espacoVazio) {

        if (blocos.getX() > espacoVazio.getX() && blocos.getY() == espacoVazio.getY())
            return "LEFT";

        if (blocos.getX() < espacoVazio.getX() && blocos.getY() == espacoVazio.getY())
            return "RIGHT";

        if (blocos.getY() > espacoVazio.getY() && blocos.getX() == espacoVazio.getX())
            return "UP";

        if (blocos.getY() < espacoVazio.getY() && blocos.getX() == espacoVazio.getX())
            return "DOWN";

        return "UNKNOWN";
    }

}