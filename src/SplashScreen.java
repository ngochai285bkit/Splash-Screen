import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SplashScreen extends JWindow {
    // attributes
    private final int duration;

    // constructor
    public SplashScreen(int duration) {
        this.duration = duration;
    }

    // A simple little method to show a title screen in the center of the screen for
    // the amount of time given in the constructor
    public void showSplash() {
        ImageBackgroundPanel content = new ImageBackgroundPanel();
        this.setContentPane(content);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setVisible(false);
    }

    private static class ImageBackgroundPanel extends JPanel {
        Image image = null;

        public ImageBackgroundPanel() {
            this.setBorder(BorderFactory.createRaisedBevelBorder());
            try {
                image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/splash.png"))).getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}
