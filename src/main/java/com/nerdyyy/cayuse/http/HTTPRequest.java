package com.nerdyyy.cayuse.http;

public class HTTPRequest {
    public String HTTPVersion;
    public String Method;
    public String Location;
    public Header[] Headers;
    public String Body;

    public HTTPRequest(String HTTPVersion, String Method, String Location, Header[] Headers, String Body) {
        this.HTTPVersion = HTTPVersion;
        this.Method = Method;
        this.Location = Location;
        this.Headers = Headers;
        this.Body = Body;
    }
    public HTTPRequest() {}

    @Override
    public String toString() {
        StringBuilder string_representation = new StringBuilder();
        string_representation.append("HTTPRequest:\n\tHTTPVersion: ");
        string_representation.append(HTTPVersion == null ? "null" : HTTPVersion);
        string_representation.append("\n\tMethod: ");
        string_representation.append(Method == null ? "null" : Method);
        string_representation.append("\n\tLocation: ");
        string_representation.append(Location == null ? "null" : Location);
        string_representation.append("\n\tHeaders: ");
        if (Headers != null)
        {
            for (Header h : Headers) {
                string_representation.append("\n\t\t");
                string_representation.append(h);
            }
        }else
            string_representation.append("null");
        string_representation.append("\n\tBody: ");
        string_representation.append(Body == null ? "null" : Body);
        return string_representation.toString();
    }
}
