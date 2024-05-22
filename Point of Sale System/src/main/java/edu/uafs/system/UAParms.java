package edu.uafs.system;

public class UAParms {
    
    private final static String username = "ua601";
    private final static String password = "uadbpass387";
    private final static String database = "CS3043";

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getSchemaname() {
        return schemaname;
    }

    public static String getUrl() {
        return url;
    }
    private final static String schemaname = "ua601";
    private final static String url = "jdbc:db2://data.cs.uafs.edu:55000/CS3043";
}
