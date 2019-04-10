package com.nerdyyy.cayuse;

import com.nerdyyy.cayuse.modules.ServeFilesystem;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MAIN {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(80);

        while (true) {
            try (Socket socket = ss.accept()) {
                //TODO: configuration stuff
                new ServeFilesystem().HandleConnection(socket);
            }
        }

    }
}
