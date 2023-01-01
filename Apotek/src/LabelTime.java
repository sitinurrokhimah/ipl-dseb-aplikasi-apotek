import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import javax.swing.JLabel;

public class LabelTime extends JLabel implements ActionListener{
    
    private SimpleDateFormat format;
    private Timer timer;
    private Date date;
 
    public LabelTime() {
        timer = new Timer(1000, this);
        format = new SimpleDateFormat("dd MMMM yyyy, HH:mm:ss");
        date = new Date();
        timer.start();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        date.setTime(System.currentTimeMillis());
        this.setText(format.format(date));
    }
    
}