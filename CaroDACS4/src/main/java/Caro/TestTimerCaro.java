/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caro;

import java.util.concurrent.Callable;

/**
 *
 * @author Admin
 */
public class TestTimerCaro {

    public TestTimerCaro() {
        Caro caro = new Caro();
        Callable endCallback, tickCallback;

        endCallback = (Callable) () -> {
            System.out.println("END");
            throw new Exception();
        };

        tickCallback = (Callable) () -> {
            if (caro.getTurnTimer().getCurrentTick() == 10) {
                caro.cancelTimer();
            }
            System.out.println(caro.getTurnTimer().getCurrentTick());
            throw new Exception();
        };

        caro.getTurnTimer().setTimerCallBack(endCallback, tickCallback, 1);

        
    }

    public static void main(String[] args) {
        new TestTimerCaro();
    }
}