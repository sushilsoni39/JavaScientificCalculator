package container;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class StandAloneMain
{
    public static void main (String[] args) {
        String data = "";
        try {
            URL url = new URL("http://localhost:8081/newfilter/getID?searchroll=RN1");
            //BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            //data = in.readLine();
            //System.out.println(data);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String type = br.readLine();
            switch (type) {
                case "application/json":
                    con.setRequestProperty("Accept", "application/json");
                    break;
                case "application/xml":
                    con.setRequestProperty("Accept", "application/xml");
                    break;
                default:
                    System.out.println("Give a valid content-type");
            }
            InputStream inputStream = con.getInputStream();
            // String theString = IOUtils.toString(inputStream,"UTF-8");
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = inputStream.read()) != -1)
                sb.append((char) ch);
            //inputStream.reset();
            data = sb.toString();
            System.out.println("Data in Requested Format:"+data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}