
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer requições https

        String url = "https://random-data-api.com/api/v2/users?size=30";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        // fazer a requição e validar codigo de resposta

        if (con.getResponseCode() != 200){

            System.err.println("falha na request, codigo de resposta : " + con.getResponseCode() );
        }

        // obter oque foi respondido

        BufferedReader response = new BufferedReader(new InputStreamReader(con.getInputStream()));

        // escrever resposta em um arquivo

        FileWriter response_file = new FileWriter("response.json");
        PrintWriter gravar_file = new PrintWriter("response.json");
  
        String line;

        while ((line = response.readLine()) != null) {

            gravar_file.printf(line + "\n");}
        
        response_file.close();
        gravar_file.close();
        
    }
}
