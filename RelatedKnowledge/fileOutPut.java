import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
 
public class outPut {
    public static void main(String[] args) {
    	Date now = new Date(); 
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String times=dateFormat.format(now);
    	String str="player1, result1, rangking1\r"
    			 + "player2, result2, rangking2\r"
    			+ "player3, result3, rangking3";
        FileWriter writer;
        try {
            writer = new FileWriter("gameResult.txt");
            writer.write(times+"\r");
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
