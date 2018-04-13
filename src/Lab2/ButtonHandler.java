package Lab2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ButtonHandler implements ActionListener {
    FilledFrame theApp;
    int size;


    ButtonHandler(FilledFrame app, int size) {
        theApp = app;
        this.size = size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        theApp.size = size;
        theApp.repaint();
    }
}
