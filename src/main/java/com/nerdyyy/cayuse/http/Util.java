package com.nerdyyy.cayuse.http;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Util {
    public static HTTPRequest parseRequest(BufferedReader request) {
        try {
            HTTPRequest requestObject = new HTTPRequest();


            String[] Request_Line_split = request.readLine().split(" ");
            requestObject.Method = Request_Line_split[0];
            requestObject.Location = Request_Line_split[1];
            requestObject.HTTPVersion = Request_Line_split[2].substring(5);

            String currentHeader = "";
            int content_length = -1;
            ArrayList<Header> headersList = new ArrayList<>();
            while (!(currentHeader = request.readLine()).equals("")) {
                String[] keyvaluesplit = currentHeader.split(":\\s*", 2);
                if (keyvaluesplit[0].equalsIgnoreCase("content-length"))
                    content_length = Integer.parseInt(keyvaluesplit[1]);
                headersList.add(new Header(keyvaluesplit[0], keyvaluesplit[1]));
            }
            requestObject.Headers = headersList.toArray(new Header[] {});

            String body = null;

            if (content_length != -1) {
                char[] buffer = new char[content_length];
                if (request.read(buffer) != content_length)
                    throw new Exception("content length didn't match content-length header.");
                body = new String(buffer);
            }
            requestObject.Body = body;

            return requestObject;
        }catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public static String generateResponse() {
        return "";
    }
}
