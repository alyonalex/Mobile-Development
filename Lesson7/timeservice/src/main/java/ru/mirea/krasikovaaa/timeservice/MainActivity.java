package ru.mirea.krasikovaaa.timeservice;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.krasikovaaa.timeservice.databinding.ActivityMainBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String[] hosts = {
            "time.nist.gov",
            "time-a.nist.gov",
            "time-b.nist.gov",
            "time-c.nist.gov",
            "utcnist.colorado.edu",
            "time-nw.nist.gov"
    };
    private final int port = 13;
    private final int CONNECT_TIMEOUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(v -> new GetTimeTask().execute());
    }

    private class GetTimeTask extends AsyncTask<Void, Void, String> {
        private String foundHost = "";

        @Override
        protected String doInBackground(Void... params) {
            for (String host : hosts) {
                Socket socket = null;
                try {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT);
                    BufferedReader reader = SocketUtils.getReader(socket);
                    reader.readLine();
                    String line = reader.readLine();
                    if (line != null && !line.trim().isEmpty() && !line.toLowerCase().startsWith("denied")) {
                        foundHost = host;
                        return line.trim();
                    }
                } catch (SocketTimeoutException e) {
                } catch (IOException e) {
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException ignored) {}
                    }
                }
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            if (result == null || result.isEmpty()) {
                binding.TextViewDate.setText("Источник: нет");
                binding.TextViewTime.setText("Время: ");
                return;
            }
            String[] parts = result.split("\\s+");
            if (parts.length >= 3) {
                binding.TextViewDate.setText("Источник: " + foundHost + "\nДата: " + parts[1]);
                binding.TextViewTime.setText("Время: " + parts[2]);
            } else {
                binding.TextViewDate.setText("Источник: " + foundHost);
                binding.TextViewTime.setText("Время: ");
            }
        }
    }
}