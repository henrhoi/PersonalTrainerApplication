package tdt4140.gr1801.web.server;

import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.sql.SQLException;
import java.sql.ResultSetMetaData;


// This class contains a static method that converts ResultSet to JSON
public class RSJSONConverter {
	
	
	// This method converts the result of a SQL-query (ResultSet) to JSON-format (JSONArray)
	public static JSONArray ResultSetToJSON(ResultSet rs ) throws SQLException, JSONException{

		// Makes a new JSONArray and collects the metadata of the RS
		JSONArray json = new JSONArray();
		ResultSetMetaData rsmd = rs.getMetaData();

	    while(rs.next()) {
	    // Checks the number of columns in the ResultSet
	      int numCol = rsmd.getColumnCount();
	      
	      // Creates a new JSONObject while there are tuples in the ResultSet
	      JSONObject jsonobj = new JSONObject();
	
	      // Goes through every column of each tuple in the ResultSet
	      for (int i=1; i<numCol+1; i++) {
	        String column_name = rsmd.getColumnName(i);
	        
	        //Each column goes through a list of if-statements, checking the columns data-type
	        
	        if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){ 
	         jsonobj.put(column_name, rs.getArray(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
	         jsonobj.put(column_name, rs.getLong(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
	         jsonobj.put(column_name, rs.getBoolean(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
	         jsonobj.put(column_name, rs.getBlob(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
	         jsonobj.put(column_name, rs.getDouble(column_name)); 
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
	         jsonobj.put(column_name, rs.getFloat(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
	         jsonobj.put(column_name, rs.getInt(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
	         jsonobj.put(column_name, rs.getNString(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
	         jsonobj.put(column_name, rs.getString(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
	         jsonobj.put(column_name, rs.getInt(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
	         jsonobj.put(column_name, rs.getInt(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
	         jsonobj.put(column_name, rs.getDate(column_name));
	        }
	        else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
	        jsonobj.put(column_name, rs.getTimestamp(column_name));   
	        }
	        else{
	         jsonobj.put(column_name, rs.getObject(column_name));
	        }
	      }
	      
	      // Then after the JSONObject is constructed with every column of the tuple, it then adds it to the JSONArray
	      json.put(jsonobj);
	    }
	    
	    //Returning the JSONArray
	    return json;
	  }


}






