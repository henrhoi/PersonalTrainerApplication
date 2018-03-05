package tdt4140.gr1801.web.server;

import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;



public class RSJSONConverter {
	
	// Denne funksjonen konverterer resultatet fra en SQL-spoerring (ResultSet) om til JSON-format.
	public static JSONArray ResultSetToJSON(ResultSet rs ) throws SQLException, JSONException{
		JSONArray json = new JSONArray();
		ResultSetMetaData rsmd = rs.getMetaData();

	    while(rs.next()) {
	      int numCol = rsmd.getColumnCount();
	      JSONObject jsonobj = new JSONObject();
	
	      for (int i=1; i<numCol+1; i++) {
	        String column_name = rsmd.getColumnName(i);
	
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
	
	      json.put(jsonobj);
	    }
	
	    return json;
	  }


}






