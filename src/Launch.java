import javax.swing.*;

public class Launch {
    private static final int splashDuration = 5000;

    public static void main(String[] args) {
        new SplashScreen(splashDuration).showSplash();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainUI("Test Splash Screen");
            }
        });
    }
}
