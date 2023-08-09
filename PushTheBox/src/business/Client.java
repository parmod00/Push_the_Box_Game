package business;

import Main.Main;

import java.io.*;
import java.net.Socket;

/*Created By Parmod and Pooja During internship at solitaire infosys*/

public class Client {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private Game game;

    public Client(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        game = Main.game;
        new ClientWorker();
    }

    public void sendMessage(String message){
        try {
            out.write(message);
            out.newLine();
            out.flush();
        }
        catch (IOException e) {
        }
    }

    public class ClientWorker implements Runnable{

        public ClientWorker(){
            (new Thread(this)).start();
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null){
                    String info[] = message.split(" ");
                    if (info[0].equals("MAP")) {
                        int currentMap = Integer.parseInt(info[1]);
                        int nMoves = Integer.parseInt(info[2]);
                        int highscore = -1;
                        if (!info[3].equals("-"))
                            highscore = Integer.parseInt(info[3]);
                        sendMessage("Send");
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        Map map = (Map) ois.readObject();
                        game.updateMap(currentMap, map, nMoves, highscore);
                        sendMessage("Confirm");
                    }
                }
                socket.close();
            }
            catch (Exception e) {
                System.err.println("Connection closed");
                e.printStackTrace();
            }
        }
    }
}